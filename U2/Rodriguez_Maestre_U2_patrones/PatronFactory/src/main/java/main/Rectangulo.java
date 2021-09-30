package main;

public class Rectangulo extends Figura {

	public Rectangulo(String color) {
		super(color);
	}

	@Override
	public String dibujarFiguar() {
		return "Rectangulo dibujado";
	}

	@Override
	public String toString() {
		return "Rectangulo [color=" + getColor() + "+]";
	}

}
