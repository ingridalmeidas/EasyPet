package infra;

import java.util.ArrayList;

import business.model.Animal;
import util.ArquivoNaoEncontrado;

public interface AnimalDAO {
	
	public ArrayList<Animal> carregaLista() throws ArquivoNaoEncontrado; 
	public void salvaLista (ArrayList<Animal> lista) throws ArquivoNaoEncontrado;
	
}
