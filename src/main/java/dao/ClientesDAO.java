package dao;

import entidades.POJO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sarac
 */

public class ClientesDAO {
     private Connection conexion = null;

    //establecer la conexion con la base de datos
    public ClientesDAO() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/neptuno", "root", "");
        } catch (SQLException ex) {
            System.err.println("Error al conectar: " + ex.getMessage());
            //ex.printStackTrace(); //usarlo sólo cuando se hacen pruebas del programa ya que avisa de dónde se encuentra el problema
        }
    }

    //comprobar la conexion con la base de datos
    public Connection getConexion() {
        return conexion;
    }
    
    //mostrar clientes utilizando Arraylist
    public ArrayList<POJO> mostrar(Integer desde, Integer hasta){
         ArrayList<POJO> mostrar = new ArrayList<>();
         POJO cliente = null;
         PreparedStatement stm = null;
         
        if (this.conexion == null){
            return null;
        }
        try{
            String sql = "SELECT * FROM clientes LIMIT ? " + ", ? ";
            stm = conexion.prepareStatement(sql); 
            stm.setInt(1,desde);
            stm.setInt(2,hasta);
            ResultSet rs = stm.executeQuery(); 
            while(rs.next()){
                cliente = new POJO(
                    rs.getInt("id"),
                    rs.getString("codigo"),
                    rs.getString("empresa"),
                    rs.getString("contacto"),
                    rs.getString("cargo_contacto"),
                    rs.getString("direccion"),
                    rs.getString("ciudad"),
                    rs.getString("region"),
                    rs.getString("cp"),
                    rs.getString("pais"),
                    rs.getString("telefono"),
                    rs.getString("fax")
                    );
                
                    mostrar.add(cliente);
            }  
            }catch (SQLException e) {
            System.out.println("Error en el Select: "+e.getMessage()+ stm.toString());
            }  
            return mostrar;
    }

    //leer
    public POJO read(Integer idCliente){
        POJO cliente = null;
        PreparedStatement stm = null;
        
        if (this.conexion == null) {
            return null;
        }
        try {
            String sql = "SELECT * FROM clientes WHERE id = " + idCliente ;
            stm = conexion.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
           
            if (rs.next()) {
                
                cliente = new POJO (
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("empresa"),
                        rs.getString("contacto"),
                        rs.getString("cargo_contacto"),
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("region"),
                        rs.getString("cp"),
                        rs.getString("pais"),
                        rs.getString("telefono"),
                        rs.getString("fax")
                    );
            } 
            stm.close();

        } catch (SQLException e) {

            System.err.println("Error en el Select: " + e.getMessage() + stm.toString());
        }

        return cliente;  
    }
    
    //max
    public Integer maxid(){
        PreparedStatement stm = null;
        Integer id = null;
        
        if (this.conexion == null) {
            return null;
        }
        
        try {
            String sql = "SELECT MAX(id) FROM `clientes`";
            stm = conexion.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                id = rs.getInt("maxid"); 
            }
            stm.close();
            
        } catch (SQLException e) {
            System.err.println("Error en el Select: " + e.getMessage() + stm.toString());
        }
        return id;
    }
    
    //introducir 
    public Boolean insert(POJO cliente){ 
      Boolean resultado = false;
      PreparedStatement stm = null;
      
        if (this.conexion == null || cliente == null) {
            return null;
        }
        
        try{
            String sql = "INSERT INTO CLIENTES VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
            stm = conexion.prepareStatement(sql);
              stm.setInt(1, cliente.getId());
              stm.setString(2, cliente.getCodigo());
              stm.setString(3, cliente.getEmpresa());
              stm.setString(4, cliente.getContacto());
              stm.setString(5, cliente.getCargo_contacto());
              stm.setString(6, cliente.getDireccion());
              stm.setString(7, cliente.getCiudad());
              stm.setString(8, cliente.getRegion());
              stm.setString(9, cliente.getCp());
              stm.setString(10, cliente.getPais());
              stm.setString(11, cliente.getTelefono());
              stm.setString(12, cliente.getFax());
              stm.executeUpdate();

            if (stm.executeUpdate() > 0) {
                resultado = true;
            }
            
        }catch (SQLException e) {
           System.out.println("Error al insertar cliente: " + e.getMessage());
        }finally{
          try{
            if (stm != null){
                stm.close();
            } 
            }catch (SQLException e) {
                System.err.println("Error al insertar cliente: " + e.getMessage() + " " + stm.toString());
            }
          }
        return resultado;
    }
    
    
     //actualizar datos del cliente
    public Boolean update(POJO cliente){
        Boolean resultado = null;
        PreparedStatement stm = null;

        if (this.conexion == null || cliente == null) {
            return false;
        }

        try {
            String sql = "UPDATE clientes SET codigo=?, empresa=?, contacto=?, cargo_contacto=?"
            + ", direccion=?, ciudad=?, region=?, cp=?, pais=?, telefono=?, fax=? WHERE id=?";

            stm = conexion.prepareStatement(sql);
            
            stm.setString(1, cliente.getCodigo());
            stm.setString(2, cliente.getEmpresa());
            stm.setString(3, cliente.getContacto());
            stm.setString(4, cliente.getCargo_contacto());
            stm.setString(5, cliente.getDireccion());
            stm.setString(6, cliente.getCiudad());
            stm.setString(7, cliente.getRegion());
            stm.setString(8, cliente.getCp());
            stm.setString(9, cliente.getPais());
            stm.setString(10, cliente.getTelefono());
            stm.setString(11, cliente.getFax());
            stm.setInt(12, cliente.getId());
            
             if(stm.executeUpdate()>0){
                resultado = true;
            }
            
            
        } catch (SQLException e) {
            System.err.println("Error en el Update: " + e.getMessage());
            
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return resultado;
    }

    //eliminar
    public Boolean delete(Integer idCliente) {
        Boolean resultado = false;
        PreparedStatement stm = null;

        try {
            String sql = "DELETE FROM clientes WHERE id = ?";
            stm = conexion.prepareStatement(sql);
            stm.setInt(1, idCliente);

            resultado = stm.execute();

            stm.close();

            System.out.println();

        } catch (SQLException e) {

            System.err.println("Error en el Delete: " + e.getMessage() + " " + stm.toString());
        }
        
        return resultado;

    }
   
}
