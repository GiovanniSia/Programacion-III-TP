package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InterfazMenu extends JFrame {
	private JButton botonInicio, botonPuntaje;
	private JPanel panelMenu;
	private JTextField jugador;
	private JLabel titulo;
	private InterfazPuntaje interfazPuntaje;
	private InterfazTablero interfazTablero;
	
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

	public InterfazMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Juegos Aritmeticos");

		panelMenu = new JPanel();
		panelMenu.setSize(getWidth(), getHeight());
		panelMenu.setLayout(null);
		panelMenu.setBackground(new Color(0, 128, 128));
		getContentPane().add(panelMenu);

		titulo = new JLabel("Juegos Aritmeticos");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(getWidth() / 4, 50, 181, 25);
		panelMenu.add(titulo);

		jugador = new JTextField("Ingrese nombre");
		jugador.setForeground(Color.BLACK);
		jugador.setHorizontalAlignment(SwingConstants.CENTER);
		jugador.setBounds(getWidth() / 5, getHeight() / 3, 200, 30);
		jugador.setVisible(true);
		panelMenu.add(jugador);

		botonInicio = new JButton("Inicio");
		botonInicio.setBounds(getWidth() / 5, getHeight() / 2, 200, 30);
		botonInicio.setBackground(Color.white);
		botonInicio.setVisible(true);
		panelMenu.add(botonInicio);

		botonInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				interfazTablero = new InterfazTablero(jugador.getText());
				interfazTablero.setVisible(true);
			}
		});
		botonPuntaje = new JButton("Puntaje");
		botonPuntaje.setBackground(Color.WHITE);
		botonPuntaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
				interfazPuntaje = new InterfazPuntaje();
				interfazPuntaje.setVisible(true);

			}
		});
		botonPuntaje.setBounds(getWidth() / 5, 220, 200, 30);
		panelMenu.add(botonPuntaje);

	}

	public String getJugador() {
		return jugador.getText();
	}

}
