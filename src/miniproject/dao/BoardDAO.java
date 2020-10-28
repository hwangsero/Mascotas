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
	 * �Խ��� ��ü ����Ʈ��ȸ
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
    * ���� ������
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
    * ���ù� ����
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
    * ÷������ ��ȸ
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
    * ���������� ��� �Խñ۸� ���̰� �ϴ� ���
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
	 * �Խ��� �˻� ��ȸ(����)
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
		 * �Խ��� �˻� ��ȸ(����)
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
	 * �Խ��� �˻� ��ȸ(����+����)
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
		 * ��ȸ��view_cnt ���� ���
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
		 * Ŀ�´�Ƽ �Խ��� ÷������ ������
		 */

		public void insertFile(BoardFileVO fileVO) {

			System.out.println(fileVO);

			StringBuilder sql = new StringBuilder();
			sql.append("insert into pet_board_file(no, file_ori_name, file_save_name, board_no) ");
			sql.append("  values( seq_board_file_no.nextval, ?, ?, ? ) ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {

				int loc = 1; // �߰��� �����Ǿ��� ��� setString�θ� ������ �ٲ��ֱ� ���ŷο�Ƿ� ++

				ps.setString(loc++, fileVO.getFile_ori_name());
				ps.setString(loc++, fileVO.getFile_save_name());
				ps.setInt(loc++, fileVO.getBoardNo());

				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		/**
		 * Ŀ�´�Ƽ�Խ��� ÷������ ����
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
		 * �����Խ��� �� ��ϱ��
		 * 
		 * @param board �Է¹��� ������
		 */
		public void insertCom_Free(BoardVO board) {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into pet_board( no, printno, cate, race, title, content, writer )");
			sql.append(" values( ?, seq_free_no.nextval, ?, ?, ?, ?, ? ) ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {

				int loc = 1; // �߰��� �����Ǿ��� ��� setString�θ� ������ �ٲ��ֱ� ���ŷο�Ƿ� ++

				ps.setInt(loc++, board.getNo());
				System.out.println("�Խñ� ��ȣ" + board.getNo());
				ps.setString(loc++, board.getCate());
				ps.setString(loc++, board.getRace());
				ps.setString(loc++, board.getTitle());
				System.out.println("�Խñ� ����" + board.getTitle());
				ps.setString(loc++, board.getContent());
				ps.setString(loc++, board.getWriter());

				ps.executeUpdate();
				System.out.println("�Խñ۵�ϿϷ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * �����Խ��� �Խù� ������ ���� ������ ��ȣ ����(seq_petboard_no)
		 */
		public int selectNo() {
			String sql = "select petboard_no.nextval from dual ";

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);) {
				ResultSet rs = ps.executeQuery();
				rs.next();
				return rs.getInt(1); // �̸��� �ʿ������� 1���̹Ƿ� 1����

			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}

		
		/**
		 * �����Խ��� ����ȸ(��������)
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
		 * �����Խ��� �Խñ� ���� ���
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
		 * Ŀ�´�Ƽ �Խ��� �Խñ� ���� ���
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
		 * �ı� �Խ��� �� ��ϱ��
		 * 
		 * @param board �Է¹��� ������
		 */
		public void insertReviewBoard(BoardVO board) {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into pet_board( no, printno, cate, race, title, content, writer, com_cate )");
			sql.append(" values( ?, seq_review_no.nextval, ?, ?, ?, ?, ?, ? ) ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {

				int loc = 1; // �߰��� �����Ǿ��� ��� setString�θ� ������ �ٲ��ֱ� ���ŷο�Ƿ� ++

				ps.setInt(loc++, board.getNo());
				System.out.println("�Խñ� ��ȣ" + board.getNo());
				ps.setString(loc++, board.getCate());
				ps.setString(loc++, board.getRace());
				ps.setString(loc++, board.getTitle());
				System.out.println("�Խñ� ����" + board.getTitle());
				ps.setString(loc++, board.getContent());
				System.out.println("�Խñ� ����" + board.getContent());
				ps.setString(loc++, board.getWriter());
				System.out.println("�۾���" + board.getContent());
				ps.setString(loc++, board.getCom_cate());
				System.out.println("ī�װ� : "+board.getCom_cate());

				ps.executeUpdate();
				System.out.println("�Խñ۵�ϿϷ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  
		
		/**
		 * �Ծ� �Խ��� �� ��ϱ��
		 * 
		 * @param board �Է¹��� ������
		 */
		public void insertAdoptBoard(BoardVO board) {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into pet_board( no, printno, cate, race, title, content, writer, com_cate )");
			sql.append(" values( ?, seq_adopt_no.nextval, ?, ?, ?, ?, ?, ? ) ");
			
			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {
				
				int loc = 1; // �߰��� �����Ǿ��� ��� setString�θ� ������ �ٲ��ֱ� ���ŷο�Ƿ� ++
				
				ps.setInt(loc++, board.getNo());
				ps.setString(loc++, board.getCate());
				ps.setString(loc++, board.getRace());
				ps.setString(loc++, board.getTitle());
				ps.setString(loc++, board.getContent());
				ps.setString(loc++, board.getWriter());
				ps.setString(loc++, board.getCom_cate());
				
				ps.executeUpdate();
				System.out.println("�Խñ۵�ϿϷ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  
		
		/**
		 * ���ᳪ�� �Խ��� �� ��ϱ��
		 * 
		 * @param board �Է¹��� ������
		 */
		public void insertFreeShareBoard(BoardVO board) {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into pet_board( no, printno, cate, race, title, content, writer, com_cate )");
			sql.append(" values( ?, seq_freeshare_no.nextval, ?, ?, ?, ?, ?, ? ) ");
			
			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());) {
				
				int loc = 1; // �߰��� �����Ǿ��� ��� setString�θ� ������ �ٲ��ֱ� ���ŷο�Ƿ� ++
				
				ps.setInt(loc++, board.getNo());
				System.out.println("�Խñ� ��ȣ" + board.getNo());
				ps.setString(loc++, board.getCate());
				ps.setString(loc++, board.getRace());
				ps.setString(loc++, board.getTitle());
				System.out.println("�Խñ� ����" + board.getTitle());
				ps.setString(loc++, board.getContent());
				System.out.println("�Խñ� ����" + board.getContent());
				ps.setString(loc++, board.getWriter());
				System.out.println("�۾���" + board.getContent());
				ps.setString(loc++, board.getCom_cate());
				System.out.println("ī�װ� : "+board.getCom_cate());
				
				ps.executeUpdate();
				System.out.println("�Խñ۵�ϿϷ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  
		
		/**
		 * (�����Խ��ǿ�) Ŀ�´�Ƽ �Խ��� ����ȸ(��������)
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
		 * (�����Խ��� ��) Ŀ�´�Ƽ�Խ��� �Խñ� ���� ���
		 */
		public void updateComBoard(BoardVO board) {
			
			StringBuilder sql = new StringBuilder();
			sql.append("update pet_board ");
			sql.append(" set race = ?, title = ?, content = ?, com_cate = ? ");
			sql.append(" where no = ? ");
			
			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					
					) {
				
				int loc = 1; // �߰��� �����Ǿ��� ��� setString�θ� ������ �ٲ��ֱ� ���ŷο�Ƿ� ++
				
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