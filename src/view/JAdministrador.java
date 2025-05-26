package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import controller.Tradutor;
import dao.DAO;
import model.Ajuda;
import model.Idiomas;
import model.ModeloTabelaUsuario;
import model.Usuario;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<Usuario> usuarios;
	private TableRowSorter<ModeloTabelaUsuario> rowSorter;
	private JTextField txtBuscaAdmin;
	private JTextField txtUsuarioAdmin;
	private JTextField txtPermissaoAdmin;
	private Usuario usuarioSelecionada;
	private JAdministrador jAdministrador;
	
	private JScrollPane scrollPane = new JScrollPane();
	private DAO dao = new DAO();
	
	private Ajuda ajuda = new Ajuda();
	
	private Idiomas idiomas = new Idiomas();
	private Tradutor tradutor = new Tradutor();
	
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
					JAdministrador frame = new JAdministrador(0);
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
	public JAdministrador(int i) {
		this.setResizable(false);
		setTitle("ICyan - Sistemas");
		
		idioma = i;
		
		this.jAdministrador = this;
		
		try {
			usuarios = dao.listarUsuario(idioma);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 651);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 11, 564, 601);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ajuda = new Ajuda(contentPane, panel, "JAdministrador_Ajuda",idioma, 4);
		
		JLabel lblTitulo = new JLabel("ADMINISTRADOR");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setBounds(176, 11, 201, 44);
		panel.add(lblTitulo);
		
		scrollPane.setBounds(23, 105, 520, 292);
		panel.add(scrollPane);
		
		setarTabela();
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNome.setBounds(22, 47, 78, 14);
		panel.add(lblNome);
		
		txtBuscaAdmin = new JTextField();
		txtBuscaAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				filtrar();
			}
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
		txtBuscaAdmin.setColumns(10);
		txtBuscaAdmin.setBounds(22, 64, 521, 30);
		panel.add(txtBuscaAdmin);
		
		JLabel lblAreaBusca = new JLabel("ÁREA DE BUSCA");
		lblAreaBusca.setForeground(Color.WHITE);
		lblAreaBusca.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblAreaBusca.setBounds(406, 47, 137, 14);
		panel.add(lblAreaBusca);
		
		JLabel lblUsuario = new JLabel("USUÁRIO");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(22, 408, 78, 14);
		panel.add(lblUsuario);
		
		txtUsuarioAdmin = new JTextField();
		txtUsuarioAdmin.setForeground(new Color(255, 255, 255));
		txtUsuarioAdmin.setBackground(new Color(128, 128, 128));
		txtUsuarioAdmin.setEditable(false);
		txtUsuarioAdmin.setColumns(10);
		txtUsuarioAdmin.setBounds(22, 429, 256, 30);
		panel.add(txtUsuarioAdmin);
		
		JLabel lblNivelPermissao = new JLabel("NIVEL DE PERMISSÃO");
		lblNivelPermissao.setForeground(Color.WHITE);
		lblNivelPermissao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNivelPermissao.setBounds(310, 408, 219, 14);
		panel.add(lblNivelPermissao);
		
		txtPermissaoAdmin = new JTextField();
		txtPermissaoAdmin.setForeground(new Color(255, 255, 255));
		txtPermissaoAdmin.setBackground(new Color(128, 128, 128));
		txtPermissaoAdmin.setEditable(false);
		txtPermissaoAdmin.setColumns(10);
		txtPermissaoAdmin.setBounds(310, 429, 233, 30);
		panel.add(txtPermissaoAdmin);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtUsuarioAdmin.getText().isEmpty() && txtPermissaoAdmin.getText().isEmpty()  ) {
					JOptionPane.showMessageDialog(null, idiomas.getAdmMenssageSUU(idioma), "Aviso", JOptionPane.WARNING_MESSAGE);
				} else {
					dao.deletarUsuario(usuarioSelecionada.getId(), idioma);
					dispose();
					jAdministrador = new JAdministrador(i);
					jAdministrador.setLocationRelativeTo(jAdministrador);
					jAdministrador.setVisible(true);
				}
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBackground(new Color(255, 128, 128));
		btnExcluir.setBounds(23, 490, 187, 41);
		panel.add(btnExcluir);
		
		JButton btnNovo = new JButton("NOVO");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JNovoUsuario jNovoUsuario = new JNovoUsuario(jAdministrador, idioma);
				jNovoUsuario.setLocationRelativeTo(jNovoUsuario);
				jNovoUsuario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				jNovoUsuario.setVisible(true);

			}
		});
		btnNovo.setForeground(new Color(64, 128, 128));
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNovo.setBackground(new Color(0, 255, 0));
		btnNovo.setBounds(366, 490, 176, 41);
		panel.add(btnNovo);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtUsuarioAdmin.getText().isEmpty() && txtPermissaoAdmin.getText().isEmpty()  ) {
					JOptionPane.showMessageDialog(null, idiomas.getAdmMenssageSUU(idioma), "Aviso", JOptionPane.WARNING_MESSAGE);
				} else {
					JEditarUsuario jEditarUsuario = new JEditarUsuario(usuarioSelecionada,jAdministrador, idioma);
					jEditarUsuario.setLocationRelativeTo(jEditarUsuario);
					jEditarUsuario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					jEditarUsuario.setVisible(true);
				}
			}
		});
		btnEditar.setForeground(new Color(64, 128, 128));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar.setBackground(new Color(255, 255, 0));
		btnEditar.setBounds(231, 490, 115, 41);
		panel.add(btnEditar);
		
		JLabel lblAjuda = new JLabel("Ajuda");
		lblAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajuda = new Ajuda(contentPane, panel, "JAdministrador_Ajuda",idioma, 4);
				ajuda.iniciar();
			}
		});
		lblAjuda.setToolTipText("");
		lblAjuda.setForeground(Color.WHITE);
		lblAjuda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAjuda.setBounds(57, 558, 59, 32);
		panel.add(lblAjuda);
		
		JLabel imgAjuda = new JLabel("");
		imgAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajuda = new Ajuda(contentPane, panel, "JAdministrador_Ajuda",idioma, 4);
				ajuda.iniciar();
			}
		});
		imgAjuda.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\ajuda.png"));
		imgAjuda.setToolTipText("");
		imgAjuda.setForeground(Color.WHITE);
		imgAjuda.setFont(new Font("Tahoma", Font.BOLD, 16));
		imgAjuda.setBounds(23, 554, 32, 32);
		panel.add(imgAjuda);
		
		imgEspanha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha_select.png"));
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
				imgEUA.setBounds(469, 563, 32, 32);
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
	
				tradutor.TAdministrador(lblTitulo, lblNome, lblAreaBusca, 
					    lblUsuario, lblNivelPermissao, lblAjuda, 
					    btnExcluir, btnEditar, btnNovo, 2);
				
				idioma = 2;
				setarTabela();
			}
		});
		imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
		imgEspanha.setBounds(511, 558, 32, 32);
		panel.add(imgEspanha);
		
		imgEUA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua_select.png"));
				imgEUA.setBounds(469, 558, 32, 32);
				
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
				
				tradutor.TAdministrador(lblTitulo, lblNome, lblAreaBusca, 
					    lblUsuario, lblNivelPermissao, lblAjuda, 
					    btnExcluir, btnEditar, btnNovo, 1);
				
				idioma = 1;
				setarTabela();
			}
		});
		imgEUA.setHorizontalAlignment(SwingConstants.CENTER);
		imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
		imgEUA.setBounds(469, 563, 32, 32);
		panel.add(imgEUA);

		imgBrasil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil_select.png"));
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
				imgEUA.setBounds(469, 563, 32, 32);
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
			
				tradutor.TAdministrador(lblTitulo, lblNome, lblAreaBusca, 
					    lblUsuario, lblNivelPermissao, lblAjuda, 
					    btnExcluir, btnEditar, btnNovo, 0);
				idioma = 0;
				setarTabela();

			}
		});
		imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
		imgBrasil.setBounds(427, 558, 32, 32);
		panel.add(imgBrasil);
		
		tradutor.TAdministrador(lblTitulo, lblNome, lblAreaBusca, 
			    lblUsuario, lblNivelPermissao, lblAjuda, 
			    btnExcluir, btnEditar, btnNovo, idioma);
		
		switch (idioma) {
		case 0: 
			imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil_select.png"));
			break;
		case 1:
			imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua_select.png"));
			imgEUA.setBounds(469, 558, 32, 32);
			break;
		case 2:
			imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha_select.png"));
			break;
		default:
			imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil_select.png"));
		}
				
	
	}
	
	private void preencherCampos(Usuario usuarioSelecionada) {
		txtUsuarioAdmin.setText(usuarioSelecionada.getUsuario());
		txtPermissaoAdmin.setText(usuarioSelecionada.getPermissao());
	}
	
	
	private void filtrar() {
	String busca = txtBuscaAdmin.getText().trim();
	
		if(busca.length()==0) {
			rowSorter.setRowFilter(null);
		}
		else {
			rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+busca));
		}
		
	}
	
	private void setarTabela() {
		ModeloTabelaUsuario modeloTabelaUsuario = new ModeloTabelaUsuario(usuarios, idioma);
		table = new JTable();
		table.setModel(modeloTabelaUsuario);
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setMinWidth(0);
		columnModel.getColumn(0).setMaxWidth(0);
		columnModel.getColumn(0).setWidth(0);
		
		table.getTableHeader().setReorderingAllowed(false);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) { // 1 - botão esquerdo ; 2 - scroll ; 3 - botão direito
					try {
						usuarioSelecionada = dao.consultarUsuario(modeloTabelaUsuario.getValueAt(table.getSelectedRow(),0).toString(), idioma);
						if (usuarioSelecionada != null) {
							preencherCampos(usuarioSelecionada);
						}
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		rowSorter = new TableRowSorter<>(modeloTabelaUsuario);
		table.setRowSorter(rowSorter);
		scrollPane.setViewportView(table);
	}
}
