package view;

import java.util.Scanner;

import business.control.*;

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
		GerenciaUsuario gerencia = new GerenciaUsuario();
		
		String loginRemovido = "";
		
		try {
			gerencia.leLista();
		}catch(ArquivoNaoEncontrado e) {
			System.out.println("\n" + e.getMessage());
		}
		
		
		System.out.println("\nLista de usuários em arquivo: ");
		gerencia.listaDeUsuarios();
		
		while(continua) {
			
			boolean loginValido = false;
			boolean senhaValida = false;
			
			System.out.println("\n\nO que voce deseja fazer? 1-Adicionar usuario 2-Excluir usuario 3-Fechar o programa");
			
			decisao = s.nextInt();
			s.nextLine();
			
			if (decisao == 1) {
				
				while(!loginValido) {
					
					System.out.println("\nDigite seu Login: ");
					
					usuario.setLogin(s.nextLine());
					
					try {
						loginValido = gerencia.validaLogin(usuario);
					}catch(LoginInvalido e) {
						System.out.println("\nLogin invalido! " + e.getMessage() + " Digite novamente!");
					}
				}
				
				while(!senhaValida) {
					System.out.println("\nDigite sua senha: ");
					
					usuario.setSenha(s.nextLine());
					
					try {
						senhaValida = gerencia.validaSenha(usuario);
					}catch(SenhaInvalida e) {
						System.out.println("\nSenha invalida! " + e.getMessage() + " Digite novamente!");
					}
				}
					
				System.out.println("\nDigite seu nome:");
				usuario.setNome(s.nextLine());
					
				System.out.println("\nDigite sua idade:");
				usuario.setIdade(s.nextInt());
				s.nextLine();
					
				System.out.println("\nDigite seu sexo: F - Feminino, M - Masculino");
				usuario.setSexo(s.nextLine().charAt(0));
					
				System.out.println("\nDigite sua cidade:");
				usuario.setCidade(s.nextLine());
					
				System.out.println("\nDigite seu Estado:");
				usuario.setEstado(s.nextLine());
				
				System.out.println("\nDigite palavras chaves separadas por espaço com características de um animal que você deseja adotar:");
				usuario.setCaracteristicasAnimais(s.nextLine());
				
				gerencia.adicionaUsuario(usuario);
				
				
				
			}
			
			else if (decisao == 2) {
				System.out.println("\nDigite o login do usuario que voce deseja excluir: ");
				loginRemovido = s.nextLine();
				
				if (gerencia.removeUsuario(loginRemovido)) {
					System.out.println("\nUsuario removido: " + loginRemovido);
				}
				
				else{
					System.out.println("\nUsuario nao foi removido");
				}
			}
			
			else if (decisao == 3){
				
				System.out.println("\nLista de usuários em arquivo: ");
				gerencia.listaDeUsuarios();
				
				System.out.println("\nAté mais!");
				try {
					gerencia.salvaListaEmArquivo();
				}catch(ArquivoNaoEncontrado e) {
					System.out.println("\n" + e.getMessage());
				}
				
				continua = false;
			}
			
			else {
				System.out.println("\nOpcao invalida");
			}
		}
		
	}
	
}
