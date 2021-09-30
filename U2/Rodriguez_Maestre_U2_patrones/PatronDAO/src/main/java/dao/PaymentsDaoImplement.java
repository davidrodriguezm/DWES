package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Payment;

public class PaymentsDaoImplement implements Payments {

	public boolean createPayment(int customerNumber, String checkNumber, String paymentDate, float amount) {
		boolean creado = false;
		Connection conex = DBConnection.getConnecttion();
		try {
			String busqueda = "SELECT * FROM customers where customerNumber= ?;";
			PreparedStatement consulta = conex.prepareStatement(busqueda);
			consulta.setInt(1, customerNumber);
	        consulta.setQueryTimeout(30);
	        ResultSet resultado = consulta.executeQuery();
	        if (resultado.next()) {
	        	busqueda = "INSERT INTO payments VALUES(?, ?, ?, ?);";
				consulta = conex.prepareStatement(busqueda);
				consulta.setInt(1, customerNumber);
				consulta.setString(2, checkNumber);
				consulta.setString(3, paymentDate);
				consulta.setFloat(4, amount);
				consulta.executeQuery();
	        	creado = true;	
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	DBConnection.close();
	    }
		
		return creado;
	}

	public List<Payment> getPayments() {
		List<Payment> lista_Payment = new ArrayList<Payment>();
		Connection conex = DBConnection.getConnecttion();
		try {
			String busqueda = "SELECT * FROM payments;";
			PreparedStatement consultas = conex.prepareStatement(busqueda);
	        consultas.setQueryTimeout(30);
	        ResultSet resultado = consultas.executeQuery();
	        Payment payment = null;
	        while ( resultado.next() ) {
	        	payment = new Payment(resultado.getInt("customerNumber"),
	        			resultado.getString("checkNumber"),resultado.getString("paymentDate"), 
	        			resultado.getFloat("amount"));
	        	lista_Payment.add(payment);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	DBConnection.close();
	    }
		return lista_Payment;
	}

}
