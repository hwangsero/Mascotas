package miniproject.borad.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.controller.Controller;
import miniproject.dao.BoardDAO;
import miniproject.vo.BoardVO;

public class PetTipController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = new ArrayList<>();
		//petTipList = dao.boardList("freeTalk");
		
		HttpSession session = request.getSession();
		
		int pageCnt = dao.listCount("애견상식"); //현재 리스트갯수
		int pageNum = (pageCnt%15 == 0) ? pageCnt/15 : pageCnt/15+1; 
		session.setAttribute("pageNum", pageNum);
		
		int pageNo = Integer.parseInt((String)request.getParameter("pageNo")); //선택된 페이지번호
		
		boardList = dao.BoardList(pageNo, 15, "애견상식"); //리스트가져오기(현재페이지, 리스트갯수, 카테)
		session.setAttribute("boardList", boardList);
		return "/jsp/menu/petTip.jsp";
	}

}
