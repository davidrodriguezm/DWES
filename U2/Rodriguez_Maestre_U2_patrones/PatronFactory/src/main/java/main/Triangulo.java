package main;

public class Triangulo extends Figura {

	public Triangulo(String color) {
		super(color);
	}

	@Override
	public String dibujarFiguar() {
		return "Triangulo dibujado";
	}

	@Override
	public String toString() {
		return "Triangulo [color=" + getColor() + "+]";
	}

}
