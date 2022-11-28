/**
 *
 */
package com.ecommerce.model.dao;

import com.ecommerce.model.entity.Category;
import com.ecommerce.model.entity.Product;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class ProductDAOTest {
    private static ProductDAO productDAO;

    @BeforeAll
    static void setUpBeforeClass() {
        productDAO = new ProductDAO();
    }

    @AfterAll
    static void tearDownAfterClass() {
        productDAO.close();
    }

    @Test
    void testCreateProduct() throws ParseException, IOException {
        Product newProduct = new Product();

        Category category = new Category("Tops");
        category.setCategoryId(2);
        newProduct.setCategory(category);

        newProduct.setTitle("");
        newProduct.setDescription("");
        newProduct.setPrice(38.87f);

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date publishDate = dateFormat.parse("05/28/2008");
        newProduct.setPublishDate(publishDate);

        String imagePath = "../ProductStoreWebsite/products/ .png";

        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        newProduct.setImage(imageBytes);

        Product createdProduct = productDAO.create(newProduct);

        Assertions.assertTrue(createdProduct.getProductId() > 0);
    }

    @Test
    void testUpdateProduct() throws ParseException, IOException {
        Product existProduct = new Product();
        existProduct.setProductId(1);

        Category category = new Category("Bottoms");
        category.setCategoryId(1);
        existProduct.setCategory(category);

        existProduct.setTitle("");
        existProduct.setDescription("");
        existProduct.setPrice(40f);

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date publishDate = dateFormat.parse("05/28/2008");
        existProduct.setPublishDate(publishDate);

        String imagePath = "../ProductStoreWebsite/products/ .jpg";

        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        existProduct.setImage(imageBytes);

        Product updatedProduct = productDAO.update(existProduct);

        Assertions.assertEquals(updatedProduct.getTitle(), "");
    }

    @Test
    void testGetProductSuccess() {
        Product product = productDAO.get(2);

        Assertions.assertNotNull(product);
    }

    @Test
    void testGetProductFail() {
        Product product = productDAO.get(99);

        Assertions.assertNull(product);
    }

    @Test
    void testDeleteProductSuccess() {
        productDAO.delete(1);

        Assertions.assertTrue(true);
    }

    @Test
    void testDeleteProductFail() {
        Integer productId = 100;
        productDAO.delete(productId);
    }

    @Test
    void testListAll() {
        List<Product> listProduct = productDAO.listAll();
        for (Product product : listProduct) {
            System.out.println(product.getTitle() + " - " + product.getTitle());
        }

        Assertions.assertFalse(listProduct.isEmpty());
    }

    @Test
    void testCount() {
        long totalProduct = productDAO.count();

        Assertions.assertEquals(2, totalProduct);
    }

    @Test
    void testFindByTitleExist() {
        Product product = productDAO.findByTitle("Bi-Swing Jacket");

        Assertions.assertNotNull(product);
    }

    @Test
    void testFindByTitleNotExist() {
        Product product = productDAO.findByTitle("Hybrid Hooded Pullover");

        Assertions.assertNull(product);
    }

    @Test
    public void testListByCategory() {
        List<Product> listProduct = productDAO.listByCategory(1);

        Assertions.assertTrue(listProduct.size() > 0);
    }

    @Test
    public void testListRecently() {
        List<Product> listProduct = productDAO.listNewProducts();
        listProduct.forEach(p -> System.out.println(p.getTitle() + " - " + p.getPublishDate()));

        Assertions.assertEquals(4, listProduct.size());
    }

    @Test
    public void testSearchProductInTitle() {
        List<Product> listProduct = productDAO.search("Java");
        listProduct.forEach(p -> System.out.println(p.getTitle()));

        Assertions.assertEquals(7, listProduct.size());
    }

    @Test
    public void testSearchProductInAuthor() {
        List<Product> listProduct = productDAO.search("Kathy");
        listProduct.forEach(p -> System.out.println(p.getTitle()));

        Assertions.assertEquals(2, listProduct.size());
    }

    @Test
    public void testSearchProductInDescription() {
        List<Product> listProduct = productDAO.search("The Chino Jacket");
        listProduct.forEach(p -> System.out.println(p.getTitle()));

        Assertions.assertEquals(1, listProduct.size());
    }

    @Test
    public void testCountByCategory() {
        long numberOfProducts = productDAO.countByCategory(1);

        Assertions.assertEquals(2, numberOfProducts);
    }
    
}
