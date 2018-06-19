package business.control;

import java.util.ArrayList;

import business.model.Animal;

public class IteradorAnimal implements Iterador {
	protected ArrayList<Animal> lista;
	protected int contador;
	
	protected IteradorAnimal(ArrayList<Animal> lista) {
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
	
	public Animal currentItem() {
		if(isDone()) {
			contador = lista.size() - 1;
		}else if (contador < 0) {
			contador = 0;
		}
		return lista.get(contador);
	}
}
