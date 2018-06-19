package view;

import view.Facade;

public class Interface {
	
	public static void main(String args[]) {
		
		Facade fachada = new Facade();
		fachada.inicializarSistema();
		
		fachada.telaInicial();
		
		fachada.finalizarSistema();
	}
	
}