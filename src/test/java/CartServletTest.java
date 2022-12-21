import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CartServletTest {
    private StringWriter stringWriter = new StringWriter();
    private PrintWriter printWriter = new PrintWriter(stringWriter);
    ArrayList<UserCart> listCart = new ArrayList<UserCart>();
	@BeforeEach
	void setUp() throws Exception {
		listCart.add(new UserCart(3,3,"name",12,"tester"));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCartServlet() throws IOException, ServletException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);       
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession hs = Mockito.mock(HttpSession.class);
        RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
        String array[] = {"Order"};
        
        Mockito.when(request.getParameterValues("button")).thenReturn(array);
        Mockito.when(request.getRequestDispatcher(eq("/cart.jsp"))).thenReturn(rd);
        Mockito.when(request.getSession()).thenReturn(hs);
        Mockito.when(hs.getAttribute("user_id")).thenReturn(1);
        Mockito.when(hs.getAttribute("listCarts")).thenReturn(listCart);
        Mockito.when(response.getWriter()).thenReturn(printWriter);
        
        new CartServlet().doPost(request, response);
        
        verify(request, atLeast(1)).getParameterValues("button");
	}
	@Test
	void testCartServletNumeric() throws IOException, ServletException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);       
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession hs = Mockito.mock(HttpSession.class);
        RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
        String array[] = {"1"};
        
        Mockito.when(request.getParameterValues("button")).thenReturn(array);
        Mockito.when(request.getRequestDispatcher(eq("/cart.jsp"))).thenReturn(rd);
        Mockito.when(request.getSession()).thenReturn(hs);
        Mockito.when(hs.getAttribute("user_id")).thenReturn(1);
        Mockito.when(response.getWriter()).thenReturn(printWriter);
        
        new CartServlet().doPost(request, response);
        
        verify(request, atLeast(3)).getParameterValues("button");
	}

}
