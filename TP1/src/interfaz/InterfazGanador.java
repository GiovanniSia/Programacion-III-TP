package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfazGanador extends JFrame {

	private JPanel panelGanador;
	private String jugador;
	private JLabel mensajeGanador;
	private JLabel tiempoGanador;
	private JButton botonSalir;
	private JButton botonMenu;
	private InterfazMenu interfazMenu;
	private JButton botonReinicio;
	InterfazTablero interfazTablero;
	
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

	public InterfazGanador(String jugador, String tiempo) {
		this.jugador = jugador;
		setTitle("Juegos Aritmeticos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		panelGanador = new JPanel();
		panelGanador.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelGanador);
		panelGanador.setLayout(null);
		panelGanador.setBackground(new Color(0, 128, 128));

		mensajeGanador = new JLabel("Ganaste" + " " + jugador + "!!!");
		mensajeGanador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		mensajeGanador.setForeground(Color.WHITE);
		mensajeGanador.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeGanador.setBounds(10, 67, 414, 73);
		panelGanador.add(mensajeGanador);

		tiempoGanador = new JLabel("Tiempo: " + tiempo);
		tiempoGanador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		tiempoGanador.setForeground(Color.WHITE);
		tiempoGanador.setHorizontalAlignment(SwingConstants.CENTER);
		tiempoGanador.setBounds(10, 97, 414, 73);
		panelGanador.add(tiempoGanador);

		botonSalir = new JButton("Salir");
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		botonSalir.setBounds(72, 197, 89, 23);
		panelGanador.add(botonSalir);

		botonMenu = new JButton("Ir al Menu");
		botonMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				interfazMenu = new InterfazMenu();
				setVisible(false);
				interfazMenu.setVisible(true);

			}
		});
		botonMenu.setBounds(171, 197, 89, 23);
		panelGanador.add(botonMenu);

		botonReinicio = new JButton("Reiniciar");
		botonReinicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				interfazTablero = new InterfazTablero(jugador);
				setVisible(false);
				interfazTablero.setVisible(true);

			}
		});
		botonReinicio.setBounds(270, 197, 89, 23);
		panelGanador.add(botonReinicio);
	}
}
