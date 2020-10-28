package miniproject.comunity.adopt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;
import miniproject.dao.BoardDAO;
import miniproject.vo.BoardFileVO;
import miniproject.vo.BoardVO;

public class Com_AdoptUpdateController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		
		BoardDAO dao = new BoardDAO();
		
		BoardVO board = dao.selectComBoard(no);
		List<BoardFileVO> fileList = dao.selectFileByNo(no);
		
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		
		return "/jsp/menu/com_Adopt/com_AdoptUpdateForm.jsp?no="+no;

	}

}
