package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 쿼리 작성
		StringBuffer query = new StringBuffer();
		query.append("SELECT ID, NAME, GENDER, KIND FROM ANIMAL"); //sql 의 Table 내용 , 

		// 1번 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2번 연결
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "1234";
		Connection con = DriverManager.getConnection(url, id, pw);

		// 3번 실행준비
		PreparedStatement stmt = con.prepareStatement(query.toString());
		
		// 4번 실행
		ResultSet rs = stmt.executeQuery();

		// 5번 조회 결과 추출 for each, iterate
		while (rs.next()) {// 한 행씩 데이터 가져오기.(next)
			int id2 = rs.getInt("ID");
			String name = rs.getString("NAME");
			String gender = rs.getString("GENDER");
			String kind = rs.getString("KIND");
			System.out.printf("%s %s %s %s \n\n", id2, name, gender, kind);
		}
	}
}
