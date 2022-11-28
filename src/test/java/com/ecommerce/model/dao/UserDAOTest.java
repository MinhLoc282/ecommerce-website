/**
 * 
 */
package com.ecommerce.model.dao;

import com.ecommerce.model.entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserDAOTest {

	private static UserDAO userDAO;

	@BeforeAll
	static void setUpBeforeClass() {
		userDAO = new UserDAO();
	}

	@AfterAll
	static void tearDownAfterClass() {
		userDAO.close();
	}

	@Test
	void testCreateUser() {
		User user = new User();
		user.setEmail("admin@gmail.com");
		user.setFullName("Admin");
		user.setPassword("admin");

		user = userDAO.create(user);

		Assertions.assertTrue(user.getUserId() > 0);
	}

	@Test
	void testUpdateUser() {
		User user = new User();
		user.setUserId(1);
		user.setEmail("user1@gmail.com");
		user.setFullName("User1");
		user.setPassword("1234");

		user = userDAO.update(user);
		String expected = "user1";
		String actual = user.getPassword();

		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetUserFound() {
		Integer userId = 1;
		User user = userDAO.get(userId);

		Assertions.assertNotNull(user);
	}

	@Test
	public void testGetUserNotFound() {
		Integer userId = 99;
		User user = userDAO.get(userId);

		Assertions.assertNull(user);
	}

	@Test
	void testDeleteUser() {
		Integer userId = 5;
		userDAO.delete(userId);

		User user = userDAO.get(userId);

		Assertions.assertNull(user);
	}

	@Test
	public void testDeleteNonExistUsers() {
		Integer userId = 99;
		userDAO.delete(userId);
	}

	@Test
	void testListAll() {
		List<User> listUsers = userDAO.listAll();

		listUsers.forEach(c -> System.out.println(c.getEmail()));

		Assertions.assertTrue(listUsers.size() > 0);
	}

	@Test
	void testCount() {
		long totalUsers = userDAO.count();

		Assertions.assertEquals(2, totalUsers);
	}

	@Test
	void testFindByEmail() {
		String email = "admin@gmail.com";
		User user = userDAO.findByEmail(email);

		Assertions.assertNotNull(user);
	}

	@Test
	public void testCheckEmailAndPasswordSuccess() {
		String email = "admin@gmail.com";
		String password = "admin";
		boolean checkResult = userDAO.checkEmailAndPassword(email, password);

		Assertions.assertTrue(checkResult);
	}

	@Test
	public void testCheckEmailAndPasswordFailed() {
		String email = "admin@gmail.com";
		String password = "1234";
		boolean checkResult = userDAO.checkEmailAndPassword(email, password);

		Assertions.assertFalse(checkResult);
	}

}
