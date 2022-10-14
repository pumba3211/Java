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
public class lista extends cliente {

    private Nodo primero;//Guarda un dato tipo cliente del primero que va tener la lista
    private Nodo ultimo;//Guarda un dato tipo cliente del ultimo que va tener la lista
    private int tamaño;//Guarda el tamaño de la lista
    private int contadorficha;//Lleva un control del numero de ficha para asignarles numero de ficha y asu vez tipo
    private int contadordeClientes;//Lleva Lleva el conteo de los clientes que han ingresado al banco
    private String error;//Variable que devuelve un error en caso que haya

    //método constructor
    public lista() {
        super();
        this.primero = ultimo = null;
        this.tamaño = 0;
        this.contadorficha = 1;
        this.contadordeClientes = 0;

    }
    //Metodos set y get de los atributos de la clase

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public int getContadordeClientes() {
        return contadordeClientes;
    }

    public void setContadordeClientes(int contadordeClientes) {
        this.contadordeClientes = contadordeClientes;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getContadorficha() {
        return contadorficha;
    }

    public void setContadorficha(int contadorficha) {
        this.contadorficha = contadorficha;
    }

    //Metodo que pregunta si la lista esta vacia
    public boolean vacia() {
        return (this.primero == null);
    }

    //Método que agrega un dato tipo cliente 
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

    //Agregar al Inicio de  la lista un dato cliente
    public boolean agregarInicio(cliente pDato) {
        boolean retorno = true;
        this.error = "";
        try {
            if (this.vacia()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = nuevo;
                this.ultimo = nuevo;

            } else {

                Nodo nuevo = new Nodo(pDato);
                nuevo.siguiente = this.primero;
                this.primero = nuevo;
            }
            this.tamaño++;
        } catch (Exception e) {
            this.error = "Error agregando a la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    //Agregar al Final de la lista un dato tipo cliente
    public boolean agregarFinal(cliente pDato) {
        boolean retorno = true;
        this.error = "";
        try {
            if (this.vacia()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = nuevo;
                this.ultimo = nuevo;

            } else {
                Nodo nuevo = new Nodo(pDato);
                this.ultimo.siguiente = nuevo;
                this.ultimo = nuevo;
            }
            this.tamaño++;
        } catch (Exception e) {
            this.error = "Error agregando a la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    //Agrega a cualquier lugar que no sea inicio ni el ultimo 
    public boolean agregarMedio(cliente pDato) {
        boolean retorno = true;
        this.error = "";
        String comparacion = pDato.getFicha().substring(1);
        try {
            if (this.vacia()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = nuevo;
                this.ultimo = nuevo;

            } else {
                Nodo nuevo = new Nodo(pDato);
                Nodo aux = this.primero;

                if (aux.siguiente.dato.tipo.compareTo(pDato.tipo) > 0) {
                    Nodo aux2 = aux.siguiente;
                    aux.siguiente = nuevo;
                    nuevo.siguiente = aux2;

                } else {
                    while (pDato.tipo.compareTo(aux.dato.tipo) > 0) {
                        aux = aux.siguiente;

                    }
                    while (aux.siguiente.dato.tipo.compareTo(pDato.tipo) == 0) {

                        aux = aux.siguiente;

                    }
                    Nodo aux2 = aux.siguiente;
                    aux.siguiente = nuevo;
                    nuevo.siguiente = aux2;
                }

            }
            this.tamaño++;
        } catch (Exception e) {
            this.error = "Error agregando a la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    //Metodo que Busca donde agregar el nodo tipo cliente por prioridad de acuerdo a la variable tipo de cliente
    public void BuscarAgregar(cliente pDato) {
        if (this.vacia()) {
            agregarInicio(pDato);
        } else if (pDato.tipo.compareTo(this.primero.dato.tipo) == 0 && this.tamaño == 1) {
            this.agregarFinal(pDato);

        } else if (pDato.tipo.compareTo(this.primero.dato.tipo) > 0 && this.tamaño == 1) {
            this.agregarFinal(pDato);

        } else if (pDato.tipo.compareTo(this.primero.dato.tipo) >= 0 && pDato.tipo.compareTo(this.ultimo.dato.tipo) < 0) {
            this.agregarMedio(pDato);

        } else if (pDato.tipo.compareTo(this.primero.dato.tipo) > 0 && pDato.tipo.compareTo(this.ultimo.dato.tipo) > 0) {
            this.agregarFinal(pDato);

        } else if (pDato.tipo.compareTo(this.ultimo.dato.tipo) == 0) {
            this.agregarFinal(pDato);

        } else if (pDato.tipo.compareTo(this.primero.dato.tipo) < 0) {
            this.agregarInicio(pDato);
        }

    }

    //Metodo que crea 10 clientes y le asigna sus datos y luego busca donde ser agregados
    public void crearClientes() {
        for (int i = 0; i < 10; i++) {
            cliente c = new cliente();
            c.Nombre();
            c.crearCedula();
            String tipo = c.tipoDePersona();
            c.setTipo(tipo);
            c.asignarTiempoAtendido();
            if (contadorficha > 99) {
                contadorficha = 1;
            }

            if ("A".equals(c.getTipo())) {
                c.setFicha(contadorficha + c.getTipo());
                contadorficha++;
            } else if ("B".equals(c.getTipo())) {
                c.setFicha(contadorficha + c.getTipo());
                contadorficha++;
            } else {
                c.setFicha(contadorficha + c.getTipo());
                contadorficha++;
            }
            contadordeClientes++;
            BuscarAgregar(c);
        }

    }

    //Metodo que crea clientes dependiendo del tamaño de la lista hasta que llegue a 10
    public void crearCliente() {
        while (tamaño < 10) {
            cliente c = new cliente();
            c.Nombre();
            c.crearCedula();
            String tipo = c.tipoDePersona();
            c.setTipo(tipo);
            c.asignarTiempoAtendido();
            if (contadorficha > 99) {
                contadorficha = 1;
            }

            if ("A".equals(c.getTipo())) {
                c.setFicha(contadorficha + c.getTipo());
                contadorficha++;
            } else if ("B".equals(c.getTipo())) {
                c.setFicha(contadorficha + c.getTipo());
                contadorficha++;
            } else {
                c.setFicha(contadorficha + c.getTipo());
                contadorficha++;
            }
            contadordeClientes++;
            BuscarAgregar(c);
        }
    }

    //Metodo que retorna los valores de nuestra lista a su vez llamando un el tostring de cliente
    public String toStringLista() {
        String retorno = "";
        int cont = 1;
        if (!this.vacia()) {
            Nodo aux = this.primero;

            for (int i = 0; i < this.tamaño; i++) {
                retorno = retorno + (aux.dato).toStringCliente() + "\n";
                aux = aux.siguiente;
                cont++;

            }
        }
        return (retorno);
    }

    //Metodo que borra el primero de la lista
    public boolean borrarinicio() {
        boolean retorno = true;
        if (this.vacia()) {
            retorno = false;
        }
        try {
            if (this.primero == this.ultimo) {
                this.primero = this.ultimo = null;
            } else {
                Nodo aux = this.primero;
                this.primero = primero.siguiente;
                aux.siguiente = null;
            }
            this.tamaño--;
        } catch (Exception e) {
            retorno = false;
        }
        return (retorno);
    }

    //Metodo que suma a la variable contadordeClientes 1 una vez que se agregue1
    public void sumarCliente() {
        contadordeClientes++;
    }

}
