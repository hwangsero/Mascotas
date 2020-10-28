package miniproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.dao.UserDAO;
import miniproject.vo.UserVO;

public class LeaveController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Å»ÅðÇß´Ï?");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		String id = userVO.getId();
		
		UserDAO dao = new UserDAO();
		dao.leaveUser(id);
		session.removeAttribute("userVO");
		
		String msg = "Å»ÅðµÇ¾ú½À´Ï´Ù";
		String url = request.getContextPath() + "/index.jsp";
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/jsp/util/result.jsp";
	}

}
