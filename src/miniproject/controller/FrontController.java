package miniproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	
private HandlerMapping mappings;
	
	@Override		//각 서블릿당 환경설정해주는 클래스 config	//ServletContext는  서블릿의 공유객체
	public void init(ServletConfig config) throws ServletException{
					
		String propLocation = config.getInitParameter("propLocation");
		
		mappings = new HandlerMapping(propLocation);	
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String context = request.getContextPath();
		
		String uri = request.getRequestURI();
		uri = uri.substring(context.length());
		
		System.out.println("호출된 uri : "+ uri);
		try {
			
			Controller control = mappings.getController(uri);
			
			//응답할 JSP주소값을 Controller인터페이스를 만들어 줌으로써 한번에 처리할 수 있다.
			String callPage = control.handleRequest(request, response);	 
			
			if(callPage.startsWith("redirect:")) {
				response.sendRedirect(callPage.substring("redirect:".length()));
			} else {
				
				//서블릿상에서 따로 포워드 시켜주기 위해 필요한 객체
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
				dispatcher.forward(request, response);
			}
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
