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

public class Com_FreeUpdateProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		System.out.println("업데이트프로세서컨트롤러");
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		
		String saveFolder = "C:\\Lecture\\web-workspace\\petSite\\WebContent\\upload";
		System.out.println("저장폴더 : "+saveFolder);
		
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024 * 1024 * 3
				, "utf-8", new AcornFileNamePolicy());
		
		int no = Integer.parseInt(multi.getParameter("no"));
		String cate = multi.getParameter("cate");
		String race = multi.getParameter("race");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		
		board.setNo(no);
		board.setCate(cate);
		board.setRace(race);
		board.setTitle(title);
		board.setContent(content);
		
		dao.updateFreeBoard(board);
		System.out.println("게시글 수정입력");
		//request영역에 저장
//		request.setAttribute("board", board);
		
		Enumeration<String> files = multi.getFileNames();
	 	System.out.println("첨부파일저장시작");
	 	while(files.hasMoreElements()) {	
	 		String fileName = files.nextElement();
	 		File f = multi.getFile(fileName);
	 		System.out.println(fileName+" : " + f);
	 
	 		if(f != null) {
	 			dao.deleteFile(no);
	 			String file_ori_name = multi.getOriginalFileName(fileName);
	 			String file_save_name = multi.getFilesystemName(fileName);
	 			
	 			BoardFileVO fileList = new BoardFileVO();
	 			fileList.setBoardNo(no);
	 			fileList.setFile_ori_name(file_ori_name);
	 			fileList.setFile_save_name(file_save_name);
	 			
	 			System.out.println("첨부파일dao");
	 			dao.insertFile(fileList);
	 			
	 			
	 		}
	 		
		
	 	}
		return "/menu/com_Free/com_FreeDetail.do?no="+no;
	}

}
