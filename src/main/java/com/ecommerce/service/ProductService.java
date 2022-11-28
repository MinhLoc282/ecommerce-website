package com.ecommerce.service;

import com.ecommerce.model.dao.CategoryDAO;
import com.ecommerce.model.dao.OrderDAO;
import com.ecommerce.model.dao.ProductDAO;
import com.ecommerce.model.entity.Category;
import com.ecommerce.model.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.ecommerce.utility.CommonUtility.*;

public class ProductService {
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final ProductDAO productDAO;
    private final CategoryDAO categoryDAO;

    public ProductService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        productDAO = new ProductDAO();
        categoryDAO = new CategoryDAO();
    }

    public void listProduct() throws ServletException, IOException {
        listProduct(null);
    }

    public void listProduct(String message) throws ServletException, IOException {
        List<Product> listProducts = productDAO.listAll();

        request.setAttribute("listProducts", listProducts);

        if (message != null) {
            request.setAttribute("message", message);
        }

        forwardToPage("product_list.jsp", message, request, response);
    }

    public void showNewProductForm() throws ServletException, IOException {
        List<Category> listCategories = categoryDAO.listAll();

        request.setAttribute("listCategories", listCategories);

        forwardToPage("product_form.jsp", request, response);
    }

    public void createProduct() throws ServletException, IOException {
        String title = request.getParameter("title");

        Product existProduct = productDAO.findByTitle(title);

        if (existProduct != null) {
            listProduct(String.format("Could not create new product because the title '%s' already exists.", title));
            return;
        }

        Product newProduct = new Product();
        readProductFields(newProduct);

        Product createdProduct = productDAO.create(newProduct);

        if (createdProduct.getProductId() > 0) {
            listProduct("A new product has been created successfully.");
        }
    }

    private void readProductFields(Product product) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date publishDate;

        try {
            publishDate = dateFormat.parse(request.getParameter("publishDate"));
        } catch (ParseException exception) {
            exception.printStackTrace();
            throw new ServletException("Error parsing publish date (format is yyyy-MM-dd)");
        }

        product.setTitle(title);
        product.setDescription(description);
        product.setPublishDate(publishDate);

        Integer categoryId = Integer.parseInt(request.getParameter("category"));
        Category category = categoryDAO.get(categoryId);

        product.setCategory(category);
        product.setPrice(price);

        Part part = request.getPart("productImage");

        if (part != null && part.getSize() > 0) {
            long size = part.getSize();
            byte[] imageByte = new byte[(int) size];

            InputStream inputStream = part.getInputStream();
            inputStream.read(imageByte);
            inputStream.close();

            product.setImage(imageByte);
        }
    }

    public void editProduct() throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.get(productId);

        if (product != null) {
            List<Category> listCategories = categoryDAO.listAll();

            request.setAttribute("product", product);
            request.setAttribute("listCategories", listCategories);

            forwardToPage("product_form.jsp", request, response);

        } else {
            messageForAdmin(
                    String.format("Could not find the product with ID %s or it might have been deleted.", productId),
                    request, response);
        }
    }

    public void updateProduct() throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        String title = request.getParameter("title");

        Product existProduct = productDAO.get(productId);
        Product productByTitle = productDAO.findByTitle(title);

        if (productByTitle != null && !existProduct.equals(productByTitle)) {
            listProduct("Could not update product because there is another product having same title.");
            return;
        }

        readProductFields(existProduct);

        productDAO.update(existProduct);

        listProduct("The product has been updated successfully.");
    }

    public void deleteProduct() throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.get(productId);

        if (product == null) {
            messageForAdmin(
                    String.format("Could not find the product with ID %s or it might have been deleted.", productId),
                    request, response);

        } else {
            if (!product.getReviews().isEmpty()) {
                messageForAdmin(
                        String.format("Could not delete the product with ID %s because it has reviews.", productId),
                        request, response);

            } else {
                OrderDAO orderDAO = new OrderDAO();
                long countByOrder = orderDAO.countOrderDetailByProduct(productId);

                if (countByOrder > 0) {
                    messageForAdmin(String.format(
                            "Could not delete the product with ID %s because there are orders associated with it.",
                            productId), request, response);

                } else {
                    productDAO.delete(productId);
                    listProduct("The book has been deleted successfully.");
                }
            }
        }
    }

    public void listProductByCategory() throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        Category category = categoryDAO.get(categoryId);
        String pageId = request.getParameter("page");
        String sort = request.getParameter("sort");
        int numBegin;
        int numEnd;

        if (pageId == null) {
            pageId = "1";
        }

        if (category == null) {
            messageForShop(String.format("Sorry. The category ID %s is not available.", categoryId), request,
                    response);
            return;
        }

        List<Product> listProducts;

        if (Objects.equals(sort, "price_desc")) {
            listProducts = productDAO.sortByPriceDesc(categoryId);
        }
        if (Objects.equals(sort, "price_asc")) {
            listProducts = productDAO.sortByPriceAsc(categoryId);
        }
        if (Objects.equals(sort, "newest")) {
            listProducts = productDAO.sortByNewest(categoryId);
        } else {
            listProducts = productDAO.listByCategory(categoryId);
        }

        List<Category> listCategories = categoryDAO.listAll();

        int numberOfPages = listProducts.size();
        int numberOfProducts = 10;

        if (numberOfPages % numberOfProducts != 0) {
            numberOfPages = numberOfPages / numberOfProducts + 1;
        } else {
            numberOfPages = numberOfPages / numberOfProducts;
        }

        numEnd = Integer.parseInt(pageId) * numberOfProducts - 1;
        numBegin = numEnd - numberOfProducts + 1;

        request.setAttribute("listProducts", listProducts);
        request.setAttribute("listCategories", listCategories);
        request.setAttribute("category", category);

        request.setAttribute("sort", sort);
        request.setAttribute("pageId", pageId);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("numBegin", numBegin);
        request.setAttribute("numEnd", numEnd);

        forwardToPage("shop/product_list_by_category.jsp", request, response);
    }

    public void viewProductDetail() throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.get(productId);

        if (product != null) {
            Integer categoryId = product.getCategory().getCategoryId();
            List<Product> listProducts = productDAO.listByCategory(categoryId);
            Collections.shuffle(listProducts);

            request.setAttribute("listProducts", listProducts);
            request.setAttribute("product", product);

            forwardToPage("shop/product_detail.jsp", request, response);

        } else {
            messageForShop(String.format("Sorry. The product with ID %s is not available.", productId), request,
                    response);
        }
    }

    public void search() throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Product> result;

        if (keyword.equals("")) {
            result = productDAO.listAll();
        } else {
            result = productDAO.search(keyword);
        }

        if (result.size() == 0) {
            request.setAttribute("message", "Found no matching product(s).");
        }

        request.setAttribute("keyword", keyword);
        request.setAttribute("result", result);

        forwardToPage("shop/search_result.jsp", request, response);
    }

}
