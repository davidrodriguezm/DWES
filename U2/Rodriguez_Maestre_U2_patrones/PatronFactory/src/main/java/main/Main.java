package main;


public class Main {

	public static void main(String[] args) {
		Figura figura_1 = FactoriaFigura.getFigura("Circulo","verde");
		System.out.println(figura_1.getColor() + ": " + figura_1.dibujarFiguar());
		
		Figura figura_2 = FactoriaFigura.getFigura("Triangulo","azul");
		System.out.println(figura_2.getColor() + ": " + figura_2.dibujarFiguar());
		
		Figura figura_3 = FactoriaFigura.getFigura("Rectangulo","rojo");
		System.out.println(figura_3.getColor() + ": " + figura_3.dibujarFiguar());
		
		Figura figura_4 = FactoriaFigura.getFigura("Cuadrado","amarillo");
		System.out.println(figura_4.getColor() + ": " + figura_4.dibujarFiguar());
		
	}

}
