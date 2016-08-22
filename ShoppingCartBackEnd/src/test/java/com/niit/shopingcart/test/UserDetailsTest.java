package com.niit.shopingcart.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopingcart.dao.UserDetailsDAO;
import com.niit.shopingcart.model.UserDetails;


public class UserDetailsTest {
	
	public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopingcart");
		context.refresh();
		
	UserDetails u =(UserDetails) context.getBean("userDetails");
	
	UserDetailsDAO userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
	u.setId("U004");
	u.setName("vijay");
	u.setAddress("Bangalore");
	u.setContactNumber("9999999999");
	u.setMailID("vijaibaskar@yahoo.com");
	userDetailsDAO.saveOrUpdate(u);
	
	u.setId("U005");
	u.setName("asdf");
	u.setAddress("dehli");
	u.setMailID("vijaibaskar@gmail.com");
	userDetailsDAO.saveOrUpdate(u);
	
	
	List<UserDetails>  list =    userDetailsDAO.list();
	
	for(UserDetails usr : list)
	{
		System.out.println(usr.getId()  + ":" +  usr.getName()  + ":"+  usr.getAddress());
	}
		
		
	}

}
