package business.model;

public class AdministradorProxy extends Administrador {
	protected String usuario, senha;
	
	public AdministradorProxy(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	@Override
	public Relatorio gerarRelatorio(String tipo) {
		if(temPermissaoDeAcesso()) {
			return super.gerarRelatorio(tipo);
		}
		return null;
	}
	
	private boolean temPermissaoDeAcesso() {
		return usuario == "admin" && senha == "admin";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
