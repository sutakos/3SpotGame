package Plateau;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCases {

    @Test
    public void testCaseVide() {
        Cases c = new Cases();
        c.caseNonVide();
        assertFalse(c.isVide());
        c.caseVide();
        assertTrue(c.isVide());
    }

    @Test
    public void testModifierContenu() {
        Cases c = new Cases();
        c.modifierContenu("test");
        assertEquals("test", c.toString());
        c.modifierContenu("nouveau contenu");
        assertEquals("nouveau contenu", c.toString());
    }

    @Test
    public void testIsVide() {
        Cases c1 = new Cases();
        assertTrue(c1.isVide());
        c1.caseNonVide();
        assertFalse(c1.isVide());

        Cases c2 = new Cases();
        assertTrue(c2.isVide());
        c2.modifierContenu("test");
        assertFalse(c2.isVide());
    }

    @Test
    public void testToString() {
        Cases c = new Cases();
        assertEquals(" ", c.toString());
        c.modifierContenu("test");
        assertEquals("test", c.toString());
    }

    @Test
    public void testCaseNonVide() {
        Cases c = new Cases();
        c.caseNonVide();
        assertFalse(c.isVide());
    }
}
