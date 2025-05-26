package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Criptografia;
import controller.Tradutor;
import dao.DAO;
import model.Idiomas;
import model.Usuario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passSenha;
	
	private Tradutor tradutor = new Tradutor();
	private Idiomas idiomas = new Idiomas();
	
	private JLabel imgBrasil = new JLabel("");
	private JLabel imgEUA = new JLabel("");
	private JLabel imgEspanha = new JLabel("");
	private int idioma = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
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
	public JLogin() {
		setTitle("ICyan - Sistemas");
		setBackground(new Color(64, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 434, 494);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imgLogo = new JLabel("");
		imgLogo.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\logo.png"));
		imgLogo.setBounds(120, 11, 200, 179);
		panel.add(imgLogo);
		
		JLabel lblUsuario = new JLabel("USUÁRIO");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(56, 227, 108, 14);
		panel.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(56, 302, 108, 14);
		panel.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int codigoAscii = (int) e.getKeyChar();

		        if ((codigoAscii == KeyEvent.VK_SPACE) &&
		                codigoAscii != KeyEvent.VK_BACK_SPACE &&
		                codigoAscii != KeyEvent.VK_DELETE) {
		            e.consume();
		            return;
		        }
			}
		});
		txtUsuario.setBounds(56, 252, 325, 32);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passSenha = new JPasswordField();
		passSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int codigoAscii = (int) e.getKeyChar();

		        if ((codigoAscii == KeyEvent.VK_SPACE) &&
		                codigoAscii != KeyEvent.VK_BACK_SPACE &&
		                codigoAscii != KeyEvent.VK_DELETE) {
		            e.consume();
		            return;
		        }
			}
		});
		passSenha.setBounds(56, 327, 325, 32);
		panel.add(passSenha);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("deprecation")
				Criptografia criptografia = new Criptografia(passSenha.getText(), Criptografia.SHA256);
				
				if (txtUsuario.getText() != null &&
						!txtUsuario.getText().isEmpty() &&
						passSenha.getPassword() != null &&
						passSenha.getPassword().length > 0) {
			
					DAO dao = new DAO();
					try {
						Usuario usuario = dao.validarUsuario(txtUsuario.getText(),criptografia.criptografar(),idioma);
							
						JOptionPane.showMessageDialog(JLogin.this, idiomas.getLoginMenssageRS(idioma));
						
						if(usuario.getPermissao().equals("1")) {
							
							dispose(); //Fecha o frame atual
							JMenu jMenu = new JMenu(idioma);
							jMenu.setLocationRelativeTo(jMenu);
							jMenu.setVisible(true);
							
						} else if (usuario.getPermissao().equals("2")) {
							
							dispose(); //Fecha o frame atual
							JAdministrador jAdministrador = new JAdministrador(idioma);
							jAdministrador.setLocationRelativeTo(jAdministrador);
							jAdministrador.setVisible(true);
			
						}
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
						txtUsuario.setText("");
						passSenha.setText("");

					}
					
					
					
				} else {
					JOptionPane.showMessageDialog(JLogin.this, idiomas.getLoginMenssageCampos(idioma), "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setForeground(new Color(64, 128, 128));
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.setBounds(165, 395, 108, 37);
		panel.add(btnEntrar);
		
		imgEspanha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha_select.png"));
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
				imgEUA.setBounds(349, 464, 32, 32);
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
	
				tradutor.TLogin(lblUsuario, lblSenha, btnEntrar, 2);
				idioma = 2;
			}
		});
		imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
		imgEspanha.setBounds(392, 460, 32, 32);
		panel.add(imgEspanha);
		
		imgEUA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua_select.png"));
				imgEUA.setBounds(349, 459, 32, 32);
				
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
				
				tradutor.TLogin(lblUsuario, lblSenha, btnEntrar, 1);
				idioma = 1;
			}
		});
		imgEUA.setHorizontalAlignment(SwingConstants.CENTER);
		imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
		imgEUA.setBounds(349, 464, 32, 32);
		panel.add(imgEUA);
		
		imgBrasil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil_select.png"));
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
				imgEUA.setBounds(349, 464, 32, 32);
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
			
				tradutor.TLogin(lblUsuario, lblSenha, btnEntrar, 0);
				idioma = 0;
			}
		});
		imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
		imgBrasil.setBounds(307, 460, 32, 32);
		panel.add(imgBrasil);

		imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil_select.png"));
		
		imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
		imgEUA.setBounds(349, 464, 32, 32);
		imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
	
		tradutor.TLogin(lblUsuario, lblSenha, btnEntrar, 0);
			
		
	}
}
