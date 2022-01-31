package org.iesalixar.drodriguezm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "userName", nullable = false, unique = true)
    private String userName;
	
	@Column(name = "password", nullable = false)
    private String password;
	
	@Column(name = "firstName", nullable = false)
    private String firstName;
    
	@Column(name = "lastName", nullable = false)
    private String lastName;
	
	@Column(name = "email", nullable = false)
    private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Valorar> valorar = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();
	
	public User() {
		super();
	}
	
	public User(String userName, String password, String firstName, String lastName, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Valorar> getValorar() {
		return valorar;
	}

	public void setValorar(Set<Valorar> valorar) {
		this.valorar = valorar;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void addPost(Post vehiculo, Integer puntuacion) {
		Valorar proPost = new Valorar(this, vehiculo, puntuacion);
		this.valorar.add(proPost);
		vehiculo.getValorar().add(proPost);
	}

	public void removePost(Post post) {
		Valorar valorar = new Valorar(this, post);
		this.valorar.remove(valorar);
		post.getValorar().remove(valorar);
	}
	
	public void addComment(Comment comments) {
		this.comments.add(comments);
		comments.setUser(this);
	}
	
	public void removeComment(Comment comments) {
		this.comments.remove(comments);
		comments.setUser(null);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userName, other.userName) || Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}
}
