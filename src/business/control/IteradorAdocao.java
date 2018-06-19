package business.control;

import java.util.ArrayList;

import business.model.Adocao;

public class IteradorAdocao {
	protected ArrayList<Adocao> lista;
	protected int contador;
	
	protected IteradorAdocao(ArrayList<Adocao> lista) {
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
	
	public Adocao currentItem() {
		if(isDone()) {
			contador = lista.size() - 1;
		}else if (contador < 0) {
			contador = 0;
		}
		return lista.get(contador);
	}
}
