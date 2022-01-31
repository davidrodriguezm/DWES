package org.iesalixar.drodriguezm.model;

import java.io.Serializable;
import java.util.Objects;

public class ValorarId implements Serializable{
	private Long post;
	
	private Long user;

	public ValorarId() {
		super();
	}
	
	public Long getPost() {
		return post;
	}

	public void setPost(Long post) {
		this.post = post;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
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
		ValorarId other = (ValorarId) obj;
		
		if (post == null) {
			if (other.post != null)
				return false;			
		} else  if (post != other.post)
				return false;
		
		if (user == null) {
			if (other.user != null)
				return false;			
		} else if (user!= other.user)
				return false;
		
		return true;
	}
}
