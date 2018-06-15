package business.model;

import java.io.Serializable;

public class Usuario implements Serializable  {
	
	private int id; //Gerado pelo sistema
	private String login;
	private String senha;
	private String nome;
	private int idade;
	private char sexo;
	private int nota; //nota obtida no questionário
	private String cidade;
	private String estado;
	private String caracteristicasAnimais; //Palavra chave com características de animais
											//que deseja adotar
	
	public Usuario(String login, String senha, String nome, int idade, char sexo,
					String cidade, String estado, String caracteristicasAnimais){
		
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.cidade = cidade;
		this.estado = estado;
		this.caracteristicasAnimais = caracteristicasAnimais;
		
	}
	
	public Usuario() {
		this.id = -1;
		this.login = "";
		this.senha = "";
		this.nome = "";
		this.idade = -1;
		this.sexo = '0';
		this.nota = -1;
		this.cidade = "";
		this.estado = "";
		this.caracteristicasAnimais = "";
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

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCaracteristicasAnimais() {
		return caracteristicasAnimais;
	}

	public void setCaracteristicasAnimais(String caracteristicasAnimais) {
		this.caracteristicasAnimais = caracteristicasAnimais;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String toString() {
		return "\nID: " + id + "\nLogin: " + login +"\nSenha: " + senha + "\nNome: " + nome + 
				"\nIdade: " + idade + "\nSexo: " + sexo + "\nNota: " + nota + "\nCidade: "
				+ cidade + "\nEstado: " + estado + "\nCaracteristicas de um animal que deseja adotar: "+ caracteristicasAnimais;
	}
	
	
}
