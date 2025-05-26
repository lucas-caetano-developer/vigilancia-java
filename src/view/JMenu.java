package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ImagemBinario;
import controller.Monitoramento;
import controller.Tradutor;
import dao.DAO;
import model.Ajuda;
import model.Idiomas;
import model.Visita;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtRG;
	private JTextField txtMotivo;
	private JTextField txtApartamento;
	private JLabel lblNomeMenu;
	private JLabel lblRgMenu;
	private JLabel lblApartamentoMenu;
	private JLabel lblMotivoMenu;
	private JLabel imgVisitante;
	private JPanel panelImg;
	private JButton btnInserirImg;
	private JButton btnEntrada;
	private JButton btnBaixaMenu;
	private JButton btnLimparMenu;
	private JLabel lblTitulo;
	private byte[] imagemByte;
    private static Monitoramento monitoramento = new Monitoramento();
    private Ajuda ajuda = new Ajuda();
    
    private Idiomas idiomas = new Idiomas();
    Tradutor tradutor = new Tradutor();
	
	private JLabel imgBrasil = new JLabel("");
	private JLabel imgEUA = new JLabel("");
	private JLabel imgEspanha = new JLabel("");
	static int idioma = 0;
    
    
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenu frame = new JMenu(0);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					monitoramento.iniciar(idioma);;
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
	public JMenu(int i) {
		this.setResizable(false);
		setTitle("ICyan - Sistemas");
		idioma = i;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 527);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 611, 488);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ajuda = new Ajuda(contentPane, panel, "JMenu_Ajuda", idioma, 10);
		
		lblTitulo = new JLabel("CONTROLE DE ENTRADA E SAÍDA");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(122, 11, 381, 40);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblTitulo);
		
		lblNomeMenu = new JLabel("Nome");
		lblNomeMenu.setToolTipText("");
		lblNomeMenu.setForeground(new Color(255, 255, 255));
		lblNomeMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNomeMenu.setBounds(47, 84, 111, 27);
		panel.add(lblNomeMenu);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("");
		txtNome.addKeyListener(new KeyAdapter() {
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
		txtNome.setBounds(47, 111, 265, 27);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		lblRgMenu = new JLabel("RG");
		lblRgMenu.setForeground(new Color(255, 255, 255));
		lblRgMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRgMenu.setBounds(47, 149, 57, 27);
		panel.add(lblRgMenu);
		
		txtRG = new JTextField();
		txtRG.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        String texto = txtRG.getText();
		        
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
		            txtRG.setText(texto + ".");
		        }

		        if (texto.length() == 10) {
		            txtRG.setText(texto + "-");
		        }
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
		            String texto = txtRG.getText();
		            if (texto.length() > 0) {
		                if (texto.endsWith(".") || texto.endsWith("-")) {
		                    txtRG.setText(texto.substring(0, texto.length() - 1));
		                }
		            }
		        }
		    }
		});
		txtRG.setColumns(10);
		txtRG.setBounds(47, 176, 265, 27);
		panel.add(txtRG);
		
		lblMotivoMenu = new JLabel("Motivo");
		lblMotivoMenu.setForeground(new Color(255, 255, 255));
		lblMotivoMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMotivoMenu.setBounds(47, 288, 111, 27);
		panel.add(lblMotivoMenu);
		
		txtMotivo = new JTextField();
		txtMotivo.setColumns(10);
		txtMotivo.setBounds(47, 315, 264, 56);
		panel.add(txtMotivo);
		
		lblApartamentoMenu = new JLabel("Apartamento");
		lblApartamentoMenu.setForeground(new Color(255, 255, 255));
		lblApartamentoMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblApartamentoMenu.setBounds(47, 223, 146, 27);
		panel.add(lblApartamentoMenu);
		
		txtApartamento = new JTextField();
		txtApartamento.setColumns(10);
		txtApartamento.setBounds(47, 250, 265, 27);
		panel.add(txtApartamento);
		
		panelImg = new JPanel();
		panelImg.setBounds(336, 73, 250, 250);
		panel.add(panelImg);
		panelImg.setLayout(null);
		
		imgVisitante = new JLabel("");
		imgVisitante.setBounds(0, 0, 250, 250);
		panelImg.add(imgVisitante);
		imgVisitante.setForeground(new Color(255, 255, 255));
		imgVisitante.setBackground(new Color(255, 255, 255));
		imgVisitante.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Perfil.png"));
		
		btnInserirImg = new JButton("INSERIR IMAGEM");
		btnInserirImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ImagemBinario imagemBinario = new ImagemBinario();
				imagemByte = imagemBinario.imagem(idioma);
		
				ImageIcon imagemIcon = imagemBinario.exibirImagem(imagemByte);
				if (imagemIcon != null) {
					imgVisitante.setIcon(imagemIcon);
					imgVisitante.setHorizontalAlignment(JLabel.CENTER);
					imgVisitante.setVerticalAlignment(JLabel.CENTER);
				}
				
			}
		});
		btnInserirImg.setForeground(new Color(64, 128, 128));
		btnInserirImg.setBackground(new Color(255, 255, 255));
		btnInserirImg.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInserirImg.setBounds(336, 331, 250, 40);
		panel.add(btnInserirImg);
		
		btnEntrada = new JButton("ENTRADA");
		btnEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!txtNome.getText().isEmpty() && !txtRG.getText().isEmpty() && !txtApartamento.getText().isEmpty() && !txtMotivo.getText().isEmpty()) {
					LocalDateTime hoje = LocalDateTime.now();
				    DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
				    String dataHora = hoje.format(formatoDataHora);
					DAO dao = new DAO();
					
					try {
					    dao.cadastrarVisita(new Visita(null, txtNome.getText(), txtRG.getText(),
					        txtApartamento.getText(), dataHora, " ", txtMotivo.getText(),"0 min"),imagemByte, idioma);
					} catch (Exception x) {
					    JOptionPane.showMessageDialog(null, idiomas.getMenuMenssageErroCAD(idioma) + x.getMessage());
					}
						
					txtNome.setText("");
					txtRG.setText("");
					txtApartamento.setText("");
					txtMotivo.setText("");
					imgVisitante.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Perfil.png"));
				}
				else {
					JOptionPane.showMessageDialog(null, idiomas.getMenssageCampos(idioma), "", JOptionPane.WARNING_MESSAGE);
				}
				

			}
		});
		btnEntrada.setBackground(new Color(0, 255, 0));
		btnEntrada.setForeground(new Color(255, 255, 255));
		btnEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrada.setBounds(47, 387, 146, 41);
		panel.add(btnEntrada);
		
		btnLimparMenu = new JButton("LIMPAR");
		btnLimparMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtRG.setText("");
				txtApartamento.setText("");
				txtMotivo.setText("");
				imgVisitante.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Perfil.png"));
			}
		});
		btnLimparMenu.setBackground(new Color(255, 255, 255));
		btnLimparMenu.setForeground(new Color(64, 128, 128));
		btnLimparMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimparMenu.setBounds(214, 387, 146, 41);
		panel.add(btnLimparMenu);
		
		btnBaixaMenu = new JButton("DAR BAIXA");
		btnBaixaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				JBaixas jBaixas = new JBaixas(idioma);
				jBaixas.setLocationRelativeTo(jBaixas);
				jBaixas.setVisible(true);
				
			}
		});
		btnBaixaMenu.setBackground(new Color(255, 128, 128));
		btnBaixaMenu.setForeground(new Color(255, 255, 255));
		btnBaixaMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBaixaMenu.setBounds(370, 387, 216, 41);
		panel.add(btnBaixaMenu);
		
		JLabel imgAjuda = new JLabel("");
		imgAjuda.setBounds(47, 448, 32, 32);
		panel.add(imgAjuda);
		imgAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajuda = new Ajuda(contentPane, panel, "JMenu_Ajuda", idioma, 10);
				ajuda.iniciar();
			}
		});
		imgAjuda.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\ajuda.png"));
		imgAjuda.setToolTipText("");
		imgAjuda.setForeground(Color.WHITE);
		imgAjuda.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblAjuda = new JLabel("Ajuda");
		lblAjuda.setBounds(81, 452, 57, 32);
		panel.add(lblAjuda);
		lblAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajuda = new Ajuda(contentPane, panel, "JMenu_Ajuda", idioma, 10);
				ajuda.iniciar();
	
			}
		});
		lblAjuda.setToolTipText("");
		lblAjuda.setForeground(Color.WHITE);
		lblAjuda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		imgEspanha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha_select.png"));
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
				imgEUA.setBounds(512, 452, 32, 32);
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
	
				tradutor.TMenu(lblTitulo, lblNomeMenu, lblRgMenu, 
						lblApartamentoMenu, lblMotivoMenu, lblAjuda, 
						btnEntrada, btnLimparMenu, btnBaixaMenu, 
						btnInserirImg, 2);
				idioma = 2;
			}
		});
		imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
		imgEspanha.setBounds(554, 448, 32, 32);
		panel.add(imgEspanha);
		
		imgEUA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua_select.png"));
				imgEUA.setBounds(512, 447, 32, 32);
				
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
				
				tradutor.TMenu(lblTitulo, lblNomeMenu, lblRgMenu, 
						lblApartamentoMenu, lblMotivoMenu, lblAjuda, 
						btnEntrada, btnLimparMenu, btnBaixaMenu, 
						btnInserirImg, 1);
				idioma = 1;
			}
		});
		imgEUA.setHorizontalAlignment(SwingConstants.CENTER);
		imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
		imgEUA.setBounds(512, 452, 32, 32);
		panel.add(imgEUA);
		
		imgBrasil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil_select.png"));
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
				imgEUA.setBounds(512, 452, 32, 32);
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
			
				tradutor.TMenu(lblTitulo, lblNomeMenu, lblRgMenu, 
						lblApartamentoMenu, lblMotivoMenu, lblAjuda, 
						btnEntrada, btnLimparMenu, btnBaixaMenu, 
						btnInserirImg, 0);
				idioma = 0;
			}
		});
		imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
		imgBrasil.setBounds(471, 448, 32, 32);
		panel.add(imgBrasil);
		
		
		tradutor.TMenu(lblTitulo, lblNomeMenu, lblRgMenu, 
				lblApartamentoMenu, lblMotivoMenu, lblAjuda, 
				btnEntrada, btnLimparMenu, btnBaixaMenu, 
				btnInserirImg, idioma);
		
		switch (idioma) {
		case 0: 
			imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil_select.png"));
			break;
		case 1:
			imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua_select.png"));
			imgEUA.setBounds(512, 447, 32, 32);
			break;
		case 2:
			imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha_select.png"));
			break;
		default:
			imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil_select.png"));
		}
		
		
		try {
			DAO dao = new DAO();
			ArrayList<Visita> visitas = null;
			visitas = dao.listarVisita(idioma);
			monitoramento.atualizarPermanencia(visitas, idioma);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, idiomas.getMenuMenssageErroLIST(idioma), "", JOptionPane.WARNING_MESSAGE);
			e1.printStackTrace();
		}
		
		
	}
	
}
