/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobanco;

/**
 *
 * @author Ronald
 */
public class cliente {

    //Atributos de la clase cliente
    protected String nombre;//Guarda el nombre del Cliente
    protected String cedula;//Guarda la cedula del cliente
    protected String tipo;//Guarda el tipo de persona adulto mayor, embarazada, normal
    protected int tiempoatendido;//Guarda el tiempo en que es atendido el cliente por el cajero
    protected String ficha;//Ficha que el cliente tendra a la hora de ingresar

    //Metodo constructor de la clase
    public cliente() {
        this.nombre = "";
        this.cedula = "";
        this.tipo = "";
        this.tiempoatendido = 0;
        this.ficha = "";

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTiempoatendido() {
        return tiempoatendido;
    }

    public void setTiempoatendido(int tiempoatendido) {
        this.tiempoatendido = tiempoatendido;
    }

    //Genera un numero aleatoria de 1 a 3 
    public int generarNumero() {
        int num = (int) ((Math.random() * 3) + 1);
        return (num);
    }

    //Metodo que crea el tipo de persona aleatoriamente  
    public String tipoDePersona() {
        int numeroComparacon = generarNumero();
        if (numeroComparacon == 1) {
            tipo = "A";
        } else if (numeroComparacon == 2) {
            tipo = "B";
        } else {
            tipo = "C";
        }
        return (tipo);
    }

    //Metodo que genera un numero aleatoria de 1 a 25
    public int generarNumeroNombre() {
        int num = (int) ((Math.random() * 25) + 1);
        return (num);
    }

    //Metodo que genera un nombre basandose en el anteriormetodo solo para Personas tipo A y C
    public String Nombre() {
        int numero = generarNumeroNombre();
        switch (numero) {
            case 1:
                nombre = "Ronald";
                break;
            case 2:
                nombre = "Diego";
                break;
            case 3:
                nombre = "Samuel";
                break;
            case 4:
                nombre = "Esteban";
                break;
            case 5:
                nombre = "Karen";
                break;
            case 6:
                nombre = "Danilo";
                break;
            case 7:
                nombre = "Pablo";
                break;
            case 8:
                nombre = "Olger";
                break;
            case 9:
                nombre = "Michael";
                break;
            case 10:
                nombre = "Karla";
                break;
            case 11:
                nombre = "Bryan";
                break;
            case 12:
                nombre = "Tony";
                break;
            case 13:
                nombre = "Atencio";
                break;
            case 14:
                nombre = "Jason";
                break;
            case 15:
                nombre = "Alexander";
                break;
            case 16:
                nombre = "Nixon";
                break;
            case 17:
                nombre = "Alexa";
                break;
            case 18:
                nombre = "Kevin";
                break;
            case 19:
                nombre = "Alicia";
                break;
            case 20:
                nombre = "Milena";
                break;
            case 21:
                nombre = "Jerson";
                break;
            case 22:
                nombre = "Marianela";
                break;
            case 23:
                nombre = "Maria";
                break;
            case 24:
                nombre = "David";
                break;
            case 25:
                nombre = "John";
                break;
        }
        return (nombre);
    }

    //Metodo que genera nombres de mujeres para tipo B 
    public String generarNombreMujeres() {
        int num = (int) ((Math.random() * 7) + 1);
        switch (num) {
            case 1:
                nombre = "Alicia";
            case 2:
                nombre = "Karla";
            case 3:
                nombre = "Karen";
                break;
            case 4:
                nombre = "Alexa";
                break;
            case 5:
                nombre = "Milena";
                break;
            case 6:
                nombre = "Maria";
                break;
            case 7:
                nombre = "Marianela";
                break;

        }
        return (nombre);
    }

    //Metodo que crea una cedula aleatoria de un cliente
    public String crearCedula() {
        for (int i = 0; i < 9; i++) {
            int num = (int) ((Math.random() * 7) + 1);
            cedula = cedula + num;
        }
        return (cedula);

    }

    //Metodo que asigna el tiempo atendido que va a tener el cliente
    public void asignarTiempoAtendido() {
        tiempoatendido = (int) ((Math.random() * 9) + 2);
    }

    //Metodo que devuelve todos atributos y datos del cliente
    public String toStringCliente() {
        String resultado = "";

        if ("A".equals(tipo) || "C".equals(this.tipo)) {
            if ("A".equals(this.tipo)) {
                resultado = nombre + " " + cedula + " " + tipo + " Adulto mayor" + " Ficha " + ficha;
            } else {
                resultado = nombre + " " + cedula + " " + tipo + " Normal" + " Ficha " + ficha;
            }
        } else if ("B".equals(tipo)) {
            nombre = generarNombreMujeres();
            resultado = nombre + " " + cedula + " " + tipo + " Embarazada" + " Ficha " + ficha;
        } else {
            resultado = "error";
        }
        return (resultado);
    }
}
