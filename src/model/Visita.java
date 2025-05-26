package model;

public class Visita extends Visitante{
	protected String apartamento;
	protected String dataHoraEntrada;
	protected String dataHoraSaida;
	protected String motivo;
	protected String tempoPermanencia;
	
	public Visita() {
		
	}

	public Visita(String id, String nome, String rg, String apartamento, String dataHoraEntrada, String dataHoraSaida, String motivo, String tempoPermanencia) {
		super(id, nome, rg);
		this.apartamento = apartamento;
		this.dataHoraEntrada = dataHoraEntrada;
		this.dataHoraSaida = dataHoraSaida;
		this.motivo = motivo;
		this.tempoPermanencia = tempoPermanencia;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public String getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(String dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public String getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(String dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}
	
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public String getTempoPermanencia() {
		return tempoPermanencia;
	}

	public void setTempoPermanencia(String tempoPermanencia) {
		this.tempoPermanencia = tempoPermanencia;
	}
	


}
