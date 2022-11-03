/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaherencia;

import java.util.Calendar;

/**
 *
 * @author UTN
 */
public class empleado {
    //atributos de la clase
    protected String cedula;
    protected String nombre;
    protected int mesingreso;
    protected int añodeingreso;
    protected double salarioneto;
    protected double porcentaje;
//metodo constructor
    public empleado(String cedula, String nombre, int mesingreso, int añodeingreso, double salarioneto, double porcentaje) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.mesingreso = mesingreso;
        this.añodeingreso = añodeingreso;
        this.salarioneto = salarioneto;
        this.porcentaje = porcentaje;
    }

    //metodo calculador de año de antiguedad
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMesingreso() {
        return mesingreso;
    }

    public void setMesingreso(int mesingreso) {
        this.mesingreso = mesingreso;
    }

    public int getAñodeingreso() {
        return añodeingreso;
    }

    public void setAñodeingreso(int añodeingreso) {
        this.añodeingreso = añodeingreso;
    }

    public double getSalarioneto() {
        return salarioneto;
    }

    public void setSalarioneto(double salarioneto) {
        this.salarioneto = salarioneto;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    //metodo que calcula la antiguedad del trabajador
    public int calculaAntiguedad() {
        int annosLaborados=0;
        int annoActual=0;
        Calendar calendario = Calendar.getInstance();
        annoActual = calendario.get(Calendar.YEAR);
        annosLaborados = annoActual - this.getAñodeingreso();
        if (calendario.get(Calendar.MONTH) >= this.getMesingreso())
            return annosLaborados;
        else
            return annosLaborados - 1;
    }
    //metodo calculador de salario
    public double calculasalario(){
        double total=this.salarioneto;
        for (int i = 1; i <= calculaAntiguedad(); i++) {
            total=total+(total*(this.porcentaje/100));
        }
        return(total);
    }
    public String ToStringEmpleado(){
        return("Empleado-"+" Cedula "+this.cedula+" Nombre "+this.nombre+"\n"+
                "Año de ingreso "+this.añodeingreso+ " Mes de ingreso "+this.mesingreso+"\n"+
                " Salario Base "+this.salarioneto+"\n"+
                "Antigüedad: "+calculaAntiguedad());
    }
    
}
