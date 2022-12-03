<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forTokens items="${product.ratingStars}" delims="," var="star">
    <c:if test="${star eq 'on'}">
        <img src="shop/images/rating_on.png" alt=""/>
    </c:if>
    <c:if test="${star eq 'off'}">
        <img src="shop/images/rating_off.png" alt=""/>
    </c:if>
    <c:if test="${star eq 'half'}">
        <img src="shop/images/rating_half.png" alt=""/>
    </c:if>
</c:forTokens>