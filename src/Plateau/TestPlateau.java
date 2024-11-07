package Plateau;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPlateau {

    @Test
    public void testToString() {
        Plateau plateau = new Plateau();
        String expected = "* * * * * * * * * * * * *\n" +
                "*       *       *       *\n" +
                "*       *       *   0   *\n" +
                "*       *       *       *\n" +
                "* * * * * * * * * * * * *\n" +
                "*       *       *       *\n" +
                "*       *       *   0   *\n" +
                "*       *       *       *\n" +
                "* * * * * * * * * * * * *\n" +
                "*       *       *       *\n" +
                "*       *       *   0   *\n" +
                "*       *       *       *\n" +
                "* * * * * * * * * * * * *\n";
        assertEquals(expected, plateau.toString());
    }

    @Test
    public void testCasesPossible() {
        Plateau plateau = new Plateau();
        plateau.casesPossible(" ");
    }

    @Test
    public void testSpotVide() {
        Plateau plateau = new Plateau();
        plateau.spotVide();
    }

    @Test
    public void testGetContenu() {
        Plateau plateau = new Plateau();
        assertEquals(" ", plateau.getContenu(0, 0));
    }

    @Test
    public void testGetCase() {
        Plateau plateau = new Plateau();
        assertNotNull(plateau.getCase(0, 0));
    }

    @Test
    public void testIntToString() {
        Plateau plateau = new Plateau();
        assertEquals("1", plateau.intToString(1));
        assertEquals("1-2", plateau.intToString(1, 2));
    }
}
