package controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import model.Idiomas;

public class Tradutor {
	
	private Idiomas linguas = new Idiomas();
	
	public Tradutor() {
		
	}
	
	public void TLogin(JLabel lblUsuario, JLabel lblSenha, 
			JButton btnEntrar, int i) {
		
		lblUsuario.setText(linguas.getLblUsuario(i));
		lblSenha.setText(linguas.getLblSenha(i));
		btnEntrar.setText(linguas.getBtnEntrar(i));

	}
	
	public void TAdministrador(JLabel lblTitulo, JLabel lblNome, JLabel lblAreaBusca, 
			JLabel lblUsuario, JLabel lblNivelPermissao, JLabel lblAjuda, 
			JButton btnExcluir, JButton btnEditar, JButton btnNovo, int i) {
		
		lblTitulo.setText(linguas.getLblTituloAdministrador(i));
		lblNome.setText(linguas.getLblNome(i));
		lblAreaBusca.setText(linguas.getLblAreaBusca(i));
		lblUsuario.setText(linguas.getLblUsuario(i));
		lblNivelPermissao.setText(linguas.getLblNivelPermissao(i));
		lblAjuda.setText(linguas.getLblAjuda(i));
		btnExcluir.setText(linguas.getBtnExcluir(i));
		btnEditar.setText(linguas.getBtnEditar(i));
		btnNovo.setText(linguas.getBtnNovo(i));
	}
	
	public void TNovoUsuario(JLabel lblUsuario, JLabel lblSenha, JLabel lblRepetirSenha, JLabel lblPermissao,
			JRadioButton rdBtnUsuario, JRadioButton rdBtnAdmin,
			JButton btnSalvar, int i) {
		
		lblUsuario.setText(linguas.getLblUsuario(i));
		lblSenha.setText(linguas.getLblSenha(i));
		lblRepetirSenha.setText(linguas.getLblRepetirSenha(i));
		lblPermissao.setText(linguas.getLblNivelPermissao(i));
		rdBtnUsuario.setText(linguas.getRdBtnUsuario(i));
		rdBtnAdmin.setText(linguas.getRdBtnAdministrador(i));
		btnSalvar.setText(linguas.getBtnSalvar(i));

	}
	
	public void TEditarUsuario(JLabel lblUsuario, JLabel lblSenha, JLabel lblRepetirSenha, JLabel lblPermissao,
			JRadioButton rdBtnUsuario, JRadioButton rdBtnAdmin,
			JButton btnEditar, int i) {
		
		lblUsuario.setText(linguas.getLblUsuario(i));
		lblSenha.setText(linguas.getLblSenha(i));
		lblRepetirSenha.setText(linguas.getLblRepetirSenha(i));
		lblPermissao.setText(linguas.getLblNivelPermissao(i));
		rdBtnUsuario.setText(linguas.getRdBtnUsuario(i));
		rdBtnAdmin.setText(linguas.getRdBtnAdministrador(i));
		btnEditar.setText(linguas.getBtnEditar(i));

	}
	
	public void TBaixas(JLabel lblNome, JLabel lblAreaBusca, 
			JLabel lblNome_, JLabel lblDataHoraEntrada, JLabel lblAjuda, 
			JButton btnBaixa, JButton btnEditar, JButton btnVoltar, int i) {
		
		lblNome.setText(linguas.getLblNome(i));
		lblAreaBusca.setText(linguas.getLblAreaBusca(i));
		lblNome_.setText(linguas.getLblNome(i));
		lblDataHoraEntrada.setText(linguas.getLblDataHoraEntrada(i));
		lblAjuda.setText(linguas.getLblAjuda(i));
		btnBaixa.setText(linguas.getBtnBaixa(i));
		btnEditar.setText(linguas.getBtnEditar(i));
		btnVoltar.setText(linguas.getBtnVoltar(i));
	}
	public void TEditar(JLabel lblNome, JLabel lblRG, 
			JLabel lblApartamento, JLabel lblMotivo,
			JButton btnConfirmar, JButton btnCancelar, int i) {
		
		lblNome.setText(linguas.getLblNome(i));
		lblRG.setText(linguas.getLblRG(i));
		lblApartamento.setText(linguas.getLblApartamento(i));
		lblMotivo.setText(linguas.getLblMotivo(i));
		btnConfirmar.setText(linguas.getBtnConfirmar(i));
		btnCancelar.setText(linguas.getBtnCancelar(i));
	}
	
	public void TMenu(JLabel lblTitulo, JLabel lblNome, JLabel lblRG, 
			JLabel lblApartamento, JLabel lblMotivo, JLabel lblAjuda, 
			JButton btnEntrada, JButton btnLimpar, JButton btnBaixa, 
			JButton btnInserirImagem, int i) {
		
		lblTitulo.setText(linguas.getLblTituloMenu(i));
		lblNome.setText(linguas.getLblNome(i));
		lblRG.setText(linguas.getLblRG(i));
		lblApartamento.setText(linguas.getLblApartamento(i));
		lblMotivo.setText(linguas.getLblMotivo(i));
		lblAjuda.setText(linguas.getLblAjuda(i));
		btnEntrada.setText(linguas.getBtnEntrada(i));
		btnLimpar.setText(linguas.getBtnLimpar(i));
		btnBaixa.setText(linguas.getBtnBaixa(i));
		btnInserirImagem.setText(linguas.getBtnInserirImagem(i));
	}
	
	
	

}
