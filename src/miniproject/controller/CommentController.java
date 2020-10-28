package miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.dao.CommentDAO;
import miniproject.vo.CommentVO;

public class CommentController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("코맨트 컨트롤러");
		String id = request.getParameter("id");
		String comment = request.getParameter("comment");
		int pno;
		if(request.getParameter("parrent_no")!=null) {
			pno = Integer.parseInt(request.getParameter("parrent_no"));
		}else {
			pno = -3;
		}
		int num = Integer.parseInt(request.getParameter("no"));
		int com = 0;
		CommentVO cvo = new CommentVO();
		HttpSession session = request.getSession();  
		CommentDAO cdo = new CommentDAO();
		if(id==null) {
			System.out.println("여기니");
		}else {
			cvo.setWriter(id);
			cvo.setPet_comment(comment);
			cvo.setBoard_no(num);
			cvo.setType("b");
			if(pno!=-3) {
				cvo.setParrent(1);
				cvo.setParrent_no(pno);
			}else {
				cvo.setParrent(0);
				cvo.setParrent_no(0);
			}
			cdo.insertcomment(cvo);
			System.out.println(cvo.toString());
		}
		int k = cdo.selectparrentlimit();
		System.out.println(k+"리밋");
		List<Object> colist = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			colist.add(cdo.selectAllcomment(num, i));		
		}
		System.out.println("rr");
		/*List colist = cdo.selectAllcomment(num, 0);*/
		System.out.println("asdf");
		System.out.println(colist.toString());
		session.setAttribute("colist", colist.get(0));
		session.setAttribute("colist2", colist.get(1));
		request.setAttribute("cik", "cik");
		System.out.println("asdfff");
		return "redirect:"+request.getContextPath()+"/comment/returncomment.jsp";
	}

}
