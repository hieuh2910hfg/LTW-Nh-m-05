<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StyleNest - Fashion Store</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
    <!-- Header -->
    <header>
        <div class="top-bar">
            <div class="contact-info">
                <span class="language">Tên Web</span>
            </div>
            <nav class="top-nav">
                <ul>
                    <li><a href="./index.jsp">Trang Chủ</a></li>
                    <li><a href="./sanpham.jsp">Sản Phẩm</a></li>
                    <li><a href="./gioithieu.jsp">Giới Thiệu</a></li>
                    <li><a href="./lienhe.jsp">Liên Hệ</a></li>
                    <li><a href="./login.jsp" class="login-button">Đăng nhập</a></li>
                    <li><a href="./toi.jsp">Tôi</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <!-- Banner Section -->
    <section class="banner" id="home">
        <h2>Tên web</h2>
        <p>Giải đáp cho mọi vấn đề thời trang của bạn.</p>
        <button>Shop Now</button>
    </section>

    <!-- Categories Section -->
    <section id="collections">
        <div class="category-grid">
            <div class="category-item">
                <a href="products?category=1">
                    <img src="./images/aonam.png" width="300" height="300" alt="Áo Nam">
                    <h3>Áo Nam</h3>
                </a>
            </div>
            <div class="category-item">
                <a href="products?category=2">
                    <img src="./images/quannam.png" width="300" height="300" alt="Quần Nam">
                    <h3>Quần Nam</h3>
                </a>
            </div>
            <div class="category-item">
                <a href="products?category=3">
                    <img src="./images/giaynam.png" width="300" height="300" alt="Giày Nam">
                    <h3>Giày Nam</h3>
                </a>
            </div>
            <div class="category-item">
                <a href="products?category=4">
                    <img src="./images/aonu.png" width="300" height="300" alt="Áo Nữ">
                    <h3>Áo Nữ</h3>
                </a>
            </div>
            <div class="category-item">
                <a href="products?category=5">
                    <img src="./images/quannu.png" width="300" height="300" alt="Quần Nữ">
                    <h3>Quần Nữ</h3>
                </a>
            </div>
            <div class="category-item">
                <a href="products?category=6">
                    <img src="./images/giaynu.png" width="300" height="300" alt="Giày Nữ">
                    <h3>Giày Nữ</h3>
                </a>
            </div>
            <div class="category-item">
                <a href="products?category=7">
                    <img src="./images/vaynu.png" width="300" height="300" alt="Váy Nữ">
                    <h3>Váy Nữ</h3>
                </a>
            </div>
            <div class="category-item">
                <a href="products?category=8">
                    <img src="./images/phukien.png" width="300" height="300" alt="Phụ Kiện">
                    <h3>Phụ Kiện</h3>
                </a>
            </div>
        </div>
    </section>
    <!-- New Arrivals Section -->
    <section id="new-arrivals">
        <div class="full-width-border">
            <h2>New Arrivals</h2>
        </div>
        <div class="product-grid">
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=New+Clothing+1" alt="New Clothing 1">
                <h3>New Clothing 1</h3>
                <p>$29.99</p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=New+Clothing+2" alt="New Clothing 2">
                <h3>New Clothing 2</h3>
                <p>$39.99</p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=New+Clothing+3" alt="New Clothing 3">
                <h3>New Clothing 3</h3>
                <p>$49.99</p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=New+Clothing+3" alt="New Clothing 3">
                <h3>New Clothing 3</h3>
                <p>$49.99</p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=New+Clothing+3" alt="New Clothing 3">
                <h3>New Clothing 3</h3>
                <p>$49.99</p>
            </div>
        </div>
    </section>

    <!-- Best Sellers Section -->
    <section id="best-sellers">
        <div class="full-width-border">
            <h2>Best Sellers</h2>
        </div>
        <div class="product-grid">
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=Best+Seller+1" alt="Best Seller 1">
                <h3>Best Seller 1</h3>
                <p>$29.99</p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=Best+Seller+2" alt="Best Seller 2">
                <h3>Best Seller 2</h3>
                <p>$39.99</p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=Best+Seller+3" alt="Best Seller 3">
                <h3>Best Seller 3</h3>
                <p>$49.99</p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=Best+Seller+3" alt="Best Seller 3">
                <h3>Best Seller 4</h3>
                <p>$49.99</p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=Best+Seller+3" alt="Best Seller 3">
                <h3>Best Seller 5</h3>
                <p>$49.99</p>
            </div>
        </div>
    </section>

    <!-- Sale Section -->
    <section id="sale">
        <div class="full-width-border">
            <h2>On Sale</h2>
        </div>
        <div class="product-grid">
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=Sale+Item+1" alt="Sale Item 1">
                <h3>Sale Item 1</h3>
                <p>$19.99 <span class="original-price">$29.99</span></p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=Sale+Item+2" alt="Sale Item 2">
                <h3>Sale Item 2</h3>
                <p>$29.99 <span class="original-price">$39.99</span></p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=Sale+Item+3" alt="Sale Item 3">
                <h3>Sale Item 3</h3>
                <p>$39.99 <span class="original-price">$49.99</span></p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=Sale+Item+3" alt="Sale Item 3">
                <h3>Sale Item 4</h3>
                <p>$39.99 <span class="original-price">$49.99</span></p>
            </div>
            <div class="product-item">
                <img src="https://via.placeholder.com/200x200?text=Sale+Item+3" alt="Sale Item 3">
                <h3>Sale Item 5</h3>
                <p>$39.99 <span class="original-price">$49.99</span></p>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer>
        <div class="footer-content">
            <p>&copy; 2024 StyleNest - All Rights Reserved</p>
        </div>
    </footer>
</body>
</html>
