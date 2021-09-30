package main;

public class Cuadrado extends Figura {

	public Cuadrado(String color) {
		super(color);
	}

	@Override
	public String dibujarFiguar() {
		return "Cuadrado dibujado";
	}

	@Override
	public String toString() {
		return "Cuadrado [color=" + getColor() + "+]";
	}

}
