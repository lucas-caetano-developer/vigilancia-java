package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import dao.DAO;
import model.Idiomas;
import model.Visita;

public class Monitoramento {
	
	private Idiomas idiomas = new Idiomas();
	
	public Monitoramento() {
		
	}
	
	private static DAO dao = new DAO();
    private static ArrayList<Visita> visitas = null;
	
	public void iniciar(int idioma) {
	    Timer timer = new Timer(60000, new ActionListener() {  
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            try {
	                visitas = dao.listarVisita(idioma);
	            } catch (Exception x) {
	            	JOptionPane.showMessageDialog(null, idiomas.getDaoVisitaVazio(idioma), "", JOptionPane.WARNING_MESSAGE);
	                x.printStackTrace();
	                return;  
	            }
	            atualizarPermanencia(visitas, idioma);
	        }
	    });
	    timer.start();
	}

	public void atualizarPermanencia(ArrayList<Visita> visitas, int idioma) {
	    LocalDateTime agora = LocalDateTime.now();
	    DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	    
	    for (Visita visita : visitas) {
	        LocalDateTime dataHoraEntrada = LocalDateTime.parse(visita.getDataHoraEntrada(), formatoDataHora);
	        long minutosPassados = Duration.between(dataHoraEntrada, agora).toMinutes();
	        
	        visita.setTempoPermanencia(minutosPassados + " min");
	        dao.atualizarVisita(visita.getId(), visita, idioma);
	        notificar(minutosPassados, visita, idioma);
	    }
		
	}

	public void notificar(long minutosPassados, Visita visita, int idioma) {
		
		if (minutosPassados > 60) {
			JOptionPane.showMessageDialog(null, idiomas.getMonitoramentoAviso1(idioma) + visita.getNome() + idiomas.getMonitoramentoAviso2(idioma), "", JOptionPane.WARNING_MESSAGE);
		}
		
	}

}


