package principal;

import dao.ClientesDAO;
import entidades.POJO;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author sarac
 */

public class principal {
    
    static ClientesDAO clientes = new ClientesDAO();
    static POJO entidades = null;
    
    public static void main(String[] args) throws IOException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        int visualizar = 0;
         
        while (!salir){
 
           System.out.println("\n   Base de datos de clientes ");
           System.out.println("-----------------------------------");
           System.out.println("1.- Visualizar los diez siguientes");
           System.out.println("2.- Visualizar los diez anteriores");
           System.out.println("3.- Introducir nuevo registro");
           System.out.println("4.- Actualizar datos de cliente por IdCliente ");
           System.out.println("5.- Borrar datos por IdCliente");
           System.out.println("0.- Salir");
 
            try {
                
                System.out.println("Introduzca una de las opciones :");
                opcion = sn.nextInt();
 
                switch (opcion) {
                   
                    case 1:  
                    
                    break;
                    
                    case 2:
                        
                    break;
                    
                    case 3:
                    introducir();  
                    break;
                    
                    case 4:
                    actualizar();
                    break;
                    
                    case 5:
                    eliminar();
                    break;
                    
                    case 0:
                        salir = true;
                        System.out.println("Fin de la aplicación");
                    break;
                    
                    default:
                        System.out.println("Solo números entre 0 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
    
    /*
    //apartado1-2
    public static void visualizar (POJO entidades, ClientesDAO clientes, Integer desde, Integer hasta){
        System.out.println("__________________________________________________________________________________________________________________________");
        				
        System.out.println("   Id     Codigo    Empresa     Contacto     Cargo     C.Postal    Ciudad     Pais     Telefono     Fax  ");
        System.out.println("___________________________________________________________________________________________________________________________");
        					
       
        System.out.println("___________________________________________________________________________________________________________________________");
        
    }*/
    
    //apartado3
    public static void introducir() throws IOException{ 
        Scanner sc = new Scanner(System.in);
        POJO cliente = new POJO();
        
        System.out.println("Introducir Codigo del Cliente ");
            cliente.setCodigo(sc.nextLine());
            
        System.out.println("Introducir Empresa del Cliente ");
            cliente.setEmpresa(sc.nextLine());
            
        System.out.println("Introducir Contacto ");
            cliente.setContacto(sc.nextLine());
            
        System.out.println("Introduir Cargo Contacto del Cliente ");
            cliente.setCargo_contacto(sc.nextLine());
            
        System.out.println("Introducir la Dirección del Cliente ");
            cliente.setDireccion(sc.nextLine());
            
        System.out.println("Introducir Ciudad del Cliente ");
            cliente.setCiudad(sc.nextLine());
            
        System.out.println("Introducir Region del Cliente ");
            cliente.setRegion(sc.nextLine());
            
        System.out.println("Introducir Código Postal del Cliente ");
            cliente.setCp(sc.nextInt());
            
        System.out.println("Introducir Pais del Cliente ");
            cliente.setPais(sc.nextLine());
            
        System.out.println("Introducir Teléfono del Cliente ");
            cliente.setTelefono(sc.nextInt());
            
        System.out.println("Introducir Fax del Cliente ");
            cliente.setFax(sc.nextInt());
            
        System.out.println("El cliente " + cliente.getCodigo() + " con nombre " + cliente.getContacto() + " ha sido añadido.");
        
    }
    
    //apartado4
    public static void actualizar() throws IOException{
        Scanner sc = new Scanner(System.in);
        POJO cliente = null;
        System.out.println("Introduce el ID del cliente que desea modificar : ");
        Integer id = Integer.parseInt(sc.nextLine());
       
        while (true) {
            try { 
                System.out.println("\n Opciones que puede modificar");
                    System.out.println("1.- Codigo");
                    System.out.println("2.- Empresa");
                    System.out.println("3.- Contacto");
                    System.out.println("4.- Cargo");
                    System.out.println("5.- Dirección ");
                    System.out.println("6.- Ciudad");
                    System.out.println("7.- Región");
                    System.out.println("8.- Código Postal");
                    System.out.println("9.- Pais");
                    System.out.println("10.- Teléfono");
                    System.out.println("11.- Fax");
                    
                    System.out.print("\nIntroduzca la modificación que desea realizar : ");
                    Integer opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.printf("Introducir modificacion del Codigo : ");
                        cliente.setCodigo(sc.nextLine());
                        clientes.update(cliente);
                        System.out.println("El cliente " + id + " ha sido modificado correctamente.");
                        break;
                    case 2:
                        System.out.printf("Introducir modificacion de Empresa : ");
                        cliente.setEmpresa(sc.nextLine());
                        clientes.update(cliente);
                        System.out.println("El cliente " + id + " ha sido modificado correctamente.");
                    break;
                    case 3:
                        System.out.printf("Introducir modificacion de Contacto : ");
                        cliente.setContacto(sc.nextLine());
                        clientes.update(cliente);
                        System.out.println("El cliente " + id + " ha sido modificado correctamente.");
                    break;
                    case 4:
                        System.out.printf("Introducir modificacion de Cargo : ");
                        cliente.setCargo_contacto(sc.nextLine());
                        clientes.update(cliente);
                        System.out.println("El cliente " + id + " ha sido modificado correctamente.");
                    break;
                    case 5:
                        System.out.printf("Introducir modificacion de Direccion : ");
                        cliente.setDireccion(sc.nextLine());
                        clientes.update(cliente);
                        System.out.println("El cliente " + id + " ha sido modificado correctamente.");
                    break;
                    case 6:
                         System.out.printf("Introducir modificacion de Ciudad : ");
                        cliente.setCiudad(sc.nextLine());
                        clientes.update(cliente);
                        System.out.println("El cliente " + id + " ha sido modificado correctamente.");
                    break;
                    case 7:
                        System.out.printf("Introducir modificacion de Region : ");
                        cliente.setRegion(sc.nextLine());
                        clientes.update(cliente);
                        System.out.println("El cliente " + id + " ha sido modificado correctamente.");
                    break;
                    case 8:
                        System.out.printf("Introducir modificacion de Codigo Postal : ");
                        cliente.setCp(Integer.parseInt(sc.nextLine()));
                        clientes.update(cliente);
                        System.out.println("El cliente " + id + " ha sido modificado correctamente.");
                    break;
                    case 9:
                        System.out.printf("Introducir modificacion de Pais : ");
                        cliente.setPais(sc.nextLine());
                        clientes.update(cliente);
                        System.out.println("El cliente " + id + " ha sido modificado correctamente.");
                    break;
                    case 10:
                        System.out.printf("Introducir modificacion de Telefono : ");
                        cliente.setTelefono(Integer.parseInt(sc.nextLine()));
                        clientes.update(cliente);
                        System.out.println("El cliente " + id + " ha sido modificado correctamente.");
                    break;
                    case 11:
                        System.out.printf("Introducir modificacion de Fax : ");
                        cliente.setFax(Integer.parseInt(sc.nextLine()));
                        clientes.update(cliente);
                        System.out.println("El cliente " + id + " ha sido modificado correctamente.");
                    break;
                    default:
                        System.out.println("\nSolo debe introducir números entre 1 y 11\n");
                }
            } catch (NumberFormatException e) {
                System.err.println("\nError: " + e.getMessage() + "\n");
            }
        }
    }
    
    //apartado5
    public static void eliminar() throws IOException{
       Scanner sc = new Scanner(System.in);
        
        System.out.printf("\nIntroduce el ID del cliente que desea eliminar : ");
           Integer id = Integer.parseInt(sc.next());
           clientes.delete(id);
        System.out.println("El cliente " + id + " ha sido eliminado Correctamente.");  
    }

}

    

    
                

    

