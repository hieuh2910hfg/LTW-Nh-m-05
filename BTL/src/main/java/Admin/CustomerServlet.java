package Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        customerDAO = new CustomerDAO(); // Khởi tạo DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            // Mặc định hiển thị danh sách khách hàng
            List<Customer> customerList = customerDAO.getAllCustomers();
            request.setAttribute("customers", customerList);
            request.getRequestDispatcher("customers.jsp").forward(request, response);
        } else {
            // Xử lý các chức năng sửa hoặc xóa dựa trên action
            handleAction(action, request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            // Thêm khách hàng
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String passwordHash = request.getParameter("password");
            String email = request.getParameter("email");

            Customer newCustomer = new Customer(0, firstName, lastName, username, passwordHash, email);
            customerDAO.addCustomer(newCustomer);
        } else if ("edit".equals(action)) {
            // Cập nhật khách hàng
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String passwordHash = request.getParameter("password");
            String email = request.getParameter("email");

            Customer updatedCustomer = new Customer(customerId, firstName, lastName, username, passwordHash, email);
            customerDAO.updateCustomer(updatedCustomer);
        }

        // Quay lại danh sách khách hàng
        response.sendRedirect("customers");
    }

    private void handleAction(String action, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("delete".equals(action)) {
            // Xóa khách hàng
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            customerDAO.deleteCustomer(customerId);
        }
        response.sendRedirect("customers");
    }
}
