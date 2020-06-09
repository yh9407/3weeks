package jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCExam2 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		FileReader fr = null;
		String line = "";
		String w = null;
		String x = null;
		String y = null;

		try {
			File file = new File("c:/dev/data.txt");
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				String[] words = line.split(", ");

				for (int i = 0; i < words.length; i++) {
					if (i % 3 == 0) {
						String a = words[i];
						w = a;
					} else if (i % 3 == 1) {
						String b = words[i];
						x = b;
					} else {
						String c = words[i];
						y = c;
					}
				}
				
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "1234";
		Connection con = DriverManager.getConnection(url, id, pw);
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO student values(�ּ�,�̸�)");

		/* SQL - insert �ڵ��ۼ� */
		PreparedStatement stmt = con.prepareStatement(query.toString());
		/* data.txt���� �о�� �������� ����ŭ �ݺ� */
		for (int i = 0; i <= 19; i++) {

			stmt.setString(i,"�̸�"+ w);
			stmt.setString(i,"�ּ�"+ x);
			stmt.setString(i,"����" +y);
			stmt.executeUpdate();
		}
	}
}
