package business.control;

import infra.API_Facebook;

public class FacebookAdapter extends API_Facebook implements ValidaLogin{
	
	public void validaCadastro(String login, String senha) {
		facebook_ValidaCadastro(login);
	}
	
	public void validaLogin(String login, String senha) {
		facebook_ValidaLogin(login, senha);
	}

}
