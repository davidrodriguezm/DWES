package main;

public class FactoriaFigura {
	
	public static Figura getFigura(String tipo, String color) {
		Figura figura = null;
		if (tipo.equalsIgnoreCase("Circulo")) {
			figura  = new Circulo(color);
	 	} else if (tipo.equalsIgnoreCase("Triangulo")) {
	 		figura  = new Triangulo(color);
	 	} else if (tipo.equalsIgnoreCase("Rectangulo")) {
	 		figura  = new Rectangulo(color);
	 	} else if (tipo.equalsIgnoreCase("Cuadrado")) {
	 		figura  = new Cuadrado(color);
	 	}
		return figura ;
	}

}
