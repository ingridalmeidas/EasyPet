package view;

import java.util.Scanner;

import business.control.FacebookAdapter;
import business.control.GerenciaAnimal;
import business.control.GerenciaUsuario;
import business.control.GmailAdapter;
import business.model.AdministradorProxy;
import business.model.Animal;
import business.model.Usuario;
import util.LoginInvalido;
import util.SenhaInvalida;

public class Menu {
	private Scanner s = new Scanner(System.in);
	
	public int telaInicial() {
		System.out.println("\nEscolha uma das opcoes abaixo!\n(1)Fazer Login\n(2)Fazer Login (Facebook)\n(3)Fazer Login (Gmail)"
							+ "\n(4)Fazer Cadastro\n(5)Fazer Cadastro (Facebook)\n(6)Fazer Cadastro (Gmail)\n(7)Cadastrar Animal\n(8)Painel Administrativo"
							+ "\n(9)Fechar Programa\nEntrada: ");
		int entrada = s.nextInt();
		s.nextLine();
		
		while(true) {
			if(entrada >= 1 || entrada <= 9)
				return entrada;
			else {
				System.out.println("Entrada invalida, tente novamente!\nEntrada: ");
				entrada = s.nextInt();
				s.nextLine();
			}
		}
	}
	
	public int cadastrarUsuario(GerenciaUsuario gerenteUsuario) {
	    Usuario usuario = new Usuario();
	    
	    boolean loginValido = false;
		boolean senhaValida = false; 
	      
	    while(!loginValido) {
	        
	      System.out.println("\nDigite seu Login: ");
	       
	      usuario.setLogin(s.nextLine());
	        
	      try {
	        loginValido = gerenteUsuario.validaLogin(usuario);
	      }catch(LoginInvalido e) {
	        System.out.println("\nLogin invalido! " + e.getMessage() + " Digite novamente!");
	      }
	    }
	      
	    while(!senhaValida) {
	      System.out.println("\nDigite sua senha: ");
	      
	      usuario.setSenha(s.nextLine());
	      
	      try {
	        senhaValida = gerenteUsuario.validaSenha(usuario);
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
	      
	    System.out.println("\nDigite palavras chaves separadas por espaco com caracteristicas de um animal que voce deseja adotar:");
	    usuario.setCaracteristicasAnimais(s.nextLine());
	      
	    gerenteUsuario.adicionaUsuario(usuario);
	    
	    return 1;
	  }
	  
	  public void removeUsuario(GerenciaUsuario gerenteUsuario){
	    String loginRemovido = "";
	    
	    System.out.println("\nDigite o login do usuario que voce deseja excluir: ");
	    loginRemovido = s.nextLine();
	    
	    if (gerenteUsuario.removeUsuario(loginRemovido)) {
	      System.out.println("\nUsuario removido: " + loginRemovido);
	    }
	    else{
	      System.out.println("\nUsuario nao foi removido");
	    }
	  }
	  
	  public void removeAnimal(GerenciaAnimal gerenteAnimal){
		String animalRemovido = "";
		    
		System.out.println("\nDigite o nome do animal que voce deseja excluir: ");
		animalRemovido = s.nextLine();
		  
		if (gerenteAnimal.removeAnimal(animalRemovido)) {
			System.out.println("\nAnimal removido: " + animalRemovido);
		}
		else{
		   System.out.println("\nAnimal nao foi removido");
		}
	  }
	  
	  public int login(GerenciaUsuario gerenteUsuario) {
		  
		System.out.println("\nDigite o seu login: ");
		String username = s.nextLine();
			  
		Usuario aux = gerenteUsuario.buscaLogin(username);
		
		while(true) {
			if(aux != null) {
				System.out.println("\nDigite a sua senha: ");
				String password = s.nextLine();
				
				while(true) {
					if(aux.getSenha().equals(password)) {
						System.out.println("\nLogin realizado com sucesso. Seja bem vindo " + aux.getNome());
						return 1;
					}
					else {
						System.out.println("\nSenha invalida, tente novamente!\nSenha: ");
						password = s.nextLine();
					}
				}
			}
			else {
				System.out.println("\nLogin invalido, tente novamente!\nLogin: ");
				username = s.nextLine();
				aux = gerenteUsuario.buscaLogin(username);
			}
		}	
		
	 }
	 
	 public void loginFacebook() {
		System.out.println("\nDigite o seu login: ");
		String username = s.nextLine();
		
		System.out.println("\nDigite a sua senha: ");
		String password = s.nextLine();
		
		FacebookAdapter fb = new FacebookAdapter();
		fb.facebook_ValidaLogin(username, password);
	 }
	 
	 public void loginGmail() {
		System.out.println("\nDigite o seu login: ");
		String username = s.nextLine();
		
		System.out.println("\nDigite a sua senha: ");
		String password = s.nextLine();
		
		GmailAdapter gm = new GmailAdapter();
		gm.gmail_ValidaLogin(username, password);
	 }
	 
	 public void cadastrarFacebook() {
		System.out.println("\nDigite o seu login: ");
		String username = s.nextLine();
		
		System.out.println("\nDigite a sua senha: ");
		String password = s.nextLine();
		
		FacebookAdapter fb = new FacebookAdapter();
		fb.facebook_ValidaCadastro(username, password);
	 }	 
	 
	 public void cadastrarGmail() {
		System.out.println("\nDigite o seu login: ");
		String username = s.nextLine();
		
		System.out.println("\nDigite a sua senha: ");
		String password = s.nextLine();
		
		GmailAdapter gm = new GmailAdapter();
		gm.gmail_ValidaCadastro(username, password);
	 }
	  
	 public int cadastrarAnimal(GerenciaAnimal gerenteAnimal) {
		System.out.println("\nDigite o id do doador: ");
		int IDdoador = s.nextInt();
		s.nextLine();
		
		Animal animal = new Animal(IDdoador);
		    
		System.out.println("\nDigite o nome do animal:");
		animal.setNome(s.nextLine());
		    
		System.out.println("\nDigite a especie do animal:");
		animal.setEspecie(s.nextLine());
		    
		System.out.println("\nDigite a raca do animal:");
		animal.setRaca(s.nextLine());
		    
		System.out.println("\nDigite a idade do animal:");
		animal.setIdade(s.nextInt());
		s.nextLine();
		        
		System.out.println("\nDigite o sexo do animal: F - Feminino, M - Masculino");
		animal.setSexo(s.nextLine().charAt(0));
		       
		System.out.println("\nDigite o estado de castracao do animal: (1) - Castrado, (0) - Nao Castrado");
		int input = s.nextInt();
		s.nextLine();
		if(input == 1)
		 	animal.setCastrado(true);
		else if(input == 0)
		   	animal.setCastrado(false);
		    
		System.out.println("\nDigite o estado de vacinacao do animal: (1) - Vacinado, (0) - Nao Vacinado");
		input = s.nextInt();
		s.nextLine();
		if(input == 1)
		   	animal.setVacinado(true);
		else if(input == 0)
		   	animal.setVacinado(false);
		        
		System.out.println("\nDigite a descricao do animal:");
		animal.setDescricao(s.nextLine());
		      
		gerenteAnimal.adicionaAnimal(animal);
		    
		return 1;
		
	 }
	 
	 public void operacoesADM(AdministradorProxy adm, GerenciaUsuario gerenteUsuario, GerenciaAnimal gerenteAnimal) {
		 boolean continua = true;
		 while(continua) {
			System.out.println("\nEscolha uma das opcoes abaixo!\n(1)Listar Usuarios\n(2)Listar Animais\n(3)Gerar Relatorio XML\n(4)Gerar Relatorio PDF"
								+ "\n(5)Remover Usuario\n(6)Remover Animal\n(7)Desfazer Operacao (Lista de Usuarios)\n(8)Sair do Painel Administrativo\nEntrada: ");
			int entrada = s.nextInt();
			s.nextLine();
			
			while(true) {
				if(entrada == 1) {
					gerenteUsuario.listaDeUsuarios();
					break;
				}	
				else if(entrada == 2) {
					gerenteAnimal.listaDeAnimais();
					break;
				}
				else if(entrada == 3) {
					adm.gerarRelatorio("XML");
					break;
				}
				else if(entrada == 4) {
					adm.gerarRelatorio("PDF");
					break;
				}
				else if(entrada == 5) {
					removeUsuario(gerenteUsuario);
					break;
				}
				else if(entrada == 6) {
					removeAnimal(gerenteAnimal);
					break;
				}
				else if(entrada == 7) {
					gerenteUsuario.retornarEstado();
					break;
				}
				else if(entrada == 8) {
					continua = false;
					break;
				}
				else {
					System.out.println("Entrada invalida, tente novamente!\nEntrada: ");
					entrada = s.nextInt();
					s.nextLine();
				}
			}
		}	
	 }
	  
	 public void telaAdministrativa(GerenciaUsuario gerenteUsuario, GerenciaAnimal gerenteAnimal) {
		AdministradorProxy adm;
		 
		System.out.println("\nDigite o login de administrador: ");
		String username = s.nextLine();
		
		while(true) {
			if(username.equals("admin")){
				System.out.println("\nDigite a senha de administrador: ");
				String password = s.nextLine();
				
				while(true) {
					if(password.equals("admin")) {
						adm = new AdministradorProxy(username, password);
						System.out.println("\nAcesso realizado com sucesso. Seja bem vindo " + adm.getUsuario());
						operacoesADM(adm, gerenteUsuario, gerenteAnimal);
						return;
					}
					else {
						System.out.println("\nSenha invalida, tente novamente!\nSenha: ");
						password = s.nextLine();
					}
				}
			}
			else {
				System.out.println("\nLogin invalido, tente novamente!\nLogin: ");
				username = s.nextLine();
			}
		}	
	 }
	 
}