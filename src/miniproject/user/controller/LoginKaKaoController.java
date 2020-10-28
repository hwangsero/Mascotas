package miniproject.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.controller.Controller;
import miniproject.vo.UserVO;

public class LoginKaKaoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("nickname");
		String nickname = request.getParameter("nickname");
		UserVO userVO = new UserVO(id,nickname);
		
		HttpSession session = request.getSession();  
		session.setAttribute("userVO", userVO);
		String msg = nickname+"�� ȯ���մϴ�";
		String url = "/jsp/user/loginForm.jsp";
		return "redirect:"+request.getContextPath();
	}

}
