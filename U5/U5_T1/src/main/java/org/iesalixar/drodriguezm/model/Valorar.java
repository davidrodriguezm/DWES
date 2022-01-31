package org.iesalixar.drodriguezm.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@IdClass(ValorarId.class)
public class Valorar implements Serializable {	
	@Id
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "post_id", insertable = false, updatable = false)
	private Post post;
		
	@Column(name = "puntuacion", nullable = false)
    private Integer puntuacion;	
		
	public Valorar() {
		super();
	}

	public Valorar(User user, Post post) {
		super();
		this.post = post;
		this.user = user;
	}

	public Valorar(User user, Post post, Integer puntuacion) {
		super();
		this.post = post;
		this.user = user;
		this.puntuacion = puntuacion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, post);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valorar other = (Valorar) obj;
		return Objects.equals(user, other.user) && Objects.equals(post, other.post);
	}

	@Override
	public String toString() {
		return "Valorar [user=" + user + ", post=" + post + ", puntuacion=" + puntuacion + "]";
	}
}
