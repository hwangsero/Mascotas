package miniproject.borad.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;

public class LostPetDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String desertionNo = request.getParameter("no");
		return "/jsp/menu/LostPetDetail.jsp?no="+desertionNo;
	}
}
