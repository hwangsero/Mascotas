package miniproject.comunity.free.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.controller.Controller;
import miniproject.dao.BoardDAO;
import miniproject.vo.BoardVO;

public class Com_FreeListController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("����Ʈ ��Ʈ�ѷ� ");
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = new ArrayList<>();
	//	freeBoardList = dao.boardList("�����Խ���");
		
		HttpSession session = request.getSession();
		
		int pageCnt = dao.listCount("�����Խ���"); //���� ����Ʈ����
		int pageNum = (pageCnt%15 == 0) ? pageCnt/15 : pageCnt/15+1; 
		
		session.setAttribute("pageNum", pageNum);
		
		int pageNo = Integer.parseInt((String)request.getParameter("pageNo")); //���õ� ��������ȣ
//		int pageNo = 1; //���õ� ��������ȣ
		
		System.out.println("�������ѹ�"+pageNo);
		
		boardList = dao.BoardList(pageNo, 15, "�����Խ���"); //����Ʈ��������(����������, ����Ʈ����, ī��)
		request.setAttribute("boardList", boardList);
		
		return "/jsp/menu/com_Free/com_FreeList.jsp";
	}

}
