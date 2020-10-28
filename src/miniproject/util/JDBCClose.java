package miniproject.util;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCClose {
	
	public static void close(Statement stmt, Connection conn) {  //PrepareStatement�? Statement�? ?��?��받고 ?��?���?�? 묵시?��?���??��
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}		
}

