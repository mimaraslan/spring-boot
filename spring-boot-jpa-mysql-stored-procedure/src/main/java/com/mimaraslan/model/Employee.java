package com.mimaraslan.model;

import javax.persistence.*;

@Entity
@Table(name= "employee")
@NamedStoredProcedureQueries(value= {

		@NamedStoredProcedureQuery(name= "procedure-one", procedureName= "findAllEmployees"),

		@NamedStoredProcedureQuery(name= "procedure-two", procedureName= "findEmployeeByDepartment",
				parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "emp_department", type= String.class)
		}),

		@NamedStoredProcedureQuery(name= "procedure-third", procedureName= "findEmployeeCountByPosition",
				parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "emp_position", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "position_count", type= Integer.class)
		})
})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	@Column
	private String position;

	@Column
	private String department;

	@Column
	private int salary;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				//"id=" + id +
				", name='" + name + '\'' +
				", position='" + position + '\'' +
				", department='" + department + '\'' +
				", salary=" + salary +
				'}';
	}

}