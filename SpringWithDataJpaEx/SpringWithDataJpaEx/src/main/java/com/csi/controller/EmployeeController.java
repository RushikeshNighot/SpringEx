package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.model.Employee;
import com.csi.service.IEmployeeService;

@RestController
@RequestMapping("/employess")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeServiceImpl;

	@PostMapping("/save")
	private ResponseEntity<Employee> save(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeServiceImpl.save(employee));

	}

	@GetMapping("/findall")
	private ResponseEntity<List<Employee>> findAll() {

		return ResponseEntity.ok(employeeServiceImpl.findAll());
	}
}
