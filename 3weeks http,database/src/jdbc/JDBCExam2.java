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
		/* data.txt���� ������ �б� �ڵ��ۼ� */
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
//		/* SQL - insert �ڵ��ۼ� */
//		PreparedStatement stmt = con.prepareStatement(query.toString());
//		/* data.txt���� �о�� �������� ����ŭ �ݺ� */
//		stmt.setString(1, ""/* �ڵ��ۼ� */);
//		stmt.setString(2, ""/* �ڵ��ۼ� */);
//		stmt.setString(3, ""/* �ڵ��ۼ� */);
//		stmt.executeUpdate();
	}
}
