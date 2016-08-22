package com.niit.shopingcart.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopingcart.dao.UserDetailsDAO;
import com.niit.shopingcart.model.UserDetails;

public class TestCaseUserDetails {

	

	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	@Autowired
	UserDetails userDetails;
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopingcart");
		context.refresh();
		
		userDetailsDAO=(UserDetailsDAO) context.getBean("userDetailsDAO");
		userDetails=(UserDetails) context.getBean("userDetails");
	}
	
	@Test
	public void deleteUserDetailsTestCase()
	{
		userDetails.setId("PRD 001");
		boolean flag=userDetailsDAO .delete(userDetails);
		assertEquals("delete ProductTestCase", flag,false);
	}
	
	@Test
	public void addUserDetailsTestCase()
	{
		userDetails.setId("U004");
		userDetails.setName("vijay");
		userDetails.setAddress("Bangalore");
		userDetails.setContactNumber("9999999999");
		userDetails.setMailID("vijaibaskar@yahoo.com");
		
		userDetails.saveorUpdate(userDetails);
		assertTrue(true);
		
	}
	
	@Test
	public void updateUserDetailsTestCase()
	{
		userDetails.setId("U004");
		userDetails.setName("vijay");
		userDetails.setAddress("Bangalore");
		userDetails.setContactNumber("9999999999");
		userDetails.setMailID("vijaibaskar@yahoo.com");
		assertTrue(true);
		
	}
	
	@Test
	public void listUserDetailsTestCase()
	{
		assertEquals("addProductTestCase",userDetailsDAO.list().size(), 0);
	}
	@Test
	public void getUserDetailsTestCase()
	{
		assertEquals("updateProductTestCase",userDetailsDAO.get("MOB 001"), null);
	}
	
	
}

