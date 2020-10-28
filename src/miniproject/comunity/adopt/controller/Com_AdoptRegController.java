package miniproject.comunity.adopt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;

public class Com_AdoptRegController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/jsp/menu/com_Adopt/com_AdoptRegForm.jsp";
		
	}

	
}
