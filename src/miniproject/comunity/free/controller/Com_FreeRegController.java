package miniproject.comunity.free.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;

public class Com_FreeRegController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/jsp/menu/com_Free/com_FreeRegForm.jsp";
		
	}

	
}
