import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class db1 {

	public static void main(String args[]) throws SQLException {
		// // HashMap<Integer,String> hm=new HashMap<Integer,String>();
		System.out.println("enter name");
		List<String> list = new ArrayList<String>();
		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// step 2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "rama");
			// step3 create the statement object
			Statement stmt = con.createStatement();
			// step4 execute querry

			ResultSet rs = stmt.executeQuery("select * from employee");
			//ResultSet rs1 = stmt.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println("enter loop");

				list.add(rs.getString(1));
				// list.add(rs.getString(2));
				// list.add(rs.getString(3));
			}
			
			for(String s:list){
				System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}