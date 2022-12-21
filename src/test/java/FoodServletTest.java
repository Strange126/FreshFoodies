import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FoodServletTest extends Mockito {
        private StringWriter stringWriter = new StringWriter();
        private PrintWriter printWriter = new PrintWriter(stringWriter);
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFoodServlet() throws Exception {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);       
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        RequestDispatcher rd = mock(RequestDispatcher.class);
        String array[] = {"logout"};
        
        Mockito.when(request.getParameterValues("button")).thenReturn(array);
        Mockito.when(request.getRequestDispatcher(eq("/index.jsp"))).thenReturn(rd);
        Mockito.when(response.getWriter()).thenReturn(printWriter);
        new FoodServlet().doPost(request, response);
        
        verify(request, atLeast(1)).getParameterValues("button");
	}
	
	@Test
	void testFoodServletnumeric() throws Exception {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);       
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        RequestDispatcher rd = mock(RequestDispatcher.class);
        String array[] = {"1"};

        Mockito.when(request.getParameterValues("button")).thenReturn(array);
        Mockito.when(request.getRequestDispatcher(eq("/index.jsp"))).thenReturn(rd);
        Mockito.when(response.getWriter()).thenReturn(printWriter);
        new FoodServlet().doPost(request, response);
        
        verify(request, atLeast(3)).getParameterValues("button");
	}


}
