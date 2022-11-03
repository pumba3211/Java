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
public class listacajero {

    private Nodo primero;//Guarda el primero de la lista
    private Nodo ultimo;//Guarda el ultimo de la lista
    private int tamaño;//Guarda el tamaño de la lista Cajero
    //Metodo constructor

    public listacajero() {
        this.primero = ultimo = null;
        this.tamaño = 0;
    }

    //Metodo que consulta si la lista esta vacia
    public boolean vacia() {
        return (this.primero == null);
    }

    //Metodo que agrega un nodo tipo cliente a la lista
    public boolean agregar(cliente pDato) {
        boolean retorno = true;
        try {
            if (this.vacia()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = this.ultimo = nuevo;
            } else {
                Nodo nuevo = new Nodo(pDato);
                nuevo.siguiente = this.primero;
                this.primero = nuevo;
            }
            this.tamaño++;
        } catch (Exception e) {
            retorno = false;
        }

        return (retorno);
    }

    //Metodo que imprime los datos de la lista
    public String toStringLista() {
        String retorno = "";
        String adultosmayores = "    ADULTOS MAYORES         " + "\n";
        String embarazadas = "    EMBARAZADAS             " + "\n";
        String normales = "    PERSONAS   " + "\n";
        int cont = 1;
        if (!this.vacia()) {
            Nodo aux = this.primero;
            for (int i = 0; i < this.tamaño; i++) {
                if (aux.dato.tipo.equals("A")) {
                    adultosmayores = adultosmayores + (aux.dato).toStringCliente() + " tiempo atendido " + aux.dato.getTiempoatendido() + "\n";
                } else if (aux.dato.tipo.equals("B")) {
                    embarazadas = embarazadas + (aux.dato).toStringCliente() + " tiempo atendido " + aux.dato.getTiempoatendido() + "\n";
                } else {
                    normales = normales + (aux.dato).toStringCliente() + " tiempo atendido " + aux.dato.getTiempoatendido() + "\n";
                }

                aux = aux.siguiente;
                cont++;
                retorno = adultosmayores + "\n" + embarazadas + "\n" + normales;
            }
        }
        return (retorno);
    }
    //Metodo que calcula el promedio de atencion de los cajeros

    public double promedioDeTiempoAtendiendo() {
        double resultado = 0;
        Nodo aux = this.primero;
        for (int i = 0; i < tamaño; i++) {
            resultado = resultado + aux.dato.getTiempoatendido();
            aux = aux.siguiente;
        }
        resultado = resultado / tamaño;
        return (resultado);
    }

    //Metodo que calcula y retorna el tiempo total atendido de los cajeros
    public int totaltiempoAtendido() {
        int resultado = 0;
        Nodo aux = this.primero;
        for (int i = 0; i < tamaño; i++) {
            resultado = resultado + aux.dato.getTiempoatendido();
            aux = aux.siguiente;
        }
        return (resultado);
    }

    //Metodos set y get
    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    //Calcula el total de Adultos mayores en la lista

    public int totalAdultosmayores() {
        int resultado = 0;
        Nodo aux = this.primero;
        for (int i = 0; i < tamaño; i++) {
            if (aux.dato.tipo.equals("A")) {
                resultado++;
            }
            aux = aux.siguiente;
        }
        return (resultado);
    }

    //Calcula el total de mujeres embarazadas en la lista
    public int totalEmbarazadas() {
        int resultado = 0;
        Nodo aux = this.primero;
        for (int i = 0; i < tamaño; i++) {
            if (aux.dato.tipo.equals("B")) {
                resultado++;
            }
            aux = aux.siguiente;
        }
        return (resultado);
    }
    //Calcula el total de personas comunes que han ingresado al banco

    public int totalPersonas() {
        int resultado = 0;
        Nodo aux = this.primero;
        for (int i = 0; i < tamaño; i++) {
            if (aux.dato.tipo.equals("C")) {
                resultado++;
            }
            aux = aux.siguiente;
        }
        return (resultado);
    }

}
