package main;

public class Main {

	public static void main(String[] args) {
		Casa casa_1 = new Casa(78, new Tejado(),new Pared(3),new Pared(3),				
				new Pared(3),new Pared(3));
		casa_1.getTejado().darSoporte();
		System.out.println(casa_1);
		
		Casa casa_2 = new Casa(89, new TejadoTejas(),new Pared(4),new Pared(4),				
				new Pared(4),new Pared(4));
		casa_2.getTejado().darSoporte();
		System.out.println(casa_2);
		
	}

}
