package miniproject.findplz.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import miniproject.controller.Controller;
import miniproject.dao.FindPlzDAO;
import miniproject.util.AcornFileNamePolicy;
import miniproject.vo.BoardFileVO;
import miniproject.vo.FindPlzVO;

public class FindPlzRegProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		System.out.println("폼컨트롤러 도착");
		String saveFolder = "C:\\Lecture\\web-workspace\\petSite\\WebContent\\upload";
		
		
		FindPlzDAO dao = new FindPlzDAO();

		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024 * 1024 * 3
				, "utf-8", new AcornFileNamePolicy());
		
		String cate = multi.getParameter("cate");
		String race = multi.getParameter("race");
		String sex = multi.getParameter("sex");
		String age = multi.getParameter("age");
		String name = multi.getParameter("name");
		String lostDate = multi.getParameter("lostDate");
		String lostSpot = multi.getParameter("lostSpot");
		String feature = multi.getParameter("feature");
		String etc = multi.getParameter("etc");
		String writer = multi.getParameter("writer");
		String tel = multi.getParameter("tel");
		
		int no = dao.selectNo();
		
		FindPlzVO findPlz = new FindPlzVO(no, cate, race, sex, age, name, lostDate, lostSpot, feature, etc, writer, tel);
		dao.insertFindPlz(findPlz);
		
		Enumeration<String> files = multi.getFileNames();
	 	System.out.println("첨부파일저장시작");
	 	while(files.hasMoreElements()) {	
	 		String fileName = files.nextElement();
	 		File f = multi.getFile(fileName);
	 		System.out.println(fileName+" : " + f);
	 
	 		if(f != null) {
	 			String file_ori_name = multi.getOriginalFileName(fileName);
	 			String file_save_name = multi.getFilesystemName(fileName);
	 			
	 			BoardFileVO fileVO = new BoardFileVO();
	 			fileVO.setFile_ori_name(file_ori_name);
	 			fileVO.setFile_save_name(file_save_name);
	 			fileVO.setBoardNo(no);
	 			System.out.println(file_ori_name);
	 			System.out.println(file_save_name);
	 			System.out.println(no);
	 			
	 			
	 			System.out.println("첨부파일dao");
	 			dao.insertFile(fileVO);
	 			
	 			
	 			//request영역에 저장
	 			request.setAttribute("fileList", fileVO);
	 		}
	 		
		 
	}
	 	return "redirect:" + request.getContextPath();

	}
}
