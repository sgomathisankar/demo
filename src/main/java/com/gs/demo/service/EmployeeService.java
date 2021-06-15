/**
 * 
 */
package com.gs.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gs.demo.entity.Employee;
import com.gs.demo.repository.EmployeeRepository;

/**
 * @author Gomathi sankar
 * Created for Employee Service
 */
@Component
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
    public List<Employee> listAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
    	employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
    	Optional<Employee> empOptional = employeeRepository.findById(id);
    	if(empOptional.isPresent()) return empOptional.get(); else return new Employee();
    }

    public void deleteUser(Long id) {
    	employeeRepository.deleteById(id);
    }
}
