import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private String jdbcURL = "jdbc:mysql://localhost:3306";
	private String jdbcUsername = "root";
	private String jdbcPassword = "cdev";
	private static final String SELECT_ALL_FOOD_FROM_USER_CART = "SELECT freshfoodies.cart.cart_id, freshfoodies.food.food_id, freshfoodies.food.name, freshfoodies.food.price, freshfoodies.food.description from freshfoodies.food Inner JOIN freshfoodies.cart on freshfoodies.food.food_id = freshfoodies.cart.cart_food_id where freshfoodies.cart.cart_user_id = ?;";
	private static final long serialVersionUID = 1L;
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
    public CartServlet() {
        super();
    }
    
    private void listCarts(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		if (request.getAttribute("loggedin") != null) {
			boolean loggedin = (boolean) request.getAttribute("loggedin");
			String username = (String) request.getAttribute("username");
			request.setAttribute(username, response);
			int user_id = (int) request.getAttribute("user_id");
		}

		List<UserCart> carts = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FOOD_FROM_USER_CART);) {
			preparedStatement.setInt(1, 2);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int cart_id = rs.getInt("cart_id");
				int food_id = rs.getInt("food_id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String description = rs.getString("description");
				carts.add(new UserCart(cart_id,food_id, name, price, description));
			}
		} catch (SQLException e) {
			System.out.println("Tester");
			System.out.println(e.getMessage());
		}
		request.setAttribute("listCarts", carts);
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			listCarts(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
