package miniproject.comunity.free.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;
import miniproject.dao.BoardDAO;
import miniproject.vo.BoardFileVO;
import miniproject.vo.BoardVO;

public class Com_FreeDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
//		String category = request.getParameter("cate");
		
		BoardDAO dao = new BoardDAO();
		/* 
			조회수 증가
			목록페이지 -> 상세페이지 조회수 증가 => type=list 파라미터 추가
			수정페이지 -> 상세페이지 조회수 증가X 
		*/
		String type = request.getParameter("type");
		if(type != null && type.equals("list")) {
			dao.updateViewCnt(no);
		}

		//해당게시물 조회
		
		BoardVO board = dao.selectFreeboard(no);
		
		//첨부파일 조회
		List<BoardFileVO> fileList = dao.selectFileByNo(no);
		
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		
		return "/jsp/menu/com_Free/com_FreeDetail.jsp";
	}

}
