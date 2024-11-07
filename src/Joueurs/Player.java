package Joueurs;

import Plateau.Plateau;
import java.util.Scanner;

/**
 * La classe Player représente un joueur dans le jeu Tic Tac Toe.
 * Chaque joueur a une lettre associée (R, B, ou W) et peut se déplacer sur un plateau de jeu.
 */
public class Player {
    private static final int TAILLE_COORD_MAX = 4; // Taille maximale des coordonnées
    private static final int TAILLE_PLATEAU = 3; // Taille du plateau
    private int points = 0; // Les points du joueur
    private final String lettre; // La lettre associée au joueur (R, B, ou W)
    private int[] coordonnees = new int[4]; // Les coordonnées des pièces du joueur sur le plateau
    private static final String CHAR_VIDE = " "; // Caractère vide pour le plateau

    /**
     * Constructeur de la classe Player.
     * @param l La lettre associée au joueur (R, B, ou W)
     */
    public Player(String l) {
        this.lettre = l;
    }

    /**
     * Getter pour obtenir la lettre associée au joueur.
     * @return La lettre associée au joueur (R, B, ou W)
     */
    public String getLettre() {
        return this.lettre;
    }

    /**
     * Méthode pour ajouter des points au joueur.
     * Les points sont ajoutés lorsque le joueur déplace sa pièce sur la ligne du milieu du plateau.
     */
    public void ajoutPoint() {
        if (this.coordonnees[1] == 2) {
            ++this.points;
        }

        if (this.coordonnees[3] == 2) {
            ++this.points;
        }
    }

    /**
     * Getter pour obtenir les points du joueur.
     * @return Le nombre de points du joueur
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Méthode pour déplacer la pièce du joueur sur le plateau.
     * Le joueur entre un chiffre pour indiquer le mouvement désiré.
     * @param p Le plateau de jeu sur lequel le joueur se déplace
     */
    public void deplacer(Plateau p) {
        boolean MauvaisDep = true;
        Scanner sc = new Scanner(System.in);

        while(MauvaisDep) {
            int choixDep = sc.nextInt();

            for(int f = 0; f < 3; ++f) {
                for(int i = 0; i < 3; ++i) {
                    if (p.intToString(choixDep).equals(p.getContenu(f, i))) {
                        assert p.getCase(f, i).isVide() || this.testCoord(f, i);

                        if (f != 0 && (p.getCase(f - 1, i).isVide() || this.testCoord(f - 1, i) && !this.testCoord(f, i)) && MauvaisDep) {
                            this.vertical(p, f, i);
                            MauvaisDep = false;
                        }

                        if (i != 2 && (p.getCase(f, i + 1).isVide() || this.testCoord(f, i + 1) && !this.testCoord(f, i)) && MauvaisDep) {
                            this.horizontal(p, f, i);
                            MauvaisDep = false;
                        }
                    } else {
                        if (p.intToString(choixDep, choixDep + 1).equals(p.getContenu(f, i))) {
                            assert p.getCase(f, i).isVide() || this.testCoord(f, i);

                            if (p.getCase(f - 1, i).isVide() || this.testCoord(f - 1, i)) {
                                this.vertical(p, f, i);
                                MauvaisDep = false;
                            }
                        }

                        if (p.intToString(choixDep - 1, choixDep).equals(p.getContenu(f, i))) {
                            assert p.getCase(f, i).isVide() || this.testCoord(f, i);

                            if (p.getCase(f, i + 1).isVide() || this.testCoord(f, i + 1)) {
                                this.horizontal(p, f, i);
                                MauvaisDep = false;
                            }
                        }
                    }
                }
            }

            System.out.println("Mauvais chiffre, rejouez");
        }

        this.ajoutPoint();
    }

    /**
     * Méthode pour tester si les coordonnées spécifiées correspondent à celles du joueur.
     * @param f L'indice de la ligne
     * @param i L'indice de la colonne
     * @return true si les coordonnées correspondent aux coordonnées du joueur, sinon false
     */
    private boolean testCoord(int f, int i) {
        return f == this.coordonnees[0] && i == this.coordonnees[1] || f == this.coordonnees[2] && i == this.coordonnees[3];
    }

    /**
     * Méthode pour déplacer la pièce du joueur verticalement sur le plateau.
     * @param p Le plateau de jeu sur lequel le joueur se déplace
     * @param f L'indice de la ligne de départ
     * @param i L'indice de la colonne de départ
     */
    private void vertical(Plateau p, int f, int i) {
        this.supprimerJoueur(p);
        p.getCase(f, i).modifierContenu(this.lettre);
        p.getCase(f - 1, i).modifierContenu(this.lettre);
        p.getCase(f, i).caseNonVide();
        p.getCase(f - 1, i).caseNonVide();
        this.ajouterCoord(f, i, f - 1, i);
    }

    /**
     * Méthode pour déplacer la pièce du joueur horizontalement sur le plateau.
     * @param p Le plateau de jeu sur lequel le joueur se déplace
     * @param f L'indice de la ligne de départ
     * @param i L'indice de la colonne de départ
     */
    private void horizontal(Plateau p, int f, int i) {
        this.supprimerJoueur(p);
        p.getCase(f, i).modifierContenu(this.lettre);
        p.getCase(f, i + 1).modifierContenu(this.lettre);
        p.getCase(f, i).caseNonVide();
        p.getCase(f, i + 1).caseNonVide();
        this.ajouterCoord(f, i, f, i + 1);
    }

    /**
     * Méthode pour supprimer la pièce du joueur du plateau.
     * @param p Le plateau de jeu sur lequel le joueur se déplace
     */
    public void supprimerJoueur(Plateau p) {
        p.getCase(this.coordonnees[0], this.coordonnees[1]).modifierContenu(" ");
        p.getCase(this.coordonnees[0], this.coordonnees[1]).caseVide();
        p.getCase(this.coordonnees[2], this.coordonnees[3]).modifierContenu(" ");
        p.getCase(this.coordonnees[2], this.coordonnees[3]).caseVide();
        p.spotVide();
        p.spotVide();
    }

    /**
     * Méthode pour ajouter des coordonnées au joueur.
     * @param r La ligne de départ
     * @param c La colonne de départ
     * @param rr La ligne de destination
     * @param cc La colonne de destination
     */
    private void ajouterCoord(int r, int c, int rr, int cc) {
        this.coordonnees[0] = r;
        this.coordonnees[1] = c;
        this.coordonnees[2] = rr;
        this.coordonnees[3] = cc;
    }

    /**
     * Méthode pour initialiser la position de départ du joueur sur le plateau.
     * @param p Le plateau de jeu sur lequel le joueur se déplace
     */
    public void init(Plateau p) {
        if (this.lettre.equals("R")) {
            p.getCase(0, 1).modifierContenu("R");
            p.getCase(0, 1).caseNonVide();
            p.getCase(0, 2).modifierContenu("R");
            p.getCase(0, 2).caseNonVide();
            this.ajouterCoord(0, 1, 0, 2);
        }

        if (this.lettre.equals("B")) {
            p.getCase(2, 1).modifierContenu("B");
            p.getCase(2, 1).caseNonVide();
            p.getCase(2, 2).modifierContenu("B");
            p.getCase(2, 2).caseNonVide();
            this.ajouterCoord(2, 1, 2, 2);
        }

        if (this.lettre.equals("W")) {
            p.getCase(1, 1).modifierContenu("W");
            p.getCase(1, 1).caseNonVide();
            p.getCase(1, 2).modifierContenu("W");
            p.getCase(1, 2).caseNonVide();
            this.ajouterCoord(1, 1, 1, 2);
        }
    }
}

