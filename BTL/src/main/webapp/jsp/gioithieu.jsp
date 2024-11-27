<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Giới Thiệu Shop Thời Trang</title>

  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }
    header {
      background-color: #333;
      color: #fff;
      padding: 20px;
      text-align: center;
    }
    header {
      background-color: #333;
      color: white;
      padding: 10px 20px;
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    .top-bar {
      width: 100%;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .contact-info, .top-nav {
      display: flex;
      gap: 15px;
    }

    .top-nav ul {
      display: flex;
      list-style: none;
      padding: 0;
    }

    .top-nav ul li {
      margin: 0 10px;
    }

    .top-nav ul li a {
      color: white;
      text-decoration: none;
    }
    .top-nav ul li a:hover {
      color: blue; /* Đổi màu chữ thành xanh dương khi hover */
    }
    section {
      padding: 20px;
      text-align: center;
    }
    h1 {
      font-size: 36px;
      color: #333;
    }
    p {
      font-size: 18px;
      line-height: 1.6;
      color: #555;
    }
    .about-section {
      background-color: #fff;
      padding: 40px 20px;
      margin: 20px auto;
      width: 80%;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
    }
    .about-section img {
      max-width: 100%;
      border-radius: 8px;
    }
    footer {
      background-color: #333;
      color: #fff;
      text-align: center;
      padding: 10px 0;
      position: relative;
      bottom: 0;
      width: 100%;
    }
    /* Dropdown menu styles */
                              .dropdown {
                                  position: relative;
                                  display: inline-block;
                              }

                              .dropdown-content {
                                  display: none;
                                  position: absolute;
                                  background-color: #222222;
                                  box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
                                  padding: 12px 16px;
                                  z-index: 1;
                              }

                              .dropdown:hover .dropdown-content {
                                  display: block;
                              }

                              .dropdown-content a {
                                  display: block;
                                  color: black;
                                  text-decoration: none;
                                  padding: 8px 0;
                              }

                              .dropdown-content a:hover {
                                  background-color: #ddd;
                              }
  </style>
</head>
<body>
<header>
    <div class="top-bar">
       <div class="landing-page">
              <a href= "${pageContext.request.contextPath}/jsp/index.jsp">
              <img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo" width = 250px height = 75px>
          </a>
       </div>

        <nav class="top-nav">
            <ul>
                <li></li>
                <!-- Dropdown menu for products -->
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/products?category=0">Sản Phẩm</a>
                    <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/products?category=1">Áo Nam</a>
                        <a href="${pageContext.request.contextPath}/products?category=2">Quần Nam</a>
                        <a href="${pageContext.request.contextPath}/products?category=3">Giày Nam</a>
                        <a href="${pageContext.request.contextPath}/products?category=4">Áo Nữ</a>
                        <a href="${pageContext.request.contextPath}/products?category=5">Quần Nữ</a>
                        <a href="${pageContext.request.contextPath}/products?category=6">Giày Nữ</a>
                        <a href="${pageContext.request.contextPath}/products?category=7">Váy Nữ</a>
                        <a href="${pageContext.request.contextPath}/products?category=8">Phụ Kiện</a>
                    </div>
                </li>
                <li><a href="${pageContext.request.contextPath}/jsp/gioithieu.jsp">Giới Thiệu</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/lienhe.jsp">Liên Hệ</a></li>
                <li><a href="${pageContext.request.contextPath}/login" class="login-button">Đăng nhập</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/toi.jsp">Tôi</a></li>
            </ul>
        </nav>
    </div>
</header>


<section class="about-section">
  <h2>Về Chúng Tôi</h2>
  <p>StyleNest là nơi bạn có thể tìm thấy những trang phục thời trang phong cách và chất lượng cao. Chúng tôi tự hào mang đến cho khách hàng những sản phẩm đa dạng từ áo quần, phụ kiện đến giày dép, tất cả đều được lựa chọn kỹ lưỡng để phù hợp với xu hướng hiện đại.</p>
  <p>Với đội ngũ tư vấn chuyên nghiệp và nhiệt tình, chúng tôi cam kết mang đến cho bạn trải nghiệm mua sắm tuyệt vời nhất. Hãy đến với StyleNest để thể hiện phong cách riêng của bạn.</p>
  <img src="${pageContext.request.contextPath}/images/gioithieu.png" width="800" alt="StyleNest Store">
</section>

<footer>
  <p>&copy; 2024 StyleNest - All Rights Reserved</p>
</footer>

</body>
</html>