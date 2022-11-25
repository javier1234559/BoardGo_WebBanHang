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
                    <span class="breadcrumb-item active">Giỏ Hàng</span>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->


    <!-- Cart Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-light table-borderless table-hover text-center mb-0">
                    <thead class="thead-dark">
                        <tr>
                            <th>Sản Phẩm </th>
                            <th>Giá</th>
                            <th>Số Lượng</th>
                            <th>Tổng</th>
                            <th>Xóa</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                        
                    <c:forEach items="${lsCart}" var="o">
	                    <tr>
                            <td class="align-middle"><img src="${o.getPro().image}" alt="" style="width: 50px;"> ${o.getPro().nameproduct}</td>
                            <td class="align-middle"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.getPro().price}"/>VNĐ</td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                               
                                    <div class="input-group-btn">
	                                     <a href="ProductServlet?action=SubCart&codeSub=${o.getPro().idproduct}" >
	                                        <button class="btn btn-sm btn-primary btn-minus" >
	                                        <i class="fa fa-minus"></i>
	                                        </button>
	                                	</a>
                                    </div>
                                    <input type="text" class="form-control form-control-sm bg-secondary border-0 text-center" value="${o.getQuantity()}">
                                    <div class="input-group-btn">
	                                    <a href="ProductServlet?action=AddCart&code=${o.getPro().idproduct}" >
	                                        <button class="btn btn-sm btn-primary btn-plus">
	                                            <i class="fa fa-plus"></i>
	                                        </button>                                    
	                                    </a>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.getPro().price}"/>VNĐ</td>
                            <td class="align-middle"><a href="ProductServlet?action=DelCart&name=${o.getPro().idproduct}"><i class="fa fa-times"></i></a></td>
                        </tr>
					</c:forEach>
                          
                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
                <form class="mb-30" action="">
                    <div class="input-group">
                        <input type="text" class="form-control border-0 p-4" placeholder="Mã giảm giá">
                        <div class="input-group-append">
                            <button class="btn btn-primary">Áp Dụng</button>
                        </div>
                    </div>
                </form>
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Tổng Cộng</span></h5>
                <div class="bg-light p-30 mb-5">
                    <div class="border-bottom pb-2">
                        <div class="d-flex justify-content-between mb-3">
                            <h6>Tạm tính</h6>
                            <h6><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${cost == 0 ? 0 : (cost + 10000)}"/>VNĐ</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Phí giao hàng</h6>
                            <h6 class="font-weight-medium"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "10000"/>VNĐ</h6>
                        </div>
                    </div>
                    <div class="pt-2">
                        <div class="d-flex justify-content-between mt-2">
                            <h5>Tổng</h5>
                            <h5><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${cost == 0 ? 0 : (cost + 10000)}"/>VNĐ</h5>
                            
                        </div>
                        <button class="btn btn-block btn-primary font-weight-bold my-3 py-3">Tiếp đến Thanh Toán</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Cart End -->

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