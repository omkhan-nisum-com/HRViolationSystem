package com.nisum.hr.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the attendance database table.
 * 
 */
@Entity
@NamedQuery(name="Attendance.findAll", query="SELECT a FROM Attendance a")
public class Attendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private int actualhours;

	private int gracehours;

	private byte isinformedlate;

	private byte islate;

	private byte isshort;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timein;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeout;

	private int totalhours;

	private int wfhhours;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employeeid")
	private Employees employee;

	public Attendance() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getActualhours() {
		return this.actualhours;
	}

	public void setActualhours(int actualhours) {
		this.actualhours = actualhours;
	}

	public int getGracehours() {
		return this.gracehours;
	}

	public void setGracehours(int gracehours) {
		this.gracehours = gracehours;
	}

	public byte getIsinformedlate() {
		return this.isinformedlate;
	}

	public void setIsinformedlate(byte isinformedlate) {
		this.isinformedlate = isinformedlate;
	}

	public byte getIslate() {
		return this.islate;
	}

	public void setIslate(byte islate) {
		this.islate = islate;
	}

	public byte getIsshort() {
		return this.isshort;
	}

	public void setIsshort(byte isshort) {
		this.isshort = isshort;
	}

	public Date getTimein() {
		return this.timein;
	}

	public void setTimein(Date timein) {
		this.timein = timein;
	}

	public Date getTimeout() {
		return this.timeout;
	}

	public void setTimeout(Date timeout) {
		this.timeout = timeout;
	}

	public int getTotalhours() {
		return this.totalhours;
	}

	public void setTotalhours(int totalhours) {
		this.totalhours = totalhours;
	}

	public int getWfhhours() {
		return this.wfhhours;
	}

	public void setWfhhours(int wfhhours) {
		this.wfhhours = wfhhours;
	}

	public Employees getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

}