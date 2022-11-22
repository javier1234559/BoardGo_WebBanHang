<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%
	if(session.getAttribute("name")==null){
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>BoardGo</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="image/logo.png" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style1.css" rel="stylesheet">
    <link href="morestyle/main.css" rel="stylesheet">
</head>

<body>
    <jsp:include page="header.jsp"></jsp:include>
    <!-- Carousel Start -->
    <div class="container-fluid mb-3">
        <div class="row px-xl-5">
            <div class="col-lg-12">
                <div id="header-carousel" class="carousel slide carousel-fade mb-30 mb-lg-0" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#header-carousel" data-slide-to="0" class="active"></li>
                        <li data-target="#header-carousel" data-slide-to="1"></li>
                        <li data-target="#header-carousel" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">  
                    <div class="carousel-item position-relative active" style="height: 430px;">
                            <img class="position-absolute w-100 h-100" src="${top3product[0].image}" style="object-fit: cover;">
                            <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                <div class="p-3" style="max-width: 700px;">
                                    <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Key Board</h1>
                                    <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Mua bàn phím giao tận nơi và tham khảo thêm nhiều sản phẩm khác. Miễn phí vận chuyển toàn quốc cho mọi đơn hàng . Đổi trả dễ dàng.</p>
                                    <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp" href="ShopServlet">Shop Now</a>
                                </div>
                            </div>
                        </div>
                    <c:forEach var="i" begin="1" end="${3-1}" >
                    	<div class="carousel-item position-relative " style="height: 430px;">
                            <img class="position-absolute w-100 h-100" src="${top3product[i].image}" style="object-fit: cover;">
                            <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                <div class="p-3" style="max-width: 700px;">
                                    <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Key Board</h1>
                                    <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Mua bàn phím giao tận nơi và tham khảo thêm nhiều sản phẩm khác. Miễn phí vận chuyển toàn quốc cho mọi đơn hàng . Đổi trả dễ dàng.</p>
                                    <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp" href="ShopServlet">Shop Now</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Carousel End -->

    <!-- Featured Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5 pb-3">
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                    <h1 class="fa fa-check text-primary m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-0">Sản phẩm chất lượng</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                    <h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
                    <h5 class="font-weight-semi-bold m-0">Miễn phí giao hàng</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                    <h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-0">14 ngày đổi trả</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                    <h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-0">24/7 Hỗ trợ</h5>
                </div>
            </div>
        </div>
    </div>
    <!-- Featured End -->

    <!-- Categories Start -->
    <div class="container-fluid pt-5">
        <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">MỘT SỐ LOẠI </span></h2>
        <div class="row px-xl-5 pb-3">
       		<c:forEach var="o" items ="${productListbycategory}">
            <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                <a class="text-decoration-none" href="ShopServletByCategory?cid=${o.idproduct}">
                    <div class="cat-item d-flex align-items-center mb-4">
                        <div class="overflow-hidden" style="width: 100px; height: 100px;">
                            <img style="height: 100%;" class="img-fluid" src="${o.image}" alt="">
                        </div>
                        <div class="flex-fill pl-3">
                            <h6>${o.category}</h6>
                        </div>
                    </div>
                </a>
            </div>
            </c:forEach>
            
        </div>
    </div>
    <!-- Categories End -->


    <!-- Products Start -->
    <div class="container-fluid pt-5 pb-3">
        <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">Sản phẩm phổ biến</span></h2>
        <div class="row px-xl-5">
            <div class="col-lg-4 col-md-6 col-sm-6 pb-1">
                <div class="product-item bg-light mb-4">
                    <div class="product-img position-relative overflow-hidden">
                        <img class="img-fluid w-100" src="${top12product[0].image }" alt="">
                        <div class="product-action">
                            <a class="btn btn-outline-dark btn-square" href="ProductServlet?action=AddCart&code=${top12product[0].idproduct}"><i class="fa fa-shopping-cart"></i></a>
                           
                            <a class="btn btn-outline-dark btn-square" href="DetailServlet?cid=${top12product[0].idproduct}"><i class="fa fa-search"></i></a>
                        </div>
                    </div>
                    <div class="text-center py-4">
                        <a class="h6 text-decoration-none text-truncate" href="">${top12product[0].nameproduct}</a>
                        <div class="d-flex align-items-center justify-content-center mt-2">
                            <h5><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${top12product[0].price}"/>VNĐ</h5><h6 class="text-muted ml-2"><del><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${top12product[0].price + 200000}"/>VNĐ</del></h6>
                        </div>
                        <div class="d-flex align-items-center justify-content-center mb-1">
                            <small class="fa fa-star text-primary mr-1"></small>
                            <small class="fa fa-star text-primary mr-1"></small>
                            <small class="fa fa-star text-primary mr-1"></small>
                            <small class="fa fa-star text-primary mr-1"></small>
                            <small class="fa fa-star text-primary mr-1"></small>
                            <small>(99)</small>
                        </div>
                    </div>
                </div>
            </div>
	        <c:forEach var="i" begin="1" end="${12-1}" >
						 <div class="col-lg-4 col-md-6 col-sm-6 pb-1">
	                    <div class="product-item bg-light mb-4">
	                        <div class="product-img position-relative overflow-hidden">
	                            <img class="img-fluid w-100" style="max-width: 100%; height: 250px; object-fit: cover" src="${top12product[i].image}" alt="">
	                            <div class="product-action">
	                                <a class="btn btn-outline-dark btn-square" href="ProductServlet?action=AddCart&code=${top12product[i].idproduct}"><i class="fa fa-shopping-cart"></i></a>
	                              
	                                <a class="btn btn-outline-dark btn-square" href="DetailServlet?cid=${top12product[i].idproduct}"><i class="fa fa-search"></i></a>
	                            </div>
	                        </div>
	                        <div class="text-center py-4">
	                            <a class="h6 text-decoration-none text-truncate" href="">${top12product[i].nameproduct}</a>
	                            <div class="d-flex align-items-center justify-content-center mt-2">
	                                <h5><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${top12product[i].price}"/>VNĐ</h5><h6 class="text-muted ml-2"><del><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${top12product[i].price + 200000}"/>VNĐ</del></h6>
	                            </div>
	                            <div class="d-flex align-items-center justify-content-center mb-1">
	                                <small class="fa fa-star text-primary mr-1"></small>
	                                <small class="fa fa-star text-primary mr-1"></small>
	                                <small class="fa fa-star text-primary mr-1"></small>
	                                <small class="fa fa-star text-primary mr-1"></small>
	                                <small class="fa fa-star text-primary mr-1"></small>
	                                <small>5</small>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </c:forEach>
        </div>
    </div>
    <!-- Products End -->


    <!-- Offer Start -->
    <div class="container-fluid pt-5 pb-3">
        <div class="row px-xl-5">
            <div class="col-md-6">
                <div class="product-offer mb-30" style="height: 300px;">
                    <img class="img-fluid" src="${top3product[0].image}" alt="">
                    <div class="offer-text">
                        <h6 class="text-white text-uppercase">Tiết kiệm 20%</h6>
                        <h3 class="text-white mb-3">Ưu đãi đặc biệt</h3>
                        <a href="ShopServlet" class="btn btn-primary">Mua Ngay</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="product-offer mb-30" style="height: 300px;">
                    <img class="img-fluid" src="${top3product[2].image}" alt="">
                    <div class="offer-text">
                        <h6 class="text-white text-uppercase">Tiết kiệm 20%</h6>
                        <h3 class="text-white mb-3">Ưu đãi đặc biệt</h3>
                        <a href="ShopServlet" class="btn btn-primary">Mua Ngay</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Offer End -->


    <!-- Vendor Start -->
    <div class="container-fluid py-5">
        <div class="row px-xl-5">
            <div class="col">
                <div class="owl-carousel vendor-carousel">
                    <div class="bg-light p-4">
                        <img src="img/vendor-1.jpg" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="img/vendor-2.jpg" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="img/vendor-3.jpg" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="img/vendor-4.jpg" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="img/vendor-5.jpg" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="img/vendor-6.jpg" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="img/vendor-7.jpg" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="img/vendor-8.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Vendor End -->


   <jsp:include page="footer.jsp"></jsp:include>


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    <script src="js1/main.js"></script>
</body>

</html>