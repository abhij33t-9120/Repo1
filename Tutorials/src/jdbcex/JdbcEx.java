package jdbcex;
import java.sql.*;

public class JdbcEx {
	public static void main(String[] args) {
		Connection conn;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "12345");
//			System.out.println("Connection established");
			
//			1st way
			Statement st = conn.createStatement();
			
//			st.execute("insert into employee values(200,'kayu',35000)");
//			2nd way
//			PreparedStatement ps = conn.prepareStatement("insert into employee values(200,'kayu',35000)");
//			here we are setting values later
//			PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?)"); //pre-compiled statement
//			ps.setInt(1, 300);
//			ps.setString(2, "pooja");
//			ps.setInt(3, 3000);
//			ps.execute();
//			
			ResultSet rs = st.executeQuery("select * from employee");
		
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
			}
			
			
			st.close();
//			ps.close();
			rs.close();
			conn.close();
		}
		catch(SQLException | ClassNotFoundException ex) {
			System.out.println(ex);
		}
		
	}
}
