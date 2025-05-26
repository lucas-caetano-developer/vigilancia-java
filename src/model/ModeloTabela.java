package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModeloTabela extends AbstractTableModel {
	
	private ArrayList<Visita> visitas;
	private int i;
	
	private static Idiomas idiomas = new Idiomas();
	
	public ModeloTabela(ArrayList<Visita> visitas, int i) {
		super();
		this.visitas = visitas;
		this.i = i;
	}
	
	private static final String[] colunasBrasil = idiomas.getBaixasColunasBrasil();
	private static final String[] colunasEUA = idiomas.getBaixasColunasEUA();
	private static final String[] colunasEspanha = idiomas.getBaixasColunasEspanha();
	
	@Override
	public int getRowCount() {
		return visitas.size();
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
		Visita visita = visitas.get(rowIndex);
		if (columnIndex == 0) {
			return visita.getId();
		} else	if (columnIndex == 1) {
			return visita.getNome();
		} else if (columnIndex == 2) {
			return visita.getApartamento();
		} else if (columnIndex == 3) {
			return visita.getDataHoraEntrada();
		} else if (columnIndex == 4) {
			return visita.getTempoPermanencia();
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
