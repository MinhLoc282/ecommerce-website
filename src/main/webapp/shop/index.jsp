<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <%@ include file="common.jsp" %>

    <title>Home Page</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="video-container">
    <div class="slide-video">
        <div class="content-video">
            <h2>TOP MENS 2022 COLLECTION</h2>
            <a href="" class="btn-video">Discover the Collection</a>
        </div>
        <video class="video-dk" autoplay="autoplay" loop="loop" muted="muted">
            <source src="https://lv-vod.fl.freecaster.net/vod/louisvuitton/dikq6kFFzG_HD.mp4" type="video/mp4">
        </video>
    </div>
</div>

<div class="video-container">
    <div class="slide-video">
        <div class="content-video">
            <h2>TOP MENS 2022 COLLECTION</h2>
            <a href="" class="btn-video">Discover the Collection</a>
        </div>
        <video class="video-dk" autoplay="autoplay" loop="loop" muted="muted">
            <source src="https://lv-vod.fl.freecaster.net/vod/louisvuitton/07Ydxht4Ij_HD.mp4" type="video/mp4">
        </video>
    </div>
</div>

<div class="video-container">
    <div class="slide-video">
        <div class="content-video">
            <h2>TOP MENS 2022 COLLECTION</h2>
            <a href="view_category?id=2" class="btn-video">Discover the
                Collection</a>
        </div>
        <video class="video-dk" autoplay="autoplay" loop="loop" muted="muted">
            <source src="https://lv-vod.fl.freecaster.net/vod/louisvuitton/ZjCbGJjT9y_HD.mp4" type="video/mp4">
        </video>
    </div>
</div>

<%@ include file="footer.jsp" %>

<!-- Placed at the end of the document so the pages load faster -->
<script src="shop/js/jquery-3.3.1.min.js"></script>
<script src="shop/bootstrap/js/bootstrap.min.js"></script>
<script src="shop/js/tether.min.js"></script>
<script src="shop/js/popper.min.js"></script>

<script>
    let btn = $('#btn-backtop');
    $(window).scroll(function () {
        if ($(window).scrollTop() > 300) {
            btn.addClass('show');
        } else {
            btn.removeClass('show');
        }
    });

    btn.on('click', function (e) {
        e.preventDefault();
        $('html, body').animate({
            scrollTop: 0
        }, '300');
    });
</script>
</body>
</html>