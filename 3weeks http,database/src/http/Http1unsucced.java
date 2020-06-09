package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//�����κ��� �����͸� ����.
public class Http1unsucced {
	public static void main(String[] args) {
		URL url = null;
		URLConnection urlConnection = null;
		InputStream in = null;
		try {
			url = new URL("http://ggoreb.com/http/list1.jsp");
			urlConnection = url.openConnection();
			in = urlConnection.getInputStream();
			//try�� �ϳ��θ��Ƴ���, catch�� �������� ���� ��Ƶд�.
			
			InputStreamReader isr = new InputStreamReader(in); // ��Ʈ���� ���� in�� �����ڿ� ����.
			BufferedReader reader = new BufferedReader(isr); // �ٽ� ���� ���� ���� isr�� �����ڿ� ����.
			while (true) {
				String data = reader.readLine();
				if (data == null)
					break;
				System.out.println(data);
			}
			// �������� Ŭ����
			reader.close();
			isr.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// �����κ��� ���� �����͸� ���ڿ��� ��ȯ -> Ȯ��
		// Q1.1.���پ� �������� ��� ���� //BufferedReader// Stream�� Read�� �̾��� Ʈ��������ʿ�.
		// Why 1byte�� �������� Stream�� �ѱ�(3byte)�� ����.
		// 2.��ȯ���ִ� ���� ��Ʈ�� ���.(InputStream ->Reader)
		// BufferedReader readline();
	}
}
