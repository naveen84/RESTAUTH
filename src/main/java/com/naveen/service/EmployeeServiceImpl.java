package com.naveen.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.dao.EmployeeDao;
import com.naveen.entity.Employee;
@Service("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService
{
	private static Logger log = LogManager.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeDao dao;
	@Override
	public int registerEmp(Employee emp) 
	{
		int i =dao.saveEmployee(emp);
		log.debug("in service : Employee saved "+ i);
		return i;
	}

	@Override
	public boolean isExist(int id) 
	{
		boolean flag = dao.isEmpExist(id);
		log.debug("in service : Employee exists with id "+ flag);
		return flag;
	}

}
