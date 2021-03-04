package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import logica.Cronometro;
import logica.Puntaje;
import logica.Tablero;

public class InterfazTablero extends JFrame {

	private JLabel tiempoJuego, tiempoTexto, instruccionesTitulo, instrucciones, JLabelCasilla[][];
	private Tablero tablero;
	private Timer t;
	private Cronometro cronometro;
	private JPanel tableroJuego;
	private String jugador;
	private int coordJuegoX;
	private int coordJuegoY;
	private InterfazGanador interfazGanador;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazMenu frame = new InterfazMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazTablero(String usuario) {
		coordJuegoX = 550;
		coordJuegoY = 600;
		cronometro = new Cronometro();

		jugador = usuario;
		
		setTitle("Juegos Aritmeticos");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, coordJuegoX, coordJuegoY);
		getContentPane().setBackground(Color.gray);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		tiempoTexto = new JLabel("Tiempo");
		tiempoTexto.setForeground(Color.WHITE);
		tiempoTexto.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tiempoTexto.setHorizontalAlignment(SwingConstants.CENTER);

		tiempoTexto.setBounds(175, 0, 190, 40);

		tiempoTexto.setVisible(true);
		getContentPane().add(tiempoTexto);

		tiempoJuego = new JLabel("");
		tiempoJuego.setForeground(Color.WHITE);
		tiempoJuego.setFont(new Font("Arial", Font.PLAIN, 30));
		tiempoJuego.setHorizontalAlignment(SwingConstants.CENTER);

		tiempoJuego.setBounds(175, 50, 190, 40);

		tiempoJuego.setVisible(true);
		getContentPane().add(tiempoJuego);

		instruccionesTitulo = new JLabel("Instrucciones del Juego");
		instruccionesTitulo.setForeground(Color.WHITE);
		instruccionesTitulo.setFont(new Font("Arial", Font.PLAIN, 18));
		instruccionesTitulo.setHorizontalAlignment(SwingConstants.LEADING);

		instruccionesTitulo.setBounds(0, 350, coordJuegoX, 300);

		instruccionesTitulo.setVisible(true);
		getContentPane().add(instruccionesTitulo);

		instrucciones = new JLabel("Click izquierdo: Agrandar numero || Click derecho: Achicar numero");
		instrucciones.setForeground(Color.WHITE);
		instrucciones.setFont(new Font("Arial", Font.PLAIN, 16));
		instrucciones.setHorizontalAlignment(SwingConstants.LEADING);

		instrucciones.setBounds(0, 380, coordJuegoX, 300);

		instrucciones.setVisible(true);
		getContentPane().add(instrucciones);

		t = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cronometro.sumarTiempo();
				tiempoJuego.setText(cronometro.getDatos());
			}
		});
		// Se crea el tablero con su respectivo tamanio 
		tablero = new Tablero(4);

		tablero.valoresDefinidos();

		JLabelCasilla = new JLabel[tablero.getTamanio() + 1][tablero.getTamanio() + 1];

		// Contiene a las celdas
		tableroJuego = new JPanel();
		tableroJuego.setBackground(Color.BLACK); // Color de las lineas del tablero

		tableroJuego.setBounds(coordJuegoX / 2 - tablero.getTamanio() * 30, coordJuegoY / 4,
				44 * ((tablero.getTamanio() + 1)), 44 * (tablero.getTamanio() + 1));

		tableroJuego.setLayout(null);
		tableroJuego.setVisible(true);
		getContentPane().add(tableroJuego);

		for (int f = 0; f < JLabelCasilla.length; f++) {
			for (int c = 0; c < JLabelCasilla.length; c++) {
				t.start();
				JLabelCasilla[f][c] = new JLabel("");
				JLabelCasilla[f][c].addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						for (int f = 0; f < JLabelCasilla.length - 1; f++) {
							for (int c = 0; c < JLabelCasilla.length - 1; c++) {
								if (e.getSource() == JLabelCasilla[f][c]) {
									manejoValorCasilla(f, c, e.getModifiersEx());
									if (tablero.gano()) {
										Puntaje.registrarPuntaje(jugador + " - " + cronometro.getDatos());
										interfazGanador = new InterfazGanador(jugador,cronometro.getDatos());
										dispose();
										interfazGanador.setVisible(true);
									}
								}
							}
						}
					}
				});

				// No entra la ultima casilla
				if (!(f == tablero.getTamanio() && c == tablero.getTamanio())) {

					JLabelCasilla[f][c].setOpaque(true);
					// Separo las casilla donde juega el usuario con las que tiene el valor a
					// conseguir
					if (f == tablero.getTamanio() || c == tablero.getTamanio()) {
						JLabelCasilla[f][c].setBackground(Color.CYAN); // Color de las soluciones
						JLabelCasilla[f][c].setText(tablero.valorDefinido(f, c));
					} else {
						JLabelCasilla[f][c].setBackground(Color.WHITE); // Color del tablero
					}

					JLabelCasilla[f][c].setHorizontalAlignment(SwingConstants.CENTER);
					JLabelCasilla[f][c].setFont(new Font("Tahoma", Font.BOLD, 24));
					JLabelCasilla[f][c].setBounds(0 + 45 * f, 0 + 45 * c, 40, 40);
					tableroJuego.add(JLabelCasilla[f][c]);

				}

			}
		}
	}

	private void manejoValorCasilla(int f, int c, int click) {
		// Click iquierdo
		if (click == 1024) {
			if (tablero.getValorCasilla(f, c) == 9) {
				JLabelCasilla[f][c].setText("" + (tablero.setValorCasilla(f, c, 1)));
			} else {
				tablero.sumarCasilla(f, c);
				JLabelCasilla[f][c].setText("" + (tablero.getValorCasilla(f, c)));
			}
		}
		// Click derecho
		if (click == 4096) {
			if (tablero.getValorCasilla(f, c) == 1 || tablero.getValorCasilla(f, c) == 0) {
				JLabelCasilla[f][c].setText("" + (tablero.setValorCasilla(f, c, 9)));
			} else {
				tablero.restarCasilla(f, c);
				JLabelCasilla[f][c].setText("" + (tablero.getValorCasilla(f, c)));
			}
		}

	}

}
