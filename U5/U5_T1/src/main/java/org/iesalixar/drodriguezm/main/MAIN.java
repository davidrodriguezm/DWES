package org.iesalixar.drodriguezm.main;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.drodriguezm.db.HibernateUtils;
import org.iesalixar.drodriguezm.service.*;
import org.iesalixar.drodriguezm.model.*;

public class MAIN {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		UserService userService = new UserService(session);
		PostService postService = new PostService(session);
		CommentService commentService = new CommentService(session);
		
// Inserción de 2 usuarios,5 posts, 3 comentarios y 10 valoraciones.
		
		Post post1 = new Post("post1", "Verde", Post.dateFactory(2021, 12, 5));
		Post post2 = new Post("post2", "Rojo", Post.dateFactory(2020, 10, 11));
		Post post3 = new Post("post3", "Violeta", Post.dateFactory(2022, 6, 6));
		Post post4 = new Post("post4", "Amarillo", Post.dateFactory(2021, 8, 25));
		Post post5 = new Post("post5", "Azul", Post.dateFactory(2022, 2, 15));
		
		postService.insertNewPost(post1);
		postService.insertNewPost(post2);
		postService.insertNewPost(post3);
		postService.insertNewPost(post4);
		postService.insertNewPost(post5);

		
		User user1 = new User("Ansiro","8gd655h","Ansio","Litico","Ansi@hotmil.com");
		User user2 = new User("Ordorio","56hfjt","Ordo","Garga","Ordo@hotmil.com");
		
		userService.insertNewUser(user1);
		userService.insertNewUser(user2);

		
		Comment comment1 = new Comment("Me aburro","No se que poner, Algo");
		Comment comment2 = new Comment("Lo que sea","Algo mas");
		Comment comment3 = new Comment("No se que","Sigo sin saberlo");
		
		commentService.insertNewComment(comment1);
		commentService.insertNewComment(comment2);
		commentService.insertNewComment(comment3);
		
		
		user1.addPost(post1, 1);
		user2.addPost(post2, 2);
		user1.addPost(post3, 3);
		user2.addPost(post4, 4);
		user1.addPost(post5, 5);
		user2.addPost(post1, 6);
		user2.addPost(post2, 7);
		user1.addPost(post3, 8);
		user1.addPost(post4, 9);
		user1.addPost(post5, 10);
		
		userService.updateUser(user1);
		userService.updateUser(user2);
		
		
		post1.addComment(comment1);
		post2.addComment(comment2);
		

		postService.updatePost(post1);
		postService.updatePost(post2);
		
		
		user1.addComment(comment1);
		user2.addComment(comment2);
		
		userService.updateUser(user1);
		userService.updateUser(user2);

		
// Utilización de una función de modificiación para un usuario y una de borrado de un comentario.
		
		user2.setLastName("Otro apellido");		
		userService.updateUser(user2);
		
		
		commentService.deleteComment(comment3);

		
// Búsqueda de comentarios que contenga una palabra determinada (con HQL)
		
		List<Comment> comments = commentService.searchByPalabra("Algo");
		
		for (Comment comment : comments ) System.out.println(comment);
		
		
// Búsqueda de todos los usuarios con un usuario o un email determinado
		
		List<User> users = userService.searchByUserNameOrEmail("Ansiro","Ordo@hotmil.com");
				
		for (User user : users ) System.out.println(user);
		
		
		session.close();	
	}
}
