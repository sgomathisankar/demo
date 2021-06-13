/**
 * 
 */
package com.gs.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.gs.demo.Entity.Employee;

/**
 * @author Gomathi sankar
 * Created for Employee Repository
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
