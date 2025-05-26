package dao;

import java.sql.Connection;

import controller.Conexao;

public class BD {
	
	@SuppressWarnings("unused")
	private static Connection connection = null;
	
	public static void main(String[] args) {
		try {
		connection = Conexao.getInstancia().abrirConexao(1);
		System.out.println("Base criada com sucesso");
		Conexao.getInstancia().fecharConexao(1);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}
