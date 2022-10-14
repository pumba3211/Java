/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobanco;

/**
 *
 * @author Ronald
 */
public class Cliente {
    private String Nombre;
    private int cedula;
    private String Tipo;
    private int contadorA;
    private int contadorB;
    private int contadorC;
    private String ficha;

    public Cliente(String Nombre, int cedula, String Tipo) {
        this.Nombre = Nombre;
        this.cedula = cedula;
        this.Tipo = Tipo;
        this.contadorA = 1;
        this.contadorB =1;
        this.contadorC = 1;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getContadorA() {
        return contadorA;
    }

    public void setContadorA(int contadorA) {
        this.contadorA = contadorA;
    }

    public int getContadorB() {
        return contadorB;
    }

    public void setContadorB(int contadorB) {
        this.contadorB = contadorB;
    }

    public int getContadorC() {
        return contadorC;
    }

    public void setContadorC(int contadorC) {
        this.contadorC = contadorC;
    }
    public int crearnumerorandom(){
        int num=(int)(Math.random()*3)+1;
        return(num);
    }
    public String creacionficha(){
        if(contadorA>99){
            contadorA=1;
        }
        if(contadorB>99){
            contadorB=1;
        }
        if(contadorC>99){
            contadorC=1;
        }
        else if(crearnumerorandom()==1){
            ficha=contadorA+"A";
            contadorA++;
        }
        else if(crearnumerorandom()==2){
            ficha=contadorB+"B";
            contadorB++;
        }
        else{
            ficha=contadorC+"C";
            contadorC++;
        }
        return(ficha);
    } 
            
}
