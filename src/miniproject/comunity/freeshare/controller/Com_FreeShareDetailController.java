package miniproject.comunity.freeshare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;
import miniproject.dao.BoardDAO;
import miniproject.vo.BoardFileVO;
import miniproject.vo.BoardVO;

public class Com_FreeShareDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
//		String category = request.getParameter("cate");
		
		BoardDAO dao = new BoardDAO();
		/* 
			��ȸ�� ����
			��������� -> �������� ��ȸ�� ���� => type=list �Ķ���� �߰�
			���������� -> �������� ��ȸ�� ����X 
		*/
		String type = request.getParameter("type");
		if(type != null && type.equals("list")) {
			dao.updateViewCnt(no);
		}

		//�ش�Խù� ��ȸ
		
		BoardVO board = dao.selectComBoard(no);
		
		//÷������ ��ȸ
		List<BoardFileVO> fileList = dao.selectFileByNo(no);
		
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		
		return "/jsp/menu/com_FreeShare/com_FreeShareDetail.jsp";
	}

}
