package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Puntaje;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class InterfazPuntaje extends JFrame {

	private JPanel panelPuntaje;
	private JLabel tituloPuntaje;
	private JLabel puntaje1;
	private JLabel puntaje2;
	private JLabel puntaje3;
	private JLabel puntaje4; 
	private JButton botonMenu;
	private InterfazMenu interfazMenu;
	
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

	public InterfazPuntaje() {
		setTitle("Juegos Aritmeticos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		setLocationRelativeTo(null);
		panelPuntaje = new JPanel();
		panelPuntaje.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPuntaje);
		panelPuntaje.setLayout(null);
		panelPuntaje.setBackground(new Color(0,128,128));
		
		tituloPuntaje = new JLabel("Puntaje");
		tituloPuntaje.setForeground(Color.WHITE);
		tituloPuntaje.setFont(new Font("Tahoma", Font.BOLD, 18));
		tituloPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPuntaje.setBounds(74, 11, 178, 35);
		panelPuntaje.add(tituloPuntaje);
		
		puntaje1 = new JLabel(Puntaje.leerPuntaje().get(0));
		puntaje1.setBackground(Color.WHITE);
		puntaje1.setForeground(Color.WHITE);
		puntaje1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		puntaje1.setBounds(74, 57, 178, 14);
		panelPuntaje.add(puntaje1);
		
		puntaje2 = new JLabel(Puntaje.leerPuntaje().get(1));
		puntaje2.setForeground(Color.WHITE);
		puntaje2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		puntaje2.setBounds(74, 94, 178, 14);
		panelPuntaje.add(puntaje2);
		
		puntaje3 = new JLabel(Puntaje.leerPuntaje().get(2));
		puntaje3.setForeground(Color.WHITE);
		puntaje3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		puntaje3.setBounds(74, 134, 178, 14);
		panelPuntaje.add(puntaje3);
		
		puntaje4 = new JLabel(Puntaje.leerPuntaje().get(3));
		puntaje4.setForeground(Color.WHITE);
		puntaje4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		puntaje4.setBounds(74, 172, 178, 14);
		panelPuntaje.add(puntaje4);
		
		botonMenu = new JButton("Ir al menu");
		botonMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
				interfazMenu=new InterfazMenu();
				interfazMenu.setVisible(true);
			
			}
		});
		botonMenu.setBounds(96, 222, 145, 23);
		panelPuntaje.add(botonMenu);
	}
}
