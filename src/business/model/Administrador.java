package business.model;

import business.model.Relatorio;
import business.control.GeradorRelatorioPDF;
import business.control.GeradorRelatorioXML;

public class Administrador {

	private int id; // Gerado pelo sistema

	public Administrador() {
		this.id = 0;
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
	
}
