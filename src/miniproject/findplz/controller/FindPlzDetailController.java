package miniproject.findplz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;
import miniproject.dao.FindPlzDAO;
import miniproject.vo.FindPlzVO;

public class FindPlzDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("findplzdatail");
		int no = Integer.parseInt(request.getParameter("no"));
		FindPlzDAO dao = new FindPlzDAO();
		
		FindPlzVO findPlz = dao.detailFindPlz(no);
		
		request.setAttribute("findPlz", findPlz);
		return "/jsp/menu/findPlzDetail.jsp";
	}

}
