package view;

import business.control.*;
import business.model.Usuario;
import view.Menu;
import util.ArquivoNaoEncontrado;

public class Facade {
  private GerenciaUsuario gerenteUsuario;
  private GerenciaAnimal gerenteAnimal;
  private GerenciaAdocao gerenteAdocao;
  private Menu menu;
   
  public void inicializarSistema() {
    gerenteUsuario = GerenciaUsuario.getInstancia();
    try {
  	  gerenteUsuario.leLista();
  	}catch(ArquivoNaoEncontrado e) {
  		System.out.println("\n" + e.getMessage());
  	}
        
    gerenteAnimal = GerenciaAnimal.getInstancia();
    try {
  	  gerenteAnimal.leLista();
   	}catch(ArquivoNaoEncontrado e) {
   		System.out.println("\n" + e.getMessage());
   	}
      
    gerenteAdocao = GerenciaAdocao.getInstancia();
    try {
  		gerenteAdocao.leLista();
  	}catch(ArquivoNaoEncontrado e) {
   		System.out.println("\n" + e.getMessage());
   	}
    
    menu = new Menu();
  }
    
  public void finalizarSistema() {
    System.out.println("\nAte mais!");
    try {
      gerenteUsuario.salvaListaEmArquivo();
    }catch(ArquivoNaoEncontrado e) {
      System.out.println("\n" + e.getMessage());
    }
    
    try {
		  gerenteAnimal.salvaListaEmArquivo();
		}catch(ArquivoNaoEncontrado e) {
		 System.out.println("\n" + e.getMessage());
		}
        
    try {
		  gerenteAdocao.salvaListaEmArquivo();
		}catch(ArquivoNaoEncontrado e) {
		 System.out.println("\n" + e.getMessage());
		}
  }
    
  public void listaDeUsuarios() {
    System.out.println("\nLista de usuarios em arquivo: ");
    gerenteUsuario.listaDeUsuarios();
  }
  
  public void listaDeAnimais() {
    System.out.println("\nLista de animais em arquivo: ");
    gerenteAnimal.listaDeAnimais();
  }
  
  public void listaDeAdocoes() {
    System.out.println("\nLista de animais em arquivo: ");
    gerenteAdocao.listaDeAdocoes();
  }
  
  public void telaInicial() {
	while(true) {
		int comando = menu.telaInicial();
		
		if(comando == 1)
			menu.login(gerenteUsuario);
		else if(comando == 2) 
			menu.loginFacebook();
		else if(comando == 3)
			menu.loginGmail();
		else if(comando == 4)
			menu.cadastrarUsuario(gerenteUsuario);
		else if(comando == 5)
			menu.cadastrarFacebook();
		else if(comando == 6)
			menu.cadastrarGmail();
		else if(comando == 7)
			menu.cadastrarAnimal(gerenteAnimal);
		else if(comando == 8)
			menu.telaAdministrativa(gerenteUsuario, gerenteAnimal);
		else if(comando == 9)
			break;
	}
	
  }
  
}