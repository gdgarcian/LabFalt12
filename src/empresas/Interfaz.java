/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Vladimir
 */
public class Interfaz {
    
    Empresa umbrella;
    
    public Interfaz(Empresa umbrella){
           this.umbrella = umbrella;
    }
    
    public void listarTodosEmpleados(ArrayList<Empleado> list){
        for(Empleado e : list){
            System.out.println(e.toString());
        }
    }
    
    public void agregarSucursal(String ciudad){
        Sucursal s = new Sucursal(ciudad);
        boolean agregarSucursal = umbrella.agregarSucursal(s);
        if(agregarSucursal){
            System.out.println("La sucursal ha sido agregada con exito.");
        }else{
            System.out.println("La sucursal ya existe en " + ciudad + ".");
        }
        
    }
    
    public void listarEmpleadosMayores(ArrayList<Empleado> list){        
        
        for(Empleado e : list){
            if(e != null)
            System.out.println(e.toString());
        }
    }
    
    public void listarEmpleadosSucursal(String ciudad){
        Sucursal temp = null;
        if(umbrella.getSucursal().containsKey(ciudad)){
           temp = umbrella.getSucursal().get(ciudad);
           if(temp.getNumEmpleados() > 0){
               for(Empleado e : temp.listarTodosEmpleados())
                   System.out.println(e.toString());
           }else{
               System.out.println("Esta sucursal no tiene empleados");
           }
        }else{
            System.out.println("Esta sucursal no existe");
        }
        
    }
    
    public void listarTodasSucursales(ArrayList<Sucursal> list){
        for(Sucursal s : list){
            System.out.println(s.toString());
        }
    }
    
    public void sucursalMayorEmpleados(Sucursal s){
        System.out.println("La sucursal con mayor numero de empleados esta en " +
                s.getCiudad() + " con " + s.getNumEmpleados() + " empleados.");
    }
    
    public void menu(){
        System.out.println("Bienvenido a Corporacion Umbrella");
        System.out.println("Seleccione una opcion ");
        System.out.println("1) Listar todos los empleados");
        System.out.println("2) Agregar Sucursal");
        System.out.println("3) Listar empleados mayores");
        System.out.println("4) Listar empleados por sucursal");
        System.out.println("5) Listar todas las sucursales");
        System.out.println("6) Sucursal con mayor cantidad de empleados");
        System.out.println("7) Salir");
    }
}