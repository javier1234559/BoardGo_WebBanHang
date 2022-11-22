<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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

<jsp:include page="header.jsp" ></jsp:include>

<!-- Breadcrumb Start -->
<div class="container-fluid">
    <div class="row px-xl-5">
        <div class="col-12">
            <nav class="breadcrumb bg-light mb-30">
                <a class="breadcrumb-item text-dark" href="#">Trang Chủ</a>
                <a class="breadcrumb-item text-dark" href="ShopServlet">Cửa Hàng</a>
                <span class="breadcrumb-item active">Danh Sách Sản Phẩm</span>
            </nav>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->


<!-- Shop Start -->
<div class="container-fluid">
    <div class="row px-xl-5">
        <!-- Shop Sidebar Start -->
        <div class="col-lg-3 col-md-4">
            <!-- Price Start -->
            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">SẮP XẾP THEO GIÁ</span></h5>
            <div class="bg-light p-4 mb-30">
                <form>
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" class="custom-control-input" checked id="price-all">
                        <label for="size-all"><a href="ShopServlet" style="text-decoration:none;color:<%="red"%>;">TẤT CẢ GIÁ</a></label>
                        <span class="badge border font-weight-normal">1000</span>
                    </div>
                    <c:forEach items="${productListbyprice}" var="o" >
	                    <div style="${cid == o.idproduct ? active : null }" class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
	                        <label class="" for="size-1"><a href="ShopServletByPrice?cid=${o.idproduct}" style="text-decoration:none;color:#6C757D;">${o.price}</a></label>
	                        <span class="badge border font-weight-normal">150</span>
	                    </div>
                    </c:forEach>
                 
                </form>
            </div>
            <!-- Price End -->

            <!-- Color Start -->
            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">SẮP XẾP THEO MÀU</span></h5>
            <div class="bg-light p-4 mb-30">
                <form>
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" class="custom-control-input" checked id="color-all">
                        <label style="<%="color:red;" %>" for="size-all"><a href="ShopServlet" style="text-decoration:none;color:<%="red"%>;">TẤT CẢ MÀU</a></label>
                        <span class="badge border font-weight-normal">1000</span>
                    </div>
                    <c:forEach items="${productDetails}" var="o">
	                       <div style="${cid == o.idimage ? active : null }"  class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
	                        <label class="" for="size-1"><a href="ShopServletByColor?cid=${o.idimage}" style="text-decoration:none;color:#6C757D;">${o.color}</a></label>
	                        <span class="badge border font-weight-normal">99</span>
	                    	</div>
                    </c:forEach>
                 
                </form>
            </div>
            <!-- Color End -->

            <!-- Size Start -->
            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">SẮP XẾP THEO LOẠI</span></h5>
            <div class="bg-light p-4 mb-30">
                <form>
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        
                        <label style="<%="color:red;" %>" for="size-all"><a href="" style="text-decoration:none;color:<%="red"%>;">TẤT CẢ LOẠI</a></label>
                        <span class="badge border font-weight-normal">1000</span>
                    </div>
                    <c:forEach items="${productListbycategory}" var="o" >
                    <div style="${cid == o.idproduct ? active : null }" class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <label class="" for="size-1"><a href="ShopServletByCategory?cid=${o.idproduct}" style="text-decoration:none;color:#6C757D;">${o.category}</a></label>
                        <span class="badge border font-weight-normal">150</span>
                    </div>
					</c:forEach>
                </form>
            </div>
            <!-- Size End -->
        </div>
        <!-- Shop Sidebar End -->
        
        <!-- Shop Product Start -->
        <div class="col-lg-9 col-md-8">
            <div class="row pb-3">
                <div class="col-12 pb-1">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <div>
                            <button class="btn btn-sm btn-light"><i class="fa fa-th-large"></i></button>
                            <button class="btn btn-sm btn-light ml-2"><i class="fa fa-bars"></i></button>
                        </div>
                        <div class="ml-2">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Sắp xếp theo</button>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <a class="dropdown-item" href="ShopServlet">Mới Nhất</a>
                                </div>
                            </div>
                            <div class="btn-group ml-2">
                                <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Hiển thị</button>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <a class="dropdown-item" href="ShopServletByLimit?cid=5">5</a>
                                    <a class="dropdown-item" href="ShopServletByLimit?cid=7">7</a>
                                    <a class="dropdown-item" href="ShopServletByLimit?cid=10">10</a>
                                    <a class="dropdown-item" href="ShopServletByLimit?cid=15">15</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <c:forEach var="o" items="${productList}">
                <div class="col-lg-4 col-md-6 col-sm-6 pb-1">
                    <div class="product-item bg-light mb-4">
                        <div class="product-img position-relative overflow-hidden">
                            <img class="img-fluid w-100" style="max-width: 100%; height: 250px; object-fit: cover" src="${o.image}" alt="">
                            <div class="product-action">
                                <a class="btn btn-outline-dark btn-square" href="ProductServlet?action=AddCart&code=${o.idproduct}"><i class="fa fa-shopping-cart"></i></a>
                                
                                <a class="btn btn-outline-dark btn-square" href="DetailServlet?cid=${o.idproduct}"><i class="fa fa-search"></i></a>
                            </div>
                        </div>
                        <div class="text-center py-4">
                            <a class="h6 text-decoration-none text-truncate" href="">${o.nameproduct}</a>
                            <div class="d-flex align-items-center justify-content-center mt-2">
                                <h5><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.price}"/>VNĐ</h5><h6 class="text-muted ml-2"><del><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.price + 200000}"/>VNĐ</del></h6>
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
                <div class="col-12">
                    <nav>
                        <ul class="pagination justify-content-center">
                            <li class="page-item"><a class="page-link" href="ShopServlet?index=0"><span>Top</span></a></li>
                            
                            <c:forEach begin="1" end="${endPage}" var="i">
                            	<li class="page-item ${index == ((i-1)*9) ? activePagination : null } "><a class="page-link" href="ShopServlet?index=${(i-1)*9}">${i}</a></li>
                            </c:forEach>
                            <li class="page-item"><a class="page-link" href="ShopServlet?index=${(endPage-1)*9}">End</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Shop Product End -->
    </div>
</div>
<!-- Shop End -->


<jsp:include page="footer.jsp" ></jsp:include>

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
</body>

</html>