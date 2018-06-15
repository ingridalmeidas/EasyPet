package business.model;

import java.io.Serializable;

public class Animal implements Serializable {

	private int id; //Gerado pelo sistema
	private String nome;
	private String especie;
	private String raça;
	private int idade;
	private char sexo;
	private boolean castrado;
	private boolean vacinado;
	private String descricao; //Palavra chave com características de animais
											//que deseja adotar
	private Usuario doador = new Usuario();
	
	
	public Animal(String nome, String especie, String raça, int idade, char sexo,
			boolean castrado, boolean vacinado, String descricao, Usuario doador){

		this.nome = nome;
		this.especie = especie;
		this.raça = raça;
		this.idade = idade;
		this.sexo = sexo;
		this.castrado = castrado;
		this.vacinado = vacinado;
		this.descricao = descricao;
		this.doador = doador;

	}

	public Animal(Usuario doador) {
	
		this.id = -1;
		this.nome = "";
		this.especie = "";
		this.raça = "";
		this.idade = -1;
		this.sexo = '0';
		this.castrado = false;
		this.vacinado = false;
		this.descricao = "";
		this.doador = doador;

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
	
	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
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
	
	public Usuario getDoador() {
		return doador;
	}

	public void setDoador(Usuario doador) {
		this.doador = doador;
	}

	
	public String toString() {
		String retorno = "\nID: " + id +  "\nNome: " + nome + "\nEspecie: " + especie + "\nRaça: " + raça + 
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
