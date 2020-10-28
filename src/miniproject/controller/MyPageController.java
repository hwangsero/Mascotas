package miniproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.dao.BoardDAO;
import miniproject.vo.BoardVO;
import miniproject.vo.UserVO;

public class MyPageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		String id = userVO.getId();
		System.out.println(id);
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.MyBoardList(id);
		session.setAttribute("boardList", boardList);
		return "/jsp/user/myPage.jsp";
	}
}
