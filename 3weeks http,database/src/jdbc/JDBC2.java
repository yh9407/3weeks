package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ���� �ۼ�

		// 1�� ����̹� �ε�
		Class.forName("com.mysql.jdbc.Driver");

		// 2�� ����
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "1234";
		Connection con = DriverManager.getConnection(url, id, pw);

		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO �μ� VALUES(?,?)"); 
		//(?,?) ������ �����ϴ� �� . PlaceHolder -> Ʋ�� ��Ƶΰ�, ������ ���߿� ä��.
		// 3�� �����غ�
		PreparedStatement stmt = con.prepareStatement(query.toString());
		for (int i = 5; i <=10; i++) {		
		stmt.setInt(1, i);
		stmt.setString(2, "�ѹ���"); //�μ� values(?,?)�� ���� ����.
		stmt.executeUpdate(); //insert, update, delete �� ���ؼ� [query.append( );��ȣ�ȿ� ����.] 
		
	}
	
	}
}
