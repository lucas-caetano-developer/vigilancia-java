package model;

public class Usuario {
	private String id;
	private String usuario;
	private String senha;
	private String permissao;
	
	public Usuario() {
		
	}
	
	public Usuario(String id, String usuario, String senha, String permissao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.permissao = permissao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	

	
}
