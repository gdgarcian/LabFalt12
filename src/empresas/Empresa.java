
package empresas;

import java.util.*;


public class Empresa {
    
    private String nombre;
    private TreeMap <String,Sucursal> sucursal;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.sucursal = new TreeMap<>();
        this.test();
    }


    public ArrayList<Empleado> listarTodosEmpleados(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        for(Sucursal s : sucursal.values()){
            for(Empleado e : s.listarTodosEmpleados()){
                empleados.add(e);
            }
        }
        return empleados;
    }
    
    public boolean agregarSucursal(Sucursal s){
        if(sucursal.containsKey(s.getCiudad())){
            return false;
        }else{
            sucursal.put(s.getCiudad(), s);
            return true;
        }
    }
    
     public ArrayList<Empleado> listarEmpleadosMayores(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        for(Sucursal s : sucursal.values()){
            
            empleados.add(s.listEmpleadoMayor());
        }
        return empleados;
    }
    
     public ArrayList<Empleado> listarEmpleadosSucursal(String ciudad){
        ArrayList<Empleado> empleados = new ArrayList<>();
        Sucursal s = sucursal.get(ciudad);
        for(Empleado e : s.listarTodosEmpleados()){
            empleados.add(e);
        }
        return empleados;
    }
     
     public ArrayList<Sucursal> listarTodasSucursales(){
         ArrayList<Sucursal> sucursales = new ArrayList<>();
         for(Sucursal s : sucursal.values())
             sucursales.add(s);
         return sucursales;
     }
     
     public Sucursal sucursalMayorEmpleados(){
         Sucursal sMayor = null;
         int nEmpleados = 0;
           for(Sucursal s : sucursal.values()){
           if(sMayor == null){
               sMayor = s;
               nEmpleados = s.listarTodosEmpleados().size();
           }else{
               if(s.listarTodosEmpleados().size() >= nEmpleados){
                   sMayor = s;
                   nEmpleados = s.listarTodosEmpleados().size();
               }
                   
           }
        }
         return sMayor;
     }

    public TreeMap<String, Sucursal> getSucursal() {
        return sucursal;
    }

    private void test() {
        Sucursal s1 = new Sucursal("Bogota");
        Sucursal s2 = new Sucursal("Cucuta");
        Empleado e1 = new Empleado("1234", "Pacho Santos", 50);
        Empleado e2 = new Empleado("0000", "Arnol Suarseneller", 45);
        Empleado e3 = new Empleado("4321", "Pirry", 55);
        
        s1.ingresarEmp(e1);
        s1.ingresarEmp(e3);
        s2.ingresarEmp(e2);
        
        this.sucursal.put(s1.getCiudad(), s1);
        this.sucursal.put(s2.getCiudad(), s2);
    }
     
     
    
}