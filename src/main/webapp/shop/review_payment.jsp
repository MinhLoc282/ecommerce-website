<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <%@ include file="common.jsp" %>

    <link rel="stylesheet" href="shop/css/style.css">

    <title>Review Payment - Online Store</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div align="center">
    <h3><i>Please carefully review the following information before making payment</i></h3>
    <h2>Payer Information</h2>
    <table>
        <tr>
            <td><b>First Name:</b></td>
            <td>${payer.firstName}</td>
        </tr>
        <tr>
            <td><b>Last Name:</b></td>
            <td>${payer.lastName}</td>
        </tr>
        <tr>
            <td><b>Email:</b></td>
            <td>${payer.email}</td>
        </tr>
    </table>
    <h2>Recipient Information</h2>
    <table>
        <tr>
            <td><b>Recipient Name:</b></td>
            <td>${recipient.recipientName}</td>
        </tr>
        <tr>
            <td><b>Address Line 1:</b></td>
            <td>${recipient.line1}</td>
        </tr>
        <tr>
            <td><b>Address Line 2:</b></td>
            <td>${recipient.line2}</td>
        </tr>
        <tr>
            <td><b>City:</b></td>
            <td>${recipient.city}</td>
        </tr>
        <tr>
            <td><b>State:</b></td>
            <td>${recipient.city}</td>
        </tr>
        <tr>
            <td><b>Country Code:</b></td>
            <td>${recipient.countryCode}</td>
        </tr>
        <tr>
            <td><b>Postal Code:</b></td>
            <td>${recipient.postalCode}</td>
        </tr>
    </table>
    <h2>Transaction Details</h2>
    <table>
        <tr>
            <td><b>Description:</b></td>
            <td>${transaction.description}</td>
        </tr>
        <tr>
            <td colspan="2"><b>Item List:</b></td>
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
                    </c:forEach>
                    <tr>
                        <td colspan="5" align="right">
                            <p>Subtotal: $${transaction.amount.details.subtotal}</p>
                            <p>Tax: $${transaction.amount.details.tax}</p>
                            <p>Shipping Fee: $${transaction.amount.details.shipping}</p>
                            <p>TOTAL: $${transaction.amount.total}</p>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>

    <div>
        <br/>
        <form action="execute_payment" method="post">
            <input type="hidden" name="paymentId" value="${param.paymentId}"/>
            <input type="hidden" name="PayerID" value="${param.PayerID}"/>
            <input type="submit" value="Pay Now"/>
        </form>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>