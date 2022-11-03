/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibretaDirecciones;


public class Contacto {
    
    String nombre;
    String direccion;
    int telefono;
    
    public Contacto(String n, String d, int t){
        nombre = n;
        direccion = d;
        telefono = t;
    }
    
    public void set(String n, String d, int t){
        nombre = n;
        direccion = d;
        telefono = t;
    }
    
    /*Métodos get*/
    public String getNombre(){
        return nombre;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public int getTelefono(){
        return telefono;
    }
    
    public String getInformation(Contacto cont){
        String info= "";
        
        info = cont.nombre +" ,"+cont.direccion+" ,"+cont.telefono;
        
       return info;
    }
}
