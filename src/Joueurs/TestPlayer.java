package Joueurs;

import Plateau.Cases;
import Plateau.Plateau;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.*;

public class TestPlayer {

    @Test
    public void testGetLettre() {
        Player player = new Player("R");
        assertEquals("R", player.getLettre());
    }

    @Test
    public void testAjoutPoint() {
        Player player = new Player("R");
        player.ajoutPoint();
    }

    @Test
    public void testGetPoints() {
        Player player = new Player("R");
        assertEquals(0, player.getPoints());
    }

    @Test
    public void testDeplacer() {
        Plateau plateau = new Plateau();
        Player joueur = new Player("R");
        String entreeUtilisateur = "1";
        InputStream in = new ByteArrayInputStream(entreeUtilisateur.getBytes());
        System.setIn(in);
        joueur.deplacer(plateau);
        Cases pieceDeplacee = plateau.getCase(0, 1);
        assertFalse(pieceDeplacee.isVide());
        assertEquals("R", pieceDeplacee.toString());
    }


    @Test
    public void testSupprimerJoueur() {
        Plateau plateau = new Plateau();
        Player player = new Player("R");
        player.init(plateau);
        player.supprimerJoueur(plateau);
        assertEquals(" ", plateau.getContenu(0, 1));
        assertEquals(" ", plateau.getContenu(0, 2));
        assertEquals(" ", plateau.getContenu(0, 1));
        assertEquals(" ", plateau.getContenu(0, 2));
    }

    @Test
    public void testInit() {
        Plateau plateau = new Plateau();
        Player player = new Player("R");
        player.init(plateau);
        assertEquals("R", plateau.getContenu(0, 1));
        assertEquals("R", plateau.getContenu(0, 2));
    }
}

