<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ include file="common.jsp" %>

    <link rel="stylesheet" href="shop/css/style.css">

    <title>>Order Detail - Online Store</title>
</head>
<body>
<%@ include file="header.jsp" %>

<c:if test="${order == null}">
    <div align="center">
        <h2>Sorry. You are not authorized to view this order</h2>
    </div>
</c:if>

<c:if test="${order != null}">
    <div align="center">
        <h2>Order Overview</h2>
        <table style="border: 0">
            <tr>
                <td><b>Ordered By: </b></td>
                <td>${order.customer.fullName}</td>
            </tr>
            <tr>
                <td><b>Order Status: </b></td>
                <td>${order.status}</td>
            </tr>
            <tr>
                <td><b>Order Date: </b></td>
                <td>${order.orderDate}</td>
            </tr>
            <tr>
                <td><b>Payment Method: </b></td>
                <td>${order.paymentMethod}</td>
            </tr>
            <tr>
                <td><b>Product Copies: </b></td>
                <td>${order.productCopies}</td>
            </tr>
            <tr>
                <td><b>Total Amount: </b></td>
                <td>$${order.total}</td>
            </tr>
        </table>

        <h2>Recipient Information</h2>
        <table>
            <tr>
                <td><b>First Name: </b></td>
                <td>${order.recipientFullName}</td>
            </tr>
            <tr>
                <td><b>Last Name: </b></td>
                <td>${order.recipientLastName}</td>
            </tr>
            <tr>
                <td><b>Phone: </b></td>
                <td>${order.recipientPhone}</td>
            </tr>
            <tr>
                <td><b>Address Line 1: </b></td>
                <td>${order.recipientAddressLine1}</td>
            </tr>
            <tr>
                <td><b>Address Line 2: </b></td>
                <td>${order.recipientAddressLine2}</td>
            </tr>
            <tr>
                <td><b>City: </b></td>
                <td>${order.recipientCity}</td>
            </tr>
            <tr>
                <td><b>State: </b></td>
                <td>${order.recipientState}</td>
            </tr>
            <tr>
                <td><b>Country: </b></td>
                <td>${order.recipientCountryName}</td>
            </tr>
            <tr>
                <td><b>Zip Code: </b></td>
                <td>${order.recipientZipCode}</td>
            </tr>
        </table>
    </div>

    <div align="center">
        <h2>Ordered Products</h2>
        <table style="border: 0">
            <tr>
                <th>Index</th>
                <th>Product Title</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Subtotal</th>
            </tr>
            <c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>
                        <img style="vertical-align: middle;"
                             src="data:image/jpg;base64,${orderDetail.product.base64Image}" width="48" height="64"/>
                            ${orderDetail.product.title}
                    </td>
                    <td>$${orderDetail.product.price}</td>
                    <td>${orderDetail.quantity}</td>
                    <td>$${orderDetail.subtotal}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" align="right">
                    <p>Subtotal: $${order.subtotal}</p>
                    <p>Tax: $${order.tax}</p>
                    <p>Shipping fee: $${order.shippingFee}</p>
                    <p>TOTAL: $${order.total}</p>
                </td>
            </tr>
        </table>
    </div>
</c:if>

<%@ include file="footer.jsp" %>
</body>
</html>