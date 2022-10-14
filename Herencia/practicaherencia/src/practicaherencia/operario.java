/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaherencia;

/**
 *
 * @author UTN
 */
public class operario extends empleado{
    private double piezasproducidads;
    private double salarioporpieza;

    public operario(double piezasproducidads, double salarioporpieza, String cedula, String nombre, int mesingreso, int añodeingreso, double salarioneto, double porcentaje) {
        super(cedula, nombre, mesingreso, añodeingreso, salarioneto, porcentaje);
        this.piezasproducidads = piezasproducidads;
        this.salarioporpieza = salarioporpieza;
    }
    public double calculasalrioOperario(){
        return(super.calculasalario()+(this.piezasproducidads*this.salarioporpieza));
    }
    public String toStrignOperario(){
        return(super.ToStringEmpleado()+"\n"+
                "Operario de Planta-"+" Piezas Producidas "+this.piezasproducidads+ " Salario por pieza "+this.salarioporpieza+"\n"
                + "Salario Neto Obtenido:"+calculasalrioOperario());
    }
  
    
}
