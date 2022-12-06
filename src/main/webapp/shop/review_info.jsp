<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <%@ include file="common.jsp" %>

    <link rel="stylesheet" href="shop/css/jquery.rateyo.min.css">

    <script type="text/javascript" src="shop/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="shop/js/jquery.rateyo.min.js"></script>

    <title>Write Review - Online Store</title>
</head>
<body>
<%@ include file="header.jsp" %>

<h1 class="products text-center">You already wrote a review for this product.</h1>
<div class="container">
    <div class="row">
        <div class="col-md-6 text-center">
            <div class="product-image mt-3">
                <img class="img-fluid" src="data:image/jpg;base64,${product.base64Image}" alt=""/>
            </div>
        </div>
        <div class="col-md-6 mt-5 mt-md-2 text-center text-md-left">
            <h5>${product.title}</h5>
            <h5>Headline</h5>
            <h6>${review.headline}</h6>
            <h5>Details</h5>
            <h6>${review.comment}</h6>
        </div>
    </div>
</div>
<h2 class="products text-center"></h2>

<%@ include file="footer.jsp" %>
<!-- Placed at the end of the document so the pages load faster -->
<script src="shop/js/list.min.js"></script>
<script src="shop/js/jquery-3.1.1.min.js"></script>
<script src="shop/bootstrap/js/bootstrap.min.js"></script>
<script src="shop/js/tether.min.js"></script>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#rateYo").rateYo({
            starWidth: "40px",
            fullStar: true,
            rating: ${review.rating},
            readOnly: true
        });
    });
</script>
</html>