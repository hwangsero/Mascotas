package miniproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import miniproject.util.ConnectionFactory;
import miniproject.vo.BoardFileVO;
import miniproject.vo.BoardVO;
import miniproject.vo.FindPlzVO;

public class FindPlzDAO {
	/**
	 * 게시물 삽입을 위한 시퀀스 번호 추출(seq_petboard_no)
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
	 * 찾아주세요 글 등록
	 */
	
	public void insertFindPlz(FindPlzVO findPlz) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into pet_findPlz ") ;
		sql.append(" values(?, seq_petfindplz_no.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,0, sysdate)");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString());) {

		int loc = 1; // 중간에 수정되었을 경우 setString부를 일일이 바꿔주기 번거로우므로 ++

//		ps.setString(loc++, board.getNo());
			ps.setInt(loc++, findPlz.getNo());
			ps.setString(loc++, findPlz.getCate());
			ps.setString(loc++, findPlz.getRace());
			ps.setString(loc++, findPlz.getSex());
			ps.setString(loc++, findPlz.getAge());
			ps.setString(loc++, findPlz.getName());
			ps.setString(loc++, findPlz.getLostDate());
			ps.setString(loc++, findPlz.getLostSpot());
			ps.setString(loc++, findPlz.getFeature());
			ps.setString(loc++, findPlz.getEtc());
			ps.setString(loc++, findPlz.getWriter());
			ps.setString(loc++, findPlz.getTel());


			ps.executeUpdate();
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 첨부파일 저장기능
	 */

	public void insertFile(BoardFileVO fileVO) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into pet_board_file(no, file_ori_name, file_save_name, board_no) ");
		sql.append("  values(seq_board_file_no.nextval, ?, ?, ? ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString());) {
			ps.setString(1, fileVO.getFile_ori_name());
			ps.setString(2, fileVO.getFile_save_name());
			ps.setInt(3, fileVO.getBoardNo());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 개시물 개수
	 * 
	 * @param category
	 * @return
	 */
	public int listCount() {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) count ");
		sql.append(" from pet_findPlz ");
		int count = 0;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

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
	 * 한페이지에 몇개의 게시글만 보이게 하는 기능
	 */
	public List<FindPlzVO> findPlzList(int n, int listCnt) {

		List<FindPlzVO> list = new ArrayList<>();

	      StringBuilder sql = new StringBuilder();
	      sql.append(
	            "select no, printno, cate, race, sex, age, name, lostDate, lostSpot, feature, etc, writer, tel, view_cnt, to_char(reg_date, 'yyyy-mm-dd hh24:mi') as reg_date ");
	      sql.append("  from (select rownum as rnum, t.*  ");
	      sql.append("          from (select * from pet_findPlz order by no desc) t) ");
	      sql.append(" where rnum between ? and ? ");

	      try (Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
	         pstmt.setInt(1, listCnt * (n - 1) + 1);
	         pstmt.setInt(2, listCnt * n);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				int printno = rs.getInt("printno");
				String cate = rs.getString("cate");
				String race = rs.getString("race");
				String sex = rs.getString("sex");
				String age = rs.getString("age");
				String name = rs.getString("name");
				String lostDate = rs.getString("lostDate");
				String lostSpot = rs.getString("lostSpot");
				String feature = rs.getString("feature");
				String etc = rs.getString("etc");
				String writer = rs.getString("writer");
				String tel = rs.getString("tel");
				int view_cnt = rs.getInt("view_cnt");
				String reg_date = rs.getString("reg_date");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String today = sdf.format(new Date());

				if (reg_date.contains(today))
					reg_date = reg_date.substring(11, 16);
				else
					reg_date = reg_date.substring(0, 10);

				FindPlzVO findPlz = new FindPlzVO(no, printno, cate, race, sex, age, name, lostDate, lostSpot, feature, etc, writer, tel, view_cnt, reg_date);

				System.out.println(findPlz);
				
				list.add(findPlz);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	/**
	 * 찾아주세요 상세보기
	 */
	public FindPlzVO detailFindPlz(int no) {
	
		BoardVO board = null;
		FindPlzVO findPlz = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select no, printno, cate, race, sex, age, name, lostDate, lostSpot, feature, etc, writer, tel, view_cnt, to_char(reg_date, 'yyyy-mm-dd hh24:mi') as reg_date ");
		sql.append("  from pet_findPlz ");
		sql.append(" where no = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
		) {

			ps.setInt(1, no);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int printno = rs.getInt("printno");
				String cate = rs.getString("cate");
				String race = rs.getString("race");
				String sex = rs.getString("sex");
				String age = rs.getString("age");
				String name = rs.getString("name");
				String lostDate = rs.getString("lostDate");
				String lostSpot = rs.getString("lostSpot");
				String feature = rs.getString("feature");
				String etc = rs.getString("etc");
				String writer = rs.getString("writer");
				String tel = rs.getString("tel");
				int view_cnt = rs.getInt("view_cnt");
				String reg_date = rs.getString("reg_date");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String today = sdf.format(new Date());

				if (reg_date.contains(today))
					reg_date = reg_date.substring(11, 16);
				else
					reg_date = reg_date.substring(0, 10);

				findPlz = new FindPlzVO(no, printno, cate, race, sex, age, name, lostDate, lostSpot, feature, etc, writer, tel, view_cnt, reg_date);
				
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return findPlz;
	}
	 public List<FindPlzVO> FindPlzMainList() {

         StringBuilder sql = new StringBuilder();
         sql.append("select no, printno, cate, race, sex, age, name, lostDate, lostSpot, feature, etc, writer, tel, view_cnt, to_char(reg_date, 'yyyy-mm-dd hh24:mi') as reg_date ");
         sql.append(" from pet_findplz ");
         sql.append(" order by printno desc ");

         FindPlzVO findPlzvo = null;

         List<FindPlzVO> boardList = new ArrayList<>();

         try (Connection conn = new ConnectionFactory().getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ) {
            
               ResultSet rs = pstmt.executeQuery();
               while (rs.next()) {
                  int no = rs.getInt("no");
                  int printno = rs.getInt("printno");
                  String cate = rs.getString("cate");
                  String race = rs.getString("race");
                  String sex = rs.getString("sex");
                  String age = rs.getString("age");
                  String name = rs.getString("name");
                  String lostDate = rs.getString("lostdate");
                  String lostSpot = rs.getString("lostspot");
                  String feature = rs.getString("feature");
                  String etc = rs.getString("etc");
                  String writer = rs.getString("writer");
                  String tel = rs.getString("tel");
                  int view_cnt = rs.getInt("view_cnt");
                  
                  String reg_date = null;
      
                  Date d = new Date();
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                  String date = sdf.format(d);
      
                  if (rs.getString("reg_date").contains(date))
                     reg_date = rs.getString("reg_date").substring(11);
                  else
                     reg_date = rs.getString("reg_date").substring(0, 10);
      
                  findPlzvo = new FindPlzVO(no, printno, cate, race, sex, age, name, lostDate, lostSpot, feature, etc, writer, tel, view_cnt, reg_date);
                  boardList.add(findPlzvo);
               }
         } catch (Exception e) {
            e.printStackTrace();
         }

         return boardList;

      }
}
