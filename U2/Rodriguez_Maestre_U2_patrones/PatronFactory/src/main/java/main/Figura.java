package main;

public abstract class Figura {
	private String color;
	
	public Figura(String color) {
		this.color = color;
	}

	public abstract String dibujarFiguar();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Figura [color=" + color + "]";
	}

}
