package com.nisum.hr.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="Users.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte isactive;

	private String password;

	private String username;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employeeid")
	private Employees employee;

	//bi-directional many-to-one association to UsersRole
	@OneToMany(mappedBy="user")
	private List<UsersRole> usersRoles;

	public Users() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getIsactive() {
		return this.isactive;
	}

	public void setIsactive(byte isactive) {
		this.isactive = isactive;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Employees getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public List<UsersRole> getUsersRoles() {
		return this.usersRoles;
	}

	public void setUsersRoles(List<UsersRole> usersRoles) {
		this.usersRoles = usersRoles;
	}

	public UsersRole addUsersRole(UsersRole usersRole) {
		getUsersRoles().add(usersRole);
		usersRole.setUser(this);

		return usersRole;
	}

	public UsersRole removeUsersRole(UsersRole usersRole) {
		getUsersRoles().remove(usersRole);
		usersRole.setUser(null);

		return usersRole;
	}

}