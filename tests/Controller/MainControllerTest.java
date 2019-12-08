package Controller;

import Model.Cliente;
import Model.Estadia;
import Model.Quarto;
import Util.ResponseMessage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * testes do Controller principal
 * @author sarah.freitas
 */
public class MainControllerTest {
    
    public MainControllerTest() {
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
     * Test of adicionarCliente method, of class MainController.
     */
    @Test
    public void testAdicionarCliente() {
        MainController instance = new MainController();
        ResponseMessage result = instance.adicionarCliente("1", "rua do teste", "Joao", "999999");
        assertEquals(true, result.status);
    }

    /**
     * Test of adicionarFuncionario method, of class MainController.
     */
    @Test
    public void testAdicionarFuncionario() {
        MainController instance = new MainController();
        ResponseMessage result = instance.adicionarFuncionario("1", "Gerente", "Jose", "9123123", "2342.43");
        assertEquals(true, result.status);
    }

    /**
     * Test of adicionarQuarto method, of class MainController.
     */
    @Test
    public void testAdicionarQuarto() {
        System.out.println("adicionarQuarto");
        MainController instance = new MainController();
        instance.adicionarQuarto("1", "3", "200");
    }

    /**
     * Test of adicionarEstadia method, of class MainController.
     */
    @Test
    public void testAdicionarEstadia() {
        MainController instance = new MainController();
        instance.adicionarCliente("1", "rua do teste", "Joao", "999999");
        instance.adicionarQuarto("1", "3", "100");
        
        ResponseMessage result = instance.adicionarEstadia("1", "1", "2", "01/02/2020", "10/02/2020");
        assertEquals(true, result.status);
    }

    /**
     * Test of finalizarEstadia method, of class MainController.
     */
    @Test
    public void testFinalizarEstadia() {
        MainController instance = new MainController();
        
        instance.adicionarCliente("1", "rua do teste", "Joao", "999999");
        instance.adicionarQuarto("1", "3", "100");
        instance.adicionarEstadia("1", "1", "2", "01/02/2020", "10/02/2020");
        
        ResponseMessage result = instance.finalizarEstadia(1);
        assertEquals(true, result.status);
    }

    /**
     * Test of buscarCliente method, of class MainController.
     */
    @Test
    public void testBuscarCliente_int() {
        MainController instance = new MainController();
        instance.adicionarCliente("1", "rua do teste", "Joao", "999999");
        
        Cliente result = instance.buscarCliente(1);
        assertEquals(1, result.getCodigo());
    }

    /**
     * Test of buscarCliente method, of class MainController.
     */
    @Test
    public void testBuscarCliente_String() {
        MainController instance = new MainController();
        instance.adicionarCliente("1", "rua do teste", "Joao", "999999");
        Cliente result = instance.buscarCliente("Joao");
        assertEquals("Joao", result.getNome());
    }

    /**
     * Test of buscarEstadiasDoCliente method, of class MainController.
     */
    @Test
    public void testBuscarEstadiasDoCliente() {
        MainController instance = new MainController();
        instance.adicionarCliente("1", "rua do teste", "Joao", "999999");
        instance.adicionarQuarto("1", "3", "100");
        instance.adicionarEstadia("1", "1", "2", "01/02/2020", "10/02/2020");
        
        ArrayList<Estadia> expResult = new ArrayList<>();
        expResult.add(instance.buscarEstadia(1));        
        ArrayList<Estadia> result = instance.buscarEstadiasDoCliente(1);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarQuartoVago method, of class MainController.
     */
    @Test
    public void testBuscarQuartoVago() {
        MainController instance = new MainController();
        instance.adicionarCliente("1", "rua do teste", "Joao", "999999");
        instance.adicionarQuarto("1", "3", "100");
        
        try {        
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dtEntrada = df.parse("01/02/2020");
            Date dtSaida = df.parse("10/02/2020");

            Quarto result = instance.buscarQuartoVago(dtEntrada, dtSaida, 2);
            assertEquals(1, result.getNumero());
        
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of buscarEstadia method, of class MainController.
     */
    @Test
    public void testBuscarEstadia() {
        MainController instance = new MainController();
        instance.adicionarCliente("1", "rua do teste", "Joao", "999999");
        instance.adicionarQuarto("1", "3", "100");
        instance.adicionarEstadia("1", "1", "2", "01/02/2020", "10/02/2020");
        
        Estadia result = instance.buscarEstadia(1);
        assertEquals(1, result.getCodigo());
    }

    /**
     * Test of buscarQuantidadePontosFidelidadeCliente method, of class MainController.
     */
    @Test
    public void testBuscarQuantidadePontosFidelidadeCliente() {
        MainController instance = new MainController();        
        instance.adicionarCliente("1", "rua do teste", "Joao", "999999");
        instance.adicionarQuarto("1", "3", "100");
        instance.adicionarEstadia("1", "1", "2", "01/02/2020", "10/02/2020");
        
        int result = instance.buscarQuantidadePontosFidelidadeCliente(1);
        assertEquals(10, result);
    }
    
}
