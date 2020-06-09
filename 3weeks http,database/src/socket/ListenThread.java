package socket;

import java.io.BufferedReader;
import java.io.IOException;

public class ListenThread implements Runnable {
	BufferedReader reader; // 전역변수 reader.

	// 한 클래스가 쓰고있던것(여기선 reder기능)을 넘겨받음.생성자로 받거나,메소드로 받거나.
	public ListenThread(BufferedReader reader) {
		// 생성자가 중괄호안에있음. 범위 밖에 reader가 있으므로 toss해야함.
		this.reader = reader;
	}

	@Override
	public void run() {
		while (true) {
			String data;
			try {
				data = reader.readLine();
				System.out.println(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 서버의 InputStream을 스레드로 넘김
		}
	}
}
