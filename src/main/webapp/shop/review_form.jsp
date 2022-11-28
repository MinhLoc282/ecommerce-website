<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <%@ include file="common.jsp" %>

    <link rel="stylesheet" href="shop/css/style.css">
    <link rel="stylesheet" href="shop/css/jquery.rateyo.min.css">

    <script type="text/javascript" src="shop/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="shop/js/jquery.validate.min.js"></script>

    <script src="shop/js/jquery.rateyo.min.js"></script>

    <title>Write Review - Online Store</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div align="center">
    <form action="submit_review" method="post">
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
                <td>
                    <div id="rateYo"></div>
                    <input type="hidden" id="rating" name="rating"/>
                    <input type="hidden" name="productId" value="${product.productId}"/>
                    <br/>
                    <input type="text" name="headline" size="60"
                           placeholder="Headline or summary for your review (required)" required="required"/>
                    <br/>
                    <br/>
                    <textarea name="comment" cols="70" rows="10" placeholder="Write your review details..."
                              required="required"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <button type="submit">Submit</button>
                    &nbsp;&nbsp;
                    <button onclick="history.go(-1);">Cancel</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<%@ include file="footer.jsp" %>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#rateYo").rateYo({
            starWidth: "40px",
            fullStar: true,
            onSet: function (rating, rateYoInstance) {
                $("#rating").val(rating);
            }
        });
    });
</script>
</html>