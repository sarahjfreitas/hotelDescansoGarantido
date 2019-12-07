package Util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * tests for Util.ResponseMessageTest
 * @author sarah.freitas
 */
public class ResponseMessageTest {
    
    public ResponseMessageTest() {
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

    @Test
    public void testContructorMessage() {
        ResponseMessage r = new ResponseMessage(true,"mensagem de sucesso");
        assertEquals("mensagem de sucesso",r.mensagem);
    }
    
    @Test
    public void testContructorStatus() {
        ResponseMessage r = new ResponseMessage(true,"mensagem de sucesso");
        assertEquals(true,r.status);
    }
    
}
