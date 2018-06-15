package business.model;

import java.io.Serializable;

public class Adocao {
	private Usuario doador = new Usuario();
	private Usuario adotante = new Usuario();
	private Animal animal = new Animal();
	
	public Adocao(Usuario doador, Usuario adotante, Animal animal) {
		this.doador = doador;
		this.adotante = adotante;
		this.animal = animal;
	}
	
	public Adocao() {
		this.doador = null;
		this.adotante = null;
		this.animal = null;
	}
	
	public Usuario getDoador() {
		return doador;
	}

	public void setDoador(Usuario doador) {
		this.doador = doador;
	}

	public Usuario getAdotante() {
		return adotante;
	}

	public void setAdotante(Usuario adotante) {
		this.adotante = adotante;
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
