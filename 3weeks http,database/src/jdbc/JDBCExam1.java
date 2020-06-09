package jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCExam1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		/* data.txt에서 데이터 읽기 코드작성 */
		try {
			Reader reader = new FileReader("c:/dev/data.txt");

			int a = 0;
			while (true) {
				a = reader.read();
				if (a == -1)
					break;
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "1234";
		Connection con = DriverManager.getConnection(url, id, pw);
		StringBuffer query = new StringBuffer();
		/* SQL - insert 코드작성 */
		PreparedStatement stmt = con.prepareStatement(query.toString());
		/* data.txt에서 읽어온 데이터의 수만큼 반복 */
		stmt.setString(1, ""/* 코드작성 */);
		stmt.setString(2, ""/* 코드작성 */);
		stmt.setString(3, ""/* 코드작성 */);
		stmt.executeUpdate();
	}
}
