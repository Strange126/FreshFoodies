import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private String jdbcURL = "jdbc:mysql://localhost:3306";
	private String jdbcUsername = "root";
	private String jdbcPassword = "cdev";
	private static final String SELECT_ALL_FOOD = "SELECT * FROM freshfoodies.food;;";
	private static final String INSERT_INTO_CART = "INSERT INTO freshfoodies.cart VALUES (null, ?, ?);";
	private static final long serialVersionUID = 1L;

	public FoodServlet() {
		super();

	}

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

	private void listFoods(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		if (request.getAttribute("loggedin") != null) {
			HttpSession session = request.getSession();
			boolean loggedin = (boolean) request.getAttribute("loggedin");
			String username = (String) request.getAttribute("username");
			int user_id = (int) request.getAttribute("user_id");
			session.setAttribute("username", username);
			session.setAttribute("user_id", user_id);
			session.setAttribute("loggedin", loggedin);
			System.out.println("added");
			System.out.println(session.getAttribute("loggedin"));
		}

		List<Food> foods = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FOOD);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int food_id = rs.getInt("food_id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String description = rs.getString("description");
				String img = rs.getString("img");
				foods.add(new Food(food_id, name, price, description, img));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listFoods", foods);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void logOut(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		
		session.removeAttribute("loggedin");
		session.removeAttribute("username");
		session.removeAttribute("user_id");

		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();
		try {
				listFoods(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		try {
			switch (request.getParameterValues("button")[0]) {
			case "logout":
				logOut(request, response);
				break;
			default:
				if(isNumeric(request.getParameterValues("button")[0])) {
					int food_id = Integer.parseInt(request.getParameterValues("button")[0]);
					System.out.println(food_id);
					int user_id = (int) session.getAttribute("user_id");
					try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CART)) {
						preparedStatement.setInt(1, food_id);
						preparedStatement.setInt(2, user_id);
						int rs = preparedStatement.executeUpdate();
						if(rs > 0) {
							System.out.println("added");
						}
					}
					
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("something happened" + e);
		}
		
		doGet(request, response);
	}

}
