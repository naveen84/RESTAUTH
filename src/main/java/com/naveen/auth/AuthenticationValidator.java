package com.naveen.auth;

import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;


public class AuthenticationValidator 
{
	private static Logger log = LogManager.getLogger(AuthenticationValidator.class);
	
	public static boolean validateUser(String auth)
	{
		boolean flag = false;
		if(auth==null||"".equals(auth.trim()))
		{
			flag=false;
		}
		else
		{
			log.debug("Authorization user " + auth);
			auth = auth.replace("Basic ", "");
			log.debug("2-->"+auth);
			byte[] arr = Base64.decodeBase64(auth.getBytes());
			auth = new String(arr);
			log.debug("3--->"+auth);
			StringTokenizer token = new StringTokenizer(auth,":");
			String username = token.nextToken();
			String password = token.nextToken();
			log.debug("username "+username+" password"+password);
			if("krishna".equals(username) && "radha".equals(password))
			 flag = true;
		}
		log.debug("AUTHORIZATION VALUE "+flag);
		return flag;
	}
}