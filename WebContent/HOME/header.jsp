<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!-- Topbar Start -->
    <div class="container-fluid ">
        <div class="row align-items-center bg-light px-xl-5 d-none d-lg-flex flex-between">
            <div class="col-lg-4">
                <a href="HomeServlet" class="text-decoration-none">
                    <div class="row">
                        <div class="logo-shop">
                            <img src="./image/logo.png" alt="logoweb">
                        </div>
                        <!-- <span class="h1 text-uppercase text-primary bg-dark px-2">BoardGo</span> -->
                        <span class="h1 text-center align-center-logo ">Board<span class="text-primary">Go</span></span>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-6 text-left">
               <form action="searchServlet" method = "post">
                <div class="input-group">
                    <input name="txt" type="text" class="form-control" placeholder="Tìm kiếm sản phẩm tại đây">
                    <div class="input-group-append">
                            <button type="submit" class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </button>
                    </div>
                </div>
           </form>
            </div>
        </div>
    </div>
    <!-- Topbar End -->

    <!-- Navbar Start -->
    <div class="container-fluid bg-dark mb-30">
        <div class="row px-xl-5">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <!-- <span class="h1 text-uppercase text-dark bg-light px-2">Multi</span>
                        <span class="h1 text-uppercase text-light bg-primary px-2 ml-n1">Shop</span> -->
                        <span class="h1 text-center align-center-logo text-white ">Board<span class="text-primary">Go</span></span>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="HomeServlet" class="nav-item nav-link active">Trang Chủ</a>
                            <a href="ShopServlet" class="nav-item nav-link">Cửa Hàng</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Thông Tin <i class="fa fa-angle-down mt-1"></i></a>
                                <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                    <a href="ProductServlet" class="dropdown-item">Giỏ Hàng</a>
                                    <a href="checkout.jsp" class="dropdown-item">Thanh Toán</a>
                                </div>
                            </div>
                            <a href="contact.jsp" class="nav-item nav-link">Liên Hệ</a>
                        </div>
                        <div class="navbar-nav ml-auto py-0 d-none d-lg-block">
                            
                            <a href="ProductServlet" class="btn px-0 ml-3">
                                <i class="fas fa-shopping-cart text-primary"></i>
                                <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">${ numberOfCart == null ? 0 :numberOfCart }</span>
                            </a>
                        </div>
                    </div>
                    <div id="navbar-nav mr-auto py-0" style ="display : flex;" >
                    		<a href="logout" class="nav-item nav-link">Đăng xuất</a>
                            <a href="logout" class="nav-item nav-link"><%=session.getAttribute("name") %></a>                            
               		</div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->
