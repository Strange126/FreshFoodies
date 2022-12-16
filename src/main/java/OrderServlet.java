

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private String jdbcURL = "jdbc:mysql://localhost:3306";
	private String jdbcUsername = "root";
	private String jdbcPassword = "cdev";
	private static final String SELECT_ALL_ORDERS = "SELECT * FROM freshfoodies.order;"; //get
	private static final String EDIT_ORDER = "UPDATE freshfoodies.order SET status = ? WHERE order_id = ?;";
	private static final String DELETE_ORDER = "DELETE FROM freshfoodies.order WHERE order_id = ?;";
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

    public OrderServlet() {
        super();

    }
    
    private void listOrders(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {


		List<Order> orders = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int order_id = rs.getInt("order_id");
				int order_user_id = rs.getInt("order_user_id");
				int order_food_id = rs.getInt("order_food_id");
				String address = rs.getString("address");
				int timestamp = rs.getInt("timestamp");
				String status = rs.getString("status");
				System.out.println("running");
				orders.add(new Order(order_id, order_user_id ,order_food_id, address, timestamp, status));
			}
		} catch (SQLException e) {
			System.out.println("Testing");
			System.out.println(e.getMessage());
		} catch (Exception i) {
			System.out.println("nani");
		}
		System.out.println(orders);
		request.setAttribute("listOrders", orders);
		request.getRequestDispatcher("/order.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();
		try {
			
				listOrders(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if(request.getParameter("EditButton") != null) {
				int order_id = Integer.parseInt(request.getParameterValues("EditButton")[0]);
				System.out.println("Completed Order"+ order_id);
				try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(EDIT_ORDER);) {
					statement.setString(1, "completed");
					statement.setInt(2, order_id);
					int f  = statement.executeUpdate();
					if(f > 0) {
						System.out.println(order_id + " has been completed!");
					}
				}
				
			
			}
			else if (request.getParameter("DeleteButton") != null) {
				int order_id = Integer.parseInt(request.getParameterValues("DeleteButton")[0]);
				System.out.println("Deleted order"+ order_id);
				try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ORDER);) {
					statement.setInt(1, order_id);
					int i  = statement.executeUpdate();
					if(i > 0) {
						System.out.println(order_id + " has been deleted!");
					}
				}
			}
		} catch (Exception e) {
			
		}
		
		doGet(request, response);
	}

}
