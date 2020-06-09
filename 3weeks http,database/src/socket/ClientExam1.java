package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientExam1 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.0.38", 8282);
		System.out.println("서버 접속");
		// 코드작성시 s.get~~();쓰고, 변수 out 그리고 맞는 변수 앞에 붙여줌.
		OutputStream out = s.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter writer = new BufferedWriter(osw);

		InputStream in = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader reader = new BufferedReader(isr);

		ListenThread lt = new ListenThread(reader); //쓰레드로 
		new Thread(lt).start();
		//new Thread(new ListenThread(reader)).start();
		//한번에도 가능.

		Scanner scan = new Scanner(System.in);
		while (true) {
			writer.write(scan.next() + "\n"); // writer가 reader보다먼저.
			// \n 엔터값은 리드라인. 여기선 next,엔터값도 포함해서 입력.
			writer.flush();
		}
	}
}
