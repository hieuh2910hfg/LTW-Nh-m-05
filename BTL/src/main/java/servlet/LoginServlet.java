package servlet;

import DAO.UserLogin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
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
    private UserLogin loginDAO;

    @Override
    public void init() throws ServletException {
        loginDAO = new UserLogin();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (loginDAO.validateUser(username, password)) {
            // Đăng nhập thành công, lưu thông tin vào session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.getWriter().println("Đăng nhập thành công!");
        } else {
            // Đăng nhập thất bại
            response.getWriter().println("Tên đăng nhập hoặc mật khẩu không đúng.");
        }
    }
}
