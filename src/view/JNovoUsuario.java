package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Criptografia;
import controller.Tradutor;
import dao.DAO;
import model.Idiomas;
import model.Usuario;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JNovoUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNovoUsuario;
	private JPasswordField passSenhaUsuario;
	private JPasswordField passRepetirSenhaUsuario;
	
	private ButtonGroup group = new ButtonGroup();
	
	private JRadioButton rdBtnUsuario = new JRadioButton("1 - Usuário");
	private JRadioButton rdBtnAdmin = new JRadioButton("2 - Administrador");
	
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
					JNovoUsuario frame = new JNovoUsuario(null, 0);
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
	public JNovoUsuario(JAdministrador jAdministrador, int i) {
		this.setResizable(false);
		setTitle("ICyan - Sistemas");
		
		idioma = i;
		
		group.add(rdBtnUsuario);
		group.add(rdBtnAdmin);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 350, 593);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\logo.png"));
		lblNewLabel.setBounds(74, 37, 200, 179);
		panel.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("USUÁRIO");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(10, 227, 117, 14);
		panel.add(lblUsuario);
		
		txtNovoUsuario = new JTextField();
		txtNovoUsuario.addKeyListener(new KeyAdapter() {
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
		txtNovoUsuario.setColumns(10);
		txtNovoUsuario.setBounds(10, 252, 325, 32);
		panel.add(txtNovoUsuario);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(10, 302, 140, 14);
		panel.add(lblSenha);
		
		passSenhaUsuario = new JPasswordField();
		passSenhaUsuario.addKeyListener(new KeyAdapter() {
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
		passSenhaUsuario.setBounds(10, 327, 325, 32);
		panel.add(passSenhaUsuario);
		
		JButton btnSalvarUsuarioS = new JButton("SALVAR");
		btnSalvarUsuarioS.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if (!txtNovoUsuario.getText().isEmpty() && !passSenhaUsuario.getText().isEmpty() && !passRepetirSenhaUsuario.getText().isEmpty() &&
				(rdBtnAdmin.isSelected() || rdBtnUsuario.isSelected())) {
					
					if (passSenhaUsuario.getPassword().length >= 8) {
						
						if (passSenhaUsuario.getText().equals(passRepetirSenhaUsuario.getText())) {
							
							DAO dao = new DAO();
							Criptografia criptografia = new Criptografia(passSenhaUsuario.getText(), Criptografia.MD5);
							Usuario usuario = new Usuario(null, txtNovoUsuario.getText(), criptografia.criptografar(), selecaoPermissao());
							
							try {
							    dao.cadastrarUsuario(usuario, idioma);
							} catch (Exception x) {
							    System.out.println(x.getMessage());
							}
							abrirTelaPrincipal(jAdministrador);
						}
						else {
							JOptionPane.showMessageDialog(null, idiomas.getMenssageSenhaIgual(idioma), "", JOptionPane.WARNING_MESSAGE);
						}
							
					} else {
						JOptionPane.showMessageDialog(null, idiomas.getMenssageSenha8caracters(idioma), "", JOptionPane.WARNING_MESSAGE);
					}
			
				}
				else {
					JOptionPane.showMessageDialog(null, idiomas.getMenssageCampos(idioma), "", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnSalvarUsuarioS.setForeground(new Color(64, 128, 128));
		btnSalvarUsuarioS.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvarUsuarioS.setBackground(new Color(0, 255, 0));
		btnSalvarUsuarioS.setBounds(112, 529, 108, 37);
		panel.add(btnSalvarUsuarioS);
		
		JLabel lblRepetirSenha = new JLabel("REPETIR SENHA");
		lblRepetirSenha.setForeground(Color.WHITE);
		lblRepetirSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRepetirSenha.setBounds(10, 381, 264, 14);
		panel.add(lblRepetirSenha);
		
		passRepetirSenhaUsuario = new JPasswordField();
		passRepetirSenhaUsuario.addKeyListener(new KeyAdapter() {
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
		passRepetirSenhaUsuario.setBounds(10, 406, 325, 32);
		panel.add(passRepetirSenhaUsuario);
		
		JLabel lblPermissao = new JLabel("PERMISSAO");
		lblPermissao.setForeground(Color.WHITE);
		lblPermissao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPermissao.setBounds(10, 459, 210, 14);
		panel.add(lblPermissao);
		rdBtnUsuario.setForeground(new Color(255, 255, 255));
		rdBtnUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnUsuario.setBackground(new Color(64, 128, 128));
		
		rdBtnUsuario.setBounds(6, 488, 109, 23);
		panel.add(rdBtnUsuario);
		rdBtnAdmin.setForeground(new Color(255, 255, 255));
		rdBtnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnAdmin.setBackground(new Color(64, 128, 128));
		
		rdBtnAdmin.setBounds(147, 488, 162, 23);
		panel.add(rdBtnAdmin);
		
		
			
		tradutor.TNovoUsuario(lblUsuario, lblSenha, lblRepetirSenha, lblPermissao,
			 rdBtnUsuario, rdBtnAdmin,
			 btnSalvarUsuarioS, idioma);
	
		
		
	}
	
	private void abrirTelaPrincipal(JAdministrador jAdministrador) {
		jAdministrador.dispose();
		dispose();
		jAdministrador = new JAdministrador(idioma);
		jAdministrador.setLocationRelativeTo(jAdministrador);
		jAdministrador.setVisible(true);
	}
	
	private String selecaoPermissao() {
		if (rdBtnAdmin.isSelected()) {
			return "2";
		} else if (rdBtnUsuario.isSelected()) {
			return "1";
		}
		else {
			return null;
		}
	}
}
