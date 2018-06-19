package business.model;

import business.model.Relatorio;
import business.control.GeradorRelatorioPDF;
import business.control.GeradorRelatorioXML;

public class Administrador {

	private int id; // Gerado pelo sistema
	private String login;
	private String senha;

	public Administrador() {
		this.id = 0;
		this.login = "admin";
		this.senha = "admin";
	}

	public Relatorio gerarRelatorio(String tipo) {
		
		if (tipo == "PDF") {
			
			GeradorRelatorioPDF geradorDeRelatorio = new GeradorRelatorioPDF();
			geradorDeRelatorio.gerarRelatorio();
			
		}else {

			GeradorRelatorioXML geradorDeRelatorio = new GeradorRelatorioXML();
			geradorDeRelatorio.gerarRelatorio();
		}
		
		
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "\nLogin: " + login + "\nSenha: " + senha;
	}
	
}
