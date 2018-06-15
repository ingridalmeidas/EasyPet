package infra;

import java.util.ArrayList;

import business.model.Usuario;
import util.ArquivoNaoEncontrado;

public interface UsuarioDAO {
	
	public ArrayList<Usuario> carregaLista() throws ArquivoNaoEncontrado; 
	public void salvaLista (ArrayList<Usuario> lista) throws ArquivoNaoEncontrado;
	
}