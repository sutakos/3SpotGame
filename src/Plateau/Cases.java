package Plateau;

/**
 * La classe Cases représente une case sur un plateau de jeu.
 * Chaque case peut avoir un contenu et peut être vide ou non vide.
 */
public class Cases {
    private String contenu = " "; // Contenu de la case (par défaut vide)
    private boolean vide = true; // Indique si la case est vide ou non vide

    /**
     * Constructeur par défaut de la classe Cases.
     * Initialise une case vide.
     */
    public Cases() {
    }

    /**
     * Méthode pour définir la case comme vide.
     * La case est vide lorsqu'elle ne contient aucun contenu.
     */
    public void caseVide() {
        this.vide = true;
    }

    /**
     * Méthode pour définir la case comme non vide.
     * La case est non vide lorsqu'elle contient un contenu.
     */
    public void caseNonVide() {
        this.vide = false;
    }

    /**
     * Méthode pour vérifier si la case est vide.
     * @return true si la case est vide, sinon false
     */
    public boolean isVide() {
        return this.vide;
    }

    /**
     * Méthode pour obtenir une représentation textuelle du contenu de la case.
     * @return Le contenu de la case sous forme de chaîne de caractères
     */
    public String toString() {
        return this.contenu;
    }

    /**
     * Méthode pour modifier le contenu de la case.
     * @param s Le nouveau contenu de la case
     */
    public void modifierContenu(String s) {
        this.contenu = s;
    }
}


