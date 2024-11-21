package DAO;

import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> getProductsByCategory(int categoryId) {
        List<Product> products = new ArrayList<>();
        String query;

        // Kiểm tra nếu categoryId là 0 thì lấy tất cả sản phẩm
        if (categoryId == 0) {
            query = "SELECT description, price, product_links, category_id FROM products";
        } else {
            query = "SELECT description, price, product_links, category_id FROM products WHERE category_id = ?";
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            if (categoryId != 0) {
                stmt.setInt(1, categoryId);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                String productLinks = rs.getString("product_links");
                int category = rs.getInt("category_id");

                Product product = new Product(categoryId,description, price, productLinks);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


}
