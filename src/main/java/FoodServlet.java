import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private String jdbcURL = "jdbc:mysql://localhost:3306";
	private String jdbcUsername = "root";
	private String jdbcPassword = "cdev";
	private static final String SELECT_ALL_FOOD = "SELECT * FROM freshfoodies.food;;";
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

	private void listFoods(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List <Food> foods = new ArrayList <>();
		try(Connection connection = getConnection(); 
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FOOD);) {
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int food_id = rs.getInt("food_id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String description = rs.getString("description");
				String img = rs.getString("img");
				foods.add(new Food(food_id, name, price, description, img));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listFoods", foods);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/insert":
				break;
			case "/delete":
				break;
			case "/edit":
				break;
			case "/update":
				break;
			default:
				listFoods(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
