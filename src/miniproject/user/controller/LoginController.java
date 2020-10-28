package miniproject.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getSession().getAttribute("userVO") != null) {
			return "redirect:"+request.getContextPath();
		}
		
		return "/jsp/user/loginForm.jsp";
	}

}
