package org.iesalixar.drodriguezm.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.drodriguezm.model.Comment;
import org.iesalixar.drodriguezm.dao.CommentDao;

public class CommentService {
	private CommentDao commentDao;

	public CommentService(final Session session) {
		this.commentDao = new CommentDao(session);
	}

	public void insertNewComment(Comment comment) {
		if (comment != null && comment.getId() == null) commentDao.insert(comment);
	}

	public void updateComment(Comment comment) {
		if (comment != null && comment.getId() != null) commentDao.update(comment);
	}

	public void deleteComment(Comment comment) {
		if (comment != null && comment.getId() != null) commentDao.delete(comment);
	}

	public Comment searchById(Long commentId) {
		Comment comment = null;
		if (commentId != null) comment = commentDao.searchById(commentId);		
		return comment;
	}

	public List<Comment> searchAll() {		
		List<Comment> commentList = new ArrayList<Comment>();
		commentList = commentDao.searchAll();
		return commentList;
	}
	
	public List<Comment> searchByPalabra(String palabra) {		
		List<Comment> comments = null;
		if (palabra != null) comments = commentDao.searchByPalabra(palabra);	
		return comments;
	}
}
