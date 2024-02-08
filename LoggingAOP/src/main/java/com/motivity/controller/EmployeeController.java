package com.motivity.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motivity.entity.Employees;
import com.motivity.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employees> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/employees/{employeeid}")
	public ResponseEntity<Optional<Employees>> getByid(@PathVariable long employeeid) {
		return ResponseEntity.ok(employeeService.getbyId(employeeid));
	}

	@PostMapping("/employees")
	public ResponseEntity<Employees> saveEmployee(@RequestBody Employees employees) {
		return ResponseEntity.ok(employeeService.createEmployee(employees));
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
		return employeeService.deleteById(employeeId);
	}

}
