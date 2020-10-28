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
		
		//VO��ü ������ �ʱ�ȭ
		UserVO loginVO = new UserVO();
		
		loginVO.setId(id);
		System.out.println("�������� : "+id);
		loginVO.setPassword(password);
		System.out.println("��й�ȣ�� : "+password);
		
		//DB���� �α��� ����
		UserDAO dao = new UserDAO();
		UserVO userVO = dao.login(loginVO);
		System.out.println(userVO);
		
		String msg="";
		String url="";
		
		if(userVO != null){
			
			switch(userVO.getType()){
			case "S" : msg="�����ڴ� ȯ���մϴ�";
					break;
			case "U" : msg= userVO.getId() + "�� ȯ���մϴ�.";
					break;
			}
			url = request.getContextPath()+"/index.jsp";
			
			//���� ���
			HttpSession session = request.getSession();  
			session.setAttribute("userVO", userVO);
			
		System.out.println("2" + userVO);
					
					
		} else {
			msg="���̵� �Ǵ� ��й�ȣ�� �߸��Է��ϼ̽��ϴ�.";
			url=request.getContextPath() + "/user/login.do";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/jsp/user/loginProcess.jsp";
	}

}
