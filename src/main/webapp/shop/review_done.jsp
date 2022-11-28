<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <%@ include file="common.jsp" %>

    <link rel="stylesheet" href="shop/css/style.css">

    <title>Review Posted - Online Store</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div align="center">
    <table style="border: 0">
        <tr>
            <td><h2>Your Reviews</h2></td>
            <td>&nbsp;</td>
            <td><h2>${loggedCustomer.fullName}</h2></td>
        </tr>
        <tr>
            <td colspan="3">
                <hr/>
            </td>
        </tr>
        <tr>
            <td>
                <span id="product-title">${product.title}</span><br/>
                <img class="product-large" src="data:image/jpg;base64,${product.base64Image}" alt=""/>
            </td>
            <td colspan="2">
                <h3>Your review has been posted. Thank you!</h3>
            </td>
        </tr>
    </table>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>