package miniproject.comunity.freeshare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;

public class Com_FreeShareRegController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/jsp/menu/com_FreeShare/com_FreeShareRegForm.jsp";
		
	}

	
}
