package miniproject.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.controller.Controller;
import miniproject.dao.UserDAO;
import miniproject.vo.UserVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		System.out.println(id);
		String password = request.getParameter("password");
		System.out.println(password);
		
		//VO객체 생성후 초기화
		UserVO loginVO = new UserVO();
		
		loginVO.setId(id);
		System.out.println("찍히나요 : "+id);
		loginVO.setPassword(password);
		System.out.println("비밀번호는 : "+password);
		
		//DB에서 로그인 수행
		UserDAO dao = new UserDAO();
		UserVO userVO = dao.login(loginVO);
		System.out.println(userVO);
		
		String msg="";
		String url="";
		
		if(userVO != null){
			
			switch(userVO.getType()){
			case "S" : msg="관리자님 환영합니다";
					break;
			case "U" : msg= userVO.getId() + "님 환영합니다.";
					break;
			}
			url = request.getContextPath()+"/index.jsp";
			
			//세션 등록
			HttpSession session = request.getSession();  
			session.setAttribute("userVO", userVO);
			
		System.out.println("2" + userVO);
					
					
		} else {
			msg="아이디 또는 비밀번호를 잘못입력하셨습니다.";
			url=request.getContextPath() + "/user/login.do";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/jsp/user/loginProcess.jsp";
	}

}
