package infra;
import business.model.Animal;
import util.ArquivoNaoEncontrado;

import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class AnimalDAOImpl implements AnimalDAO{
		
	public void salvaLista(ArrayList<Animal> lista) throws ArquivoNaoEncontrado{
			
		try {

			File file = new File("Animais.dat");
				
            FileOutputStream saveFile = new FileOutputStream(file);

            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            stream.writeObject(lista);

            stream.close();

         } catch (Exception e) {

        	  throw new ArquivoNaoEncontrado("Arquivo não encontrado. Um novo arquivo será inicializado");

          }	
	}
		
	public ArrayList<Animal> carregaLista() throws ArquivoNaoEncontrado{
			
		try {
            File file = new File("Animais.dat");
	            
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
	            
            ArrayList<Animal> listaDeAnimais = (ArrayList<Animal>) input.readObject();
	            
            input.close();
            
            return listaDeAnimais;
		}
		catch(Exception e){
            throw new ArquivoNaoEncontrado("Arquivo não encontrado. Um novo arquivo será inicializado");
		}
	
	}

}
