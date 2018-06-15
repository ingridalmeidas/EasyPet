package business.model;

import java.io.Serializable;

public class Animal implements Serializable {

	private int id; //Gerado pelo sistema
	private String nome;
	private String especie;
	private String raca;
	private int idade;
	private char sexo;
	private boolean castrado;
	private boolean vacinado;
	private String descricao; //Palavra chave com características de animais
											//que deseja adotar
	private int IDdoador; //ID do usuário que disponibilizou o animal para adoção
	
	
	public Animal(String nome, String especie, String raca, int idade, char sexo,
			boolean castrado, boolean vacinado, String descricao, int IDdoador){

		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
		this.sexo = sexo;
		this.castrado = castrado;
		this.vacinado = vacinado;
		this.descricao = descricao;
		this.IDdoador = IDdoador;

	}

	public Animal(int IDdoador) {
	
		this.id = -1;
		this.nome = "";
		this.especie = "";
		this.raca = "";
		this.idade = -1;
		this.sexo = '0';
		this.castrado = false;
		this.vacinado = false;
		this.descricao = "";
		this.IDdoador = IDdoador;

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public boolean getCastrado() {
		return castrado;
	}

	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}
	
	public boolean getVacinado() {
		return vacinado;
	}

	public void setVacinado(boolean vacinado) {
		this.vacinado = vacinado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getIDdoador() {
		return IDdoador;
	}

	public void setIDdoador(int IDdoador) {
		this.IDdoador = IDdoador;
	}

	
	public String toString() {
		String retorno = "\nID: " + id +  "\nNome: " + nome + "\nEspecie: " + especie + "\nRa�a: " + raca + 
				"\nIdade: " + idade + "\nSexo: " + sexo + "\nDescrição: "+ descricao;
		
		if (castrado){
			
			retorno += "\nCastrado: Sim";
			
		}
		
		if (vacinado) {
			retorno += "\nVacinado: Sim";
		}
		
		return retorno;
	}
}
