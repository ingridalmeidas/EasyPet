package business.model;

import business.model.Relatorio;
import business.control.GeradorRelatorioPDF;
import business.control.GeradorRelatorioXML;

public class Administrador {

	private int id; // Gerado pelo sistema
	private String login;
	private String senha;

	public Administrador() {
		this.id = -1;
		this.login = "";
		this.senha = "";
	}

	public Relatorio gerarRelatorio(String tipo) {
		
		if (tipo == "XML") {
			
			GeradorRelatorioPDF geradorDeRelatorio = new GeradorRelatorioPDF();
			geradorDeRelatorio.gerarRelatorio();
			
		}else {
			//gera PDF
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
