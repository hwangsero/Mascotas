package miniproject.findplz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.controller.Controller;

public class FindPlzFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("FindPlzFormController에 들어왔어요");
		return "/jsp/menu/findPlzForm.jsp";
	}

}
