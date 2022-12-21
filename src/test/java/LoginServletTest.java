import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginServletTest {
    private StringWriter stringWriter = new StringWriter();
    private PrintWriter printWriter = new PrintWriter(stringWriter);
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLoginServlet() throws IOException, ServletException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);       
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        RequestDispatcher rd = mock(RequestDispatcher.class);
        
        Mockito.when(request.getRequestDispatcher(eq("/FoodServlet"))).thenReturn(rd);
        Mockito.when(request.getParameter("LoginUsername")).thenReturn("Strange");
        Mockito.when(request.getParameter("LoginPassword")).thenReturn("password123");
        Mockito.when(response.getWriter()).thenReturn(printWriter);
        
        new LoginServlet().doPost(request, response);
        
        verify(request, atLeast(1)).getParameter("LoginUsername");
        verify(request, atLeast(1)).getParameter("LoginPassword");
	}

}
