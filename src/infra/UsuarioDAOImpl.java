package infra;
import business.model.Usuario;
import util.ArquivoNaoEncontrado;

import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class UsuarioDAOImpl implements UsuarioDAO{
		
	public void salvaLista(ArrayList<Usuario> lista) throws ArquivoNaoEncontrado{
			
		try {

			File file = new File("Usuarios.dat");
				
            FileOutputStream saveFile = new FileOutputStream(file);

            ObjectOutputStream stream = new ObjectOutputStream(saveFile);

            stream.writeObject(lista);

            stream.close();

         } catch (Exception e) {

        	  throw new ArquivoNaoEncontrado("Arquivo nao encontrado. Um novo arquivo sera inicializado");

          }	
	}
		
	public ArrayList<Usuario> carregaLista() throws ArquivoNaoEncontrado{
			
		try {
            File file = new File("Usuarios.dat");
	            
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
	            
            ArrayList<Usuario> listaDeUsuarios = (ArrayList<Usuario>) input.readObject();
	            
            input.close();
            
            return listaDeUsuarios;
		}
		catch(Exception e){
            throw new ArquivoNaoEncontrado("Arquivo nao encontrado. Um novo arquivo sera inicializado");
		}
	
	}
}
