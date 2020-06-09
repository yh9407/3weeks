package jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JDBCExam2 {
	public static void main(String[] args) {
		/* data.txt에서 데이터 읽기 코드작성 */
		// Reader reader = new FileReader("data.txt")
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			in = new FileInputStream("c:/dev/data.txt");
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String data = "";
			List<String> list = new ArrayList<String>();
			List<List<String>> list1 = new ArrayList<List<String>>();
			
			
			while ((data = br.readLine()) != null) {

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

//		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/java";
//		String id = "root";
//		String pw = "1234";
//		Connection con = DriverManager.getConnection(url, id, pw);
//		StringBuffer query = new StringBuffer();
//		/* SQL - insert 코드작성 */
//		PreparedStatement stmt = con.prepareStatement(query.toString());
//		/* data.txt에서 읽어온 데이터의 수만큼 반복 */
//		stmt.setString(1, ""/* 코드작성 */);
//		stmt.setString(2, ""/* 코드작성 */);
//		stmt.setString(3, ""/* 코드작성 */);
//		stmt.executeUpdate();
	}
}
