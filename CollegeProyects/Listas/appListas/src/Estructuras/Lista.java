/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author jpabloq
 */
public class Lista {
	private Nodo primero;
	private Nodo ultimo;
	private int tamanno;
	private String error;

	public Lista() {
		this.primero = null;
		this.ultimo = null;
		this.tamanno = 0;
	}

	public boolean vacio() {
		return (this.primero == null);
	}

	public boolean agregar(Object pDato) {
		boolean retorno = true;
		this.error = "";
		try{
			if(this.vacio()) {
				Nodo nuevo = new Nodo(pDato);
				this.primero = nuevo;
				this.ultimo = nuevo;
				//nuevo.siguiente = nuevo;
			}
			else {
				Nodo nuevo = new Nodo(pDato);
				nuevo.siguiente = this.primero;
                                this.primero.anterior = nuevo;
				this.primero = nuevo;
			}
			this.tamanno++;
		}catch(Exception e)
		{
			this.error = "Error agregando a la lista, detalle:" + e.getMessage();
			retorno = false;
		}
        return retorno;
    }
	
	public  boolean borrar() {
		boolean retorno = true; 		
		this.error = "";		
	    if(this.vacio()) {
	    	this.error = "La lista se encuentra vacia";
	    	retorno = false;
	        return retorno;
	    }
	    try{
	    	if(this.primero == this.ultimo) {
	    		this.primero = null;
	    		this.ultimo = null;
	        }
	        else {
	            Nodo actual = this.primero;
	            while(actual.siguiente != ultimo) {
	                actual = actual.siguiente;
	            }	            
	            actual.siguiente = null;
	            this.ultimo = actual;
	        }
	        this.tamanno--;
	    }catch (Exception e) {
			this.error = "Error borrando de la lista, detalle:" + e.getMessage();
			retorno = false;
		}
	    return retorno;
	}
	
	public int getTamanno()
	{
		return this.tamanno;
	}
	
	public String getError()
	{
		return this.error;
	}
	
	public String toString() {
		String retorno = "";
        if(!this.vacio()) {
            Nodo temp = this.primero;            
            for(int i = 0; i < this.tamanno; i++) {
            	retorno = retorno + String.valueOf(temp.dato) + "\n";
                temp = temp.siguiente;
            }            
        }
        return retorno;
    }
}
