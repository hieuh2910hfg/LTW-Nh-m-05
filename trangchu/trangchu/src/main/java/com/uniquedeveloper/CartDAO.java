package cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CartDAO {
	
	private Connection con;
	
	public CartDAO(Connection con) {
		super();
		this.con = con;
	}
	public boolean addToCart(Cart cart) {
		boolean flag = false;
		try {
			String query = "insert into cart_items(cart_item_id, cart_id, product_id, quantity) values(?,?,?,?)";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, cart.getCartItemId());
			psmt.setInt(2, cart.getCartId());
			psmt.setInt(3, cart.getProductId());
			psmt.setInt(4, cart.getQuantity());
			psmt.executeUpdate();
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public void removeProduct(int cartItemId) {
		try {
			String query = "delete from cart_items where cart_item_id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, cartItemId);

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeAllProduct() {
		try {
			String query = "delete from cart_items";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getQuantity(int cartItemId, int productId) {
		int qty = 0;
		try {
			String query = "select * from cart_items where cart_item_id = ? and product_id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, cartItemId);
			psmt.setInt(2, productId);

			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				qty = rs.getInt("quantity");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qty;
	}
	
	public void updateQuantity(int cartItemId, int quantity) {

		try {
			String query = "update cart_items set quantity = ? where cart_item_id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, quantity);
			psmt.setInt(2, cartItemId);

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getProductId(int cartItemId) {
		int pid = 0;
		try {
			String query = "select product_id from cart_items where cart_item_id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, cartItemId);
			ResultSet rs = psmt.executeQuery();
			rs.next();
			pid = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pid;
	}
	
	public List<Cart> getCartItemsfromCart(int cartId) {
		List<Cart> list = new ArrayList<Cart>();
		try {
			String query = "select ci.* from cart_items ci join carts c on ci.cart_id = c.cart_id where carts.cart_id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, cartId);

			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setCartItemId(rs.getInt("cart_item_id"));
				cart.setProductId(rs.getInt("product_id"));
				cart.setCartId(rs.getInt("cart_id"));
				cart.setQuantity(rs.getInt("quantity"));

				list.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

