package miniproject.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;
import miniproject.dao.UserDAO;

public class IdCheck implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		UserDAO dao = new UserDAO();
		int check = dao.checkId(id);
		request.setAttribute("check", check);
		
		String msg = null;
		if(check == 1){
		
			return "/jsp/menu/user/idCheck.jsp";
		}
		
		return "/jsp/menu/user/idCheck.jsp";


	}		
}
