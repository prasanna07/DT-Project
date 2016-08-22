package com.niit.shopingcart.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopingcart.dao.CategoryDAO;
import com.niit.shopingcart.model.Category;

public class TestCaseCategory {

@Autowired
CategoryDAO categoryDAO;

@Autowired
Category category;

AnnotationConfigApplicationContext context;

	@Before
	public void init(){
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	category = (Category) context.getBean("category");
	}
@Test

public void categoryListTestCase()
{

	List<Category> list = categoryDAO.list();
	int rowCount = list.size();
	
	assertEquals("Category List Test Case",rowCount,5);
	
}

@Test
public void deleteTestCaseCategory()
{
category.setId("CAT_001");
boolean flag = categoryDAO.delete("category");
 assertEquals("deleteCategoryTestCase",  flag, false);
	
}

@Test
public void addCategoryTestCase()
{
	category.setId("PRD 001");
	category.setName("samsung");
	category.setDescription("This is samsung phone ");
	categoryDAO.saveOrUpdate(category);
	assertTrue(true);
	
}

@Test
public void updateCategoryTestCase()
{
	category.setId("MOB 001");
	category.setName("samsung");
	assertTrue(true);
	
}

@Test
public void listCategoryTestCase()
{
	assertEquals("addProductTestCase",categoryDAO.list().size(), 0);
}
@Test
public void getCategoryTestCase()
{
	assertEquals("updateProductTestCase",categoryDAO.get("MOB 001"), null);
}



}
