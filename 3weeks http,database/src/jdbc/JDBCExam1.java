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
		/* data.txt���� ������ �б� �ڵ��ۼ� */
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
		/* SQL - insert �ڵ��ۼ� */
		PreparedStatement stmt = con.prepareStatement(query.toString());
		/* data.txt���� �о�� �������� ����ŭ �ݺ� */
		stmt.setString(1, ""/* �ڵ��ۼ� */);
		stmt.setString(2, ""/* �ڵ��ۼ� */);
		stmt.setString(3, ""/* �ڵ��ۼ� */);
		stmt.executeUpdate();
	}
}
