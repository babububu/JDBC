import java.sql.*; 

public class TestDML2 {
	public static void main(String[] args) {
		
		if(args.length != 3) {
			System.out.println("Parameter Error!Please Input Again!");
			System.exit(-1);
		}
		
		int deptno = 0;
		
		try{
		deptno = Integer.parseInt(args[0]);
		}catch (NumberFormatException e){
			System.out.println("Parameter Error!Deptno should be number format!");
			System.exit(-1);
		}
		
		String dname = args[1];
		String loc = args[2];
		
		Connection conn = null;
		Statement stmt = null;
		//ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?user=root&password=233232");
			stmt = conn.createStatement();
			String sql = "insert into dept values("+deptno+",'"+dname+"','"+loc+"')" ;
			System.out.println(sql);
			
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