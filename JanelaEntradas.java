package visao;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.Gerador;
import model.Tempo;
import model.Tempo.UnidadeTempo;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class JanelaEntradas {

	public JFrame frame;
	private JTextField txtDado1TServ1;
	private JTextField txtDado2TServ1;
	private JTextField txtDado3TServ1;
	private JTextField txtDado1Chegada1;
	private JTextField txtDado2Chegada1;
	private JTextField txtDado3Chegada1;
	private JTextField txtDado1EmFalhaServ1;
	private JTextField txtDado2EmFalhaServ1;
	private JTextField txtDado3EmFalhaServ1;
	private JTextField txtDado1FalhasServ1;
	private JTextField txtDado2FalhasServ1;
	private JTextField txtDado3FalhasServ1;
	private JTextField txtDado1TServ2;
	private JTextField txtDado2TServ2;
	private JTextField txtDado3TServ2;
	private JTextField txtDado1Chegada2;
	private JTextField txtDado2Chegada2;
	private JTextField txtDado3Chegada2;
	private JTextField txtDado1EmFalhaServ2;
	private JTextField txtDado2EmFalhaServ2;
	private JTextField txtDado3EmFalhaServ2;
	private JTextField txtDado1FalhasServ2;
	private JTextField txtDado2FalhasServ2;
	private JTextField txtDado3FalhasServ2;
	
	private JLabel lblTipo;
	private JLabel lblDistribuioChegada;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbBChegada1;
	private JLabel lblDistribuioTempoDe;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbBTServ1;
	private JLabel lblDadoTServ1;
	private JLabel lblDado2TServ1;
	private JLabel lblDado3TServ1;
	private JLabel lblDado1Chegada1;
	private JLabel lblDado2Chegada1;
	private JLabel lblDado3Chegada1;
	private JLabel lblDistribuioTempoEntre;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbBServ1EntreFalhas;
	private JLabel lblDistribuioTempoEm;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbBServ1EmFalha;
	private JLabel lblDadoTemfalhas;
	private JLabel lblDadoTemfalhas_1;
	private JLabel lblDadoTemfalhas_2;
	private JLabel lblDado1FalhasServ1;
	private JLabel lblDado2FalhasServ1;
	private JLabel lblDado3FalhasServ1;
	private JLabel lblEntidade;
	private JLabel lblServidor;
	private JLabel lblTipo_1;
	private JLabel label_1;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbBChegada2;
	private JLabel lbldistribuiotempoDe;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbBTServ2;
	private JLabel lblDado1TServ2;
	private JLabel lblDado2TServ2;
	private JLabel lblDado3TServ2;
	private JLabel lblDado1Chegada2;
	private JLabel lblDado2Chegada2;
	private JLabel lblDado3Chegada2;
	private JLabel lbldistribuiotempoEntre;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbBServ2EntreFalhas;
	private JLabel lbldistribuiotempoEm;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbBServ2EmFalha;
	private JLabel lblDado1TEmFalhaServ2;
	private JLabel lblDado2TEmFalhaServ2;
	private JLabel lblDado3TEmFalhaServ2;
	private JLabel lblDado1FalhasServ2;
	private JLabel lblDado2FalhasServ2;
	private JLabel lblDado3FalhasServ2;
	private JLabel lblentidade;
	private JLabel lblservidor;
	private JButton btnIniciarSimulao;
	
	public volatile boolean validos;
	private JLabel lblDuraoDaSimulao;
	private JTextField txtDuracao;
	public volatile boolean passoAPasso;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaEntradas window = new JanelaEntradas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaEntradas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		validos = false;
		passoAPasso = false;
		frame = new JFrame();
		frame.setTitle("Entrada Dados Simulação");
		frame.setResizable(false);
		frame.setBounds(100, 0, 600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTipo = new JLabel("Tipo 1");
		lblTipo.setForeground(Color.BLUE);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setBounds(0, 0, 118, 21);
		frame.getContentPane().add(lblTipo);
		
		lblDistribuioChegada = new JLabel("Distribuição Chegada");
		lblDistribuioChegada.setBounds(10, 52, 140, 14);
		frame.getContentPane().add(lblDistribuioChegada);
		
		cmbBChegada1 = new JComboBox();
		cmbBChegada1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch(cmbBChegada1.getSelectedItem().toString()) {
				case "Uniforme":
					lblDado1Chegada1.setVisible(true);
					lblDado1Chegada1.setText("Min");
					txtDado1Chegada1.setEnabled(true);
					
					lblDado2Chegada1.setVisible(true);
					lblDado2Chegada1.setText("Max");
					txtDado2Chegada1.setVisible(true);
					
					lblDado3Chegada1.setVisible(false);
					txtDado3Chegada1.setVisible(false);
					break;
				case "Exponencial":
					lblDado1Chegada1.setVisible(true);
					lblDado1Chegada1.setText("Média");
					txtDado1Chegada1.setEnabled(true);
					
					lblDado2Chegada1.setVisible(false);
					txtDado2Chegada1.setVisible(false);
					
					lblDado3Chegada1.setVisible(false);
					txtDado3Chegada1.setVisible(false);
					break;
				case "Normal":
					lblDado1Chegada1.setVisible(true);
					lblDado1Chegada1.setText("Média");
					txtDado1Chegada1.setEnabled(true);
					
					lblDado2Chegada1.setVisible(true);
					lblDado2Chegada1.setText("Desvio Padrão");
					txtDado2Chegada1.setVisible(true);
					
					lblDado3Chegada1.setVisible(false);
					txtDado3Chegada1.setVisible(false);
					break;
				case "Triangular":
					lblDado1Chegada1.setVisible(true);
					lblDado1Chegada1.setText("A");
					txtDado1Chegada1.setEnabled(true);
					
					lblDado2Chegada1.setVisible(true);
					lblDado2Chegada1.setText("B");
					txtDado2Chegada1.setVisible(true);
					
					lblDado3Chegada1.setVisible(true);
					lblDado3Chegada1.setText("C");
					txtDado3Chegada1.setVisible(true);
					break;
				default:
					lblDado1Chegada1.setVisible(true);
					lblDado1Chegada1.setText("Constante");
					txtDado1Chegada1.setEnabled(true);
					
					lblDado2Chegada1.setVisible(false);
					txtDado2Chegada1.setVisible(false);
					
					lblDado3Chegada1.setVisible(false);
					txtDado3Chegada1.setVisible(false);
					break;
				}
			}
		});
		cmbBChegada1.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Uniforme", "Exponencial", "Normal", "Triangular"}));
		cmbBChegada1.setSelectedIndex(0);
		cmbBChegada1.setBounds(10, 72, 108, 20);
		frame.getContentPane().add(cmbBChegada1);
		
		lblDistribuioTempoDe = new JLabel("<html>Distribuição<br>Tempo de Serviço</html>");
		lblDistribuioTempoDe.setBounds(10, 95, 217, 28);
		frame.getContentPane().add(lblDistribuioTempoDe);
		
		cmbBTServ1 = new JComboBox();
		cmbBTServ1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch(cmbBTServ1.getSelectedItem().toString()) {
				case "Uniforme":
					lblDadoTServ1.setVisible(true);
					lblDadoTServ1.setText("Min");
					txtDado1TServ1.setEnabled(true);
					
					lblDado2TServ1.setVisible(true);
					lblDado2TServ1.setText("Max");
					txtDado2TServ1.setVisible(true);
					
					lblDado3TServ1.setVisible(false);
					txtDado3TServ1.setVisible(false);
					break;
				case "Exponencial":
					lblDadoTServ1.setVisible(true);
					lblDadoTServ1.setText("Média");
					txtDado1TServ1.setEnabled(true);
					
					lblDado2TServ1.setVisible(false);
					txtDado2TServ1.setVisible(false);
					
					lblDado3TServ1.setVisible(false);
					txtDado3TServ1.setVisible(false);
					break;
				case "Normal":
					lblDadoTServ1.setVisible(true);
					lblDadoTServ1.setText("Média");
					txtDado1TServ1.setEnabled(true);
					
					lblDado2TServ1.setVisible(true);
					lblDado2TServ1.setText("Desvio Padrão");
					txtDado2TServ1.setVisible(true);
					
					lblDado3TServ1.setVisible(false);
					txtDado3TServ1.setVisible(false);
					break;
				case "Triangular":
					lblDadoTServ1.setVisible(true);
					lblDadoTServ1.setText("A");
					txtDado1TServ1.setEnabled(true);
					
					lblDado2TServ1.setVisible(true);
					lblDado2TServ1.setText("B");
					txtDado2TServ1.setVisible(true);
					
					lblDado3TServ1.setVisible(true);
					lblDado3TServ1.setText("C");
					txtDado3TServ1.setVisible(true);
					break;
				default:
					lblDadoTServ1.setVisible(true);
					lblDadoTServ1.setText("Constante");
					txtDado1TServ1.setEnabled(true);
					
					lblDado2TServ1.setVisible(false);
					txtDado2TServ1.setVisible(false);
					
					lblDado3TServ1.setVisible(false);
					txtDado3TServ1.setVisible(false);
					break;
				}
			}
		});
		cmbBTServ1.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Uniforme", "Exponencial", "Normal", "Triangular"}));
		cmbBTServ1.setSelectedIndex(0);
		cmbBTServ1.setBounds(10, 128, 108, 20);
		frame.getContentPane().add(cmbBTServ1);
		
		lblDadoTServ1 = new JLabel("Dado1 TServ");
		lblDadoTServ1.setBounds(174, 103, 100, 14);
		frame.getContentPane().add(lblDadoTServ1);
		
		txtDado1TServ1 = new JTextField();
		txtDado1TServ1.setBounds(174, 128, 86, 20);
		frame.getContentPane().add(txtDado1TServ1);
		txtDado1TServ1.setColumns(10);
		
		lblDado2TServ1 = new JLabel("Dado2 TServ");
		lblDado2TServ1.setBounds(274, 103, 94, 14);
		frame.getContentPane().add(lblDado2TServ1);
		
		txtDado2TServ1 = new JTextField();
		txtDado2TServ1.setBounds(270, 128, 86, 20);
		frame.getContentPane().add(txtDado2TServ1);
		txtDado2TServ1.setColumns(10);
		
		lblDado3TServ1 = new JLabel("Dado3 TServ");
		lblDado3TServ1.setBounds(366, 103, 100, 14);
		frame.getContentPane().add(lblDado3TServ1);
		
		txtDado3TServ1 = new JTextField();
		txtDado3TServ1.setBounds(366, 128, 86, 20);
		frame.getContentPane().add(txtDado3TServ1);
		txtDado3TServ1.setColumns(10);
		
		lblDado1Chegada1 = new JLabel("Dado1 Chegada");
		lblDado1Chegada1.setBounds(174, 47, 100, 14);
		frame.getContentPane().add(lblDado1Chegada1);
		
		txtDado1Chegada1 = new JTextField();
		txtDado1Chegada1.setBounds(174, 72, 86, 20);
		frame.getContentPane().add(txtDado1Chegada1);
		txtDado1Chegada1.setColumns(10);
		
		lblDado2Chegada1 = new JLabel("Dado2 Chegada");
		lblDado2Chegada1.setBounds(274, 47, 94, 14);
		frame.getContentPane().add(lblDado2Chegada1);
		
		txtDado2Chegada1 = new JTextField();
		txtDado2Chegada1.setBounds(270, 72, 86, 20);
		frame.getContentPane().add(txtDado2Chegada1);
		txtDado2Chegada1.setColumns(10);
		
		lblDado3Chegada1 = new JLabel("Dado3 Chegada");
		lblDado3Chegada1.setBounds(366, 47, 100, 14);
		frame.getContentPane().add(lblDado3Chegada1);
		
		txtDado3Chegada1 = new JTextField();
		txtDado3Chegada1.setBounds(366, 72, 86, 20);
		frame.getContentPane().add(txtDado3Chegada1);
		txtDado3Chegada1.setColumns(10);
		
		lblDistribuioTempoEntre = new JLabel("<html>Distribuição <br>Tempo Entre Falhas</html>");
		lblDistribuioTempoEntre.setBounds(10, 190, 154, 28);
		frame.getContentPane().add(lblDistribuioTempoEntre);
		
		cmbBServ1EntreFalhas = new JComboBox();
		cmbBServ1EntreFalhas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch(cmbBServ1EntreFalhas.getSelectedItem().toString()) {
				case "Uniforme":
					lblDado1FalhasServ1.setVisible(true);
					lblDado1FalhasServ1.setText("Min");
					txtDado1FalhasServ1.setEnabled(true);
					
					lblDado2FalhasServ1.setVisible(true);
					lblDado2FalhasServ1.setText("Max");
					txtDado2FalhasServ1.setVisible(true);
					
					lblDado3FalhasServ1.setVisible(false);
					txtDado3FalhasServ1.setVisible(false);
					break;
				case "Exponencial":
					lblDado1FalhasServ1.setVisible(true);
					lblDado1FalhasServ1.setText("Média");
					txtDado1FalhasServ1.setEnabled(true);
					
					lblDado2FalhasServ1.setVisible(false);
					txtDado2FalhasServ1.setVisible(false);
					
					lblDado3FalhasServ1.setVisible(false);
					txtDado3FalhasServ1.setVisible(false);
					break;
				case "Normal":
					lblDado1FalhasServ1.setVisible(true);
					lblDado1FalhasServ1.setText("Média");
					txtDado1FalhasServ1.setEnabled(true);
					
					lblDado2FalhasServ1.setVisible(true);
					lblDado2FalhasServ1.setText("Desvio Padrão");
					txtDado2FalhasServ1.setVisible(true);
					
					lblDado3FalhasServ1.setVisible(false);
					txtDado3FalhasServ1.setVisible(false);
					break;
				case "Triangular":
					lblDado1FalhasServ1.setVisible(true);
					lblDado1FalhasServ1.setText("A");
					txtDado1FalhasServ1.setEnabled(true);
					
					lblDado2FalhasServ1.setVisible(true);
					lblDado2FalhasServ1.setText("B");
					txtDado2FalhasServ1.setVisible(true);
					
					lblDado3FalhasServ1.setVisible(true);
					lblDado3FalhasServ1.setText("C");
					txtDado3FalhasServ1.setVisible(true);
					break;
				default:
					lblDado1FalhasServ1.setVisible(true);
					lblDado1FalhasServ1.setText("Constante");
					txtDado1FalhasServ1.setEnabled(true);
					
					lblDado2FalhasServ1.setVisible(false);
					txtDado2FalhasServ1.setVisible(false);
					
					lblDado3FalhasServ1.setVisible(false);
					txtDado3FalhasServ1.setVisible(false);
				}
			}
		});
		cmbBServ1EntreFalhas.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Uniforme", "Exponencial", "Normal", "Triangular"}));
		cmbBServ1EntreFalhas.setSelectedIndex(0);
		cmbBServ1EntreFalhas.setBounds(10, 220, 108, 20);
		frame.getContentPane().add(cmbBServ1EntreFalhas);
		
		lblDistribuioTempoEm = new JLabel("<html>Distribuição <br>Tempo Em Falha</html>");
		lblDistribuioTempoEm.setBounds(10, 246, 154, 28);
		frame.getContentPane().add(lblDistribuioTempoEm);
		
		cmbBServ1EmFalha = new JComboBox();
		cmbBServ1EmFalha.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch(cmbBServ1EmFalha.getSelectedItem().toString()) {
				case "Uniforme":
					lblDadoTemfalhas.setVisible(true);
					lblDadoTemfalhas.setText("Min");
					txtDado1EmFalhaServ1.setEnabled(true);
					
					lblDadoTemfalhas_1.setVisible(true);
					lblDadoTemfalhas_1.setText("Max");
					txtDado2EmFalhaServ1.setVisible(true);
					
					lblDadoTemfalhas_2.setVisible(false);
					txtDado3EmFalhaServ1.setVisible(false);
					break;
				case "Exponencial":
					lblDadoTemfalhas.setVisible(true);
					lblDadoTemfalhas.setText("Média");
					txtDado1EmFalhaServ1.setEnabled(true);
					
					lblDadoTemfalhas_1.setVisible(false);
					txtDado2EmFalhaServ1.setVisible(false);
					
					lblDadoTemfalhas_2.setVisible(false);
					txtDado3EmFalhaServ1.setVisible(false);
					break;
				case "Normal":
					lblDadoTemfalhas.setVisible(true);
					lblDadoTemfalhas.setText("Média");
					txtDado1EmFalhaServ1.setEnabled(true);
					
					lblDadoTemfalhas_1.setVisible(true);
					lblDadoTemfalhas_1.setText("Desvio Padrão");
					txtDado2EmFalhaServ1.setVisible(true);
					
					lblDadoTemfalhas_2.setVisible(false);
					txtDado3EmFalhaServ1.setVisible(false);
					break;
				case "Triangular":
					lblDadoTemfalhas.setVisible(true);
					lblDadoTemfalhas.setText("A");
					txtDado1EmFalhaServ1.setEnabled(true);
					
					lblDadoTemfalhas_1.setVisible(true);
					lblDadoTemfalhas_1.setText("B");
					txtDado2EmFalhaServ1.setVisible(true);
					
					lblDadoTemfalhas_2.setVisible(true);
					lblDadoTemfalhas_2.setText("C");
					txtDado3EmFalhaServ1.setVisible(true);
					break;
				default:
					lblDadoTemfalhas.setVisible(true);
					lblDadoTemfalhas.setText("Constante");
					txtDado1EmFalhaServ1.setEnabled(true);
					
					lblDadoTemfalhas_1.setVisible(false);
					txtDado2EmFalhaServ1.setVisible(false);
					
					lblDadoTemfalhas_2.setVisible(false);
					txtDado3EmFalhaServ1.setVisible(false);
				}
			}
		});
		cmbBServ1EmFalha.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Uniforme", "Exponencial", "Normal", "Triangular"}));
		cmbBServ1EmFalha.setSelectedIndex(0);
		cmbBServ1EmFalha.setBounds(10, 276, 108, 20);
		frame.getContentPane().add(cmbBServ1EmFalha);
		
		lblDadoTemfalhas = new JLabel("Dado1 TEmFalha");
		lblDadoTemfalhas.setBounds(174, 251, 108, 14);
		frame.getContentPane().add(lblDadoTemfalhas);
		
		txtDado1EmFalhaServ1 = new JTextField();
		txtDado1EmFalhaServ1.setColumns(10);
		txtDado1EmFalhaServ1.setBounds(174, 276, 86, 20);
		frame.getContentPane().add(txtDado1EmFalhaServ1);
		
		lblDadoTemfalhas_1 = new JLabel("Dado2 TEmFalha");
		lblDadoTemfalhas_1.setBounds(274, 251, 118, 14);
		frame.getContentPane().add(lblDadoTemfalhas_1);
		
		txtDado2EmFalhaServ1 = new JTextField();
		txtDado2EmFalhaServ1.setColumns(10);
		txtDado2EmFalhaServ1.setBounds(270, 276, 86, 20);
		frame.getContentPane().add(txtDado2EmFalhaServ1);
		
		lblDadoTemfalhas_2 = new JLabel("Dado3 TEmFalha");
		lblDadoTemfalhas_2.setBounds(370, 251, 118, 14);
		frame.getContentPane().add(lblDadoTemfalhas_2);
		
		txtDado3EmFalhaServ1 = new JTextField();
		txtDado3EmFalhaServ1.setColumns(10);
		txtDado3EmFalhaServ1.setBounds(366, 276, 86, 20);
		frame.getContentPane().add(txtDado3EmFalhaServ1);
		
		lblDado1FalhasServ1 = new JLabel("Dado1 Falhas");
		lblDado1FalhasServ1.setBounds(174, 195, 86, 14);
		frame.getContentPane().add(lblDado1FalhasServ1);
		
		txtDado1FalhasServ1 = new JTextField();
		txtDado1FalhasServ1.setColumns(10);
		txtDado1FalhasServ1.setBounds(174, 220, 86, 20);
		frame.getContentPane().add(txtDado1FalhasServ1);
		
		lblDado2FalhasServ1 = new JLabel("Dado2 Falhas");
		lblDado2FalhasServ1.setBounds(274, 195, 82, 14);
		frame.getContentPane().add(lblDado2FalhasServ1);
		
		txtDado2FalhasServ1 = new JTextField();
		txtDado2FalhasServ1.setColumns(10);
		txtDado2FalhasServ1.setBounds(270, 220, 86, 20);
		frame.getContentPane().add(txtDado2FalhasServ1);
		
		lblDado3FalhasServ1 = new JLabel("Dado3 Falhas");
		lblDado3FalhasServ1.setBounds(366, 195, 86, 14);
		frame.getContentPane().add(lblDado3FalhasServ1);
		
		txtDado3FalhasServ1 = new JTextField();
		txtDado3FalhasServ1.setColumns(10);
		txtDado3FalhasServ1.setBounds(366, 220, 86, 20);
		frame.getContentPane().add(txtDado3FalhasServ1);
		
		lblEntidade = new JLabel("<html><u>Entidade</u></html>");
		lblEntidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEntidade.setBounds(10, 25, 118, 21);
		frame.getContentPane().add(lblEntidade);
		
		lblServidor = new JLabel("<html><u>Servidor</u></html>");
		lblServidor.setHorizontalAlignment(SwingConstants.CENTER);
		lblServidor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblServidor.setBounds(10, 163, 118, 21);
		frame.getContentPane().add(lblServidor);
		
		lblTipo_1 = new JLabel("Tipo 2");
		lblTipo_1.setForeground(Color.RED);
		lblTipo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTipo_1.setBounds(0, 325, 118, 21);
		frame.getContentPane().add(lblTipo_1);
		
		label_1 = new JLabel("Distribuição Chegada");
		label_1.setBounds(10, 375, 140, 14);
		frame.getContentPane().add(label_1);
		
		cmbBChegada2 = new JComboBox();
		cmbBChegada2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch(cmbBChegada2.getSelectedItem().toString()) {
				case "Uniforme":
					lblDado1Chegada2.setVisible(true);
					lblDado1Chegada2.setText("Min");
					txtDado1Chegada2.setEnabled(true);
					
					lblDado2Chegada2.setVisible(true);
					lblDado2Chegada2.setText("Max");
					txtDado2Chegada2.setVisible(true);
					
					lblDado3Chegada2.setVisible(false);
					txtDado3Chegada2.setVisible(false);
					break;
				case "Exponencial":
					lblDado1Chegada2.setVisible(true);
					lblDado1Chegada2.setText("Média");
					txtDado1Chegada2.setEnabled(true);
					
					lblDado2Chegada2.setVisible(false);
					txtDado2Chegada2.setVisible(false);
					
					lblDado3Chegada2.setVisible(false);
					txtDado3Chegada2.setVisible(false);
					break;
				case "Normal":
					lblDado1Chegada2.setVisible(true);
					lblDado1Chegada2.setText("Média");
					txtDado1Chegada2.setEnabled(true);
					
					lblDado2Chegada2.setVisible(true);
					lblDado2Chegada2.setText("Desvio Padrão");
					txtDado2Chegada2.setVisible(true);
				
					lblDado3Chegada2.setVisible(false);
					txtDado3Chegada2.setVisible(false);
					break;
				case "Triangular":
					lblDado1Chegada2.setVisible(true);
					lblDado1Chegada2.setText("A");
					txtDado1Chegada2.setEnabled(true);
					
					lblDado2Chegada2.setVisible(true);
					lblDado2Chegada2.setText("B");
					txtDado2Chegada2.setVisible(true);
					
					lblDado3Chegada2.setVisible(true);
					lblDado3Chegada2.setText("C");
					txtDado3Chegada2.setVisible(true);
					break;
				default:
					lblDado1Chegada2.setVisible(true);
					lblDado1Chegada2.setText("Constante");
					txtDado1Chegada2.setEnabled(true);
					
					lblDado2Chegada2.setVisible(false);
					txtDado2Chegada2.setVisible(false);
					
					lblDado3Chegada2.setVisible(false);
					txtDado3Chegada2.setVisible(false);
					break;
				}
			}
		});
		cmbBChegada2.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Uniforme", "Exponencial", "Normal", "Triangular"}));
		cmbBChegada2.setSelectedIndex(0);
		cmbBChegada2.setBounds(10, 397, 108, 20);
		frame.getContentPane().add(cmbBChegada2);
		
		lbldistribuiotempoDe = new JLabel("<html>Distribuição <br>Tempo de Serviço</html>");
		lbldistribuiotempoDe.setBounds(10, 422, 154, 28);
		frame.getContentPane().add(lbldistribuiotempoDe);
		
		cmbBTServ2 = new JComboBox();
		cmbBTServ2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch(cmbBTServ2.getSelectedItem().toString()) {
				case "Uniforme":
					lblDado1TServ2.setVisible(true);
					lblDado1TServ2.setText("Min");
					txtDado1TServ2.setEnabled(true);
					
					lblDado2TServ2.setVisible(true);
					lblDado2TServ2.setText("Max");
					txtDado2TServ2.setVisible(true);
					
					lblDado3TServ2.setVisible(false);
					txtDado3TServ2.setVisible(false);
					break;
				case "Exponencial":
					lblDado1TServ2.setVisible(true);
					lblDado1TServ2.setText("Média");
					txtDado1TServ2.setEnabled(true);
					
					lblDado2TServ2.setVisible(false);
					txtDado2TServ2.setVisible(false);
				
					lblDado3TServ2.setVisible(false);
					txtDado3TServ2.setVisible(false);
					break;
				case "Normal":
					lblDado1TServ2.setVisible(true);
					lblDado1TServ2.setText("Média");
					txtDado1TServ2.setEnabled(true);
					
					lblDado2TServ2.setVisible(true);
					lblDado2TServ2.setText("Desvio Padrão");
					txtDado2TServ2.setVisible(true);
					
					lblDado3TServ2.setVisible(false);
					txtDado3TServ2.setVisible(false);
					break;
				case "Triangular":
					lblDado1TServ2.setVisible(true);
					lblDado1TServ2.setText("A");
					txtDado1TServ2.setEnabled(true);
					
					lblDado2TServ2.setVisible(true);
					lblDado2TServ2.setText("B");
					txtDado2TServ2.setVisible(true);
					
					lblDado3TServ2.setVisible(true);
					lblDado3TServ2.setText("C");
					txtDado3TServ2.setVisible(true);
					break;
				default:
					lblDado1TServ2.setVisible(true);
					lblDado1TServ2.setText("Constante");
					txtDado1TServ2.setEnabled(true);
					
					lblDado2TServ2.setVisible(false);
					txtDado2TServ2.setVisible(false);
				
					lblDado3TServ2.setVisible(false);
					txtDado3TServ2.setVisible(false);
					break;
				}
			}
		});
		cmbBTServ2.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Uniforme", "Exponencial", "Normal", "Triangular"}));
		cmbBTServ2.setSelectedIndex(0);
		cmbBTServ2.setBounds(10, 453, 108, 20);
		frame.getContentPane().add(cmbBTServ2);
		
		lblDado1TServ2 = new JLabel("Dado1 TServ");
		lblDado1TServ2.setBounds(174, 428, 86, 14);
		frame.getContentPane().add(lblDado1TServ2);
		
		txtDado1TServ2 = new JTextField();
		txtDado1TServ2.setColumns(10);
		txtDado1TServ2.setBounds(174, 453, 86, 20);
		frame.getContentPane().add(txtDado1TServ2);
		
		lblDado2TServ2 = new JLabel("Dado2 TServ");
		lblDado2TServ2.setBounds(274, 428, 82, 14);
		frame.getContentPane().add(lblDado2TServ2);
		
		txtDado2TServ2 = new JTextField();
		txtDado2TServ2.setColumns(10);
		txtDado2TServ2.setBounds(270, 453, 86, 20);
		frame.getContentPane().add(txtDado2TServ2);
		
		lblDado3TServ2 = new JLabel("Dado3 TServ");
		lblDado3TServ2.setBounds(366, 428, 86, 14);
		frame.getContentPane().add(lblDado3TServ2);
		
		txtDado3TServ2 = new JTextField();
		txtDado3TServ2.setColumns(10);
		txtDado3TServ2.setBounds(366, 453, 86, 20);
		frame.getContentPane().add(txtDado3TServ2);
		
		lblDado1Chegada2 = new JLabel("Dado1 Chegada");
		lblDado1Chegada2.setBounds(174, 372, 108, 14);
		frame.getContentPane().add(lblDado1Chegada2);
		
		txtDado1Chegada2 = new JTextField();
		txtDado1Chegada2.setColumns(10);
		txtDado1Chegada2.setBounds(174, 397, 86, 20);
		frame.getContentPane().add(txtDado1Chegada2);
		
		lblDado2Chegada2 = new JLabel("Dado2 Chegada");
		lblDado2Chegada2.setBounds(274, 372, 118, 14);
		frame.getContentPane().add(lblDado2Chegada2);
		
		txtDado2Chegada2 = new JTextField();
		txtDado2Chegada2.setColumns(10);
		txtDado2Chegada2.setBounds(270, 397, 86, 20);
		frame.getContentPane().add(txtDado2Chegada2);
		
		lblDado3Chegada2 = new JLabel("Dado3 Chegada");
		lblDado3Chegada2.setBounds(366, 372, 118, 14);
		frame.getContentPane().add(lblDado3Chegada2);
		
		txtDado3Chegada2 = new JTextField();
		txtDado3Chegada2.setColumns(10);
		txtDado3Chegada2.setBounds(366, 397, 86, 20);
		frame.getContentPane().add(txtDado3Chegada2);
		
		lbldistribuiotempoEntre = new JLabel("<html>Distribuição <br>Tempo Entre Falhas</html>");
		lbldistribuiotempoEntre.setBounds(10, 515, 154, 28);
		frame.getContentPane().add(lbldistribuiotempoEntre);
		
		cmbBServ2EntreFalhas = new JComboBox();
		cmbBServ2EntreFalhas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch(cmbBServ2EntreFalhas.getSelectedItem().toString()) {
				case "Uniforme":
					lblDado1FalhasServ2.setVisible(true);
					lblDado1FalhasServ2.setText("Min");
					txtDado1FalhasServ2.setEnabled(true);
					
					lblDado2FalhasServ2.setVisible(true);
					lblDado2FalhasServ2.setText("Max");
					txtDado2FalhasServ2.setVisible(true);
					
					lblDado3FalhasServ2.setVisible(false);
					txtDado3FalhasServ2.setVisible(false);
					break;
				case "Exponencial":
					lblDado1FalhasServ2.setVisible(true);
					lblDado1FalhasServ2.setText("Média");
					txtDado1FalhasServ2.setEnabled(true);
					
					lblDado2FalhasServ2.setVisible(false);
					txtDado2FalhasServ2.setVisible(false);
				
					lblDado3FalhasServ2.setVisible(false);
					txtDado3FalhasServ2.setVisible(false);
					break;
				case "Normal":
					lblDado1FalhasServ2.setVisible(true);
					lblDado1FalhasServ2.setText("Média");
					txtDado1FalhasServ2.setEnabled(true);
					
					lblDado2FalhasServ2.setVisible(true);
					lblDado2FalhasServ2.setText("Desvio Padrão");
					txtDado2FalhasServ2.setVisible(true);
					
					lblDado3FalhasServ2.setVisible(false);
					txtDado3FalhasServ2.setVisible(false);
					break;
				case "Triangular":
					lblDado1FalhasServ2.setVisible(true);
					lblDado1FalhasServ2.setText("A");
					txtDado1FalhasServ2.setEnabled(true);
					
					lblDado2FalhasServ2.setVisible(true);
					lblDado2FalhasServ2.setText("B");
					txtDado2FalhasServ2.setVisible(true);
					
					lblDado3FalhasServ2.setVisible(true);
					lblDado3FalhasServ2.setText("C");
					txtDado3FalhasServ2.setVisible(true);
					break;
				default:
					lblDado1FalhasServ2.setVisible(true);
					lblDado1FalhasServ2.setText("Constante");
					txtDado1FalhasServ2.setEnabled(true);
					
					lblDado2FalhasServ2.setVisible(false);
					txtDado2FalhasServ2.setVisible(false);
				
					lblDado3FalhasServ2.setVisible(false);
					txtDado3FalhasServ2.setVisible(false);
					break;
				}
			}
		});
		cmbBServ2EntreFalhas.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Uniforme", "Exponencial", "Normal", "Triangular"}));
		cmbBServ2EntreFalhas.setSelectedIndex(0);
		cmbBServ2EntreFalhas.setBounds(10, 545, 108, 20);
		frame.getContentPane().add(cmbBServ2EntreFalhas);
		
		lbldistribuiotempoEm = new JLabel("<html>Distribuição <br>Tempo Em Falha</html>");
		lbldistribuiotempoEm.setBounds(10, 570, 154, 28);
		frame.getContentPane().add(lbldistribuiotempoEm);
		
		cmbBServ2EmFalha = new JComboBox();
		cmbBServ2EmFalha.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch(cmbBServ2EmFalha.getSelectedItem().toString()) {
				case "Uniforme":
					lblDado1TEmFalhaServ2.setVisible(true);
					lblDado1TEmFalhaServ2.setText("Min");
					txtDado1EmFalhaServ2.setEnabled(true);
					
					lblDado2TEmFalhaServ2.setVisible(true);
					lblDado2TEmFalhaServ2.setText("Max");
					txtDado2EmFalhaServ2.setVisible(true);
					
					lblDado3TEmFalhaServ2.setVisible(false);
					txtDado3EmFalhaServ2.setVisible(false);
					break;
				case "Exponencial":
					lblDado1TEmFalhaServ2.setVisible(true);
					lblDado1TEmFalhaServ2.setText("Média");
					txtDado1EmFalhaServ2.setEnabled(true);
					
					lblDado2TEmFalhaServ2.setVisible(false);
					txtDado2EmFalhaServ2.setVisible(false);
					
					lblDado3TEmFalhaServ2.setVisible(false);
					txtDado3EmFalhaServ2.setVisible(false);
					break;
				case "Normal":
					lblDado1TEmFalhaServ2.setVisible(true);
					lblDado1TEmFalhaServ2.setText("Média");
					txtDado1EmFalhaServ2.setEnabled(true);
					
					lblDado2TEmFalhaServ2.setVisible(true);
					lblDado2TEmFalhaServ2.setText("Desvio Padrão");
					txtDado2EmFalhaServ2.setVisible(true);
					
					lblDado3TEmFalhaServ2.setVisible(false);
					txtDado3EmFalhaServ2.setVisible(false);
					break;
				case "Triangular":
					lblDado1TEmFalhaServ2.setVisible(true);
					lblDado1TEmFalhaServ2.setText("A");
					txtDado1EmFalhaServ2.setEnabled(true);
					
					lblDado2TEmFalhaServ2.setVisible(true);
					lblDado2TEmFalhaServ2.setText("B");
					txtDado2EmFalhaServ2.setVisible(true);
					
					lblDado3TEmFalhaServ2.setVisible(true);
					lblDado3TEmFalhaServ2.setText("C");
					txtDado3EmFalhaServ2.setVisible(true);
					break;
				default:
					lblDado1TEmFalhaServ2.setVisible(true);
					lblDado1TEmFalhaServ2.setText("Constante");
					txtDado1EmFalhaServ2.setEnabled(true);
					
					lblDado2TEmFalhaServ2.setVisible(false);
					txtDado2EmFalhaServ2.setVisible(false);
					
					lblDado3TEmFalhaServ2.setVisible(false);
					txtDado3EmFalhaServ2.setVisible(false);
				}
			}
		});
		cmbBServ2EmFalha.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Uniforme", "Exponencial", "Normal", "Triangular"}));
		cmbBServ2EmFalha.setSelectedIndex(0);
		cmbBServ2EmFalha.setBounds(10, 601, 108, 20);
		frame.getContentPane().add(cmbBServ2EmFalha);
		
		lblDado1TEmFalhaServ2 = new JLabel("Dado1 TEmFalha");
		lblDado1TEmFalhaServ2.setBounds(174, 576, 108, 14);
		frame.getContentPane().add(lblDado1TEmFalhaServ2);
		
		txtDado1EmFalhaServ2 = new JTextField();
		txtDado1EmFalhaServ2.setColumns(10);
		txtDado1EmFalhaServ2.setBounds(174, 601, 86, 20);
		frame.getContentPane().add(txtDado1EmFalhaServ2);
		
		lblDado2TEmFalhaServ2 = new JLabel("Dado2 TEmFalha");
		lblDado2TEmFalhaServ2.setBounds(274, 576, 118, 14);
		frame.getContentPane().add(lblDado2TEmFalhaServ2);
		
		txtDado2EmFalhaServ2 = new JTextField();
		txtDado2EmFalhaServ2.setColumns(10);
		txtDado2EmFalhaServ2.setBounds(270, 601, 86, 20);
		frame.getContentPane().add(txtDado2EmFalhaServ2);
		
		lblDado3TEmFalhaServ2 = new JLabel("Dado3 TEmFalha");
		lblDado3TEmFalhaServ2.setBounds(370, 576, 118, 14);
		frame.getContentPane().add(lblDado3TEmFalhaServ2);
		
		txtDado3EmFalhaServ2 = new JTextField();
		txtDado3EmFalhaServ2.setColumns(10);
		txtDado3EmFalhaServ2.setBounds(366, 601, 86, 20);
		frame.getContentPane().add(txtDado3EmFalhaServ2);
		
		lblDado1FalhasServ2 = new JLabel("Dado1 Falhas");
		lblDado1FalhasServ2.setBounds(174, 520, 86, 14);
		frame.getContentPane().add(lblDado1FalhasServ2);
		
		txtDado1FalhasServ2 = new JTextField();
		txtDado1FalhasServ2.setColumns(10);
		txtDado1FalhasServ2.setBounds(174, 545, 86, 20);
		frame.getContentPane().add(txtDado1FalhasServ2);
		
		lblDado2FalhasServ2 = new JLabel("Dado2 Falhas");
		lblDado2FalhasServ2.setBounds(274, 520, 82, 14);
		frame.getContentPane().add(lblDado2FalhasServ2);
		
		txtDado2FalhasServ2 = new JTextField();
		txtDado2FalhasServ2.setColumns(10);
		txtDado2FalhasServ2.setBounds(270, 545, 86, 20);
		frame.getContentPane().add(txtDado2FalhasServ2);
		
		lblDado3FalhasServ2 = new JLabel("Dado3 Falhas");
		lblDado3FalhasServ2.setBounds(366, 520, 86, 14);
		frame.getContentPane().add(lblDado3FalhasServ2);
		
		txtDado3FalhasServ2 = new JTextField();
		txtDado3FalhasServ2.setColumns(10);
		txtDado3FalhasServ2.setBounds(366, 545, 86, 20);
		frame.getContentPane().add(txtDado3FalhasServ2);
		
		lblentidade = new JLabel("<html><u>Entidade</u></html>");
		lblentidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblentidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblentidade.setBounds(10, 350, 118, 21);
		frame.getContentPane().add(lblentidade);
		
		lblservidor = new JLabel("<html><u>Servidor</u></html>");
		lblservidor.setHorizontalAlignment(SwingConstants.CENTER);
		lblservidor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblservidor.setBounds(10, 488, 118, 21);
		frame.getContentPane().add(lblservidor);
		
		btnIniciarSimulao = new JButton("Iniciar Simulação");
		btnIniciarSimulao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Tipo1
					switch (cmbBChegada1.getSelectedItem().toString()) {
					case "Uniforme":
						Gerador.teChegadas1 = 'u';
						Gerador.min1 = Double.parseDouble(txtDado1Chegada1.getText());
						Gerador.max1 = Double.parseDouble(txtDado2Chegada1.getText());
						break;
					case "Exponencial":
						Gerador.teChegadas1 = 'e';
						Gerador.media1 = Double.parseDouble(txtDado1Chegada1.getText());
						break;
					case "Normal":
						Gerador.teChegadas1 = 'n';
						Gerador.media1 = Double.parseDouble(txtDado1Chegada1.getText());
						Gerador.desvioPadrao1 = Double.parseDouble(txtDado2Chegada1.getText());
						break;
					case "Triangular":
						Gerador.teChegadas1 = 't';
						Gerador.a1 = Double.parseDouble(txtDado1Chegada1.getText());
						Gerador.b1 = Double.parseDouble(txtDado2Chegada1.getText());
						Gerador.c1 = Double.parseDouble(txtDado3Chegada1.getText());
						break;
					default:
						Gerador.teChegadas1 = 'c';
						Gerador.constante1 = Double.parseDouble(txtDado1Chegada1.getText());
						break;
					}
					switch (cmbBTServ1.getSelectedItem().toString()) {
					case "Uniforme":
						Gerador.tServico1 = 'u';
						Gerador.min1TS = Double.parseDouble(txtDado1TServ1.getText());
						Gerador.max1TS = Double.parseDouble(txtDado2TServ1.getText());
						break;
					case "Exponencial":
						Gerador.tServico1 = 'e';
						Gerador.media1TS = Double.parseDouble(txtDado1TServ1.getText());
						break;
					case "Normal":
						Gerador.tServico1 = 'n';
						Gerador.media1TS = Double.parseDouble(txtDado1TServ1.getText());
						Gerador.desvioPadrao1TS = Double.parseDouble(txtDado2TServ1.getText());
						break;
					case "Triangular":
						Gerador.tServico1 = 't';
						Gerador.a1TS = Double.parseDouble(txtDado1TServ1.getText());
						Gerador.b1TS = Double.parseDouble(txtDado2TServ1.getText());
						Gerador.c1TS = Double.parseDouble(txtDado3TServ1.getText());
						break;
					default:
						Gerador.tServico1 = 'c';
						Gerador.constante1TS = Double.parseDouble(txtDado1TServ1.getText());
						break;
					}
					
					switch (cmbBServ1EntreFalhas.getSelectedItem().toString()) {
					case "Uniforme":
						Gerador.tEntreFalhasServidor1 = 'u';
						Gerador.minNFS1 = Double.parseDouble(txtDado1FalhasServ1.getText());
						Gerador.maxNFS1 = Double.parseDouble(txtDado2FalhasServ1.getText());
						break;
					case "Exponencial":
						Gerador.tEntreFalhasServidor1 = 'e';
						Gerador.mediaNFS1 = Double.parseDouble(txtDado1FalhasServ1.getText());
						break;
					case "Normal":
						Gerador.tEntreFalhasServidor1 = 'n';
						Gerador.mediaNFS1 = Double.parseDouble(txtDado1FalhasServ1.getText());
						Gerador.desvioPadraoNFS1 = Double.parseDouble(txtDado2FalhasServ1.getText());
						break;
					case "Triangular":
						Gerador.tEntreFalhasServidor1 = 't';
						Gerador.aNFS1 = Double.parseDouble(txtDado1FalhasServ1.getText());
						Gerador.bNFS1 = Double.parseDouble(txtDado2FalhasServ1.getText());
						Gerador.cNFS1 = Double.parseDouble(txtDado3FalhasServ1.getText());
						break;
					default:
						Gerador.tEntreFalhasServidor1 = 'c';
						Gerador.constanteNFS1 = Double.parseDouble(txtDado1FalhasServ1.getText());
						break;
					}
					switch (cmbBServ1EmFalha.getSelectedItem().toString()) {
					case "Uniforme":
						Gerador.tEmFalhaServidor1 = 'u';
						Gerador.minFS1 = Double.parseDouble(txtDado1EmFalhaServ1.getText());
						Gerador.maxFS1 = Double.parseDouble(txtDado2EmFalhaServ1.getText());
						break;
					case "Exponencial":
						Gerador.tEmFalhaServidor1 = 'e';
						Gerador.mediaFS1 = Double.parseDouble(txtDado1EmFalhaServ1.getText());
						break;
					case "Normal":
						Gerador.tEmFalhaServidor1 = 'n';
						Gerador.mediaFS1 = Double.parseDouble(txtDado1EmFalhaServ1.getText());
						Gerador.desvioPadraoFS1 = Double.parseDouble(txtDado2EmFalhaServ1.getText());
						break;
					case "Triangular":
						Gerador.tEmFalhaServidor1 = 't';
						Gerador.aFS1 = Double.parseDouble(txtDado1EmFalhaServ1.getText());
						Gerador.bFS1 = Double.parseDouble(txtDado2EmFalhaServ1.getText());
						Gerador.cFS1 = Double.parseDouble(txtDado3EmFalhaServ1.getText());
						break;
					default:
						Gerador.tEmFalhaServidor1 = 'c';
						Gerador.constanteFS1 = Double.parseDouble(txtDado1EmFalhaServ1.getText());
						break;
					}
					//Tipo2
					switch (cmbBChegada2.getSelectedItem().toString()) {
					case "Uniforme":
						Gerador.teChegadas2 = 'u';
						Gerador.min2 = Double.parseDouble(txtDado1Chegada2.getText());
						Gerador.max2 = Double.parseDouble(txtDado2Chegada2.getText());
						break;
					case "Exponencial":
						Gerador.teChegadas2 = 'e';
						Gerador.media2 = Double.parseDouble(txtDado1Chegada2.getText());
						break;
					case "Normal":
						Gerador.teChegadas2 = 'n';
						Gerador.media2 = Double.parseDouble(txtDado1Chegada2.getText());
						Gerador.desvioPadrao2 = Double.parseDouble(txtDado2Chegada2.getText());
						break;
					case "Triangular":
						Gerador.teChegadas2 = 't';
						Gerador.a2 = Double.parseDouble(txtDado1Chegada2.getText());
						Gerador.b2 = Double.parseDouble(txtDado2Chegada2.getText());
						Gerador.c2 = Double.parseDouble(txtDado3Chegada2.getText());
						break;
					default:
						Gerador.teChegadas2 = 'c';
						Gerador.constante2 = Double.parseDouble(txtDado1Chegada2.getText());
						break;
					}
					switch (cmbBTServ2.getSelectedItem().toString()) {
					case "Uniforme":
						Gerador.tServico2 = 'u';
						Gerador.min2TS = Double.parseDouble(txtDado1TServ2.getText());
						Gerador.max2TS = Double.parseDouble(txtDado2TServ2.getText());
						break;
					case "Exponencial":
						Gerador.tServico2 = 'e';
						Gerador.media2TS = Double.parseDouble(txtDado1TServ2.getText());
						break;
					case "Normal":
						Gerador.tServico2 = 'n';
						Gerador.media2TS = Double.parseDouble(txtDado1TServ2.getText());
						Gerador.desvioPadrao2TS = Double.parseDouble(txtDado2TServ2.getText());
						break;
					case "Triangular":
						Gerador.tServico2 = 't';
						Gerador.a2TS = Double.parseDouble(txtDado1TServ2.getText());
						Gerador.b2TS = Double.parseDouble(txtDado2TServ2.getText());
						Gerador.c2TS = Double.parseDouble(txtDado3TServ2.getText());
						break;
					default:
						Gerador.tServico2 = 'c';
						Gerador.constante2TS = Double.parseDouble(txtDado1TServ2.getText());
						break;
					}
					switch (cmbBServ2EntreFalhas.getSelectedItem().toString()) {
					case "Uniforme":
						Gerador.tEntreFalhasServidor2 = 'u';
						Gerador.minNFS2 = Double.parseDouble(txtDado1FalhasServ2.getText());
						Gerador.maxNFS2 = Double.parseDouble(txtDado2FalhasServ2.getText());
						break;
					case "Exponencial":
						Gerador.tEntreFalhasServidor2 = 'e';
						Gerador.mediaNFS2 = Double.parseDouble(txtDado1FalhasServ2.getText());
						break;
					case "Normal":
						Gerador.tEntreFalhasServidor2 = 'n';
						Gerador.mediaNFS2 = Double.parseDouble(txtDado1FalhasServ2.getText());
						Gerador.desvioPadraoNFS2 = Double.parseDouble(txtDado2FalhasServ2.getText());
						break;
					case "Triangular":
						Gerador.tEntreFalhasServidor2 = 't';
						Gerador.aNFS2 = Double.parseDouble(txtDado1FalhasServ2.getText());
						Gerador.bNFS2 = Double.parseDouble(txtDado2FalhasServ2.getText());
						Gerador.cNFS2 = Double.parseDouble(txtDado3FalhasServ2.getText());
						break;
					default:
						Gerador.tEntreFalhasServidor2 = 'c';
						Gerador.constanteNFS2 = Double.parseDouble(txtDado1FalhasServ2.getText());
						break;
					}
					switch (cmbBServ2EmFalha.getSelectedItem().toString()) {
					case "Uniforme":
						Gerador.tEmFalhaServidor2 = 'u';
						Gerador.minFS2 = Double.parseDouble(txtDado1EmFalhaServ2.getText());
						Gerador.maxFS2 = Double.parseDouble(txtDado2EmFalhaServ2.getText());
						break;
					case "Exponencial":
						Gerador.tEmFalhaServidor2 = 'e';
						Gerador.mediaFS2 = Double.parseDouble(txtDado1EmFalhaServ2.getText());
						break;
					case "Normal":
						Gerador.tEmFalhaServidor2 = 'n';
						Gerador.mediaFS2 = Double.parseDouble(txtDado1EmFalhaServ2.getText());
						Gerador.desvioPadraoFS2 = Double.parseDouble(txtDado2EmFalhaServ2.getText());
						break;
					case "Triangular":
						Gerador.tEmFalhaServidor2 = 't';
						Gerador.aFS2 = Double.parseDouble(txtDado1EmFalhaServ2.getText());
						Gerador.bFS2 = Double.parseDouble(txtDado2EmFalhaServ2.getText());
						Gerador.cFS2 = Double.parseDouble(txtDado3EmFalhaServ2.getText());
						break;
					default:
						Gerador.tEmFalhaServidor2 = 'c';
						Gerador.constanteFS2 = Double.parseDouble(txtDado1EmFalhaServ2.getText());
						break;
					}
					
					Gerador.tempoFinalSim = new Tempo(Double.parseDouble(txtDuracao.getText()), UnidadeTempo.SEGUNDOS);
					
					validos = true;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Entrada Inválida");
					validos = false;
				}
			}
		});
		btnIniciarSimulao.setBounds(430, 642, 154, 23);
		frame.getContentPane().add(btnIniciarSimulao);
		
		//Config inicial Constante
		//Chegada1
		lblDado1Chegada1.setVisible(true);
		lblDado1Chegada1.setText("Constante");
		txtDado1Chegada1.setEnabled(true);
		
		lblDado2Chegada1.setVisible(false);
		txtDado2Chegada1.setVisible(false);
		
		lblDado3Chegada1.setVisible(false);
		txtDado3Chegada1.setVisible(false);
		
		//TServ1
		lblDadoTServ1.setVisible(true);
		lblDadoTServ1.setText("Constante");
		txtDado1TServ1.setEnabled(true);
		
		lblDado2TServ1.setVisible(false);
		txtDado2TServ1.setVisible(false);
		
		lblDado3TServ1.setVisible(false);
		txtDado3TServ1.setVisible(false);
		
		//TEntreFalhas1
		lblDado1FalhasServ1.setVisible(true);
		lblDado1FalhasServ1.setText("Constante");
		txtDado1FalhasServ1.setEnabled(true);
		
		lblDado2FalhasServ1.setVisible(false);
		txtDado2FalhasServ1.setVisible(false);
		
		lblDado3FalhasServ1.setVisible(false);
		txtDado3FalhasServ1.setVisible(false);
		
		//TEmFalhas1
		lblDadoTemfalhas.setVisible(true);
		lblDadoTemfalhas.setText("Constante");
		txtDado1EmFalhaServ1.setEnabled(true);
		
		lblDadoTemfalhas_1.setVisible(false);
		txtDado2EmFalhaServ1.setVisible(false);
		
		lblDadoTemfalhas_2.setVisible(false);
		txtDado3EmFalhaServ1.setVisible(false);
		
		//Chegada2
		lblDado1Chegada2.setVisible(true);
		lblDado1Chegada2.setText("Constante");
		txtDado1Chegada2.setEnabled(true);
		
		lblDado2Chegada2.setVisible(false);
		txtDado2Chegada2.setVisible(false);
		
		lblDado3Chegada2.setVisible(false);
		txtDado3Chegada2.setVisible(false);
		
		//TServ2
		lblDado1TServ2.setVisible(true);
		lblDado1TServ2.setText("Constante");
		txtDado1TServ2.setEnabled(true);
		
		lblDado2TServ2.setVisible(false);
		txtDado2TServ2.setVisible(false);
	
		lblDado3TServ2.setVisible(false);
		txtDado3TServ2.setVisible(false);
		
		//EntreFalha2
		lblDado1FalhasServ2.setVisible(true);
		lblDado1FalhasServ2.setText("Constante");
		txtDado1FalhasServ2.setEnabled(true);
		
		lblDado2FalhasServ2.setVisible(false);
		txtDado2FalhasServ2.setVisible(false);
	
		lblDado3FalhasServ2.setVisible(false);
		txtDado3FalhasServ2.setVisible(false);
		
		//TEmFalha2
		lblDado1TEmFalhaServ2.setVisible(true);
		lblDado1TEmFalhaServ2.setText("Constante");
		txtDado1EmFalhaServ2.setEnabled(true);
		
		lblDuraoDaSimulao = new JLabel("<html><b><u> Duração da Simulação</u></b> (em seg):</html>");
		lblDuraoDaSimulao.setBounds(10, 646, 217, 14);
		frame.getContentPane().add(lblDuraoDaSimulao);
		
		txtDuracao = new JTextField();
		txtDuracao.setBounds(203, 643, 108, 20);
		frame.getContentPane().add(txtDuracao);
		txtDuracao.setColumns(10);
		
		JCheckBox chckbxPassoAPasso = new JCheckBox("Passo a Passo");
		chckbxPassoAPasso.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent arg0) {
				passoAPasso = !passoAPasso;
			}
		});
		chckbxPassoAPasso.setBounds(458, 612, 126, 23);
		frame.getContentPane().add(chckbxPassoAPasso);
		
		lblDado2TEmFalhaServ2.setVisible(false);
		txtDado2EmFalhaServ2.setVisible(false);
		
		lblDado3TEmFalhaServ2.setVisible(false);
		txtDado3EmFalhaServ2.setVisible(false);
		
	}
}
