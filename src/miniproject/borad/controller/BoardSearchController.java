package miniproject.borad.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.controller.Controller;
import miniproject.dao.BoardDAO;
import miniproject.vo.BoardVO;

public class BoardSearchController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = new ArrayList<>();
		HttpSession session = request.getSession();
		
		String cate = request.getParameter("cate");
		String url = request.getParameter("url");
		
		
	//	int pageNo = Integer.parseInt(request.getParameter("pageNo")); //선택된 페이지번호
		int pageNo = 1;
		String sel = request.getParameter("sel");
		String search = request.getParameter("searchType");
		
		if(sel.equals("제목"))
			boardList = dao.boardSearchTitle(pageNo, 15, cate, search);
		else if(sel.equals("내용"))
			boardList = dao.boardSearchCon(pageNo, 15, cate, search);
		else if(sel.equals("제목+내용"))
			boardList = dao.boardSearchTitleCon(pageNo, 15, cate, search);
		
		int pageCnt = boardList.size();
		int pageNum = (pageCnt%15 == 0) ? pageCnt/15 : pageCnt/15+1; 
		session.setAttribute("pageNum", pageNum);
		
		session.setAttribute("boardList", boardList);
		return "/jsp" + url;
	}

	
}
