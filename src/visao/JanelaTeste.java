package visao;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Estatisticas;
import model.Relogio;

public class JanelaTeste {

	private JFrame frame;
	private volatile boolean pause;
	private long delay;

	private JLabel lblSpeed;
	private JSlider slider;
	private JLabel lblPrint;
	private JLabel lblNewLabel;
	private JButton btnPausarcontinuar;
	private Estatisticas e;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaTeste window = new JanelaTeste();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaTeste() {
		initialize();
	}

	public void atualiza() {
		String txt = atualizaEstatisticas();
		String txtPt2 = atualizaEstatisticasPt2();
		lblNewLabel.setText(txtPt2);
		lblPrint.setText(txt);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame("Simulação"));
		pause = false;
		delay = 1000;
		e = Estatisticas.getInstance();
		getFrame().setResizable(false);
		getFrame().setBounds(100, 100, 800, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		String txt = atualizaEstatisticas();
		String txtPt2 = atualizaEstatisticasPt2();

		lblSpeed = new JLabel("Delay = 1000ms");
		lblSpeed.setBounds(10, 208, 130, 14);
		getFrame().getContentPane().add(lblSpeed);

		slider = new JSlider();
		slider.setMajorTickSpacing(100);
		slider.setMaximum(1000);
		slider.setMinimum(0);
		slider.setValue(1000);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				delay = slider.getValue();
				lblSpeed.setText("Delay = " + delay + "ms");
			}
		});
		slider.setBounds(0, 233, 200, 26);
		getFrame().getContentPane().add(slider);

		lblPrint = new JLabel(txt);
		lblPrint.setBounds(10, 11, 354, 200);
		getFrame().getContentPane().add(lblPrint);

		lblNewLabel = new JLabel(txtPt2);
		lblNewLabel.setBounds(374, 11, 400, 200);
		getFrame().getContentPane().add(lblNewLabel);

		btnPausarcontinuar = new JButton("Pausar / Continuar");
		btnPausarcontinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pause = !pause;
				if (pause) {
					lblSpeed.setText("PAUSADO");
				} else {
					lblSpeed.setText("Delay = " + slider.getValue() + "ms");
				}
				slider.setEnabled(!pause);
			}
		});
		btnPausarcontinuar.setBounds(374, 233, 150, 23);
		getFrame().getContentPane().add(btnPausarcontinuar);
	}

	private String atualizaEstatisticas() {
		String txt = "<html>";

		txt += "Entidades Tipo1				 = " + e.getNumeroEntidadesTipo1() + "<br>";

		txt += "Entidades Total               = " + e.getNumeroEntidades() + "<br>";

		txt += "Entidades Saida Tipo1         = " + e.getNumeroEntidadesSaidaTipo1() + "<br>";

		txt += "Num Falhas Serv1              = " + e.getNumeroFalhasServ1() + "<br>";

		txt += "Num Falhas Serv2              = " + e.getnumeroFalhasServ2() + "<br>";

		txt += "Num Medio Entidades Fila 1    = " + e.getNumeroMedioDeEntidadeFila1() + "<br>";

		txt += "Num Medio Entidades em Filas  = " + e.getNumeroMedioDeEntidadeFilas() + "<br>";

		txt += "Taxa Media de Ocupação Serv2  = " + e.getTaxaMediaOcupacaoDoServidor2() + "<br>";

		txt += "Tempo Medio No Sistema Tipo1  = " + e.getTempoMedioNoSistemaTipo1() + " seg<br>";

		txt += "Tempo Medio No Sistema Total  = " + e.getTempoMedioNoSistemaTotal() + " seg<br>";

		txt += "Tempo Medio Entidade em Fila Serv2 = "+ e.getTempoMedioEntidadeNaFilaServ2()+" seg<br>";
		
		return txt;
	}

	private String atualizaEstatisticasPt2() {
		String txt2 = "<html>";
		txt2 += "Entidades Tipo2                     = " + e.getNumeroEntidadesTipo2() + "<br>";
		txt2 += "Entidades Saida Total               = " + e.getNumeroEntidadesSaida() + "<br>";
		txt2 += "Entidades Saida Tipo2               = " + e.getNumeroEntidadesSaidaTipo2() + "<br>";
		txt2 += "Porcentagem do Tempo em Falha Serv1 = " + e.getPercentTempoEmFalhaServ1() + "<br>";
		txt2 += "Porcentagem do Tempo em Falha Serv2 = " + e.getPercentTempoEmFalhaServ2() + "<br>";
		txt2 += "Num Medio Entidades Fila 2          = " + e.getNumeroMedioDeEntidadeFila2() + "<br>";
		txt2 += "Taxa Media de Ocupação Serv1        = " + e.getTaxaMediaOcupacaoDoServidor1() + "<br>";
		txt2 += "Num Trocas                          = " + e.getnumeroTrocas() + "<br>";
		txt2 += "Tempo Medio No Sistema Tipo2        = " + e.getTempoMedioNoSistemaTipo2() + " seg<br>";
		txt2 += "Tempo Medio Entidades em Fila Serv1 = " + e.getTempoMedioEntidadeNaFilaServ1() + " seg<br>";
		txt2 += "Tempo Medio Entidades em Fila Total = " + e.getTempoMedioEntidadeNaFilaTotal() + " seg<br>";
		txt2 += "Tempo Atual = "+ Relogio.getInstance().getTempo().getEmSegundos() +" seg</html>";
		return txt2;
	}

	public long getDelay() {
		return delay;
	}

	public boolean getPause() {
		return pause;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setPause() {
		this.pause = !pause;
	}
}
