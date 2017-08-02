package com.nisum.hr.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the employees_shifts database table.
 * 
 */
@Entity
@Table(name="employees_shifts")
@NamedQuery(name="EmployeesShift.findAll", query="SELECT e FROM EmployeesShift e")
public class EmployeesShift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fromdate;

	private byte isactive;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tilldate;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	private Employees employee;

	//bi-directional many-to-one association to Shift
	@ManyToOne(fetch=FetchType.LAZY)
	private Shifts shift;

	public EmployeesShift() {
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

	public byte getIsactive() {
		return this.isactive;
	}

	public void setIsactive(byte isactive) {
		this.isactive = isactive;
	}

	public Date getTilldate() {
		return this.tilldate;
	}

	public void setTilldate(Date tilldate) {
		this.tilldate = tilldate;
	}

	public Employees getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Shifts getShift() {
		return this.shift;
	}

	public void setShift(Shifts shift) {
		this.shift = shift;
	}

}