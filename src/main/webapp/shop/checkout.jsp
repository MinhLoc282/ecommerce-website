<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ include file="common.jsp" %>

    <link rel="stylesheet" href="shop/css/style.css">

    <title>Checkout - Online Store</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div align="center">
    <c:if test="${message != null}">
        <div align="center">
            <h4>${message}</h4>
        </div>
    </c:if>

    <c:set var="cart" value="${sessionScope['cart']}"/>

    <c:if test="${cart.totalItems == 0}">
        <h2>There's no items in your cart</h2>
    </c:if>

    <c:if test="${cart.totalItems > 0}">
        <div>
            <h2>Review Your Order Detail <a href="view_cart">Edit</a></h2>
            <table style="border: 0">
                <tr>
                    <th>No</th>
                    <th colspan="2">Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>
                </tr>

                <c:forEach items="${cart.items}" var="item" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td><img class="book-small" src="data:image/jpg;base64,${item.key.base64Image}" alt=""/></td>
                        <td><span id="book-title">${item.key.title}</span></td>
                        <td>$${item.key.price}</td>
                        <td><input type="text" name="quantity${status.index + 1}" value="${item.value}" size="5"
                                   readonly="readonly"/>
                        </td>
                        <td>$${item.value * item.key.price}</td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="6">
                        <p>${cart.totalQuantity} product(s)</p>
                        <p>Subtotal: $${cart.totalAmount}</p>
                        <p>Tax: $${tax}</p>
                        <p>Shipping Fee: $${shippingFee}</p>
                        <p>TOTAL: $${total}</p>
                    </td>
                    <td><b></b></td>
                    <td>Total:</td>
                    <td colspan="2"><b>$${cart.totalAmount}</b></td>
                </tr>
            </table>
            <h2>Your Shipping Information</h2>
            <form action="place_order" method="post">
                <table>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" name="recipientFirstName" value="${loggedCustomer.firstName}"
                                   required="required" maxlength="32"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" name="recipientLastName" value="${loggedCustomer.lastName}"
                                   required="required" maxlength="32"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Phone:</td>
                        <td><input type="number" name="recipientPhone" value="${loggedCustomer.phone}"
                                   required="required" maxlength="16"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Address Line 1:</td>
                        <td><input type="text" name="recipientAddressLine1" value="${loggedCustomer.addressLine1}"
                                   required="required" maxlength="128"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Address Line 2:</td>
                        <td><input type="text" name="recipientAddressLine2" value="${loggedCustomer.addressLine2}"
                                   required="required" maxlength="128"/>
                        </td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td><input type="text" name="recipientCity" value="${loggedCustomer.city}" required="required"
                                   maxlength="32">
                        </td>
                    </tr>
                    <tr>
                        <td>State:</td>
                        <td><input type="text" name="recipientState" value="${loggedCustomer.state}" required="required"
                                   maxlength="32">
                        </td>
                    </tr>
                    <tr>
                        <td>Zip Code:</td>
                        <td><input type="text" name="recipientZipCode" value="${loggedCustomer.zipCode}"
                                   required="required" maxlength="16"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Country:</td>
                        <td>
                            <select name="recipientCountry">
                                <c:forEach items="${mapCountries}" var="country">
                                    <option value="${country.value}"
                                            <c:if test="${loggedCustomer.country eq country.value}">selected="selected"</c:if>>${country.key}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>

                <div>
                    <h2>Payment</h2>
                    Choose your payment method:
                    &nbsp;&nbsp;&nbsp;
                    <select name="paymentMethod">
                        <option value="Cash On Delivery">Cash On Delivery</option>
                        <option value="paypal">PayPal or Credit card</option>
                    </select>
                </div>

                <div>
                    <table class="normal">
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>
                                <button type="submit">Place Order</button>
                            </td>
                            <td><a href="${pageContext.request.contextPath}/">Continue Shopping</a></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
    </c:if>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>