package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Ajuda {

    private JPanel panelMae;
    private JPanel panelFilho;
    private String pastaNome;
    private int pastaIdioma;
    private int totalImagens = 0;
    private JLabel imgAjudaMenu;
    private int i = 1;

    public Ajuda() {
    }

    public Ajuda(JPanel panelMae, JPanel panelFilho, String pastaNome, int pastaIdioma, int totalImagens) {
        this.panelMae = panelMae;
        this.panelFilho = panelFilho;
        this.pastaNome = pastaNome;
        this.pastaIdioma = pastaIdioma;
        this.totalImagens = totalImagens;
    }

    public void iniciar() {
        panelFilho.setVisible(false);

        JPanel painelDeAjuda = new JPanel();
        painelDeAjuda.setBackground(panelFilho.getBackground());
        painelDeAjuda.setBounds(panelFilho.getBounds());  
        painelDeAjuda.setLayout(null); 
        panelMae.add(painelDeAjuda);

        imgAjudaMenu = new JLabel();
        imgAjudaMenu.setBounds(0, 0, painelDeAjuda.getWidth(), painelDeAjuda.getHeight() - 70); 
        painelDeAjuda.add(imgAjudaMenu);

        atualizarImagem();

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));  
        painelBotoes.setBounds(0, painelDeAjuda.getHeight() - 70, painelDeAjuda.getWidth(), 70); 
        painelBotoes.setBackground(new Color(64, 128, 128));
        painelDeAjuda.add(painelBotoes);

        JButton btnAnterior = new JButton("ANTERIOR");
        btnAnterior.setPreferredSize(new java.awt.Dimension(120, 30)); 
        btnAnterior.setForeground(new Color(0, 0, 0));
        btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAnterior.setBackground(new Color(255, 255, 128));
        btnAnterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anterior();
            }
        });
        painelBotoes.add(btnAnterior);

        JButton btnProxima = new JButton("PRÓXIMA");
        btnProxima.setPreferredSize(new java.awt.Dimension(120, 30)); 
        btnProxima.setForeground(new Color(255, 255, 255));
        btnProxima.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnProxima.setBackground(new Color(0, 255, 0));
        btnProxima.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                proxima(painelDeAjuda);
            }
        });
        painelBotoes.add(btnProxima);

        JButton btnFinalizar = new JButton("FINALIZAR");
        btnFinalizar.setPreferredSize(new java.awt.Dimension(120, 30)); 
        btnFinalizar.setForeground(new Color(255, 255, 255));
        btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnFinalizar.setBackground(new Color(255, 0, 0));
        btnFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalizar(painelDeAjuda);
            }
        });
        painelBotoes.add(btnFinalizar);
    }

    private void finalizar(JPanel painelDeAjuda) {
        i = 1; 
        imgAjudaMenu.setIcon(new ImageIcon(getCaminhoImagem()));
        panelFilho.setVisible(true);
        painelDeAjuda.setVisible(false);
    }

    private String getCaminhoImagem() {
        String diretorioBase = System.getProperty("user.dir");
        String idioma = "";
        
        switch (pastaIdioma) {
		case 0: 
			idioma = "BRASIL";
			break;
		case 1:
			idioma = "EUA";
			break;
		case 2:
			idioma = "ESPANHA";
			break;
		default:
			JOptionPane.showMessageDialog(null, "Não foi possível abrir a interface de ajuda");
			
        }
        
        String caminhoRelativo = diretorioBase + File.separator + "icons" + File.separator + pastaNome + File.separator + idioma + File.separator + i + ".png";
        return caminhoRelativo;
    }

    public void proxima(JPanel painelDeAjuda) {
        if (i < totalImagens) {
            i++;
        } else {
            i = 1; 
        }
        atualizarImagem();
    }

    public void anterior() {
        if (i > 1) {
            i--;
        } else {
            i = totalImagens;
        }
        atualizarImagem();
    }

    private void atualizarImagem() {
        imgAjudaMenu.setIcon(new ImageIcon(getCaminhoImagem()));
    }
}
