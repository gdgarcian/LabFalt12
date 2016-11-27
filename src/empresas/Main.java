/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas;
import java.util.*;

public class Main {
    
    
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Empresa umbrella = new Empresa("Corporacion Umbrella");
        Interfaz interfaz = new Interfaz(umbrella);
        String ciudad = null;
        char seleccion;
        while(true){
            interfaz.menu();
            
            
            seleccion = entrada.next().charAt(0);
            switch(seleccion){
                case '1':
                    interfaz.listarTodosEmpleados(umbrella.listarTodosEmpleados());
                break;
                 case '2':                     
                     System.out.println("Ingrese el nombre de la ciudad de la nueva sucursal.");
                     ciudad = entrada.next();
                     interfaz.agregarSucursal(ciudad);
                break;
                 case '3':
                     
                     interfaz.listarEmpleadosMayores(umbrella.listarEmpleadosMayores());
                     
                break;
                 case '4':
                     System.out.println("Ingrese el nombre de la ciudad de la sucursal.");
                     ciudad = entrada.next();
                     interfaz.listarEmpleadosSucursal(ciudad);
                break;
                 case '5':
                     interfaz.listarTodasSucursales(umbrella.listarTodasSucursales());
                break;
                 case '6':
                     interfaz.sucursalMayorEmpleados(umbrella.sucursalMayorEmpleados());
                     break;
                 case '7':
                     System.exit(0);
                    break;
                 default:
                     System.out.println("Ingrese un valor numerico entre 1 - 7");
            }        
            
            
        }
    }
}