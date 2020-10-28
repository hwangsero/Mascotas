package miniproject.comunity.adopt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;
import miniproject.dao.BoardDAO;

public class Com_AdoptDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(no);
		dao.deleteFile(no);
		
		return "/jsp/menu/com_Adopt/com_AdoptDelete.jsp";
	}

}
