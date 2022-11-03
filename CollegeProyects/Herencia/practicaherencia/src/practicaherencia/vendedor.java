/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaherencia;

/**
 *
 * @author UTN
 */
public class vendedor extends empleado {
    double porcentajedecomision;
    double porcentajedeventas;
 
    public vendedor(double porcentajedecomision, double porcentajedeventas, String cedula, String nombre, int mesingreso, int añodeingreso, double salarioneto, double porcentaje) {
        super(cedula, nombre, mesingreso, añodeingreso, salarioneto, porcentaje);
        this.porcentajedecomision = porcentajedecomision;
        this.porcentajedeventas = porcentajedeventas;
    }

    public double getPorcentajedecomision() {
        return porcentajedecomision;
    }

    public void setPorcentajedecomision(double porcentajedecomision) {
        this.porcentajedecomision = porcentajedecomision;
    }

    public double getPorcentajedeventas() {
        return porcentajedeventas;
    }

    public void setPorcentajedeventas(double porcentajedeventas) {
        this.porcentajedeventas = porcentajedeventas;
    }
    public double calculasalario(){
        return(super.calculasalario()+(this.porcentajedeventas*(this.porcentajedecomision/100)));
    }
    public String toStringVendedor(){
        return(super.ToStringEmpleado()+"\n"+
                "Vendedor-"+" Porcentaje de Comision: "+this.porcentajedecomision+"% "+ " Monto de ventas: "+this.porcentajedeventas+"\n"
                + "Salario Neto Obtenido:"+calculasalario());
    }
}
