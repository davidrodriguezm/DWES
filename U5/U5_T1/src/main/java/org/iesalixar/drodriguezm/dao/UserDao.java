package org.iesalixar.drodriguezm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.iesalixar.drodriguezm.model.User;

public class UserDao extends GenericDAO<User> {
	private Session session;

	public UserDao(Session session) {
		super(session);
		this.session = session;
	}
	
	
	public List<User> searchByUserNameOrEmail(String userName, String email) {
		List<User> userList = null;
		
		if (!session.getTransaction().isActive()) session.getTransaction().begin();

		Criteria cr = session.createCriteria(User.class);
		
		Criterion first = Restrictions.eq("userName", userName); 
		Criterion last = Restrictions.eq("email", email);
		LogicalExpression andExp = Restrictions.or(first,last);
		cr.add(andExp);
		
		userList = cr.list();		
		

		return userList;
	}
}
