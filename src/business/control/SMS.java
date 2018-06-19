package business.control;

public class SMS implements NotificacaoCommand{

	public void enviarNotificacao(int IDdoador) {
		System.out.println("Enviando SMS ao doador");
	}
	
}
