/**
 * 
 */
package com.gs.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gs.demo.Entity.Employee;
import com.gs.demo.Repository.EmployeeRepository;

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
        return employeeRepository.findById(id).get();
    }

    public void deleteUser(Long id) {
    	employeeRepository.deleteById(id);
    }
}
