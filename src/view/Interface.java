package view;

import java.util.Scanner;

import view.Facade;

import business.model.Usuario;

public class Interface {
	
	public static void main(String args[]) {
		
		Facade fachada = new Facade();
		fachada.inicializarSistema();
		
		fachada.telaInicial();
		
		fachada.finalizarSistema();
	}
	
}