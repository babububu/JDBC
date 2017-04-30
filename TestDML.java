import java.sql.*; 

public class TestDML {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		//ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?user=root&password=233232");
			stmt = conn.createStatement();
			String sql = "insert into dept values(77,'F','F')";
			 stmt.executeUpdate(sql);
			
			/*while(rs.next()) {
				System.out.println();
			}*/
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try{
			/*if(rs != null) {
				rs.close();
				rs = null;
			}*/
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
