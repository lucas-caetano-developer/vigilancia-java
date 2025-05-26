package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModeloTabelaUsuario extends AbstractTableModel {
	
	private ArrayList<Usuario> usuarios;
	private int i;
	
	private static Idiomas idiomas = new Idiomas();

	public ModeloTabelaUsuario(ArrayList<Usuario> usuarios, int i) {
		super();
		this.usuarios = usuarios;
		this.i = i;
	}
	
	private static final String[] colunasBrasil = idiomas.getUsuariosColunasBrasil();
	private static final String[] colunasEUA = idiomas.getUsuariosColunasEUA();
	private static final String[] colunasEspanha = idiomas.getUsuariosColunasEspanha();
	
	@Override
	public int getRowCount() {
		return usuarios.size();
	}

	@Override
	public int getColumnCount() {
		
		if (i == 0 ) {
			return colunasBrasil.length;
		} 
		else if (i == 1) {
			return colunasEUA.length;
		} 
		else if (i == 2) {
			return colunasEspanha.length;
		}
		return colunasBrasil.length;
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario usuario = usuarios.get(rowIndex);
		if (columnIndex == 0) {
			return usuario.getId();
		} else	if (columnIndex == 1) {
			return usuario.getUsuario();
		} else if (columnIndex == 2) {
			return usuario.getPermissao();
		} else {
			return null;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		
		if (i == 0 ) {
			return colunasBrasil[column];
		} 
		else if (i == 1) {
			return colunasEUA[column];
		} 
		else if (i == 2) {
			return colunasEspanha[column];
		}
		return colunasBrasil[column];
	}

}
