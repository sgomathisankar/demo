package com.gs.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gs.demo.entity.Employee;
import com.gs.demo.repository.EmployeeRepository;

@SpringBootTest
class MysqldemoApplicationTests {
	@Autowired
	private EmployeeRepository employeeRepository;
		
	@Test
	void testEmployeeListing() {
		Optional<Employee> emp = employeeRepository.findById((long) 2);
		assertEquals("002", emp.get().getCode());
	}

}
