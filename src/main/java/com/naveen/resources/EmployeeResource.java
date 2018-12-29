package com.naveen.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.naveen.auth.AuthenticationValidator;
import com.naveen.entity.Employee;
import com.naveen.service.EmployeeService;


@Path("/employee")
public class EmployeeResource
{
	private static Logger log = LogManager.getLogger(EmployeeResource.class);
	@Autowired
	private EmployeeService service;
	@POST
	@Consumes("application/json")
	@Path("/save")
	public Response saveEmployee(@HeaderParam("Authorization")String auth,Employee emp)
	{
		
		boolean flag = AuthenticationValidator.validateUser(auth);
		if(!flag)
		  return Response.status(Status.UNAUTHORIZED).entity("UNAUTHORIZED USER").build();
		else
		{
			Employee employee = new Employee();
			employee.setId(emp.getId());
			employee.setName(emp.getName());
			boolean exists =service.isExist(emp.getId());
			if(exists)
			{
				return Response.status(Status.CONFLICT).entity("USER ALREADY EXISTS WITH GIVEN ID").build();
			}
			else
			{
				service.registerEmp(employee);
				log.debug("employee saved successfully with id " +emp.getId());
			}
		}
		return Response.status(Status.ACCEPTED).entity("USER SAVED SUCCESSFULLY").build();
	}
	@GET
	@Path("/hello")
	public Response hello()
	{
		log.debug("from hello()");
		return Response.ok("hello").build();
	}
}
