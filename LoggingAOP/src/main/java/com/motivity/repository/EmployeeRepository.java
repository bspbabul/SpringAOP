package com.motivity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motivity.entity.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {

}
