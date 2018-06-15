package view;

import java.util.Scanner;

import Facade;

import business.model.Usuario;
import util.LoginInvalido;
import util.SenhaInvalida;
import util.ArquivoNaoEncontrado;



public class Interface {

	
	public static void main(String args[]) {
		
		boolean continua = true;
		
		int decisao = 1; //Variavel que auxiliara quando o programa tiver que ser terminado
		
		Scanner s = new Scanner(System.in);
		Usuario usuario = new Usuario();
		Facade fachada = new Facade();
		
		fachada.inicializarSistema();
		
		fachada.listaDeUsuarios();
		
		while(continua) {
			
			System.out.println("\n\nO que voce deseja fazer? 1-Adicionar usuario 2-Excluir usuario 3-Fechar o programa");
			decisao = s.nextInt();
			s.nextLine();
			
			if (decisao == 1) {
			  fachada.cadastrarUsuario();
			}
			
			else if (decisao == 2) {
				fachada.removeUsuario();
			}
			
			else if (decisao == 3){
				fachada.listaDeUsuarios();
				fachada.finalizarSistema();
				continua = false;
			}
			
			else {
				System.out.println("\nOpcao invalida");
			}
		}
		
	}
	
}