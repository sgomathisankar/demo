/**
 * 
 */
package com.gs.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.gs.demo.entity.Employee;

/**
 * @author Gomathi sankar
 * Created for Employee Repository
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
