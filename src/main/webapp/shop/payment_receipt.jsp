<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <%@ include file="common.jsp" %>

    <link rel="stylesheet" href="shop/css/style.css">

    <title>Payment Receipt - Online Store</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div align="center">
    <h5>You have made payment successfully. Thank you for purchasing!</h5>
    <h6>Your Payment Receipt</h6>
    <h2>Seller Information</h2>
    <table>
        <tr>
            <td><b>Email: </b></td>
            <td>sales@onlinestore.com</td>
        </tr>
        <tr>
            <td><b>Phone: </b></td>
            <td>+1 123 456 789</td>
        </tr>
    </table>

    <h2>Buyer Information</h2>
    <table>
        <tr>
            <td><b>First Name: </b></td>
            <td>${payer.firstName}</td>
        </tr>
        <tr>
            <td><b>Last Name: </b></td>
            <td>${payer.lastName}</td>
        </tr>
        <tr>
            <td><b>Email: </b></td>
            <td>${payer.email}</td>
        </tr>
    </table>

    <h2>Order Details</h2>
    <table>
        <tr>
            <td><b>Order ID: </b></td>
            <td>${orderId}</td>
        </tr>
        <tr>
            <td><b>Ordered by: </b></td>
            <td>${loggedCustomer.fullName}</td>
        </tr>
        <tr>
            <td><b>Transaction Description: </b></td>
            <td>${transaction.description}</td>
        </tr>
        <tr>
            <td colspan="2">Items:</td>
        </tr>
        <tr>
            <td colspan="2">
                <table>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Subtotal</th>
                    </tr>
                    <c:forEach items="${transaction.itemList.items}" var="item" varStatus="var">
                        <tr>
                            <td>${var.index + 1}</td>
                            <td>${item.name}</td>
                            <td>${item.quantity}</td>
                            <td>$${item.price}</td>
                            <td>$${item.price * item.quantity}</td>
                        </tr>
                        <tr>
                            <td colspan="5" align="right">
                                <p>Subtotal: $${transaction.amount.details.subtotal}</p>
                                <p>Tax: $${transaction.amount.details.tax}</p>
                                <p>Shipping Fee: $${transaction.amount.details.shipping}</p>
                                <p>TOTAL: $${transaction.amount.total}</p>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>