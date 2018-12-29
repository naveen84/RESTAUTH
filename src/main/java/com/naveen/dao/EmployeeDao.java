package com.naveen.dao;

import com.naveen.entity.Employee;

public interface EmployeeDao 
{
	int saveEmployee(Employee emp);
	boolean isEmpExist(int id);
}
