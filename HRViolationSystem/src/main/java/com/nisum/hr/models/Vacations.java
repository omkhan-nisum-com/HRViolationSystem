package com.nisum.hr.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the vacations database table.
 * 
 */
@Entity
@Table(name="vacations")
@NamedQuery(name="Vacations.findAll", query="SELECT v FROM Vacations v")
public class Vacations implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fromdate;

	private String name;

	@Temporal(TemporalType.DATE)
	private Date todate;

	public Vacations() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFromdate() {
		return this.fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTodate() {
		return this.todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

}