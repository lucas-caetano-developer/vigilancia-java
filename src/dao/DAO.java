package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.Conexao;
import model.Idiomas;
import model.Usuario;
import model.Visita;

public class DAO {

	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	private Idiomas idiomas = new Idiomas();
	
	private static String CADASTRAR_VISITA = " INSERT INTO VISITA "
			+ " (ID, NOME, RG, APARTAMENTO, DATA_HORA_ENTRADA, DATA_HORA_SAIDA, MOTIVO, TEMPO_PERMANENCIA, IMAGEM) "
			+ " VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?) ";
	
	private static String CONSULTAR_VISITA = " SELECT * FROM VISITA "
			+ " WHERE ID = ? ";
	
	private static String ALTERAR_VISITA = " UPDATE VISITA SET "
			+ " NOME = ?, RG = ?, APARTAMENTO = ?, DATA_HORA_ENTRADA = ?, DATA_HORA_SAIDA = ?, MOTIVO = ?, TEMPO_PERMANENCIA = ? "
			+ " WHERE ID = ? ";
	
	private static String ATUALIZAR_VISITA = " UPDATE VISITA SET "
			+ " NOME = ?, RG = ?, APARTAMENTO = ?, DATA_HORA_ENTRADA = ?, DATA_HORA_SAIDA = ?, MOTIVO = ?, TEMPO_PERMANENCIA = ? "
			+ " WHERE ID = ? ";
	
	private static String DELETAR_VISITA = " DELETE FROM VISITA "
			+ " WHERE ID = ? ";
	
	private static String LISTAR_VISITA = " SELECT * FROM VISITA "
			+ " WHERE 1=1 AND DATA_HORA_SAIDA = ' ' ";
	
	
	private static String CADASTRAR_USUARIO = " INSERT INTO USUARIO "
			+ " (ID, USUARIO, SENHA, PERMISSAO) "
			+ " VALUES (NULL, ?, ?, ?) ";
	
	private static String CONSULTAR_USUARIO = " SELECT * FROM USUARIO "
			+ " WHERE ID = ? ";
	
	private static String VALIDAR_USUARIO = " SELECT * FROM USUARIO "
			+ " WHERE USUARIO = ? "
			+ " AND SENHA = ? ";
	
	private static String ALTERAR_USUARIO = " UPDATE USUARIO SET "
			+ " USUARIO = ?, SENHA = ?, PERMISSAO = ? "
			+ " WHERE ID = ? ";
	
	private static String DELETAR_USUARIO = " DELETE FROM USUARIO "
			+ " WHERE ID = ? ";
	
	private static String LISTAR_USUARIO = " SELECT * FROM USUARIO "
			+ " WHERE 1=1 ";
	
	
	public DAO() {
		
	}
	
	public void cadastrarVisita(Visita visita, byte[] imagemBinaria, int idioma) {
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		
		String query = CADASTRAR_VISITA;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			//NOME, RG, APARTAMENTO, DATA_HORA_ENTRADA, DATA_HORA_SAIDA, MOTIVO, TEMPO_PERMANENCIA, IMAGEM
			preparedStatement.setString(i++, visita.getNome());
			preparedStatement.setString(i++, visita.getRg());
			preparedStatement.setString(i++, visita.getApartamento());
			preparedStatement.setString(i++, visita.getDataHoraEntrada());
			preparedStatement.setString(i++, visita.getDataHoraSaida());
			preparedStatement.setString(i++, visita.getMotivo());
			preparedStatement.setString(i++, visita.getTempoPermanencia());
			
			if (imagemBinaria != null) {
	            preparedStatement.setBytes(i++, imagemBinaria);
	        } else {
	            preparedStatement.setNull(i++, java.sql.Types.BLOB);  
	        }
			
			preparedStatement.execute();
			connection.commit();

			JOptionPane.showMessageDialog(null, idiomas.getDaoVisitaNovo(idioma));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		
	}
	
	public Visita consultarVisita(String id, int idioma) throws Exception {
		
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		Visita visita = null;
		String query = CONSULTAR_VISITA;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			preparedStatement.setString(i++, id);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				visita = new Visita(resultSet.getString("ID"),
						resultSet.getString("NOME"),
						resultSet.getString("RG"),
						resultSet.getString("APARTAMENTO"),
						resultSet.getString("DATA_HORA_ENTRADA"),
						resultSet.getString("DATA_HORA_SAIDA"),
						resultSet.getString("MOTIVO"),
						resultSet.getString("TEMPO_PERMANENCIA"));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		if(visita == null) {
			JOptionPane.showMessageDialog(null, idiomas.getDaoVisitaRetorno(idioma), "", JOptionPane.WARNING_MESSAGE);
			throw new Exception(idiomas.getDaoVisitaRetorno(idioma));
		}
		return visita;
		
	}
	
	public void alterarVisita(String id, Visita visita, int idioma) {
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		
		String query = ALTERAR_VISITA;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			//NOME, RG, APARTAMENTO, DATA_HORA_ENTRADA, DATA_HORA_SAIDA, MOTIVO
			preparedStatement.setString(i++, visita.getNome());
			preparedStatement.setString(i++, visita.getRg());
			preparedStatement.setString(i++, visita.getApartamento());
			preparedStatement.setString(i++, visita.getDataHoraEntrada());
			preparedStatement.setString(i++, visita.getDataHoraSaida());
			preparedStatement.setString(i++, visita.getMotivo());
			preparedStatement.setString(i++, visita.getTempoPermanencia());
			preparedStatement.setString(i++, id);
			
			
			preparedStatement.execute();
			connection.commit();
			
			JOptionPane.showMessageDialog(null, idiomas.getDaoVisitaAlterada(idioma));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		
	}
	
	public void atualizarVisita(String id, Visita visita, int idioma) {
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		
		String query = ATUALIZAR_VISITA;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			//NOME, RG, APARTAMENTO, DATA_HORA_ENTRADA, DATA_HORA_SAIDA, MOTIVO
			preparedStatement.setString(i++, visita.getNome());
			preparedStatement.setString(i++, visita.getRg());
			preparedStatement.setString(i++, visita.getApartamento());
			preparedStatement.setString(i++, visita.getDataHoraEntrada());
			preparedStatement.setString(i++, visita.getDataHoraSaida());
			preparedStatement.setString(i++, visita.getMotivo());
			preparedStatement.setString(i++, visita.getTempoPermanencia());
			preparedStatement.setString(i++, id);
			
			
			preparedStatement.execute();
			connection.commit();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		
	}

	public void deletarVisita(String id, int idioma) {
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		
		String query = DELETAR_VISITA;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;

			preparedStatement.setString(i++, id);
			
			
			preparedStatement.execute();
			connection.commit();
			
			JOptionPane.showMessageDialog(null, idiomas.getDaoVisitaExcluir(idioma));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		
	}
	
	public ArrayList<Visita> listarVisita(int idioma) throws Exception {
		
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		ArrayList<Visita> visitas = new ArrayList<>();
		String query = LISTAR_VISITA;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				visitas.add( new Visita(resultSet.getString("ID"),
						resultSet.getString("NOME"),
						resultSet.getString("RG"),
						resultSet.getString("APARTAMENTO"),
						resultSet.getString("DATA_HORA_ENTRADA"),
						resultSet.getString("DATA_HORA_SAIDA"),
						resultSet.getString("MOTIVO"),
						resultSet.getString("TEMPO_PERMANENCIA")));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		if(visitas.size() < 0) {
			JOptionPane.showMessageDialog(null, idiomas.getDaoVisitaVazio(idioma), "", JOptionPane.WARNING_MESSAGE);
			throw new Exception(idiomas.getDaoVisitaVazio(idioma));
		}
		return visitas;
		
	}
	
	
	public void cadastrarUsuario(Usuario usuario, int idioma) {
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		
		String query = CADASTRAR_USUARIO;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			//USUARIO, SENHA, PERMISSAO
			preparedStatement.setString(i++, usuario.getUsuario());
			preparedStatement.setString(i++, usuario.getSenha());
			preparedStatement.setString(i++, usuario.getPermissao());
			
			preparedStatement.execute();
			connection.commit();
			
			JOptionPane.showMessageDialog(null, idiomas.getDaoUsuarioNovo(idioma));
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, idiomas.getDaoUsuarioNovoErro(idioma) + e.getMessage());
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		
	}
	
	public Usuario validarUsuario(String nomeUsuario, String senhaCriptografada, int idioma) throws Exception {
		
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		Usuario usuario = null;
		String query = VALIDAR_USUARIO;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			preparedStatement.setString(i++, nomeUsuario);
			preparedStatement.setString(i++, senhaCriptografada);
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				usuario = new Usuario(resultSet.getString("ID"),
									  resultSet.getString("USUARIO"),
									  resultSet.getString("SENHA"),
									  resultSet.getString("PERMISSAO"));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		if(usuario == null) {
			JOptionPane.showMessageDialog(null, idiomas.getDaoUsuarioValidar(idioma), "", JOptionPane.WARNING_MESSAGE);
			throw new Exception(idiomas.getDaoUsuarioValidar(idioma));
		} 
		return usuario;
		
	}
	
	public Usuario consultarUsuario(String id, int idioma) throws Exception {
		
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		Usuario usuario = null;
		String query = CONSULTAR_USUARIO;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			preparedStatement.setString(i++, id);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				usuario = new Usuario(resultSet.getString("ID"),
						  resultSet.getString("USUARIO"),
						  resultSet.getString("SENHA"),
						  resultSet.getString("PERMISSAO"));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		if(usuario == null) {
			JOptionPane.showMessageDialog(null, idiomas.getDaoUsuarioRetorno(idioma), "", JOptionPane.WARNING_MESSAGE);
			throw new Exception(idiomas.getDaoUsuarioRetorno(idioma));
		}
		return usuario;
		
	}
	
	public ArrayList<Usuario> listarUsuario(int idioma) throws Exception {
		
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String query = LISTAR_USUARIO;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				usuarios.add( new Usuario(resultSet.getString("ID"),
						resultSet.getString("USUARIO"),
						resultSet.getString("SENHA"),
						resultSet.getString("PERMISSAO")));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		if(usuarios.size() < 0) {
			JOptionPane.showMessageDialog(null, idiomas.getDaoUsuarioVazio(idioma), "", JOptionPane.WARNING_MESSAGE);
			throw new Exception(idiomas.getDaoUsuarioVazio(idioma));
		}
		return usuarios;
		
	}
	
	public void deletarUsuario(String id, int idioma) {
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		
		String query = DELETAR_USUARIO;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;

			preparedStatement.setString(i++, id);
			
			
			preparedStatement.execute();
			connection.commit();
			
			JOptionPane.showMessageDialog(null, idiomas.getDaoUsuarioExcluir(idioma));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		
	}
	
	public void alterarUsuario(String id, Usuario usuario, int idioma) {
		Connection connection = Conexao.getInstancia().abrirConexao(idioma);
		
		String query = ALTERAR_USUARIO;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			preparedStatement.setString(i++, usuario.getUsuario());
			preparedStatement.setString(i++, usuario.getSenha());
			preparedStatement.setString(i++, usuario.getPermissao());
			preparedStatement.setString(i++, id);

			preparedStatement.execute();
			connection.commit();
			
			JOptionPane.showMessageDialog(null, idiomas.getDaoUsuarioAlterado(idioma));
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, idiomas.getDaoUsuarioAlteradoErro(idioma) + e.getMessage());
			e.printStackTrace();
		} finally {
			fecharConexao(idioma);
		}
		
	}
	
	private void fecharConexao(int idioma) {
		
		
		try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
			Conexao.getInstancia().fecharConexao(idioma);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
}


