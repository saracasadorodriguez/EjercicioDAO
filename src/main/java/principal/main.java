/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author sarac
 */
public class main {
    public static void main(String[] args) throws IOException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; 
 
        while (!salir) {
 
           System.out.println("\n    Base de datos de clientes ");
           System.out.println("-----------------------------------");
           System.out.println("1.- Visualizar los diez siguientes");
           System.out.println("2.- Visualizar los diez anteriores");
           System.out.println("3.- Introducir nuevo registro");
           System.out.println("4.- Actualizar dato de cliente por IdCliente ");
           System.out.println("5.- Borrar dato por IdCliente");
           System.out.println("0.- Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                   
                    case 1:
                       
                    break;
                    
                    case 2:
                        
                    break;
                    
                    case 3:
                        
                    break;
                    
                    case 4:
                        
                    break;
                    
                    case 5:
                        
                    break;
                    
                    case 0:
                        salir = true;
                        System.out.println("Fin de la aplicación");
                    break;
                    
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
    }
}
