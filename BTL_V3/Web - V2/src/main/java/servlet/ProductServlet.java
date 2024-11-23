package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> aonam = new ArrayList<>();
        List<Product> quannam = new ArrayList<>();
        List<Product> giaynam = new ArrayList<>();
        List<Product> aonu = new ArrayList<>();
        List<Product> quannu = new ArrayList<>();
        List<Product> giaynu = new ArrayList<>();
        List<Product> vaynu = new ArrayList<>();
        List<Product> phukien = new ArrayList<>();

        String query = "SELECT category_id, description, price FROM products";
        
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int category_id = rs.getInt("category_id");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                Product product = new Product(category_id, description, price);
                
                // Phân loại sản phẩm dựa trên category_id
                if (category_id == 11) {
                    aonam.add(product);
                } else if (category_id == 12) {
                    quannam.add(product);
                } else if (category_id == 13) {
                    giaynam.add(product);
                }else if (category_id == 21) {
                    aonu.add(product);
                } else if (category_id == 22) {
                    quannu.add(product);
                }else if (category_id == 23) {
                    giaynu.add(product);
                } else if (category_id == 24) {
                    vaynu.add(product);
                }else if (category_id == 31) {
                    phukien.add(product);
                } 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Đưa các danh sách vào request để truyền sang JSP
        request.setAttribute("aonam", aonam);
        request.setAttribute("quannam", quannam);
        request.setAttribute("giaynam", giaynam);
        request.setAttribute("aonu", aonu);
        request.setAttribute("quannu", quannu);
        request.setAttribute("giaynu", giaynu);
        request.setAttribute("vaynu", vaynu);
        request.setAttribute("phukien", phukien);
       
        
        // Chuyển hướng đến trang JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("sanpham.jsp");
        dispatcher.forward(request, response);
    }
    
    private Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_banhang_thoitrang", "root", "dat123654");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver không tìm thấy.", e);
        }
    }
}
