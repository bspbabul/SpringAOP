package com.motivity.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motivity.entity.Employees;
import com.motivity.exception.EmployeeNotFoundException;
import com.motivity.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	public List<Employees> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Optional<Employees> getbyId(long Employeeid){
		return Optional.ofNullable(employeeRepository.findById(Employeeid).orElseThrow(()->new EmployeeNotFoundException("Employees not found for the given Id")));
	}
	
	public Map<String, Boolean> deleteById(long Employeeid) {
        Optional<Employees> employeeOptional = employeeRepository.findById(Employeeid);
        if (employeeOptional.isPresent()) {
            employeeRepository.deleteById(Employeeid);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        } else {
            throw new EmployeeNotFoundException("Employee not found for the given Id");
        }
    }
	
	public Employees createEmployee(Employees employees) {
		return employeeRepository.save(employees);
	}

}