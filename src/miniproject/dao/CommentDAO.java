package miniproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import miniproject.util.ConnectionFactory;
import miniproject.util.JDBCClose;
import miniproject.vo.CommentVO;

public class CommentDAO {
	public void insertcomment(CommentVO comment) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into pet_comment( no, writer, pet_comment, type, parrent, parrent_no, board_no)");
		sql.append(" values( seq_comment.nextval,?,?,'b',?,?,?) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString());) {

			int loc = 1; // 중간에 수정되었을 경우 setString부를 일일이 바꿔주기 번거로우므로 ++

//      ps.setString(loc++, comment.getNo());
			ps.setString(loc++, comment.getWriter());
			ps.setString(loc++, comment.getPet_comment());
			ps.setInt(loc++, comment.getParrent());
			ps.setInt(loc++, comment.getParrent_no());
			ps.setInt(loc++, comment.getBoard_no());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatecomment(String comment, int no) {

		StringBuilder sql = new StringBuilder();
		sql.append("update pet_comment ");
		sql.append(" set pet_comment = ? ");
		sql.append(" where no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setString(1, comment);
			pstmt.setInt(2, no);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletecomment(int no) {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from pet_comment ");
		sql.append(" where no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString());) {

			ps.setInt(1, no);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<CommentVO> selectAllcomment(int boardno, int par) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<CommentVO> list = new ArrayList<>();
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, writer, pet_comment,type,parrent,parrent_no,board_no,reg_date ");
			sql.append(" from pet_comment ");
			sql.append(" where board_no = ? and parrent = ? ");
			sql.append(" order by no asc ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardno);
			pstmt.setInt(2, par);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String writer = rs.getString("writer");
				String pet_comment = rs.getString("pet_comment");
				String type = rs.getString("type");
				int parrent = rs.getInt("parrent");
				int parrent_no = rs.getInt("parrent_no");
				int board_no = rs.getInt("board_no");
				String reg_date = rs.getString("reg_date");

				CommentVO comment = new CommentVO();
				comment.setNo(no);
				comment.setWriter(writer);
				comment.setPet_comment(pet_comment);
				comment.setType(type);
				comment.setParrent(parrent);
				comment.setParrent_no(parrent_no);
				comment.setBoard_no(board_no);
				comment.setReg_date(reg_date);

				list.add(comment);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return list;
	}
	public int selectparrentlimit() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int no = 0;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no,parrent ");
			sql.append(" from pet_comment ");
			sql.append(" order by parrent desc ");
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				no = rs.getInt("no");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return no;
	}

	public int getParrent(int pno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int no = 0;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select parrent ");
			sql.append(" from pet_comment ");
			sql.append(" where parrent_no = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, pno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				no = rs.getInt("parrent");	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return no;
	}
}