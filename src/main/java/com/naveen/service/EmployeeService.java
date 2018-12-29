package com.naveen.service;

import com.naveen.entity.Employee;

public interface EmployeeService 
{
	int registerEmp(Employee emp);
	boolean isExist(int id);
}
