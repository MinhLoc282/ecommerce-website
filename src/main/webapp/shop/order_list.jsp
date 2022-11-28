<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <%@ include file="common.jsp" %>

    <link rel="stylesheet" href="shop/css/style.css">

    <title>Order History - Online Store</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div align="center">
    <h2>My Order History</h2>
</div>

<c:if test="${fn:length(listOrder) == 0}">
    <div align="center">
        <h3>You have not placed any order.</h3>
    </div>
</c:if>

<c:if test="${fn:length(listOrder) > 0}">
    <div align="center">
        <table>
            <tr>
                <th>Index</th>
                <th>Order ID</th>
                <th>Quantity</th>
                <th>Total Amount</th>
                <th>Order Date</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="order" items="${listOrder}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${order.orderId}</td>
                    <td>${order.productCopies}</td>
                    <td>$${order.total}"</td>
                    <td>${order.orderDate}</td>
                    <td>${order.status}</td>
                    <td>
                        <a href="show_order_detail?id=${order.orderId}">View Detail</a> &nbsp;
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>

<%@ include file="footer.jsp" %>
</body>
</html>