package infra;
import business.model.Adocao;
import util.ArquivoNaoEncontrado;

import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class AdocaoDAOImpl implements AdocaoDAO{
		
	public void salvaLista(ArrayList<Adocao> lista) throws ArquivoNaoEncontrado{
			
		try {

			File file = new File("Adocoes.dat");
				
            FileOutputStream saveFile = new FileOutputStream(file);

            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            stream.writeObject(lista);

            stream.close();

         } catch (Exception e) {

        	  throw new ArquivoNaoEncontrado("Arquivo não encontrado. Um novo arquivo será inicializado");

          }	
	}
		
	public ArrayList<Adocao> carregaLista() throws ArquivoNaoEncontrado{
			
		try {
            File file = new File("Adocoes.dat");
	            
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
	            
            ArrayList<Adocao> listaDeAnimais = (ArrayList<Adocao>) input.readObject();
	            
            input.close();
            
            return listaDeAnimais;
		}
		catch(Exception e){
            throw new ArquivoNaoEncontrado("Arquivo não encontrado. Um novo arquivo será inicializado");
		}
	
	}

}
