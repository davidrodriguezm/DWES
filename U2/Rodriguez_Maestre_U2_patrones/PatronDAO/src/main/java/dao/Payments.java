package dao;

import java.util.List;

import model.Payment;

public interface Payments {
	
	public boolean createPayment(int customerNumber, String checkNumber, String paymentDate, float amount);
	
	public List<Payment> getPayments();

}
