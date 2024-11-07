import Joueurs.Player;
import Plateau.Plateau;
import java.io.PrintStream;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        // Initialisation des lettres représentant les joueurs
        String r = "R";
        String b = "B";
        String w = "W";

        // Initialisation du nombre de tours et du nombre maximal de points
        int nbTour = 1;
        int MAX_POINT = 12;

        // Création du plateau de jeu
        Plateau p = new Plateau();

        // Initialisation des joueurs avec leurs lettres respectives et placement initial sur le plateau
        Player R = new Player(r);
        R.init(p);
        Player W = new Player(w);
        W.init(p);
        Player B = new Player(b);
        B.init(p);

        // Déroulement des tours jusqu'à ce qu'un joueur atteigne 12 points
        while(R.getPoints() < 12 && B.getPoints() < 12) {
            // Affichage du numéro du tour
            System.out.println("Tour n°" + nbTour);
            // Affichage du plateau de jeu
            System.out.println(p);

            // Tour du joueur Rouge
            System.out.println("Joueur Rouge entrez un chiffre: ");
            p.casesPossible(r);
            System.out.println(p);
            R.deplacer(p);
            System.out.println(p);

            // Tour du joueur Blanc
            System.out.println("Joueur Rouge bougez Blanc entrez un chiffre: ");
            p.casesPossible(w);
            System.out.println(p);
            W.deplacer(p);
            System.out.println(p);

            // Tour du joueur Bleu
            System.out.println("Joueur Bleu entrez un chiffre: ");
            p.casesPossible(b);
            System.out.println(p);
            B.deplacer(p);
            System.out.println(p);

            // Tour du joueur Blanc
            System.out.println("Joueur Bleu bougez Blanc entrez un chiffre: ");
            p.casesPossible(w);
            System.out.println(p);
            W.deplacer(p);
            System.out.println(p);

            // Affichage du score des joueurs
            System.out.println("Rouge à " + R.getPoints() + " points et Bleu à " + B.getPoints() + " points");

            // Passage au tour suivant
            ++nbTour;
        }

        // Affichage du vainqueur du jeu
        if (R.getPoints() >= 12) {
            if (B.getPoints() < 6) {
                System.out.println("Bleu l'emporte");
            } else {
                System.out.println("Rouge l'emporte");
            }
        }

        if (B.getPoints() >= 12) {
            if (R.getPoints() < 6) {
                System.out.println("Rouge l'emporte");
            } else {
                System.out.println("Bleu l'emporte");
            }
        }
    }
}
