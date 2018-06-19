package business.model;

import java.io.Serializable;

public class Adocao implements Serializable {
	private int id;
	private int IDdoador;
	private int IDadotante;
	private int IDanimal;
	
	public Adocao(int IDdoador, int IDadotante, int IDanimal) {
		this.IDdoador = IDdoador;
		this.IDadotante = IDadotante;
		this.IDanimal = IDanimal;
	}
	
	public Adocao() {
		this.IDdoador = -1;
		this.IDadotante = -1;
		this.IDanimal = -1;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIDdoador() {
		return IDdoador;
	}

	public void setIdoador(int IDdoador) {
		this.IDdoador = IDdoador;
	}

	public int getIDadotante() {
		return IDadotante;
	}

	public void setIDadotante(int IDadotante) {
		this.IDadotante = IDadotante;
	}
	
	public int getIDanimal() {
		return IDanimal;
	}

	public void setIDAnimal(int IDanimal) {
		this.IDanimal = IDanimal;
	}
	
	
}
