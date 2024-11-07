package com.uniquedeveloper.RegistartionServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/registerAction")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ form
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String passwordHash = request.getParameter("passwordHash");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");

        Connection conn = null;

        try {
            // Nạp driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Kết nối tới cơ sở dữ liệu
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_banhang_thoitrang", "root", "dat123654");

            // Câu lệnh SQL để thêm người dùng mới
            String sql = "INSERT INTO customers (first_name, last_name, username, passwordHash, email, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
            String checkUserSql = "SELECT * FROM customers WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkUserSql);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Nếu tên đăng nhập đã tồn tại, thông báo lỗi
                request.setAttribute("errorMessage", "Tên đăng nhập đã được sử dụng.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            else {

            // Sử dụng PreparedStatement để thực thi câu lệnh
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, firstname);
                pstmt.setString(2, lastname);
                pstmt.setString(3, username);
                pstmt.setString(4, passwordHash);
                pstmt.setString(5, email);
                pstmt.setString(6, phonenumber);
                pstmt.executeUpdate(); // Thực thi câu lệnh

                // Chuyển hướng đến trang đăng nhập nếu đăng ký thành công
                response.sendRedirect("login.jsp");
            }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().print("Không tìm thấy driver: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().print("Lỗi SQL: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close(); // Đóng kết nối sau khi hoàn thành
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
