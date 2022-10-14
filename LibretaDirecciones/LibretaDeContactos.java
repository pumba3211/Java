/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibretaDirecciones;
import java.util.ArrayList; //Librería para arrays
import javax.sound.midi.SysexMessage;

public class LibretaDeContactos {
    
    private ArrayList<Contacto> libreta;
    private int indice;
    
  public LibretaDeContactos(){
    libreta = new ArrayList<Contacto>();
    
  }
  
     public void agregarContacto(Contacto contacto){
         if(libreta.size() == 0){
             Contacto nn = new Contacto(contacto.nombre,contacto.direccion,contacto.telefono);
             libreta.add(contacto);
             System.out.println("Contacto ingresado en el primero");
             return;
         }
         else{
             int cont = libreta.size();
             libreta.add(cont,contacto);
         }
         
         
    }
    
     public void  buscarContacto(int tel){
           int cont = libreta.size()-1;
           if(cont==-1){
                 System.out.println("No hay contactos\n");
                 return;
             }
           String contacto= "";
            while(cont >= 0){
                Contacto temp = (Contacto)libreta.get(cont);
                if(temp.telefono == tel){
                    temp.getInformation(temp);
                    contacto = temp.getInformation(temp);
                    System.out.print(contacto+"\n");
                    return;
                }
                cont --;
            }
        
        System.out.println("Contacto no encontrado\n");
    }
      
    public void eliminarContacto(int tel){    
        
     
             int cont = libreta.size()-1;
             if(cont==-1){
                 System.out.println("No hay contactos\n");
                 return;
             }
             while(cont >= 0){
                 Contacto temp = (Contacto)libreta.get(cont);
                 if(temp.telefono == tel){
                    libreta.remove(cont);
                    System.out.print("Contacto eliminado\n");
                    return;
                }         
                 cont--;
             }
             System.out.println("Contacto no encontrado\n");
             return;
         
         
    }
    
    public void imprimirContactos(){
        String contactos= "";
        int i= 0;
        System.out.println("*******Contactos*******\n");
        for(int cont = 0; cont <= libreta.size()-1;cont++){
            Contacto temp = (Contacto)libreta.get(cont);
            contactos = temp.getInformation(temp)+"\n";
             System.out.print(contactos);
             i ++;
        }
        if(i == 0){
          System.out.println("No hay contactos");
        }
    }
    
}
