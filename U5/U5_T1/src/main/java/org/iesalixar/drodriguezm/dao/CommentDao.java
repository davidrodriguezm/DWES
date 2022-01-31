package org.iesalixar.drodriguezm.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.drodriguezm.model.Comment;

public class CommentDao extends GenericDAO<Comment> {
	private Session session;

	public CommentDao(Session session) {
		super(session);
		this.session = session;
	}
	
	
	public List<Comment> searchByPalabra(String palabra) {
		List<Comment> comments = null;
		
		if (!session.getTransaction().isActive()) session.getTransaction().begin();

		comments = session.createQuery("FROM Comment c WHERE c.content Like :palabra ")
				.setParameter("palabra", "%" + palabra + "%")
				.list();
		
		return comments;
	}
}
