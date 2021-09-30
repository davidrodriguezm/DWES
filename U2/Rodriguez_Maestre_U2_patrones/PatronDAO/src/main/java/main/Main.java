package main;

import java.util.List;

import model.Payment;
import dao.PaymentsDaoImplement;

public class Main {

	public static void main(String[] args) {
		boolean creado_1 = new PaymentsDaoImplement().createPayment(103, "Payment 1", "2006-10-19", 56383);
		System.out.println("¿Se ha creado el Payment 1? " + creado_1);
		
		boolean creado_2 = new PaymentsDaoImplement().createPayment(6, "Payment 2", "2005-10-19", 76485);
		System.out.println("¿Se ha creado el Payment 2? " + creado_2);
		
		List<Payment> lista_Payment = new PaymentsDaoImplement().getPayments();
		for( Payment p : lista_Payment ) {
			System.out.println(p);
		}
		
		
	}

}
