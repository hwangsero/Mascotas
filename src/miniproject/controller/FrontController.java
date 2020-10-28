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
	
	@Override		//�� ������ ȯ�漳�����ִ� Ŭ���� config	//ServletContext��  ������ ������ü
	public void init(ServletConfig config) throws ServletException{
					
		String propLocation = config.getInitParameter("propLocation");
		
		mappings = new HandlerMapping(propLocation);	
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String context = request.getContextPath();
		
		String uri = request.getRequestURI();
		uri = uri.substring(context.length());
		
		System.out.println("ȣ��� uri : "+ uri);
		try {
			
			Controller control = mappings.getController(uri);
			
			//������ JSP�ּҰ��� Controller�������̽��� ����� �����ν� �ѹ��� ó���� �� �ִ�.
			String callPage = control.handleRequest(request, response);	 
			
			if(callPage.startsWith("redirect:")) {
				response.sendRedirect(callPage.substring("redirect:".length()));
			} else {
				
				//�����󿡼� ���� ������ �����ֱ� ���� �ʿ��� ��ü
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
				dispatcher.forward(request, response);
			}
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
