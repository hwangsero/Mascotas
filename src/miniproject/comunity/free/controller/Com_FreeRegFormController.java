package miniproject.comunity.free.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import miniproject.controller.Controller;
import miniproject.dao.BoardDAO;
import miniproject.util.AcornFileNamePolicy;
import miniproject.vo.BoardFileVO;
import miniproject.vo.BoardVO;

public class Com_FreeRegFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		System.out.println("폼컨트롤러 도착");
		String saveFolder = "C:\\Lecture\\web-workspace\\petSite\\WebContent\\upload";
		
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024 * 1024 * 3
					, "utf-8", new AcornFileNamePolicy());
	
		//1. 게시물 저장(petboard)
		String cate 	= multi.getParameter("cate");
		String race 	= multi.getParameter("race");
		String title 	= multi.getParameter("title");
		String writer 	= multi.getParameter("writer");
		String content 	= multi.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setCate(cate);
		board.setRace(race);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
				
		BoardDAO dao = new BoardDAO();
		
		int boardNo = dao.selectNo();	//고유 시퀀스 넘버
		board.setNo(boardNo);
		

		dao.insertCom_Free(board);
		
		//2.첨부파일 저장(board_file)
	 	Enumeration<String> files = multi.getFileNames();
	 	System.out.println("첨부파일저장시작");
	 	while(files.hasMoreElements()) {	
	 		String fileName = files.nextElement();
	 		File f = multi.getFile(fileName);
	 		System.out.println(fileName+" : " + f);
	 
	 		if(f != null) {
	 			String file_ori_name = multi.getOriginalFileName(fileName);
	 			String file_save_name = multi.getFilesystemName(fileName);
	 			
	 			BoardFileVO fileList = new BoardFileVO();
	 			fileList.setFile_ori_name(file_ori_name);
	 			fileList.setFile_save_name(file_save_name);
	 			fileList.setBoardNo(boardNo);
	 			System.out.println(file_ori_name);
	 			System.out.println(file_save_name);
	 			System.out.println(boardNo);
	 			
	 			
	 			dao.insertFile(fileList);
	 			
	 		}
		
	 	}
	 	

	 	return "/menu/com_Free/com_FreeList.do?pageNo=1";

	}
}
