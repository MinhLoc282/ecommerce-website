/**
 *
 */
package com.ecommerce.model.dao;

import com.ecommerce.model.entity.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomerDAOTest {

    private static CustomerDAO customerDAO;

    @BeforeAll
    static void setUpBeforeClass() {
        customerDAO = new CustomerDAO();
    }

    @AfterAll
    static void tearDownAfterClass() {
        customerDAO.close();
    }

    @Test
    final void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setEmail("peter.drucker@gmail.com");
        customer.setFirstName("Peter");
        customer.setLastName("Trucker");
        customer.setCity("New York");
        customer.setState("New York");
        customer.setCountry("United States");
        customer.setAddressLine1("100 North Avenue");
        customer.setAddressLine2("Clifton Park");
        customer.setPassword("secret");
        customer.setPhone("18001900");
        customer.setZipCode("100000");
        Customer savedCustomer = customerDAO.create(customer);

        Assertions.assertTrue(savedCustomer.getCustomerId() > 0);
    }

    @Test
    final void testUpdateCustomer() {
        Customer customer = customerDAO.get(1);
        String firstName = "Janie";
        customer.setFirstName(firstName);
        Customer updatedCustomer = customerDAO.update(customer);

        Assertions.assertEquals(updatedCustomer.getFirstName(), firstName);
    }

    @Test
    final void testGet() {
        Integer customerId = 1;
        Customer customer = customerDAO.get(customerId);

        Assertions.assertNotNull(customer);
    }

    @Test
    final void testDeleteCustomer() {
        Integer customerId = 1;
        customerDAO.delete(customerId);
        Customer customer = customerDAO.get(1);

        Assertions.assertNull(customer);
    }

    @Test
    final void testListAll() {
        List<Customer> listCustomers = customerDAO.listAll();
        for (Customer customer : listCustomers) {
            System.out.println(customer.getFirstName());
        }

        Assertions.assertFalse(listCustomers.isEmpty());
    }

    @Test
    final void testCount() {
        long totalCustomers = customerDAO.count();

        Assertions.assertEquals(1, totalCustomers);
    }

    @Test
    final void testFindByEmail() {
        String email = "customer@gmail.com";
        Customer customer = customerDAO.findByEmail(email);

        Assertions.assertNotNull(customer);
    }

    /**
     * Test method for {@link CustomerDAO#findByEmailAndPassword}.
     */
    @Test
    final void testFindByEmailAndPasswordSuccess() {
        String email = "customer@gmail.com";
        String password = "customer";
        Customer customer = customerDAO.findByEmailAndPassword(email, password);

        Assertions.assertNotNull(customer);
    }

    @Test
    final void testFindByEmailAndPasswordFail() {
        String email = "admin@gmail.com";
        String password = "admin";
        Customer customer = customerDAO.findByEmailAndPassword(email, password);

        Assertions.assertNull(customer);
    }

}
