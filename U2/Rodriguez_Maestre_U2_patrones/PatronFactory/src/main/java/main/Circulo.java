package main;

public class Circulo extends Figura {
	
	public Circulo(String color) {
		super(color);
	}

	@Override
	public String dibujarFiguar() {
		return "Circulo dibujado";
	}

	@Override
	public String toString() {
		return "Circulo [color=" + getColor() + "+]";
	}

}
