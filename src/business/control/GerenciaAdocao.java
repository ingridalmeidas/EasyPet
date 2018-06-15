package business.control;

import business.model.Adocao;

import java.util.ArrayList;

import infra.AdocaoDAOImpl;
import util.ArquivoNaoEncontrado;

public class GerenciaAdocao {
	
	public static GerenciaAdocao instancia;
	private ArrayList<Adocao> listaDeAdocoes = new ArrayList<Adocao>();
	private AdocaoDAOImpl p = new AdocaoDAOImpl();
	
	protected GerenciaAdocao() {}
		
	public static GerenciaAdocao getInstancia() {
		if(instancia == null)
			instancia = new GerenciaAdocao();
		return instancia;
	}
	
	public void listaDeAdocoes() {
		
		System.out.printf("\nTamanho da lista de adocoes: %d\n" , listaDeAdocoes.size());
		
		for (int i = 0; i < listaDeAdocoes.size(); i++) {
			
			Adocao a = (Adocao) listaDeAdocoes.get(i);
			
			a.setId(i);
			
			System.out.printf("\nAdocao %d: ",a.getId());
			System.out.println(a.toString());
			
		}
	}
	
	public void salvaListaEmArquivo() throws ArquivoNaoEncontrado{
		
		try {
			p.salvaLista(listaDeAdocoes);
		}catch(ArquivoNaoEncontrado e) {
			throw e;
		}
		
	}
	
	public void leLista() throws ArquivoNaoEncontrado{
		
		try {
			listaDeAdocoes = p.carregaLista();
		}catch(ArquivoNaoEncontrado e) {
			throw e;
		}	
	
	}
}