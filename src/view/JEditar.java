package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Tradutor;
import dao.DAO;
import model.Idiomas;
import model.Visita;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JEditar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeEditar;
	private JTextField txtRGEditar;
	private JTextField txtApartamentoEditar;
	private JTextField txtMotivoEditar;
	
	private Idiomas idiomas = new Idiomas();
	private Tradutor tradutor = new Tradutor();
	private int idioma = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JEditar frame = new JEditar(null, null, 0);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JEditar(Visita visitaSelecionada, JBaixas jBaixas, int i) {
		this.setResizable(false);
		setTitle("ICyan - Sistemas");
		idioma = i;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 363, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNome.setBounds(50, 23, 57, 27);
		panel.add(lblNome);
		
		txtNomeEditar = new JTextField();
		txtNomeEditar.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {

		        int codigoAscii = (int) e.getKeyChar();

		        if ((codigoAscii < 65 || (codigoAscii > 90 && codigoAscii < 97) || codigoAscii > 122) &&
		                codigoAscii != KeyEvent.VK_BACK_SPACE &&
		                codigoAscii != KeyEvent.VK_SPACE &&
		                codigoAscii != KeyEvent.VK_DELETE) {
		            e.consume();
		            return;
		        }
				
			}
		});
		txtNomeEditar.setColumns(10);
		txtNomeEditar.setBounds(50, 50, 265, 27);
		panel.add(txtNomeEditar);
		
		JLabel lblRG = new JLabel("RG");
		lblRG.setForeground(Color.WHITE);
		lblRG.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRG.setBounds(50, 88, 57, 27);
		panel.add(lblRG);
		
		txtRGEditar = new JTextField();
		txtRGEditar.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyTyped(KeyEvent e) {
		        String texto = txtRGEditar.getText();
		        
		        if (texto.length() >= 12) {
		            e.consume();
		            return;
		        }

		        int codigoAscii = (int) e.getKeyChar();

		        if ((codigoAscii < 48 || codigoAscii > 57) && codigoAscii != KeyEvent.VK_BACK_SPACE && codigoAscii != KeyEvent.VK_DELETE) {
		            e.consume();
		            return;
		        }

		        if (texto.length() == 2 || texto.length() == 6) {
		        	txtRGEditar.setText(texto + ".");
		        }

		        if (texto.length() == 10) {
		        	txtRGEditar.setText(texto + "-");
		        }
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
		            String texto = txtRGEditar.getText();
		            if (texto.length() > 0) {
		                if (texto.endsWith(".") || texto.endsWith("-")) {
		                	txtRGEditar.setText(texto.substring(0, texto.length() - 1));
		                }
		            }
		        }
		    }
		});
		txtRGEditar.setColumns(10);
		txtRGEditar.setBounds(50, 115, 265, 27);
		panel.add(txtRGEditar);
		
		JLabel lblApartamento = new JLabel("Apartamento");
		lblApartamento.setForeground(Color.WHITE);
		lblApartamento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblApartamento.setBounds(50, 162, 122, 27);
		panel.add(lblApartamento);
		
		txtApartamentoEditar = new JTextField();
		txtApartamentoEditar.setColumns(10);
		txtApartamentoEditar.setBounds(50, 189, 265, 27);
		panel.add(txtApartamentoEditar);
		
		JLabel lblMotivo = new JLabel("Motivo");
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMotivo.setBounds(50, 227, 57, 27);
		panel.add(lblMotivo);
		
		txtMotivoEditar = new JTextField();
		txtMotivoEditar.setColumns(10);
		txtMotivoEditar.setBounds(50, 254, 264, 56);
		panel.add(txtMotivoEditar);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!txtNomeEditar.getText().isEmpty() && !txtRGEditar.getText().isEmpty() && !txtApartamentoEditar.getText().isEmpty() && !txtMotivoEditar.getText().isEmpty()) {
					LocalDateTime hoje = LocalDateTime.now();
					DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					String dataHora = hoje.format(formatoDataHora);
					DAO dao = new DAO();
				
					Visita visita = new Visita(null, txtNomeEditar.getText(), txtRGEditar.getText(), txtApartamentoEditar.getText(),
							dataHora," ",txtMotivoEditar.getText(),null);
					
					try {
						dao.alterarVisita(visitaSelecionada.getId(), visita, idioma);
					} catch (Exception x) {
					    JOptionPane.showMessageDialog(null, idiomas.getEditarMenssageERRO(idioma) + x.getMessage());
					}

					abrirTelaPrincipal(jBaixas);
				}
				else {
					JOptionPane.showMessageDialog(null, idiomas.getMenssageCampos(idioma), "", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmar.setBackground(Color.GREEN);
		btnConfirmar.setBounds(26, 332, 146, 41);
		panel.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBackground(new Color(255, 128, 128));
		btnCancelar.setBounds(195, 332, 146, 41);
		panel.add(btnCancelar);
		
		tradutor.TEditar(lblNome, lblRG, 
			    lblApartamento, lblMotivo, 
			    btnConfirmar, btnCancelar, i);
		
		if (visitaSelecionada != null) {
			preencherCampos(visitaSelecionada);
		}
	}
	
	private void preencherCampos(Visita visitaSelecionada) {
		txtNomeEditar.setText(visitaSelecionada.getNome());
		txtRGEditar.setText(visitaSelecionada.getRg());
		txtApartamentoEditar.setText(visitaSelecionada.getApartamento());
		txtMotivoEditar.setText(visitaSelecionada.getMotivo());

	}
	
	private void abrirTelaPrincipal(JBaixas jBaixas) {
		jBaixas.dispose();
		dispose();
		jBaixas = new JBaixas(idioma);
		jBaixas.setLocationRelativeTo(jBaixas);
		jBaixas.setVisible(true);
	}
	
}
