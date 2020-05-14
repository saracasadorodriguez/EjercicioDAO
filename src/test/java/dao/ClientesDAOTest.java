package dao;

import entidades.POJO;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sarac
 */

public class ClientesDAOTest {
    
    static ClientesDAO clientes;
    
    public ClientesDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        clientes = new ClientesDAO();
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
     * Test of getConexion method, of class ClientesDAO.
     */
    
    @Test
    public void testGetConexion() {
        System.out.println("getConexion");
        ClientesDAO instance = new ClientesDAO();
        Connection resesperado = null;
        Connection resultado = instance.getConexion();
        assertNotEquals(resesperado, resultado);
        
    }

    /**
     * Test of mostrar method, of class ClientesDAO.
     */
    
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        Integer desde = 0;
        Integer hasta = 10;
        ArrayList<POJO> resesperado = null;
        ArrayList<POJO> resultado = clientes.mostrar(desde, hasta);
        assertNotEquals(null, resultado);
    }

    /**
     * Test of read method, of class ClientesDAO.
     */
    
    @Test
    public void testRead() {
        System.out.println("Read");
        POJO resesperado = new POJO (1,"ALFKI","Alfreds Futterkiste","Maria Anders","Representante de ventas","Obere Str. 57","Berlín",null,"12209","Alemania","030-0074321","030-0076545");
        POJO resultado;
        resultado = clientes.read(1);
        assertEquals(resultado.getId(),resesperado.getId());
    }

    /**
     * Test of maxid method, of class ClientesDAO.
     */
    
    @Test
    public void testMaxid() {
        System.out.println("maxid");
        ClientesDAO instance = new ClientesDAO();
        Integer resesperado = null;
        Integer resultado = instance.maxid();
        assertEquals(resesperado, resultado);
    }

    /**
     * Test of insert method, of class ClientesDAO.
     */
    
    @Test
    public void testInsert() {
        System.out.println("Insert");
        POJO cliente = null;
        Boolean resesperado = true;
        Boolean resultado;
        resultado = clientes.insert(cliente);
        assertEquals(resesperado, resultado);
    }

    /**
     * Test of update method, of class ClientesDAO.
     */
    
    @Test
    public void testUpdate() {
        System.out.println("Update");
        POJO cliente = null;
        ClientesDAO instance = new ClientesDAO();
        Boolean resesperado = null;
        Boolean resultado;
        resultado = instance.update(cliente);
        assertEquals(resesperado, resultado);
    }

    /**
     * Test of delete method, of class ClientesDAO.
     */
    
    @Test
    public void testDelete() {
        System.out.println("Delete");
        Integer idCliente = null;
        ClientesDAO instance = new ClientesDAO();
        Boolean resesperado = null;
        Boolean resultado;
        resultado = instance.delete(idCliente);
        assertEquals(resesperado, resultado);
    }
    
}
