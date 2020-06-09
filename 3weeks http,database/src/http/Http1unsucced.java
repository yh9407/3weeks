package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//서버로부터 데이터를 받음.
public class Http1unsucced {
	public static void main(String[] args) {
		URL url = null;
		URLConnection urlConnection = null;
		InputStream in = null;
		try {
			url = new URL("http://ggoreb.com/http/list1.jsp");
			urlConnection = url.openConnection();
			in = urlConnection.getInputStream();
			//try는 하나로몰아놓고, catch는 가독성을 위해 모아둔다.
			
			InputStreamReader isr = new InputStreamReader(in); // 스트림의 변수 in을 생성자에 넣음.
			BufferedReader reader = new BufferedReader(isr); // 다시 위의 리더 변수 isr을 생성자에 넣음.
			while (true) {
				String data = reader.readLine();
				if (data == null)
					break;
				System.out.println(data);
			}
			// 역순으로 클로즈
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
		// 서버로부터 받은 데이터를 문자열로 변환 -> 확인
		// Q1.1.한줄씩 가져오는 기능 도입 //BufferedReader// Stream과 Read를 이어줄 트랜스기능필요.
		// Why 1byte씩 가져오는 Stream은 한글(3byte)은 깨짐.
		// 2.변환해주는 보조 스트림 사용.(InputStream ->Reader)
		// BufferedReader readline();
	}
}
