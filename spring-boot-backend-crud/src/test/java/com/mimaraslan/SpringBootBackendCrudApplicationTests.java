package com.mimaraslan;

import com.mimaraslan.model.Employee;
import com.mimaraslan.repository.EmployeeRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mimaraslan.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootBackendCrudApplicationTests {

	@Autowired
	private EmployeeService service;

	@Autowired
	private EmployeeRepository repository;


	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(
                        new Employee(376, "A", "B", "C", null), new Employee(1, "ABC", "ccc", "UK", null)).collect(Collectors.toList()));
		assertEquals(2, service.getEmployees().size());
	}

	/*
	@Test
	public void getEmployeeByIdTest() {
		int numId = 1;
		when(repository.findById(numId))
				.thenReturn(Stream.of(new Employee(2, "A", "66", "AAA")).collect(Collectors.toList()));
		assertEquals(1, service.getEmployeeById(numId).size());
	}
	*/

	@Test
	public void saveUserTest() {
		Employee user = new Employee(2, "m", "h", "u", null);
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addEmployee(user));
	}

	@Test
	public void deleteUserTest() {
		Employee user = new Employee(2, "m", "t", "k",null);
		service.deleteEmployee(user);
		verify(repository, times(1)).delete(user);
	}

}
