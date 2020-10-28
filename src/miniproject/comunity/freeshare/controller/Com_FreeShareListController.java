package miniproject.comunity.freeshare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.controller.Controller;
import miniproject.dao.BoardDAO;
import miniproject.vo.BoardVO;

public class Com_FreeShareListController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("리스트 컨트롤러 ");
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = new ArrayList<>();
		
		HttpSession session = request.getSession();
		
		int pageCnt = dao.listCount("무료나눔게시판"); //현재 리스트갯수
		int pageNum = (pageCnt%15 == 0) ? pageCnt/15 : pageCnt/15+1; 
		
		session.setAttribute("pageNum", pageNum);
		
		int pageNo = Integer.parseInt((String)request.getParameter("pageNo")); //선택된 페이지번호
//		int pageNo = 1; //선택된 페이지번호
		
		System.out.println("페이지넘버"+pageNo);
		
		boardList = dao.BoardList(pageNo, 15, "무료나눔게시판"); //리스트가져오기(현재페이지, 리스트갯수, 카테)
		request.setAttribute("boardList", boardList);
		
		return "/jsp/menu/com_FreeShare/com_FreeShareList.jsp";
	}

}
