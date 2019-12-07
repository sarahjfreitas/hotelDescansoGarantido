package Util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * tests for Util.Utilities
 * @author sarah.freitas
 */
public class UtilitiesTest {

    public UtilitiesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isInteger method, of class Utilities. - passing string text
     */
    @Test
    public void testIsIntegerPassingText() {
        assertEquals(Utilities.isInteger("entradaInvalida"), false);
    }

    /**
     * Test of isInteger method, of class Utilities. - passing string int
     */
    @Test
    public void testIsIntegerPassingInt() {
        assertEquals(Utilities.isInteger("14"), true);
    }

    /**
     * Test of isInteger method, of class Utilities. - passing string double
     */
    @Test
    public void testIsIntegerPassingDouble() {
        assertEquals(Utilities.isInteger("14.56"), false);
    }
    
    /**
     * Test of isInteger method, of class Utilities. - passing empty string
     */
    @Test
    public void testIsIntegerPassingEmpty() {
        assertEquals(Utilities.isInteger(""), false);
    }
    
    /**
     * Test of isInteger method, of class Utilities. - passing null
     */
    @Test
    public void testIsIntegerPassingNull() {
        assertEquals(Utilities.isInteger(null), false);
    }
    
    /**
     * Test of isDouble method, of class Utilities. - passing string text
     */
    @Test
    public void testisDoublePassingText() {
        assertEquals(Utilities.isDouble("entradaInvalida"), false);
    }

    /**
     * Test of isDouble method, of class Utilities. - passing string int
     */
    @Test
    public void testisDoublePassingInt() {
        assertEquals(Utilities.isDouble("14"), true);
    }

    /**
     * Test of isDouble method, of class Utilities. - passing string double
     */
    @Test
    public void testisDoublePassingDouble() {
        assertEquals(Utilities.isDouble("14.56"), true);
    }
    
    /**
     * Test of isDouble method, of class Utilities. - passing empty string
     */
    @Test
    public void testisDoublePassingEmpty() {
        assertEquals(Utilities.isDouble(""), false);
    }
    
    /**
     * Test of isDouble method, of class Utilities. - passing null
     */
    @Test
    public void testisDoublePassingNull() {
        assertEquals(Utilities.isDouble(null), false);
    }

}
