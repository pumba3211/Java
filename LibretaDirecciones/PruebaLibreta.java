/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibretaDirecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PruebaLibreta {
    
    public static LibretaDeContactos LC = new LibretaDeContactos();
 
    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args)throws IOException {
        // TODO code application logic here
         LibretaDeContactos instancia = new LibretaDeContactos();
         
         InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader br = new BufferedReader(isr);
         String name = "";
         String address = "";
         String telephone = "";
         int tel;
        while(true){
         System.out.print("*******Menu********\n");
         System.out.print("1) Agregar contacto\n");
         System.out.print("2) Imprimir la informacion de un determinado contacto\n");
         System.out.print("3) Eliminar un determinado contacto\n");
         System.out.print("4) Mostrar la informacion de todos los contactos\n");
         System.out.print("5) Salir\n");
         System.out.print("Seleccione el numero de la opcion deseada: ");
         int entero1 = Integer.parseInt(br.readLine());
         switch(entero1){
             case 1:
                System.out.print("Ingrese el nombre: "); 
                name = br.readLine();
                System.out.print("Ingrese la direccion: "); 
                address = br.readLine();
                System.out.print("Ingrese el telefono (Solo numeros): "); 
                tel = Integer.parseInt(br.readLine());
                Contacto contact = new Contacto(name, address, tel);
                LC.agregarContacto(contact);
                break;

            case 2: 
                System.out.print("Ingrese el telefono de la persona a buscar (Solo numeros): ");
                tel = Integer.parseInt(br.readLine());
                LC.buscarContacto(tel);
                break;

            case 3:
                System.out.print("Ingrese el telefono de la persona a buscar (Solo numeros): ");
                tel = Integer.parseInt(br.readLine());
                LC.eliminarContacto(tel);
                break;
            case 4:
                LC.imprimirContactos();
                break;
            case 5:
                System.exit(0);
                break;
            default: 
                 System.out.println("Opcion invalida");
            break;
         }
        }
    }
}
