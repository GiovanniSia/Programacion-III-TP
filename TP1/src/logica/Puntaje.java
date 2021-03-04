package logica;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Puntaje {
	public static ArrayList<String> leerPuntaje() {
		try {
			ArrayList<String> ret = new ArrayList<String>();
			FileInputStream fis = new FileInputStream("puntaje.txt");
			Scanner scanner = new Scanner(fis);

			while (scanner.hasNext()) {
				ret.add(scanner.nextLine());
			}
			scanner.close();
			return ret;

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	public static void registrarPuntaje(String datos) {
		try {
			ArrayList<String> puntajes = new ArrayList<String>();
			String ret = "";
			int cont = 0;
			FileInputStream fis = new FileInputStream("puntaje.txt");
			Scanner scanner = new Scanner(fis);

			FileOutputStream fos = new FileOutputStream("puntaje.txt", true);
			OutputStreamWriter out = new OutputStreamWriter(fos);

			while (scanner.hasNext() && cont!=4) {
				puntajes.add(scanner.nextLine());
				cont++;
			}
			if (cont==4) {
				String aux0=puntajes.get(0);
				String aux1=puntajes.get(1);
				String aux2=puntajes.get(2);
				String aux3=puntajes.get(3);
			
				puntajes.set(0, datos);
				puntajes.set(1, aux0);
				puntajes.set(2, aux1);
				puntajes.set(3, aux2);
					
			}
			else {
				puntajes.add(datos);				
			}

			for (String s : puntajes) {
				ret = ret + s + "\n";
			}
			if (puntajes.size() != 1) {
				limpiarArchivo("puntaje.txt");
			}

			out.write(ret);
			out.flush();
			out.close();

			scanner.close();

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private static void limpiarArchivo(String archivo) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(archivo));
			bw.write("");
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}