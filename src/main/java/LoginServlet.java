

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306";
	private String jdbcUsername = "root";
	private String jdbcPassword = "cdev";
	private static final String LOGIN = "SELECT * FROM freshfoodies.user where username = ? and password = ?";
	
	
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
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("LoginUsername");
		String inputpassword = request.getParameter("LoginPassword");
		User users = new User(0, "", "");
		boolean loggedin = false;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN)) {
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, inputpassword);
				ResultSet rs = preparedStatement.executeQuery();
				if (!rs.isBeforeFirst() ) {    
					out.println("<script type=\"text/javascript\">alert('No User found');</script>");
				}
				else {
					while(rs.next()) {
						int user_id = rs.getInt("user_id");
						String username = rs.getString("username");
						users.setUser_id(user_id);
						users.setName(username);
						loggedin = true;
						out.println("<script type=\"text/javascript\">alert('Logged in');</script>");
					}
				}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("user_id", users.getUser_id());
		request.setAttribute("username", users.getName());
		request.setAttribute("loggedin", loggedin);
		request.getRequestDispatcher("/FoodServlet").forward(request, response);
		doGet(request, response);
	}

}
