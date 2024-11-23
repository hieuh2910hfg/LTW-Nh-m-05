package servlet;

import DAO.UserRegister;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserRegister userRegister;

    @Override
    public void init() throws ServletException {
        userRegister = new UserRegister();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Lấy thông tin từ form
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String passwordHash = request.getParameter("passwordHash");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");

        // Gọi DAO để đăng ký người dùng và tạo giỏ hàng
        boolean isRegistered = userRegister.registerUser(firstname, lastname, username, passwordHash, email, phonenumber);

        // Phản hồi cho người dùng dựa trên kết quả đăng ký
        if (isRegistered) {
            response.getWriter().print("Registered successfully!");
        } else {
            response.getWriter().print("Registration failed!");
        }
    }
}
