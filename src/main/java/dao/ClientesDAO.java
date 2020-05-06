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
    
    public ArrayList<POJO> mostrar(Integer desde, Integer cuantos, String order, String filtro) throws SQLException{
         ArrayList<POJO> mostrar = new ArrayList<>();
         POJO cliente = null;
         PreparedStatement stm = null;
        if (this.conexion == null){
            return null;
        }
        try{
            String sql = "SELECT * from clientes LIMIT ? " + ", ? ";
            stm = conexion.prepareStatement(sql); 
            ResultSet rs = stm.executeQuery(sql); 
            while(rs.next()){
                cliente = new POJO(
                    rs.getInt("id"),
                    rs.getString("codigo"),
                    rs.getString("empresa"),
                    rs.getString("contacto"),
                    rs.getString("carga_contacto"),
                    rs.getString("direccion"),
                    rs.getString("ciudad"),
                    rs.getString("region"),
                    rs.getInt("cp"),
                    rs.getString("pais"),
                    rs.getInt("telefono"),
                    rs.getInt("fax")
                    );
                    mostrar.add(cliente);
            }  
            }catch (SQLException e) {
            System.out.println("Error en el Select: "+e.getMessage()+stm.toString());
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
            String sql = "SELECT * FROM clientes WHERE id = ?";
            stm = conexion.prepareStatement(sql);

            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                cliente = new POJO (
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("empresa"),
                        rs.getString("contacto"),
                        rs.getString("carga_contacto"),
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("region"),
                        rs.getInt("cp"),
                        rs.getString("pais"),
                        rs.getInt("telefono"),
                        rs.getInt("fax")
                    );
            }
            stm.close();

        } catch (SQLException e) {

            System.err.println("Error en el Select: " + e.getMessage() + stm.toString());
        }

        return cliente;  
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
              stm.setString(1, cliente.getCodigo());
              stm.setString(2, cliente.getEmpresa());
              stm.setString(3, cliente.getContacto());
              stm.setString(4, cliente.getCargo_contacto());
              stm.setString(5, cliente.getDireccion());
              stm.setString(6, cliente.getCiudad());
              stm.setString(7, cliente.getRegion());
              stm.setInt(8, cliente.getCp());
              stm.setString(9, cliente.getPais());
              stm.setInt(10, cliente.getTelefono());
              stm.setInt(11, cliente.getFax());
              stm.executeUpdate();

            if (stm.executeUpdate() > 0) {
                resultado = true;
            }
            
        }catch (SQLException e) {
           System.out.println("Error al insertar empleado: " + e.getMessage() + " " + stm.toString());
        }finally{
          try{
            if (stm != null){
                stm.close();
            } 
            }catch (SQLException e) {
                System.err.println("Error al insertar empleado: " + e.getMessage() + " " + stm.toString());
            }
          }
        return resultado;
    }
    
   
}
