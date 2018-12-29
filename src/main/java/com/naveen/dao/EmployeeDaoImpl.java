package com.naveen.dao;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naveen.entity.Employee;
@Repository("employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao
{
	private static Logger log = LogManager.getLogger(EmployeeDaoImpl.class);
	@Autowired
	private JdbcTemplate jt;
	public int saveEmployee(Employee emp)
	{
		int i=0;
		 i =jt.update("insert into employee  values (?,?)",new Object[]{ emp.getId(),emp.getName()});
		 if(i==0)
		 {
			 log.debug("EMP OBJECT DOES NOT SAVED");
		 }
		 return i;
	}
	@Override
	public boolean isEmpExist(int id) 
	{
		boolean flag = false;
		int i= 0;
		i = jt.queryForObject("select count(*) from employee where id=?",Integer.class,id);
		if(i==1)
		{
			log.debug("EMPLOYEE ALREADY EXISTS WITH ID "+ id);
			flag = true;
		}
		return flag;
	}
	
}
