package miniproject.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;
import miniproject.dao.UserDAO;
import miniproject.vo.UserVO;

public class SignUpProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		UserVO user = new UserVO();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email_id = request.getParameter("email_id");
		String email_domain = request.getParameter("email_domain");
		String basic_addr = request.getParameter("basic_addr");
		String detail_addr = request.getParameter("detail_addr");
		
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		user.setEmail_id(email_id);
		user.setEmail_domain(email_domain);
		user.setBasic_addr(basic_addr);
		user.setDetail_addr(detail_addr);
		UserDAO dao = new UserDAO();
		dao.insertUser(user);
		
		return "/jsp/user/signUp.jsp";
	}

}
