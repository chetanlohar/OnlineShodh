package com.onlineshodh.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.onlineshodh.controller.CategoryController;
import com.onlineshodh.entity.CategoryEntity;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(
		{
			"file:src/test/resources/test-context.xml"
		}		
)
@TransactionConfiguration
@Transactional
public class CategoryDaoTest {
	
	private static final Logger logger = Logger.getLogger(CategoryController.class);
	
	@Autowired
	protected CategoryDao categoryDao;
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	protected static Integer ID = 1;
	protected static Integer SIZE = 7;
	protected static String CATEGORY_NAME = "TRAVELING";
	protected static String CATEGORY_CHANGE_NAME = "TOURISM";
	
	/**
	 * Test that the Size and the Category Name match with the Expected
	 */
	@BeforeTransaction
	public void beforeTransaction()
	{
		testCategoryName(true, CATEGORY_NAME);
	}
	
	/**
	 * Tests the Category Table and updates the Category Name
	 */
	@Test
	public void testCategoryDao()
	{
		assertNotNull("categoryDao is null.",categoryDao);
		List<CategoryEntity> categories = categoryDao.getAllCategories();
		assertNotNull("Category List is null.", categories);
		assertEquals("No. of Categories should be "+Double.valueOf(SIZE),Double.valueOf(SIZE),Double.valueOf(categories.size()));
		
		for(CategoryEntity category:categories)
		{
			assertNotNull("Category is null",category);
			
			if(ID.equals(category.getCategoryId()))
			{
				assertEquals("Category Name should be "+CATEGORY_NAME, CATEGORY_NAME,category.getCategoryName());
				category.setCategoryName(CATEGORY_CHANGE_NAME);
				categoryDao.saveCategory(category);
			}
		}
	}
	
	@AfterTransaction
	public void afterTransaction()
	{
		testCategoryName(false, CATEGORY_NAME);
	}
	
	/**
	 * @param beforeTransaction describes beforeTransaction
	 * @param name describes the Category Name
	 * 
	 * Tests the Category Table
	 * 
	 */
	public void testCategoryName(boolean beforeTransaction,String name)
	{
		List<Map<String, Object>> categories =  jdbcTemplate.queryForList("select * from category where categoryid="+ID);
        assertNotNull("Category list is null.", categories);
        assertEquals("Number of Categories should be " +Double.valueOf(SIZE) + ".", Double.valueOf(SIZE),Double.valueOf(categories.size()));
        Map<String, Object> hCategory = categories.get(0);
        logger.debug((beforeTransaction ? "Before" : "After") + " transaction.  " + hCategory.toString());
        Integer id = (Integer)hCategory.get("categoryid");
        String categoryName = (String)hCategory.get("categoryname");
        if (ID.equals(id)) {                
        	assertEquals("Person first name should be " + CATEGORY_CHANGE_NAME + ".", CATEGORY_CHANGE_NAME, categoryName);
        }
	}
}
