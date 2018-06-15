package business.control;

import business.model.Animal;

import java.util.ArrayList;

import infra.AnimalDAOImpl;
import util.LoginInvalido;
import util.SenhaInvalida;
import util.ValidadorUsuario;
import util.ArquivoNaoEncontrado;

public class GerenciaAnimal {
	
	private ArrayList<Animal> listaDeAnimais = new ArrayList<Animal>();
	
	AnimalDAOImpl p = new AnimalDAOImpl();
	
	public void adicionaAnimal(Animal animal){
		
		listaDeAnimais.add(new Animal(animal.getNome(), animal.getEspecie(), animal.getRaça(),
				animal.getIdade(), animal.getSexo(), animal.getCastrado(), animal.getVacinado(),
				animal.getDescricao(), animal.getDoador()));
		
		System.out.printf("\nO animal '%s' foi adicionado com sucesso \n", animal.getNome());
		
	}
	
	public void listaDeAnimais() {
		
		System.out.printf("\nTamanho da lista de animais: %d\n" , listaDeAnimais.size());
		
		for (int i = 0; i < listaDeAnimais.size(); i++) {
			
			Animal a = (Animal) listaDeAnimais.get(i);
			
			a.setId(i);
			
			System.out.printf("\nAnimal %d: ", a.getId());
			System.out.println(a.toString());
			
		}
	}
	
	
	public boolean removeAnimal(String id) {
			
		for (int i = 0; i < listaDeAnimais.size(); i++) {
				
			Animal a = (Animal) listaDeAnimais.get(i);
				
				
			if (id.equals(a.getId())) {
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
