package miniproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import miniproject.util.ConnectionFactory;
import miniproject.util.JDBCClose;
import miniproject.vo.BoardFileVO;
import miniproject.vo.BoardVO;

public class BoardDAO {
	
	/**
	 * 게시판 전체 리스트조회
	 * 
	 * @param category
	 * @return
	 *//*
	
	public List<BoardVO> boardList(String category) {

		StringBuilder sql = new StringBuilder();
		sql.append("select no, printno, cate, race, title, content, writer, view_cnt"
				+ "           , to_char(reg_date, 'yyyy-mm-dd hh24:mi') as reg_date ");
		sql.append(" from pet_board ");
		sql.append(" where cate = ? ");
		sql.append(" order by printno desc ");

		BoardVO boardvo = null;

		List<BoardVO> boardList = new ArrayList<>();

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			
				pstmt.setString(1, category);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					int no = rs.getInt("no");
					int printno = rs.getInt("printno");
					String cate = rs.getString("cate");
					String race = rs.getString("race");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String writer = rs.getString("writer");
					int view_cnt = rs.getInt("view_cnt");
					
					String reg_date = null;
	
					Date d = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(d);
	
					if (rs.getString("reg_date").contains(date))
						reg_date = rs.getString("reg_date").substring(11);
					else
						reg_date = rs.getString("reg_date").substring(0, 10);
	
					boardvo = new BoardVO(no, printno, cate, race, title, content, writer, view_cnt, reg_date);
					boardList.add(boardvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boardList;

	}*/

    
   /**
    * 파일 상세정보
    * 
    * @param boardVO
    * @return
    */
   public BoardVO boardDetail(BoardVO boardVO) {
      StringBuilder sql = new StringBuilder();
      sql.append(
            "select no, printno, cate, race, title, content, writer, view_cnt, to_char(reg_date, 'yyyy-mm-dd hh24:mi') as reg_date ");
      sql.append(" from pet_board ");
      sql.append(" where no = ? ");

      BoardVO boardvo = null;

      try (Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
         pstmt.setInt(1, boardVO.getNo());

         ResultSet rs = pstmt.executeQuery();
         if (rs.next()) {
            int no = rs.getInt("no");
            int printno = rs.getInt("printno");
            String cate = rs.getString("cate");
            String race = rs.getString("race");
            String title = rs.getString("title");
            String content = rs.getString("content");
            String writer = rs.getString("writer");
            int view_cnt = rs.getInt("view_cnt");
            String reg_date = null;

            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(d);

            if (rs.getString("reg_date").contains(date))
               reg_date = rs.getString("reg_date").substring(11);
            else
               reg_date = rs.getString("reg_date").substring(0, 10);

            boardvo = new BoardVO(no, printno, cate, race, title, content, writer, view_cnt, reg_date);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return boardvo;
   }

   /**
    * 개시물 개수
    * 
    * @param category
    * @return
    */
   public int listCount(String category) {
      StringBuilder sql = new StringBuilder();
      sql.append("select count(*) count ");
      sql.append(" from pet_board ");
      sql.append(" where cate = ? ");
      int count = 0;
      try (Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
         pstmt.setString(1, category);
         ResultSet rs = pstmt.executeQuery();
         if (rs.next()) {
            count = rs.getInt("count");

         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      return count;

   }

   /**
    * 첨부파일 조회
    * 
    * @param boardNo
    * @return
    */

   public List<BoardFileVO> selectFileByNo(int boardNo) {

      List<BoardFileVO> fileList = new ArrayList<>();

      StringBuilder sql = new StringBuilder();
      sql.append("select * ");
      sql.append(" from pet_board_file ");
      sql.append("where board_no = ? ");

      try (Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());

      ) {
         pstmt.setInt(1, boardNo);
         ;
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
            BoardFileVO fileVO = new BoardFileVO();
            fileVO.setNo(rs.getInt("no"));
            fileVO.setFile_ori_name(rs.getString("file_ori_name"));
            fileVO.setFile_save_name(rs.getString("file_save_name"));
            fileVO.setBoardNo(rs.getInt("board_no"));

            fileList.add(fileVO);

         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      return fileList;
   }

   /**
    * 한페이지에 몇개의 게시글만 보이게 하는 기능
    */
   public List<BoardVO> BoardList(int n, int listCnt, String category) {

      List<BoardVO> list = new ArrayList<>();

      StringBuilder sql = new StringBuilder();
      sql.append("select no, printno, cate, race, title, content, writer, view_cnt, to_char(reg_date, 'yyyy-mm-dd hh24:mi') as reg_date, com_cate");
      sql.append("  from (select rownum as rnum, t.*  ");
      sql.append("          from (select * from pet_board where cate = ? order by printno desc) t) ");
      sql.append(" where rnum between ? and ? ");

      try (Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
    	  pstmt.setString(1, category);
         pstmt.setInt(2, listCnt * (n - 1) + 1);
         pstmt.setInt(3, listCnt * n);

         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
            int no = rs.getInt("no");
            int printno = rs.getInt("printno");
            String cate = rs.getString("cate");
            String race = rs.getString("race");
            String com_cate = rs.getString("com_cate");
            String title = rs.getString("title");
            String content = rs.getString("content");
            String writer = rs.getString("writer");
            int viewCnt = rs.getInt("view_cnt");
            String regDate = rs.getString("reg_date");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());

            if (regDate.contains(today))
               regDate = regDate.substring(11, 16);
            else
               regDate = regDate.substring(0, 10);

            BoardVO board = new BoardVO();
            board.setNo(no);
            board.setPrintno(printno);
            board.setCate(cate);
            board.setRace(race);
            board.setCom_cate(com_cate);;
            board.setTitle(title);
            board.setContent(content);
            board.setWriter(writer);
            board.setView_cnt(viewCnt);
            board.setReg_date(regDate);

            list.add(board);
         }
         
         System.out.println("dao : " + list.size());

      } catch (Exception e) {
         e.printStackTrace();
      }

      return list;
   }
   
   /**
	 * 게시판 검색 조회(제목)
	 */

	  public List<BoardVO> boardSearchTitle(int n, int listCnt, String category, String search) {
	  
	  List<BoardVO> list = new ArrayList<>();
	  
	  StringBuilder sql = new StringBuilder(); sql.
	  append("select no, printno, cate, race, title, content, writer, view_cnt, to_char(reg_date, 'yyyy-mm-dd hh24:mi') as reg_date "
	  ); sql.append("  from (select rownum as rnum, t.*  ");
	  sql.append("          from (select * from pet_board where cate=? and title like ? order by no desc) t) ");
	  sql.append(" where rnum between ? and ? ");
	 
	  try( Connection conn = new ConnectionFactory().getConnection();
	  PreparedStatement pstmt = conn.prepareStatement(sql.toString()); ){
	  pstmt.setString(1, category);
	  pstmt.setString(2, "%"+search+"%");
	  pstmt.setInt(3, listCnt*(n-1)+1); 
	  pstmt.setInt(4, listCnt*n);
	  
	  ResultSet rs = pstmt.executeQuery(); 
	  while(rs.next()) { 
	  int no = rs.getInt("no");
	  int printno = rs.getInt("printno");
	  String cate = rs.getString("cate");
	  String race = rs.getString("race");
	  String title = rs.getString("title");
	  String content = rs.getString("content");
	  String writer = rs.getString("writer");
	  int viewCnt = rs.getInt("view_cnt"); 
	  String regDate = rs.getString("reg_date");
	  
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); String today =
	  sdf.format(new Date());
	  
	  if(regDate.contains(today)) regDate = regDate.substring(11, 16); else regDate
	  =regDate.substring(0, 10);
	  
	  BoardVO board = new BoardVO(); 
	  board.setNo(no); 
	  board.setPrintno(printno);
	  board.setCate(cate); 
	  board.setRace(race); 
	  board.setTitle(title);
	  board.setContent(content); 
	  board.setWriter(writer);
	  board.setView_cnt(viewCnt); 
	  board.setReg_date(regDate);
	  
	  list.add(board); 
	  }
	  
	  } catch (Exception e) { 
		e.printStackTrace(); 
	}
	  
	  return list; 
}
	  /**
		 * 게시판 검색 조회(내용)
		 */

		  public List<BoardVO> boardSearchCon(int n, int listCnt, String category, String search) {
		  
		  List<BoardVO> list = new ArrayList<>();
		  
		  StringBuilder sql = new StringBuilder(); sql.
		  append("select no, printno, cate, race, title, content, writer, view_cnt, to_char(reg_date, 'yyyy-mm-dd hh24:mi') as reg_date "
		  ); sql.append("  from (select rownum as rnum, t.*  ");
		  sql.append("          from (select * from pet_board order by no desc) t) ");
		  sql.append(" where rnum between ? and ? and cate = ? and content like ?");
		 
		  try( Connection conn = new ConnectionFactory().getConnection();
		  PreparedStatement pstmt = conn.prepareStatement(sql.toString()); ){
		  pstmt.setInt(1, listCnt*(n-1)+1); 
		  pstmt.setInt(2, listCnt*n);
		  pstmt.setString(3, category);
		  pstmt.setString(4, "%"+search+"%");
		  
		  ResultSet rs = pstmt.executeQuery(); 
		  while(rs.next()) { 
		  int no = rs.getInt("no");
		  int printno = rs.getInt("printno");
		  String cate = rs.getString("cate");
		  String race = rs.getString("race");
		  String title = rs.getString("title");
		  String content = rs.getString("content");
		  String writer = rs.getString("writer");
		  int viewCnt = rs.getInt("view_cnt"); 
		  String regDate = rs.getString("reg_date");
		  
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); String today =
		  sdf.format(new Date());
		  
		  if(regDate.contains(today)) regDate = regDate.substring(11, 16); else regDate
		  =regDate.substring(0, 10);
		  
		  BoardVO board = new BoardVO(); 
		  board.setNo(no); 
		  board.setPrintno(printno);
		  board.setCate(cate); 
		  board.setRace(race); 
		  board.setTitle(title);
		  board.setContent(content); 
		  board.setWriter(writer);
		  board.setView_cnt(viewCnt); 
		  board.setReg_date(regDate);
		  
		  list.add(board); 
		  }
		  
		  } catch (Exception e) { 
			e.printStackTrace(); 
		}
		  
		  return list; 
	}
		  
  /**
	 * 게시판 검색 조회(제목+내용)
	 */

	  public List<BoardVO> boardSearchTitleCon(int n, int listCnt, String category, String search) {
	  
	  List<BoardVO> list = new ArrayList<>();
	  
	  StringBuilder sql = new StringBuilder(); sql.
	  append("select no, printno, cate, race, title, content, writer, view_cnt, to_char(reg_date, 'yyyy-mm-dd hh24:mi') as reg_date "
	  ); sql.append("  from (select rownum as rnum, t.*  ");
	  sql.append("          from (select * from pet_board order by no desc) t) ");
	  sql.append(" where rnum between ? and ? and cate = ? and (title like ? or content like ?)");
	 
	  try( Connection conn = new ConnectionFactory().getConnection();
	  PreparedStatement pstmt = conn.prepareStatement(sql.toString()); ){
	  pstmt.setInt(1, listCnt*(n-1)+1); 
	  pstmt.setInt(2, listCnt*n);
	  pstmt.setString(3, category);
	  pstmt.setString(4, "%"+search+"%");
	  pstmt.setString(5, "%"+search+"%");
	  
	  ResultSet rs = pstmt.executeQuery(); 
	  while(rs.next()) { 
	  int no = rs.getInt("no");
	  int printno = rs.getInt("printno");
	  String cate = rs.getString("cate");
	  String race = rs.getString("race");
	  String title = rs.getString("title");
	  String content = rs.getString("content");
	  String writer = rs.getString("writer");
	  int viewCnt = rs.getInt("view_cnt"); 
	  String regDate = rs.getString("reg_date");
	  
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); String today =
			  sdf.format(new Date());
			  
			  if(regDate.contains(today)) regDate = regDate.substring(11, 16); else regDate
			  =regDate.substring(0, 10);
			  
			  BoardVO board = new BoardVO(); 
			  board.setNo(no); 
			  board.setPrintno(printno);
			  board.setCate(cate); 
			  board.setRace(race); 
			  board.setTitle(title);
			  board.setContent(content); 
			  board.setWriter(writer);
			  board.setView_cnt(viewCnt); 
			  board.setReg_date(regDate);
			  
			  list.add(board); 
			  }
			  
			  } catch (Exception e) { 
				e.printStackTrace(); 
			}
			  
			  return list; 
		}
   
	  /**
		 * 조회수view_cnt 증가 기능
		 */
		public void updateViewCnt(int no) {

			StringBuilder sql = new StringBuilder();
			sql.append("update pet_board ");
			sql.append("  set view_cnt = view_cnt + 1 ");
			sql.append(" where no = ? ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {
				ps.setInt(1, no);
				ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		/**
		 * 커뮤니티 게시판 첨부파일 저장기능
		 */

		public void insertFile(BoardFileVO fileVO) {

			System.out.println(fileVO);

			StringBuilder sql = new StringBuilder();
			sql.append("insert into pet_board_file(no, file_ori_name, file_save_name, board_no) ");
			sql.append("  values( seq_board_file_no.nextval, ?, ?, ? ) ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {

				int loc = 1; // 중간에 수정되었을 경우 setString부를 일일이 바꿔주기 번거로우므로 ++

				ps.setString(loc++, fileVO.getFile_ori_name());
				ps.setString(loc++, fileVO.getFile_save_name());
				ps.setInt(loc++, fileVO.getBoardNo());

				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		/**
		 * 커뮤니티게시판 첨부파일 삭제
		 */
		public void deleteFile(int boardNo) {

			StringBuilder sql = new StringBuilder();
			sql.append("delete from pet_board_file ");
			sql.append(" where board_no = ? ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {

				ps.setInt(1, boardNo);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * 자유게시판 글 등록기능
		 * 
		 * @param board 입력받은 데이터
		 */
		public void insertCom_Free(BoardVO board) {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into pet_board( no, printno, cate, race, title, content, writer )");
			sql.append(" values( ?, seq_free_no.nextval, ?, ?, ?, ?, ? ) ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {

				int loc = 1; // 중간에 수정되었을 경우 setString부를 일일이 바꿔주기 번거로우므로 ++

				ps.setInt(loc++, board.getNo());
				System.out.println("게시글 번호" + board.getNo());
				ps.setString(loc++, board.getCate());
				ps.setString(loc++, board.getRace());
				ps.setString(loc++, board.getTitle());
				System.out.println("게시글 제목" + board.getTitle());
				ps.setString(loc++, board.getContent());
				ps.setString(loc++, board.getWriter());

				ps.executeUpdate();
				System.out.println("게시글등록완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * 자유게시판 게시물 삽입을 위한 시퀀스 번호 추출(seq_petboard_no)
		 */
		public int selectNo() {
			String sql = "select petboard_no.nextval from dual ";

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);) {
				ResultSet rs = ps.executeQuery();
				rs.next();
				return rs.getInt(1); // 이름이 필요하지만 1줄이므로 1써줌

			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}

		
		/**
		 * 자유게시판 글조회(상세페이지)
		 */
		public BoardVO selectFreeboard(int no) {

			BoardVO board = null;

			StringBuilder sql = new StringBuilder();
			sql.append("select printno, cate, race, title, writer, content, view_cnt ");
			sql.append("     , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append("  from pet_board ");
			sql.append(" where no = ? ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {

				ps.setInt(1, no);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					int boardNo = rs.getInt("printno");
					String category = rs.getString("cate");
					String race = rs.getString("race");
					String title = rs.getString("title");
					String writer = rs.getString("writer");
					String content = rs.getString("content");
					int viewCnt = rs.getInt("view_cnt");
					String regDate = rs.getString("reg_date");

					board = new BoardVO(boardNo, category, race, title, writer, content, viewCnt, regDate);
					System.out.println(board.toString());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return board;
		}

		/**
		 * 자유게시판 게시글 수정 기능
		 */
		public void updateFreeBoard(BoardVO board) {

			StringBuilder sql = new StringBuilder();
			sql.append("update pet_board ");
			sql.append(" set race = ?, title = ?, content = ? ");
			sql.append(" where no = ? ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			) {

				pstmt.setString(1, board.getRace());
				pstmt.setString(2, board.getTitle());
				pstmt.setString(3, board.getContent());
				pstmt.setInt(4, board.getNo());

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

		/**
		 * 커뮤니티 게시판 게시글 삭제 기능
		 */

		public void deleteBoard(int no) {

			StringBuilder sql = new StringBuilder();
			sql.append("delete from pet_board ");
			sql.append(" where no = ? ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {

				ps.setInt(1, no);

				ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		/**
		 * 후기 게시판 글 등록기능
		 * 
		 * @param board 입력받은 데이터
		 */
		public void insertReviewBoard(BoardVO board) {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into pet_board( no, printno, cate, race, title, content, writer, com_cate )");
			sql.append(" values( ?, seq_review_no.nextval, ?, ?, ?, ?, ?, ? ) ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {

				int loc = 1; // 중간에 수정되었을 경우 setString부를 일일이 바꿔주기 번거로우므로 ++

				ps.setInt(loc++, board.getNo());
				System.out.println("게시글 번호" + board.getNo());
				ps.setString(loc++, board.getCate());
				ps.setString(loc++, board.getRace());
				ps.setString(loc++, board.getTitle());
				System.out.println("게시글 제목" + board.getTitle());
				ps.setString(loc++, board.getContent());
				System.out.println("게시글 내용" + board.getContent());
				ps.setString(loc++, board.getWriter());
				System.out.println("글쓴이" + board.getContent());
				ps.setString(loc++, board.getCom_cate());
				System.out.println("카테고리 : "+board.getCom_cate());

				ps.executeUpdate();
				System.out.println("게시글등록완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  
		
		/**
		 * 입양 게시판 글 등록기능
		 * 
		 * @param board 입력받은 데이터
		 */
		public void insertAdoptBoard(BoardVO board) {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into pet_board( no, printno, cate, race, title, content, writer, com_cate )");
			sql.append(" values( ?, seq_adopt_no.nextval, ?, ?, ?, ?, ?, ? ) ");
			
			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {
				
				int loc = 1; // 중간에 수정되었을 경우 setString부를 일일이 바꿔주기 번거로우므로 ++
				
				ps.setInt(loc++, board.getNo());
				ps.setString(loc++, board.getCate());
				ps.setString(loc++, board.getRace());
				ps.setString(loc++, board.getTitle());
				ps.setString(loc++, board.getContent());
				ps.setString(loc++, board.getWriter());
				ps.setString(loc++, board.getCom_cate());
				
				ps.executeUpdate();
				System.out.println("게시글등록완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  
		
		/**
		 * 무료나눔 게시판 글 등록기능
		 * 
		 * @param board 입력받은 데이터
		 */
		public void insertFreeShareBoard(BoardVO board) {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into pet_board( no, printno, cate, race, title, content, writer, com_cate )");
			sql.append(" values( ?, seq_freeshare_no.nextval, ?, ?, ?, ?, ?, ? ) ");
			
			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {
				
				int loc = 1; // 중간에 수정되었을 경우 setString부를 일일이 바꿔주기 번거로우므로 ++
				
				ps.setInt(loc++, board.getNo());
				System.out.println("게시글 번호" + board.getNo());
				ps.setString(loc++, board.getCate());
				ps.setString(loc++, board.getRace());
				ps.setString(loc++, board.getTitle());
				System.out.println("게시글 제목" + board.getTitle());
				ps.setString(loc++, board.getContent());
				System.out.println("게시글 내용" + board.getContent());
				ps.setString(loc++, board.getWriter());
				System.out.println("글쓴이" + board.getContent());
				ps.setString(loc++, board.getCom_cate());
				System.out.println("카테고리 : "+board.getCom_cate());
				
				ps.executeUpdate();
				System.out.println("게시글등록완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  
		
		/**
		 * (자유게시판외) 커뮤니티 게시판 글조회(상세페이지)
		 */
		public BoardVO selectComBoard(int no) {

			BoardVO board = null;

			StringBuilder sql = new StringBuilder();
			sql.append("select printno, cate, race, title, writer, content, view_cnt ");
			sql.append("     , to_char(reg_date, 'yyyy-mm-dd') as reg_date, com_cate ");
			sql.append("  from pet_board ");
			sql.append(" where no = ? ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {

				ps.setInt(1, no);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					int boardNo = rs.getInt("printno");
					String category = rs.getString("cate");
					String race = rs.getString("race");
					String com_cate = rs.getString("com_cate");
					String title = rs.getString("title");
					String writer = rs.getString("writer");
					String content = rs.getString("content");
					int viewCnt = rs.getInt("view_cnt");
					String regDate = rs.getString("reg_date");
					
					board = new BoardVO(boardNo, category, race, com_cate, title, writer, content, viewCnt, regDate);
					System.out.println(board.toString());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return board;
		}
		
		/**
		 * (자유게시판 외) 커뮤니티게시판 게시글 수정 기능
		 */
		public void updateComBoard(BoardVO board) {
			
			StringBuilder sql = new StringBuilder();
			sql.append("update pet_board ");
			sql.append(" set race = ?, title = ?, content = ?, com_cate = ? ");
			sql.append(" where no = ? ");
			
			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					
					) {
				
				int loc = 1; // 중간에 수정되었을 경우 setString부를 일일이 바꿔주기 번거로우므로 ++
				
				pstmt.setString(loc++, board.getRace());
				pstmt.setString(loc++, board.getTitle());
				pstmt.setString(loc++, board.getContent());
				pstmt.setString(loc++, board.getCom_cate());
				pstmt.setInt(loc++, board.getNo());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
   
}