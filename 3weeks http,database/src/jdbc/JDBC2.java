package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 쿼리 작성

		// 1번 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");

		// 2번 연결
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "1234";
		Connection con = DriverManager.getConnection(url, id, pw);

		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO 부서 VALUES(?,?)"); 
		//(?,?) 식으로 진행하는 것 . PlaceHolder -> 틀만 잡아두고, 내용은 나중에 채움.
		// 3번 실행준비
		PreparedStatement stmt = con.prepareStatement(query.toString());
		for (int i = 5; i <=10; i++) {		
		stmt.setInt(1, i);
		stmt.setString(2, "총무부"); //부서 values(?,?)에 들어가는 내용.
		stmt.executeUpdate(); //insert, update, delete 에 대해서 [query.append( );괄호안에 있음.] 
		
	}
	
	}
}
