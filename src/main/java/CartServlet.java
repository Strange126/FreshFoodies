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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private String jdbcURL = "jdbc:mysql://localhost:3306";
	private String jdbcUsername = "root";
	private String jdbcPassword = "cdev";
	private static final String SELECT_ALL_FOOD_FROM_USER_CART = "SELECT freshfoodies.cart.cart_id, freshfoodies.food.food_id, freshfoodies.food.name, freshfoodies.food.price, freshfoodies.food.description from freshfoodies.food Inner JOIN freshfoodies.cart on freshfoodies.food.food_id = freshfoodies.cart.cart_food_id where freshfoodies.cart.cart_user_id = ?;";
	private static final String DELETE_CART_ITEM = "DELETE FROM freshfoodies.cart WHERE cart_id = ?;";
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
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
    public CartServlet() {
        super();
    }
    
    private void listCarts(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
    	
    	HttpSession session = request.getSession();
    	int user_id = (int) session.getAttribute("user_id");
		List<UserCart> carts = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FOOD_FROM_USER_CART);) {
			preparedStatement.setInt(1, user_id);
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
		session.setAttribute("listCarts", carts);
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
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<UserCart> listCart = (ArrayList<UserCart>) session.getAttribute("listCarts");
		try {
			switch(request.getParameterValues("button")[0]) {
				case "Order":
					System.out.println("Ordering");
				default:
					if(isNumeric(request.getParameterValues("button")[0])) {
						int cart_id = Integer.parseInt(request.getParameterValues("button")[0]);
						System.out.println(cart_id);
						try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CART_ITEM);) {
							statement.setInt(1, cart_id);
							int i = statement.executeUpdate();
							if(i > 0) {
								System.out.println("Deleted");
							}
						}
					}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		doGet(request, response);
	}

}
