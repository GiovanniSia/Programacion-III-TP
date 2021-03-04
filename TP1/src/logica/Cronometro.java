package logica;

public class Cronometro {
	private int h;
	private int m;
	private int s;
	private int cs;
	private String datos;

	public Cronometro() {
		h = 0;
		m = 0;
		s = 0;
		cs = 0;
		datos = "";
	}

	public void sumarTiempo() {
		cs++;
		if (cs == 100) {
			cs = 0;
			s++;
		}
		if (s == 60) {
			s = 0;
			m++;
		}
		if (m == 60) {
			m = 0;
			h++;
		}
		actualizarDatos(h, m, s, cs);
	}

	private void actualizarDatos(int h, int m, int s, int cs) {
		datos = (h <= 9 ? "0" : "") + h + ":" + (m <= 9 ? "0" : "") + m + ":" + (s <= 9 ? "0" : "") + s + ":"
				+ (cs <= 9 ? "0" : "") + cs;
	}

	public String getDatos() {
		return datos;
	}
}
