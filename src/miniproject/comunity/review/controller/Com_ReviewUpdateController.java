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
		System.out.println("�ı� ������Ʈ");
		int no = Integer.parseInt(request.getParameter("no"));
		
		
		BoardDAO dao = new BoardDAO();
		
		BoardVO board = dao.selectComBoard(no);
		System.out.println(board.toString());
		
		List<BoardFileVO> fileList = dao.selectFileByNo(no);
		
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		System.out.println("�ı� ������Ʈ ��Ʈ�ѷ��� ���ϻ�����"+fileList.size());
		
		return "/jsp/menu/com_Review/com_ReviewUpdateForm.jsp?no="+no;
	}

}
