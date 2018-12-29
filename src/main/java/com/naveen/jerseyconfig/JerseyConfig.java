package com.naveen.jerseyconfig;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.naveen.resources.EmployeeResource;
@Component
public class JerseyConfig extends ResourceConfig
{
	public JerseyConfig()
	{
		register(EmployeeResource.class);
	}
}
