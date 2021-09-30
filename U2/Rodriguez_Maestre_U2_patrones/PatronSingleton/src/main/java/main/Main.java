package main;

public class Main {

	public static void main(String[] args) {
		Presidente presi_1= Presidente.getPresidente("Ordo","Piesverdes Anacleto","2021");
		System.out.println(presi_1);
		
		Presidente presi_2= Presidente.getPresidente("Amparo","Castaño Oscuro","2032");
		System.out.println(presi_2);
		
		System.out.println("¿Son la misma istancia presi_1 y presi_2? " + presi_1.equals(presi_2));
	}

}
