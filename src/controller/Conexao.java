package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Idiomas;

public class Conexao {

	private static Conexao instancia;
	private static String DRIVER = "org.sqlite.JDBC";
	private static String BD = "jdbc:sqlite:resources/bdvisitas.db";
	private static Connection conexao;
	
	private Idiomas idiomas = new Idiomas();
	
	private Conexao() {
		
	}
	
	public static Conexao getInstancia() {
		if(instancia == null) {
			instancia = new Conexao();
		}
		return instancia;
	}
	
	public Connection abrirConexao(int idioma) {
		
		try {
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(BD);
			conexao.setAutoCommit(false);
		} catch (SQLException | ClassNotFoundException e) {
			
			System.out.println(idiomas.getConexaoMenssageErroConectar(idioma) + e.getMessage());
		}
		return conexao;
		
	}
	
	public void fecharConexao(int idioma) {
		try {
			if(conexao!=null && !conexao.isClosed()) {
				conexao.close();
			}
		} catch (SQLException e) {
			System.out.println(idiomas.getConexaoMenssageErroFechar(idioma)+ e.getMessage());
		} finally {
			conexao = null;
		}
	}

}
