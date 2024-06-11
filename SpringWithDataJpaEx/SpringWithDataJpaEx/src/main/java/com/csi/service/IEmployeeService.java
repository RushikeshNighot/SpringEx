package com.csi.service;

import java.util.List;

import com.csi.model.Employee;

public interface IEmployeeService {

	Employee save(Employee employee);

	List<Employee> findAll();
}
