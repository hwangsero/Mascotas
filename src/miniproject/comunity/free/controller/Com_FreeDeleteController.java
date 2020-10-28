package miniproject.comunity.free.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;
import miniproject.dao.BoardDAO;

public class Com_FreeDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(no);
		dao.deleteFile(no);
		
		return "/jsp/menu/com_Free/com_FreeDelete.jsp";
	}

}
