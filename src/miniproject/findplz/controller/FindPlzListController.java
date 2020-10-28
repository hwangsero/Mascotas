package miniproject.findplz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.controller.Controller;
import miniproject.dao.FindPlzDAO;
import miniproject.vo.FindPlzVO;

public class FindPlzListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<FindPlzVO> findPlzList = new ArrayList<>();
		FindPlzDAO dao = new FindPlzDAO();
		
		HttpSession session = request.getSession();
		
		int pageCnt = dao.listCount();
		int pageNum = (pageCnt%15 == 0) ? pageCnt/15 : pageCnt/15+1; 
		session.setAttribute("pageNum", pageNum);
		int pageNo = Integer.parseInt((String)request.getParameter("pageNo")); //선택된 페이지번호

		findPlzList = dao.findPlzList(pageNo, 15); 
		System.out.println("FindList.do");
		session.setAttribute("findPlzList", findPlzList);
		
		
		return "/jsp/menu/findPlzList.jsp";
	}

}
