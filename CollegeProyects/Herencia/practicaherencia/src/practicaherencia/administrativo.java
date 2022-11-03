/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaherencia;

/**
 *
 * @author UTN
 */
public class administrativo extends empleado {
    private int horaextra;

    public administrativo(int horaextra, String cedula, String nombre, int mesingreso, int añodeingreso, double salarioneto, double porcentaje) {
        super(cedula, nombre, mesingreso, añodeingreso, salarioneto, porcentaje);
        this.horaextra = horaextra;
    }
    public double calculasalarioadministrativo(){
        double pagoanualidad=super.calculasalario();
        double pagosemanal=pagoanualidad/4.33;
        double costohora=pagosemanal/48;
        double horasextra=(costohora*this.horaextra)*1.5;
        double total=pagoanualidad+horasextra;
        return(total);
    }
    public String toStringAdministrativo(){
        return (super.ToStringEmpleado()+"\n"+"Administrativos- Horas extras laboradas "+this.horaextra+"\n"
                +"Salario Neto obtenido:"+calculasalarioadministrativo());
    }
    
}
