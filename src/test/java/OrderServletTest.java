import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
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

class OrderServletTest {
    private StringWriter stringWriter = new StringWriter();
    private PrintWriter printWriter = new PrintWriter(stringWriter);
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testOrderServlet() throws IOException, ServletException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);       
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
        String array[] = {"1"};
        Mockito.when(request.getParameter("EditButton")).thenReturn("1");
        Mockito.when(request.getParameterValues("EditButton")).thenReturn(array);
        Mockito.when(request.getRequestDispatcher(eq("/order.jsp"))).thenReturn(rd);
        Mockito.when(response.getWriter()).thenReturn(printWriter);
        
        new OrderServlet().doPost(request, response);
        
        verify(request, atLeast(1)).getParameterValues("EditButton");
        verify(request, atLeast(1)).getParameter("EditButton");
	}
	@Test
	void testOrderServletDelete() throws IOException, ServletException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);       
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
        String array[] = {"1"};
        Mockito.when(request.getParameter("DeleteButton")).thenReturn("1");
        Mockito.when(request.getParameterValues("DeleteButton")).thenReturn(array);
        Mockito.when(request.getRequestDispatcher(eq("/order.jsp"))).thenReturn(rd);
        Mockito.when(response.getWriter()).thenReturn(printWriter);
        
        new OrderServlet().doPost(request, response);
        
        verify(request, atLeast(1)).getParameterValues("DeleteButton");
        verify(request, atLeast(1)).getParameter("DeleteButton");
	}

}
