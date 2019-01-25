package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {
	public static Connection getConnection( ) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Libreria?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			 return DriverManager.getConnection(
			        url, "root", "root");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
