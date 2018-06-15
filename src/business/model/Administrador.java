package business.model;

public class Administrador {

	private int id; //Gerado pelo sistema
	private String login;
	private String senha;
	
	public Administrador() {
		this.id = -1;
		this.login = "";
		this.senha = "";
	}
	
	public void gerarRelatorio() {
		System.out.println("Gerando Relatório...");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String toString() {
		return "\nLogin: " + login +"\nSenha: " + senha;
	}
	
	
}
