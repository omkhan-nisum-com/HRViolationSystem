package com.nisum.hr.models;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employees.findAll", query="SELECT e FROM Employees e")
public class Employees implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	private String employeecode;

	private byte isactive;

	private String name;

	//bi-directional many-to-one association to Attendance
	@OneToMany(mappedBy="employee")
	private List<Attendance> attendances;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="managerid")
	private Employees employee;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employee")
	private List<Employees> employees;

	//bi-directional many-to-one association to EmployeesShift
	@OneToMany(mappedBy="employee")
	private List<EmployeesShift> employeesShifts;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="employee")
	private List<Users> users;

	public Employees() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeecode() {
		return this.employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
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

	public List<Attendance> getAttendances() {
		return this.attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public Attendance addAttendance(Attendance attendance) {
		getAttendances().add(attendance);
		attendance.setEmployee(this);

		return attendance;
	}

	public Attendance removeAttendance(Attendance attendance) {
		getAttendances().remove(attendance);
		attendance.setEmployee(null);

		return attendance;
	}

	public Employees getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public List<Employees> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	public Employees addEmployee(Employees employee) {
		getEmployees().add(employee);
		employee.setEmployee(this);

		return employee;
	}

	public Employees removeEmployee(Employees employee) {
		getEmployees().remove(employee);
		employee.setEmployee(null);

		return employee;
	}

	public List<EmployeesShift> getEmployeesShifts() {
		return this.employeesShifts;
	}

	public void setEmployeesShifts(List<EmployeesShift> employeesShifts) {
		this.employeesShifts = employeesShifts;
	}

	public EmployeesShift addEmployeesShift(EmployeesShift employeesShift) {
		getEmployeesShifts().add(employeesShift);
		employeesShift.setEmployee(this);

		return employeesShift;
	}

	public EmployeesShift removeEmployeesShift(EmployeesShift employeesShift) {
		getEmployeesShifts().remove(employeesShift);
		employeesShift.setEmployee(null);

		return employeesShift;
	}

	public List<Users> getUsers() {
		return this.users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Users addUser(Users user) {
		getUsers().add(user);
		user.setEmployee(this);

		return user;
	}

	public Users removeUser(Users user) {
		getUsers().remove(user);
		user.setEmployee(null);

		return user;
	}
	
	@Override
	public String toString() {
		
		return this.name + "-" + this.id + "-" + this.email;
	}

}