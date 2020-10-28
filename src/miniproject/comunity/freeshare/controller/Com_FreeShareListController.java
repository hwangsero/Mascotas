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
		System.out.println("����Ʈ ��Ʈ�ѷ� ");
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = new ArrayList<>();
		
		HttpSession session = request.getSession();
		
		int pageCnt = dao.listCount("���ᳪ���Խ���"); //���� ����Ʈ����
		int pageNum = (pageCnt%15 == 0) ? pageCnt/15 : pageCnt/15+1; 
		
		session.setAttribute("pageNum", pageNum);
		
		int pageNo = Integer.parseInt((String)request.getParameter("pageNo")); //���õ� ��������ȣ
//		int pageNo = 1; //���õ� ��������ȣ
		
		System.out.println("�������ѹ�"+pageNo);
		
		boardList = dao.BoardList(pageNo, 15, "���ᳪ���Խ���"); //����Ʈ��������(����������, ����Ʈ����, ī��)
		request.setAttribute("boardList", boardList);
		
		return "/jsp/menu/com_FreeShare/com_FreeShareList.jsp";
	}

}
