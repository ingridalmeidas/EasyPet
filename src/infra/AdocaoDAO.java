package infra;

import java.util.ArrayList;

import business.model.Adocao;
import util.ArquivoNaoEncontrado;

public interface AdocaoDAO {
	
	public ArrayList<Adocao> carregaLista() throws ArquivoNaoEncontrado; 
	public void salvaLista (ArrayList<Adocao> lista) throws ArquivoNaoEncontrado;
	
}
