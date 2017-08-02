package com.nisum.hr.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users_roles database table.
 * 
 */
@Entity
@Table(name="users_roles")
@NamedQuery(name="UsersRole.findAll", query="SELECT u FROM UsersRole u")
public class UsersRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="roleid")
	private Roles role;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private Users user;

	public UsersRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Roles getRole() {
		return this.role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}