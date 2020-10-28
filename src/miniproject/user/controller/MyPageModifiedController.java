package miniproject.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.controller.Controller;
import miniproject.dao.UserDAO;
import miniproject.vo.UserVO;

public class MyPageModifiedController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		UserDAO dao = new UserDAO();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email_id = request.getParameter("email_id");
		String email_domain = request.getParameter("email_domain");
		String basic_addr = request.getParameter("basic_addr");
		String detail_addr = request.getParameter("detail_addr");
		String type = request.getParameter("type");
		
		System.out.println("id는?" + id);
		System.out.println("type는?" + type);
		System.out.println("address는?" + basic_addr);
		UserVO userVO = new UserVO(id, password, name, email_id, email_domain, basic_addr, detail_addr, type);
		
		System.out.println("잘찍히나 :" + userVO);
		
		dao.updateMypage(userVO); //정보 수정
		
		session.setAttribute("userVO", userVO);
		
		String msg = "정보수정을 완료했습니다";
		String url = request.getContextPath() + "/jsp/user/myPage.jsp";
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/jsp/util/result.jsp";
	}

}
