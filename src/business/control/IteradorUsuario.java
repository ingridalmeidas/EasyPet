package business.control;

import java.util.ArrayList;

import business.model.Usuario;

public class IteradorUsuario implements Iterador{
	protected ArrayList<Usuario> lista;
	protected int contador;
	
	protected IteradorUsuario(ArrayList<Usuario> lista) {
		this.lista = lista;
		contador = 0;
	}
	
	public void first() {
		contador = 0;
	}

	public void next() {
		contador++;		
	}

	public boolean isDone() {
		return contador == lista.size();		
	}
	
	public Usuario currentItem() {
		if(isDone()) {
			contador = lista.size() - 1;
		}else if (contador < 0) {
			contador = 0;
		}
		return lista.get(contador);
	}	
}
