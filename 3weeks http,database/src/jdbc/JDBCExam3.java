package jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCExam3 {
	public static void main(String[] args) {

		String line = "";
		String w = null;
		String x = null;
		String y = null;
		File file = new File("c:/dev/data.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
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
				System.out.println(w);
				System.out.println(y);
				System.out.println(x);
			}
			br.close();
//
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/java";
//			String id = "root";
//			String pw = "1234";
//			Connection con;
//			con = DriverManager.getConnection(url, id, pw);
//			StringBuffer query = new StringBuffer();
//
//			query.append("INSERT INTO student values(name,place,job)");
//			PreparedStatement stmt = con.prepareStatement(query.toString());
//			stmt.setString(1, "이름" + w/* 코드작성 */);
//			stmt.setString(2, "주소" + x/* 코드작성 */);
//			stmt.setString(3, "전공" + y/* 코드작성 */);
//			stmt.executeUpdate();

		} catch (IOException e) {
			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		}
		/* SQL - insert 코드작성 */
		/* data.txt에서 읽어온 데이터의 수만큼 반복 */

	}
}