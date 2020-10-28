package miniproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import miniproject.util.ConnectionFactory;
import miniproject.vo.UserVO;

public class UserDAO {

	public void insertUser(UserVO user) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into pet_user(id, password, name, email_id, email_domain, basic_addr, detail_addr) ");
		sql.append(" values( ?, ?, ?, ?, ?, ?, ? ) ");

		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
		) {
			
			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getEmail_id());
			ps.setString(5, user.getEmail_domain());
			ps.setString(6, user.getBasic_addr());
			ps.setString(7, user.getDetail_addr());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	public UserVO login(UserVO userVO) {
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");						//********���� �ٲ� 11�� 21�� ���� 7�� 23��***********
			sql.append(" from pet_user ");										
			sql.append(" where id = ? and password = ? ");
			UserVO user = null;
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql.toString());	
					) {
				
				ps.setString(1, userVO.getId());
				ps.setString(2, userVO.getPassword());
				
				ResultSet rs = ps.executeQuery();
				userVO = null;
				if(rs.next()) {
					user = new UserVO();
					user.setId(rs.getString("id"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setEmail_id(rs.getString("email_id"));							//********���� �ٲ� 11�� 21�� ���� 7�� 23��***********
					user.setEmail_domain(rs.getString("email_domain"));					//********���� �ٲ� 11�� 21�� ���� 7�� 23��***********
					user.setBasic_addr(rs.getString("basic_addr"));						//********���� �ٲ� 11�� 21�� ���� 7�� 23��***********
					user.setDetail_addr(rs.getString("detail_addr"));					//********���� �ٲ� 11�� 21�� ���� 7�� 23��***********
					user.setType(rs.getString("type"));
					System.out.println("dao������ userVO" + user);			}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return user;
		}
	
	 /**
	    * ���������� ���� ���
	    */
	  /* public void updateMypage(UserVO userVO) {
			
			StringBuilder sql = new StringBuilder();
			sql.append("update pet_user ");
			sql.append(" set name = ?, password = ?, email_id = ?, email_domain = ?, basic_addr = ?, detail_addr = ? " );
			sql.append(" where id = ? ");
			
			try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
				
				pstmt.setString(1, userVO.getName());
				pstmt.setString(2, userVO.getPassword());
				pstmt.setString(3, userVO.getEmail_id());
				pstmt.setString(4, userVO.getEmail_domain());
				pstmt.setString(5, userVO.getBasic_addr());
				pstmt.setString(6, userVO.getDetail_addr());
				pstmt.setString(7, userVO.getId());
				
				pstmt.executeUpdate();
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	   */
	   /**
	    * ���̵� �ߺ�üũ
	    * @param id
	    * @return
	    */
	   public int checkId(String id) {
	      
	      int result = 0; 
	      System.out.println("���̵� �ߺ�üũ �޼ҵ�");
	      StringBuilder sql = new StringBuilder(); 
	      sql.append("select * from pet_user where id = ? ");
	      
	      try(
	         Connection conn = new ConnectionFactory().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	      ){
	         pstmt.setString(1, id);
	         System.out.println(id);
	         ResultSet rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	        	 result = 1;
	         }
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      return result;  
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   public void updateMypage(UserVO userVO) {
			
			StringBuilder sql = new StringBuilder();
			sql.append("update pet_user ");
			sql.append(" set name = ?, password = ?, email_id = ?, email_domain = ?, basic_addr = ?, detail_addr = ? " );
			sql.append(" where id = ? ");
			
			try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
				
				pstmt.setString(1, userVO.getName());
				pstmt.setString(2, userVO.getPassword());
				pstmt.setString(3, userVO.getEmail_id());
				pstmt.setString(4, userVO.getEmail_domain());
				pstmt.setString(5, userVO.getBasic_addr());
				pstmt.setString(6, userVO.getDetail_addr());
				pstmt.setString(7, userVO.getId());
				
				pstmt.executeUpdate();
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	   
	   /**
	    * Ż��
	    */
	   
	   public void leaveUser(String id) {
			
				StringBuilder sql = new StringBuilder();
				sql.append("delete from pet_user ");
				sql.append(" where id = ? ");
				
				try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					) {
					
					pstmt.setString(1, id);
					
					pstmt.executeUpdate();
					
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
}
