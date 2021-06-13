/**
 * 
 */
package com.gs.demo.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs.demo.Entity.Employee;
import com.gs.demo.Service.EmployeeService;

/**
 * @author Gomathi sankar
 * Created for Employee Controller
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("")
	public List<Employee> listAll(){
		return employeeService.listAllEmployee(); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> listById(@PathVariable Long id){
		try {
            Employee employee = employeeService.getEmployee(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
	}
	
	@PostMapping("/")
	public void add(@RequestBody Employee employee){
		employeeService.saveEmployee(employee); 
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Employee> update(@RequestBody Employee employee, @PathVariable Long id) {
        try {
        	Employee existEmployee = employeeService.getEmployee(id);
        	employee.setId(existEmployee.getId());            
            employeeService.saveEmployee(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		employeeService.deleteUser(id); 
	}
}
