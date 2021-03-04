package logica;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Tablero {
	private int casilla[][];
	private int valores_filas[];
	private int valores_columnas[];

	public Tablero(int tamanio) {
		casilla = new int[tamanio][tamanio];

		valores_filas = new int[casilla.length];
		valores_columnas = new int[casilla.length];

	}

	// Valores que el jugador tiene que conseguir para ganar
	public void valoresDefinidos() {
		// crea un tablero y llena las casillas con numeros random del 1 al 9
		Tablero tablero = new Tablero(casilla.length);
		for (int i = 0; i < tablero.casilla.length; i++) {
			for (int j = 0; j < tablero.casilla.length; j++) {
				int valor = ThreadLocalRandom.current().nextInt(1, 10);
				tablero.setValorCasilla(i, j, valor);
			}
		}
		// suma las casillas de cada fila y guarda los resultados en la lista de valores
		// definidos para las filas
		for (int i = 0; i < tablero.casilla.length; i++) {
			int suma = 0;
			for (int j = 0; j < tablero.casilla.length; j++) {
				suma = suma + tablero.casilla[j][i];
			}
			setValorListaColumna(i, suma);
		}

		// suma las casillas de cada columna y guarda los resultados en la lista de
		// valores definidos para las columnas
		for (int i = 0; i < tablero.casilla.length; i++) {
			int suma = 0;
			for (int j = 0; j < tablero.casilla.length; j++) {
				suma = suma + tablero.casilla[i][j];
			}
			setValorListaFila(i, suma);
		}

	}

	public String valorDefinido(int f, int c) {
		if (f == getTamanio()) {
			return "" + getValorListaFila(c);

		}
		if (c == getTamanio()) {
			return "" + getValorListaColumna(f);
		}
		return "";
	}

	// Los valores tanto de filas como columna sumas lo mismo que los
	// valoresDefinidos
	public boolean gano() {
		boolean gano = true;
		for (int f = 0; f < casilla.length; f++) {
			int suma = 0;
			for (int c = 0; c < casilla.length; c++) {
				suma = suma + casilla[c][f];
			}
			if (suma != getValorListaFila(f)) {
				gano = false;
			}
		}

		for (int f = 0; f < casilla.length; f++) {
			int suma = 0;
			for (int c = 0; c < casilla.length; c++) {
				suma = suma + casilla[f][c];
			}
			if (suma != getValorListaColumna(f)) {
				gano = false;
			}
		}
		return gano;
	}

	public int getTamanio() {
		return casilla.length;
	}

	public int getValorCasilla(int f, int c) {
		return casilla[f][c];
	}

	public int setValorCasilla(int f, int c, int valor) {
		return casilla[f][c] = valor;
	}

	public int sumarCasilla(int f, int c) {
		return casilla[f][c]++;
	}

	public int restarCasilla(int f, int c) {
		return casilla[f][c]--;
	}

	public int getValorListaFila(int f) {
		return valores_filas[f];
	}

	public int getValorListaColumna(int c) {
		return valores_columnas[c];
	}

	public int setValorListaFila(int f, int valor) {
		return valores_filas[f] = valor;
	}

	public int setValorListaColumna(int c, int valor) {
		return valores_columnas[c] = valor;
	}
}
