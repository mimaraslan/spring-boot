package com.mimaraslan.repository;

import com.mimaraslan.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmployeeRepository {

	@Autowired
	private EntityManager em;

	/**
	 * Method to fetch all employees from the db.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Iterable<Employee> getAllEmployees() {
		return em.createNamedStoredProcedureQuery("my-procedure-1").getResultList();
	}

	/**
	 * Method to fetch employees on the basis of department.
	 * @param input
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Iterable<Employee> getEmployeesByDepartment(String input) {
		return em.createNamedStoredProcedureQuery("my-procedure-2").setParameter("emp_department", input).getResultList();
	}

	/**
	 * Method to fetch the employees count on the basis of position.
	 * @param input
	 * @return
	 */
	public Integer getEmployeesCountByPosition(String input) {
		return (Integer) em.createNamedStoredProcedureQuery("my-procedure-3").setParameter("emp_position", input).getOutputParameterValue("position_count");
	}
}