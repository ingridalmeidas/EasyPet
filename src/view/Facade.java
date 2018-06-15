package view;

import business.control.*;
import business.model.*;
import java.util.Scanner;
import util.LoginInvalido;
import util.SenhaInvalida;
import util.ArquivoNaoEncontrado;

public class Facade {
  private GerenciaUsuario gerenteUsuario;
  private GerenciaAnimal gerenteAnimal;
  private GerenciaAdocao gerenteAdocao;
   
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
  }
    
  public void finalizarSistema() {
    System.out.println("\nAté mais!");
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
    System.out.println("\nLista de usuários em arquivo: ");
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
  
  public void cadastrarUsuario() {
    Scanner s = new Scanner(System.in);
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
      
    System.out.println("\nDigite palavras chaves separadas por espaço com características de um animal que você deseja adotar:");
    usuario.setCaracteristicasAnimais(s.nextLine());
      
    gerenteUsuario.adicionaUsuario(usuario);
  }
  
  public void removeUsuario(){
	Scanner s = new Scanner(System.in);
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
  
}