package org.iesalixar.drodriguezm.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.drodriguezm.model.Post;

public class PostDao extends GenericDAO<Post> {
	private Session session;

	public PostDao(Session session) {
		super(session);
		this.session = session;
	}
	
}
