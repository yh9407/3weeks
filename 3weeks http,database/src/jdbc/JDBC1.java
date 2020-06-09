package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ���� �ۼ�
		StringBuffer query = new StringBuffer();
		query.append("SELECT ID, NAME, GENDER, KIND FROM ANIMAL"); //sql �� Table ���� , 

		// 1�� ����̹� �ε�
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2�� ����
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "1234";
		Connection con = DriverManager.getConnection(url, id, pw);

		// 3�� �����غ�
		PreparedStatement stmt = con.prepareStatement(query.toString());
		
		// 4�� ����
		ResultSet rs = stmt.executeQuery();

		// 5�� ��ȸ ��� ���� for each, iterate
		while (rs.next()) {// �� �྿ ������ ��������.(next)
			int id2 = rs.getInt("ID");
			String name = rs.getString("NAME");
			String gender = rs.getString("GENDER");
			String kind = rs.getString("KIND");
			System.out.printf("%s %s %s %s \n\n", id2, name, gender, kind);
		}
	}
}
