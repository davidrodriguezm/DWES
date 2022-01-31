package org.iesalixar.drodriguezm.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.drodriguezm.model.Post;
import org.iesalixar.drodriguezm.dao.PostDao;

public class PostService {
	private PostDao postDao;

	public PostService(final Session session) {
		this.postDao = new PostDao(session);
	}

	public void insertNewPost(Post post) {
		if (post != null && post.getId() == null) postDao.insert(post);
	}

	public void updatePost(Post post) {
		if (post != null && post.getId() != null) postDao.update(post);
	}

	public void deletePost(Post post) {
		if (post != null && post.getId() != null) postDao.delete(post);
	}

	public Post searchById(Long postId) {
		Post post = null;
		if (postId != null) post = postDao.searchById(postId);		
		return post;
	}

	public List<Post> searchAll() {		
		List<Post> postList = new ArrayList<Post>();
		postList = postDao.searchAll();
		return postList;
	}
	
}
