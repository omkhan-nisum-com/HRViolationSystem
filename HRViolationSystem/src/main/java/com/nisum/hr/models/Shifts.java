package com.nisum.hr.models;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the shifts database table.
 * 
 */
@Entity
@Table(name="shifts")
@NamedQuery(name="Shifts.findAll", query="SELECT s FROM Shifts s")
public class Shifts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fromTime;

	private byte isactive;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date toTime;

	//bi-directional many-to-one association to EmployeesShift
	@OneToMany(mappedBy="shift")
	private List<EmployeesShift> employeesShifts;

	public Shifts() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFromTime() {
		return this.fromTime;
	}

	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}

	public byte getIsactive() {
		return this.isactive;
	}

	public void setIsactive(byte isactive) {
		this.isactive = isactive;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getToTime() {
		return this.toTime;
	}

	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}

	public List<EmployeesShift> getEmployeesShifts() {
		return this.employeesShifts;
	}

	public void setEmployeesShifts(List<EmployeesShift> employeesShifts) {
		this.employeesShifts = employeesShifts;
	}

	public EmployeesShift addEmployeesShift(EmployeesShift employeesShift) {
		getEmployeesShifts().add(employeesShift);
		employeesShift.setShift(this);

		return employeesShift;
	}

	public EmployeesShift removeEmployeesShift(EmployeesShift employeesShift) {
		getEmployeesShifts().remove(employeesShift);
		employeesShift.setShift(null);

		return employeesShift;
	}

}