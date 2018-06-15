package business.control;

import business.model.Relatorio;

public abstract class GeradorRelatorioTemplate {
	
	public abstract String tipoRelatorio();
	
	public Relatorio gerarRelatorio() {
		
		String tipo = tipoRelatorio();
		
		System.out.println("Gerando Relatório " + tipo);
		
		return null;
	}
}
