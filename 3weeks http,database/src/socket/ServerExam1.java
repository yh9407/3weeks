package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExam1 {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
		try {
			ss = new ServerSocket(8282);
			System.out.println("클라이언트 접속 대기중");
			s = ss.accept(); // 접속 대기
			System.out.println("클라이언트 접속");

			// 클라이언드(Out)의 반대로 작성.
			// 실행 순서 서버on , 다음 클라이언트.
			in = s.getInputStream();
			isr = new InputStreamReader(in);
			reader = new BufferedReader(isr);

			// reader의 주소를 ListenThread로 넘겨줌.
			ListenThread lt = new ListenThread(reader);
			new Thread(lt).start(); // ???????????????

			OutputStream out = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out);
			BufferedWriter writer = new BufferedWriter(osw);

			Scanner scan = new Scanner(System.in);
			while (true) {
				writer.write(scan.next() + "\n");
				writer.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
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
	}
}
