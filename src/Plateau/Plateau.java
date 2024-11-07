package Plateau;

/**
 * La classe Plateau représente le plateau de jeu pour le Tic Tac Toe.
 * Elle contient les cases du plateau et offre des méthodes pour effectuer des opérations sur le plateau.
 */
public class Plateau {
    private static final int TAILLE_MAX = 3; // Taille maximale du plateau
    private Cases[][] rangees = new Cases[3][3]; // Les cases du plateau
    private static final String CHARA_VIDE = " "; // Caractère représentant une case vide
    private static final String SPOT = "O"; // Caractère représentant un emplacement spécial

    /**
     * Constructeur de la classe Plateau.
     * Initialise les cases du plateau et place des emplacements spéciaux sur la dernière rangée.
     */
    public Plateau() {
        // Initialisation des cases du plateau
        for (int i = 0; i < 3; ++i) {
            for (int f = 0; f < 3; ++f) {
                this.rangees[i][f] = new Cases();
            }
        }

        // Placement des emplacements spéciaux sur la dernière rangée
        for (int i = 0; i < 3; ++i) {
            this.rangees[i][2].modifierContenu("O");
        }
    }

    /**
     * Méthode toString pour afficher le plateau.
     * @return Une représentation textuelle du plateau de jeu
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; ++i) {
            sb.append("* * * * * * * * * * * * *\n");
            sb.append("*       ".repeat(4));
            sb.append("\n");

            for (int f = 0; f < 3; ++f) {
                sb.append("*");
                if (this.rangees[i][f].toString().length() == 3) {
                    sb.append("  ").append(this.rangees[i][f].toString()).append("  ");
                } else {
                    sb.append("   ").append(this.rangees[i][f].toString()).append("   ");
                }
            }

            sb.append("*\n");
            sb.append("*       ".repeat(4));
            sb.append("\n");
        }

        sb.append("* * * * * * * * * * * * *\n");
        return sb.toString();
    }

    /**
     * Méthode pour identifier les cases possibles pour un joueur.
     * Cette méthode identifie les cases vides ou occupées par le joueur adjacentes à une case vide.
     * @param l La lettre du joueur (R, B, ou W)
     */
    public void casesPossible(String l) {
        int nbCasesPossible = 0;

        for (int y = 0; y < 3; ++y) {
            for (int i = 0; i < 3; ++i) {
                if (this.rangees[y][i].isVide() || this.rangees[y][i].toString().equals(l)) {
                    if (i != 2) {
                        if (this.rangees[y][i + 1].isVide()) {
                            assert this.isNotJoueur(this.rangees[y][i + 1].toString());

                            ++nbCasesPossible;
                            this.rangees[y][i].modifierContenu(this.intToString(nbCasesPossible));
                        }

                        if (this.rangees[y][i + 1].toString().equals(l) && this.rangees[y][i].isVide()) {
                            assert this.isNotJoueur(this.rangees[y][i].toString());

                            ++nbCasesPossible;
                            this.rangees[y][i].modifierContenu(this.intToString(nbCasesPossible));
                        }
                    }

                    if (y != 0) {
                        if (this.rangees[y - 1][i].isVide()) {
                            assert this.isNotJoueur(this.rangees[y - 1][i].toString());

                            ++nbCasesPossible;
                            this.rangees[y][i].modifierContenu(this.intToString(nbCasesPossible));
                        }

                        if (this.rangees[y - 1][i].toString().equals(l) && this.rangees[y][i].isVide() || this.rangees[y - 1][i].toString().equals(this.intToString(nbCasesPossible)) && this.rangees[y - 1][i].isVide()) {
                            assert this.isNotJoueur(this.rangees[y][i].toString());

                            ++nbCasesPossible;
                            this.rangees[y][i].modifierContenu(this.intToString(nbCasesPossible));
                        }
                    }

                    if (y != 0 && i != 2) {
                        if (this.rangees[y][i + 1].isVide() && this.rangees[y - 1][i].isVide()) {
                            assert this.isNotJoueur(this.rangees[y][i + 1].toString()) && this.isNotJoueur(this.rangees[y - 1][i].toString());

                            this.rangees[y][i].modifierContenu(this.intToString(nbCasesPossible, nbCasesPossible + 1));
                            ++nbCasesPossible;
                        }

                        if (this.rangees[y][i + 1].toString().equals(l) && this.rangees[y][i].isVide() && this.rangees[y - 1][i].isVide() || this.rangees[y - 1][i].toString().equals(l) && this.rangees[y][i + 1].isVide() && !this.rangees[y][i].toString().equals(this.intToString(nbCasesPossible))) {
                            assert this.isNotJoueur(this.rangees[y][i].toString());

                            this.rangees[y][i].modifierContenu(this.intToString(nbCasesPossible, nbCasesPossible + 1));
                            ++nbCasesPossible;
                        }
                    }
                }
            }
        }
    }

    /**
     * Méthode pour remplacer les cases vides par des emplacements spéciaux.
     * Cette méthode est appelée après chaque déplacement pour restaurer les emplacements spéciaux.
     */
    public void spotVide() {
        for (int y = 0; y < 3; ++y) {
            for (int i = 0; i < 2; ++i) {
                if (this.rangees[y][i].isVide()) {
                    this.rangees[y][i].modifierContenu(" ");
                }
            }

            if (this.rangees[y][2].isVide()) {
                this.rangees[y][2].modifierContenu("O");
            }
        }
    }

    /**
     * Méthode pour obtenir le contenu d'une case du plateau.
     * @param f L'indice de la rangée
     * @param i L'indice de la colonne
     * @return Le contenu de la case spécifiée
     */
    public String getContenu(int f, int i) {
        return this.rangees[f][i].toString();
    }

    /**
     * Méthode pour obtenir une case spécifique du plateau.
     * @param f L'indice de la rangée
     * @param i L'indice de la colonne
     * @return La case spécifiée
     */
    public Cases getCase(int f, int i) {
        return this.rangees[f][i];
    }

    /**
     * Méthode pour convertir un entier en chaîne de caractères.
     * @param n L'entier à convertir
     * @return La chaîne de caractères représentant l'entier
     */
    public String intToString(int n) {
        return "" + n;
    }

    /**
     * Méthode pour convertir deux entiers en une chaîne de caractères avec un trait d'union.
     * @param n Le premier entier
     * @param v Le deuxième entier
     * @return La chaîne de caractères représentant les deux entiers séparés par un trait d'union
     */
    public String intToString(int n, int v) {
        return "" + n + "-" + v;
    }

    /**
     * Méthode pour vérifier si une chaîne de caractères ne représente pas un joueur.
     * @param s La chaîne de caractères à vérifier
     * @return true si la chaîne de caractères ne représente pas un joueur, sinon false
     */
    private boolean isNotJoueur(String s) {
        return !s.equals("R") && !s.equals("B") && !s.equals("W");
    }
}
