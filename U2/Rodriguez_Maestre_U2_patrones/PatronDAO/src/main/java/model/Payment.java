package model;

public class Payment {
	private int customerNumber;
	private String checkNumber;
	private String paymentDate;
	private float amount;
	
	public Payment(int customerNumber, String checkNumber, String paymentDate, float amount) {
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public Payment() {
	}

	@Override
	public String toString() {
		return "Payment [customerNumber=" + customerNumber + ", checkNumber=" + checkNumber + ", paymentDate="
				+ paymentDate + ", amount=" + amount + "]";
	}
	
}
