package miniproject.comunity.review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;
import miniproject.dao.BoardDAO;
import miniproject.vo.BoardFileVO;
import miniproject.vo.BoardVO;

public class Com_ReviewUpdateController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		request.setCharacterEncoding("utf-8");
		System.out.println("후기 업데이트");
		int no = Integer.parseInt(request.getParameter("no"));
		
		
		BoardDAO dao = new BoardDAO();
		
		BoardVO board = dao.selectComBoard(no);
		System.out.println(board.toString());
		
		List<BoardFileVO> fileList = dao.selectFileByNo(no);
		
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		System.out.println("후기 업데이트 컨트롤러의 파일사이즈"+fileList.size());
		
		return "/jsp/menu/com_Review/com_ReviewUpdateForm.jsp?no="+no;
	}

}
