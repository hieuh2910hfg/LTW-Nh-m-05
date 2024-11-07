package com.uniquedeveloper.LoginServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/loginAction")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_banhang_thoitrang", "root", "dat123654");

            String sql = "SELECT * FROM customers WHERE username = ? AND passwordHash = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Đăng nhập thành công, lưu thông tin vào session và chuyển hướng sang index.jsp
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("index.jsp");
            } else {
                // Đăng nhập thất bại, hiển thị thông báo lỗi và giữ lại ở trang đăng nhập
                request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Lỗi: " + e.getMessage());
        }
    }
}
