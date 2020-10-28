package miniproject.comunity.review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;

public class Com_ReviewRegController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		return "/jsp/menu/com_Review/com_ReviewRegForm.jsp";	
	}

}
