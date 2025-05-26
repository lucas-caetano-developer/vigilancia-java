package model;

public class Visitante {
	protected String id;
	protected String nome;
	protected String rg;
	
	public Visitante() {
		
	}
	
	public Visitante(String id, String nome, String rg) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	

}

