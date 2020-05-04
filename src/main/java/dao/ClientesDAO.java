package dao;

import entidades.POJO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    //comprobar la conexion con la base de datos3
    public Connection getConexion() {
        return conexion;
    }
    
    //introducir 
    public Boolean insert(POJO cliente){ 
      Boolean resultado = false;
      PreparedStatement stm = null;
      
      if (this.conexion == null || cliente == null) {
            return false;
        }

    try{
        if(cliente != null){
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/neptuno", "root", "");
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
              stm.setInt(9, cliente.getCp());
              stm.setString(10, cliente.getPais());
              stm.setInt(11, cliente.getTelefono());
              stm.setInt(12, cliente.getFax());
           

            if (stm.executeUpdate() > 0) {
                resultado = true;

            }

          }
      }catch (SQLException ex) {
           System.err.println("Error al insertar empleado: " + ex.getMessage() + " " + stm.toString());
      }finally{
          try{
              stm.close();
              conexion.close();
          } catch (SQLException ex) {
             System.err.println("Error al insertar empleado: " + ex.getMessage() + " " + stm.toString());
          }
      }
      return resultado;
  
 }
    
}
