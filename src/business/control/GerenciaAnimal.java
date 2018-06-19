package business.control;

import business.model.Animal;

import java.util.ArrayList;

import infra.AnimalDAOImpl;
import util.ArquivoNaoEncontrado;

public class GerenciaAnimal {
	
	public static GerenciaAnimal instancia;
	private ArrayList<Animal> listaDeAnimais = new ArrayList<Animal>();
	private AnimalDAOImpl p = new AnimalDAOImpl();
	
	protected GerenciaAnimal() {}
		
	public static GerenciaAnimal getInstancia() {
		if(instancia == null)
			instancia = new GerenciaAnimal();
		return instancia;
	}
	
	public void adicionaAnimal(Animal animal){
		
		listaDeAnimais.add(new Animal(animal.getNome(), animal.getEspecie(), animal.getRaca(),
				animal.getIdade(), animal.getSexo(), animal.getCastrado(), animal.getVacinado(),
				animal.getDescricao(), animal.getIDdoador()));
		
		System.out.printf("\nO animal '%s' foi adicionado com sucesso \n", animal.getNome());
		
	}
	
	public void listaDeAnimais() {
		
		System.out.printf("\nTamanho da lista de animais: %d\n" , listaDeAnimais.size());
		
		for (IteradorAnimal iterator = new IteradorAnimal(this.listaDeAnimais); !iterator.isDone(); iterator.next()) {
			
			Animal a = iterator.currentItem();
			
			a.setId(iterator.contador);
			
			System.out.printf("\nAnimal %d: ", a.getId());
			System.out.println(a.toString());
			
		}
	}
	
	
	public boolean removeAnimal(String nome) {
			
		for (IteradorAnimal iterator = new IteradorAnimal(this.listaDeAnimais); !iterator.isDone(); iterator.next()) {
				
			Animal a = iterator.currentItem();
				
				
			if (nome.equals(a.getNome())) {
				return listaDeAnimais.remove(a);
			}
		}
			
		return false;
	}
	
	public void salvaListaEmArquivo() throws ArquivoNaoEncontrado{
		
		try {
			p.salvaLista(listaDeAnimais);
		}catch(ArquivoNaoEncontrado e) {
			throw e;
		}
		
	}
	
	public void leLista() throws ArquivoNaoEncontrado{
		
		try {
			listaDeAnimais = p.carregaLista();
		}catch(ArquivoNaoEncontrado e) {
			throw e;
		}	
	
	}
}
