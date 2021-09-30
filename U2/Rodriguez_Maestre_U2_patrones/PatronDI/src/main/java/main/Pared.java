package main;

public class Pared {
	private int altura;

	public Pared(int altura) {
		this.altura = altura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Pared [altura=" + altura + "]";
	}	
	
}
