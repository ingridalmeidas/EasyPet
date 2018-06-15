package business.control;

import business.model.Usuario;

import java.util.ArrayList;

import infra.UsuarioDAOImpl;
import util.LoginInvalido;
import util.SenhaInvalida;
import util.ValidadorUsuario;
import util.ArquivoNaoEncontrado;

public class GerenciaUsuario {
	
	private ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
	
	UsuarioDAOImpl p = new UsuarioDAOImpl();
	
	ValidadorUsuario validador = new ValidadorUsuario();
	
	
	public boolean validaSenha(Usuario usuario) throws SenhaInvalida{
		return validador.validaSenha(usuario);
	}
	
	public boolean validaLogin(Usuario usuario) throws LoginInvalido{
		return validador.validaLogin(usuario);
	}
	
	public void adicionaUsuario(Usuario usuario){
		
		listaDeUsuarios.add(new Usuario(usuario.getLogin(), usuario.getSenha(), usuario.getNome(), usuario.getIdade(),
							usuario.getSexo(), usuario.getCidade(), usuario.getEstado(), usuario.getCaracteristicasAnimais()));
		
		System.out.printf("\nO usuario '%s' foi adicionado com sucesso \n", usuario.getLogin());
		
	}
	
	public void listaDeUsuarios() {
		
		System.out.printf("\nTamanho da lista de usuarios: %d\n" , listaDeUsuarios.size());
		
		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			
			Usuario u = (Usuario) listaDeUsuarios.get(i);
			
			u.setId(i);
			
			System.out.printf("\nUsuario %d: ", u.getId());
			System.out.println(u.toString());
			
		}
	}
	
	
	public boolean removeUsuario(String login) {
			
		for (int i = 0; i < listaDeUsuarios.size(); i++) {
				
			Usuario u = (Usuario) listaDeUsuarios.get(i);
				
				
			if (login.equals(u.getLogin())) {
				return listaDeUsuarios.remove(u);
			}
		}
			
		return false;
	}
	
	public void salvaListaEmArquivo() throws ArquivoNaoEncontrado{
		
		try {
			p.salvaLista(listaDeUsuarios);
		}catch(ArquivoNaoEncontrado e) {
			throw e;
		}
		
	}
	
	public void leLista() throws ArquivoNaoEncontrado{
		
		try {
			listaDeUsuarios = p.carregaLista();
		}catch(ArquivoNaoEncontrado e) {
			throw e;
		}	
	
	}
}
