package business.control;

public class Email implements NotificacaoCommand {

	public void enviarNotificacao(int idDoador) {
		System.out.println("Enviando Email ao doador");
	}
	
}
