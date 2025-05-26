package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import controller.Tradutor;
import dao.DAO;
import model.Ajuda;
import model.Idiomas;
import model.ModeloTabela;
import model.Visita;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class JBaixas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeBaixas;
	private JTextField txtDataHoraEntradaBaixas;
	private JTable table;
	private ArrayList<Visita> visitas;
	private Visita visitaSelecionada;
	private JBaixas jBaixas;
	private JTextField txtBuscaEditar;
	private JLabel lblAreaBusca;
	private TableRowSorter<ModeloTabela> rowSorter;
	
	private JScrollPane scrollPane = new JScrollPane();
	private DAO dao = new DAO();
	
	private Idiomas idiomas = new Idiomas();
	private Ajuda ajuda = new Ajuda();
	
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
					JBaixas frame = new JBaixas(0);
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
	public JBaixas(int i) {
		this.setResizable(false);
		setTitle("ICyan - Sistemas");
		idioma = i;
		
		this.jBaixas = this;
		
		try {
			visitas = dao.listarVisita(idioma);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 585);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 736, 546);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ajuda = new Ajuda(contentPane, panel, "JBaixas_Ajuda", idioma, 3);
		
		txtNomeBaixas = new JTextField();
		txtNomeBaixas.setBackground(new Color(128, 128, 128));
		txtNomeBaixas.setEditable(false);
		txtNomeBaixas.setBounds(10, 362, 309, 30);
		panel.add(txtNomeBaixas);
		txtNomeBaixas.setColumns(10);
		
		JLabel lblNomeSelecao = new JLabel("NOME");
		lblNomeSelecao.setForeground(Color.WHITE);
		lblNomeSelecao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeSelecao.setBounds(10, 337, 78, 14);
		panel.add(lblNomeSelecao);
		
		JLabel lblDataHoraEntrada = new JLabel("DATA E HORA DE ENTRADA");
		lblDataHoraEntrada.setForeground(Color.WHITE);
		lblDataHoraEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDataHoraEntrada.setBounds(491, 337, 219, 14);
		panel.add(lblDataHoraEntrada);
		
		txtDataHoraEntradaBaixas = new JTextField();
		txtDataHoraEntradaBaixas.setBackground(new Color(128, 128, 128));
		txtDataHoraEntradaBaixas.setEditable(false);
		txtDataHoraEntradaBaixas.setColumns(10);
		txtDataHoraEntradaBaixas.setBounds(414, 362, 309, 30);
		panel.add(txtDataHoraEntradaBaixas);
		
		JButton btnBaixaBaixas = new JButton("DAR BAIXA");
		btnBaixaBaixas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNomeBaixas.getText().isEmpty() && txtDataHoraEntradaBaixas.getText().isEmpty()  ) {
					JOptionPane.showMessageDialog(JBaixas.this, idiomas.getBaixasMenssageSUV(idioma), "Aviso", JOptionPane.WARNING_MESSAGE);
				} else {
					LocalDateTime hoje = LocalDateTime.now();
				    DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
				    String dataHora = hoje.format(formatoDataHora);
					
				    try {
				    	Visita visita = new Visita(null, visitaSelecionada.getNome(), visitaSelecionada.getRg(), visitaSelecionada.getApartamento(),
								visitaSelecionada.getDataHoraEntrada(),dataHora,visitaSelecionada.getMotivo(),null);
						dao.alterarVisita(visitaSelecionada.getId(), visita, idioma);
					} catch (Exception x) {
					    JOptionPane.showMessageDialog(null, idiomas.getBaixasMenssageERRO(idioma));
					}
					
					dispose();
					jBaixas = new JBaixas(idioma);
					jBaixas.setLocationRelativeTo(jBaixas);
					jBaixas.setVisible(true);
				}
				
			}
		});
		btnBaixaBaixas.setForeground(Color.WHITE);
		btnBaixaBaixas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBaixaBaixas.setBackground(new Color(255, 128, 128));
		btnBaixaBaixas.setBounds(268, 416, 198, 41);
		panel.add(btnBaixaBaixas);
		
		JButton btnEditarBaixas = new JButton("EDITAR");
		btnEditarBaixas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtNomeBaixas.getText().isEmpty() && txtDataHoraEntradaBaixas.getText().isEmpty()  ) {
					JOptionPane.showMessageDialog(JBaixas.this, idiomas.getBaixasMenssageSUV(idioma), "Aviso", JOptionPane.WARNING_MESSAGE);
				} else {
					JEditar jEditar = new JEditar(visitaSelecionada,jBaixas, idioma);
					jEditar.setLocationRelativeTo(jEditar);
					jEditar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					jEditar.setVisible(true);
				}
				
			}
		});
		btnEditarBaixas.setForeground(new Color(64, 128, 128));
		btnEditarBaixas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditarBaixas.setBackground(new Color(0, 255, 0));
		btnEditarBaixas.setBounds(11, 416, 177, 41);
		panel.add(btnEditarBaixas);
		
		JButton btnVoltarBaixas = new JButton("VOLTAR");
		btnVoltarBaixas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				dispose(); 
				JMenu jMenu = new JMenu(idioma);
				jMenu.setLocationRelativeTo(jMenu);
				jMenu.setVisible(true);
				
			}
		});
		btnVoltarBaixas.setForeground(new Color(64, 128, 128));
		btnVoltarBaixas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltarBaixas.setBackground(new Color(255, 255, 128));
		btnVoltarBaixas.setBounds(546, 416, 176, 41);
		panel.add(btnVoltarBaixas);
		
		scrollPane.setBounds(10, 83, 713, 246);
		panel.add(scrollPane);
		
		setarTabela();
		
		txtBuscaEditar = new JTextField();
		txtBuscaEditar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				filtrar();
			}
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
		txtBuscaEditar.setColumns(10);
		txtBuscaEditar.setBounds(10, 42, 712, 30);
		panel.add(txtBuscaEditar);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNome.setBounds(10, 25, 78, 14);
		panel.add(lblNome);
		
		lblAreaBusca = new JLabel("ÁREA DE BUSCA");
		lblAreaBusca.setForeground(Color.WHITE);
		lblAreaBusca.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblAreaBusca.setBounds(583, 21, 140, 14);
		panel.add(lblAreaBusca);
		
		JLabel imgAjuda = new JLabel("");
		imgAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajuda = new Ajuda(contentPane, panel, "JBaixas_Ajuda", idioma, 3);
				ajuda.iniciar();
			}
		});
		imgAjuda.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\ajuda.png"));
		imgAjuda.setToolTipText("");
		imgAjuda.setForeground(Color.WHITE);
		imgAjuda.setFont(new Font("Tahoma", Font.BOLD, 16));
		imgAjuda.setBounds(10, 489, 32, 32);
		panel.add(imgAjuda);
		
		JLabel lblAjuda = new JLabel("Ajuda");
		lblAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajuda = new Ajuda(contentPane, panel, "JBaixas_Ajuda", idioma, 3);
				ajuda.iniciar();
			}
		});

		lblAjuda.setToolTipText("");
		lblAjuda.setForeground(Color.WHITE);
		lblAjuda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAjuda.setBounds(44, 493, 57, 32);
		panel.add(lblAjuda);
		
		imgEspanha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha_select.png"));
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
				imgEUA.setBounds(636, 492, 32, 32);
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
	
				tradutor.TBaixas(lblNome, lblAreaBusca, 
						lblNomeSelecao, lblDataHoraEntrada, lblAjuda, 
					    btnBaixaBaixas, btnEditarBaixas, btnVoltarBaixas, 2);
				idioma = 2;
				setarTabela();
			}
		});
		imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
		imgEspanha.setBounds(691, 489, 32, 32);
		panel.add(imgEspanha);
		
		imgEUA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua_select.png"));
				imgEUA.setBounds(636, 487, 32, 32);
				
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
				
				tradutor.TBaixas(lblNome, lblAreaBusca, 
						lblNomeSelecao, lblDataHoraEntrada, lblAjuda, 
					    btnBaixaBaixas, btnEditarBaixas, btnVoltarBaixas, 1);
				idioma = 1;
				setarTabela();
			}
		});
		imgEUA.setHorizontalAlignment(SwingConstants.CENTER);
		imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
		imgEUA.setBounds(636, 492, 32, 32);
		panel.add(imgEUA);
		
		imgBrasil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil_select.png"));
				
				imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua.png"));
				imgEUA.setBounds(636, 492, 32, 32);
				imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha.png"));
			
				tradutor.TBaixas(lblNome, lblAreaBusca, 
						lblNomeSelecao, lblDataHoraEntrada, lblAjuda, 
					    btnBaixaBaixas, btnEditarBaixas, btnVoltarBaixas, 0);
				idioma = 0;
				setarTabela();
			}
		});
		imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil.png"));
		imgBrasil.setBounds(583, 489, 32, 32);
		panel.add(imgBrasil);
		
		
		tradutor.TBaixas(lblNome, lblAreaBusca, 
				lblNomeSelecao, lblDataHoraEntrada, lblAjuda, 
				btnBaixaBaixas, btnEditarBaixas, btnVoltarBaixas, idioma);
		
		switch (idioma) {
		case 0: 
			imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil_select.png"));
			break;
		case 1:
			imgEUA.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\eua_select.png"));
			imgEUA.setBounds(636, 487, 32, 32);
			break;
		case 2:
			imgEspanha.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\espanha_select.png"));
			break;
		default:
			imgBrasil.setIcon(new ImageIcon("C:\\Users\\lucas.caetano\\eclipse-workspace\\Vigilancia\\icons\\Idiomas\\brasil_select.png"));
		}
		
	}
	
	private void preencherCampos(Visita visitaSelecionada) {
		txtNomeBaixas.setText(visitaSelecionada.getNome());
		txtDataHoraEntradaBaixas.setText(visitaSelecionada.getDataHoraEntrada());
	}
	
	private void filtrar() {
		String busca = txtBuscaEditar.getText().trim();
		
		if(busca.length()==0) {
			rowSorter.setRowFilter(null);
		}
		else {
			rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+busca));
		}
		
	}
	
	private void setarTabela() {
		ModeloTabela modeloTabela = new ModeloTabela(visitas, idioma);
		table = new JTable();
		table.setModel(modeloTabela);
		
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
						visitaSelecionada = dao.consultarVisita(modeloTabela.getValueAt(table.getSelectedRow(),0).toString(), idioma);
						if (visitaSelecionada != null) {
							preencherCampos(visitaSelecionada);
						}
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		rowSorter = new TableRowSorter<>(modeloTabela);
		table.setRowSorter(rowSorter);
		scrollPane.setViewportView(table);
	}
}
