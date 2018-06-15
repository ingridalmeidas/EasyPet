package business.control;

import infra.API_Gmail;

public class GmailAdapter extends API_Gmail implements ValidaLogin{
	
	public void validaCadastro(String login, String senha) {
		gmail_ValidaCadastro(login, senha);
	}
	
	public void validaLogin(String login, String senha) {
		gmail_ValidaLogin(login, senha);
	}
	

}
