

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306";
	private String jdbcUsername = "root";
	private String jdbcPassword = "cdev";
	private static final String REGISTER_USER = "INSERT INTO freshfoodies.user VALUES(NULL,?,?);";
    
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
    public SignUpServlet() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("SignUpUsername");
		String inputpassword = request.getParameter("SignUpPassword");
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_USER)) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, inputpassword);
			int rs = preparedStatement.executeUpdate();
			if(rs > 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<script src=\"./webjars/popper.js/2.9.2/umd/popper.min.js\"></script>\r\n"
						+ "<script src=\"./webjars/bootstrap/5.2.0/js/bootstrap.min.js\"></script>\r\n"
						+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"./webjars/bootstrap/5.2.0/css/bootstrap.min.css\"> "+ "<h1>" + "You have successfully registered an account!" + "</h1>" + "<a class='btn btn-lg btn-primary m-3'" + "href=\"login.jsp\"> " + "Go to Login" + "</a>");
				writer.close();
			}
		}
		catch(Exception e) {
			System.out.println(e);
			PrintWriter writer = response.getWriter();
			writer.println("<script src=\"./webjars/popper.js/2.9.2/umd/popper.min.js\"></script>\r\n"
					+ "<script src=\"./webjars/bootstrap/5.2.0/js/bootstrap.min.js\"></script>\r\n"
					+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"./webjars/bootstrap/5.2.0/css/bootstrap.min.css\"> " + "<h1>" + "Username is already in used" + "</h1>" +  "<a class='btn btn-lg btn-primary m-3'" + "btn btn-primary btn-lg" +" href=\"signup.jsp\"> " + "Back to Sign up" + "</a>");
			writer.close();
			out.close();
		}
		doGet(request, response);
	}

}
