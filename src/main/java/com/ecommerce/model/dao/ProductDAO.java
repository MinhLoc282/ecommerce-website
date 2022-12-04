package com.ecommerce.model.dao;

import com.ecommerce.model.entity.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDAO extends JpaDAO<Product> implements GenericDAO<Product> {

    @Override
    public Product create(Product product) {
        product.setLastUpdateTime(new Date());
        return super.create(product);
    }

    @Override
    public Product update(Product product) {
        product.setLastUpdateTime(new Date());
        return super.update(product);
    }

    @Override
    public Product get(Object productId) {
        return super.find(Product.class, productId);
    }

    @Override
    public void delete(Object productId) {
        super.delete(Product.class, productId);
    }

    @Override
    public List<Product> listAll() {
        return super.findWithNamedQuery("Product.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Product.countAll");
    }

    public Product findByTitle(String title) {
        List<Product> result = super.findWithNamedQuery("Product.findByTitle", "title", title);

        if (!result.isEmpty()) {
            return result.get(0);
        }

        return null;
    }

    public List<Product> listByCategory(int categoryId) {
        return super.findWithNamedQuery("Product.findByCategory", "categoryId", categoryId);
    }

    public List<Product> listNewProducts() {
        return super.findWithNamedQuery("Product.listNewProducts", 0, 4);
    }

    public List<Product> search(String keyword) {
        return super.findWithNamedQuery("Product.search", "keyword", keyword);
    }

    public long countByCategory(int categoryId) {
        return super.countWithNamedQuery("Product.countByCategory", "categoryId", categoryId);
    }

    public List<Product> listBestSellingProducts() {
        return super.findWithNamedQuery("OrderDetail.bestSelling", 0, 4);
    }

    public List<Product> listBestSellingProducts(int categoryId) {
        return super.findWithNamedQuery("OrderDetail.bestSellingByCategory", "categoryId", categoryId);
    }

    public List<Product> listMostFavoredProducts() {
        List<Product> mostFavoredProducts = new ArrayList<>();
        List<Object[]> result = super.findWithNamedQueryObjects("Review.mostFavoredProducts", 0, 4);

        if (!result.isEmpty()) {
            for (Object[] elements : result) {
                Product product = (Product) elements[0];
                mostFavoredProducts.add(product);
            }
        }

        return mostFavoredProducts;
    }

    public List<Product> sortByPriceDesc(int categoryId) {
        return super.findWithNamedQuery("Product.sortByPriceDesc", "categoryId", categoryId);
    }

    public List<Product> sortByPriceAsc(int categoryId) {
        return super.findWithNamedQuery("Product.sortByPriceAsc", "categoryId", categoryId);
    }

    public List<Product> sortByNewest(int categoryId) {
        return super.findWithNamedQuery("Product.sortByNewest", "categoryId", categoryId);
    }

}
