package servlet;

import DAO.UserDAO;
import model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Điều hướng đến trang login.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập mã hóa
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        UserDAO userDAO = new UserDAO();
        // Lấy dữ liệu từ form đăng nhập
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra thông tin đăng nhập
        if (userDAO.validateUser(username, password)) {
            // Đăng nhập thành công, lưu thông tin vào session
        	User user = userDAO.getUserByEmailPassword(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("validateUser", user);
            
            // Chuyển hướng đến index.jsp
            response.sendRedirect("jsp/index.jsp");
        } else {
            // Đăng nhập thất bại, gửi thông báo lỗi
            request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
