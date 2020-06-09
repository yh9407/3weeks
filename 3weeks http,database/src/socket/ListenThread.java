package socket;

import java.io.BufferedReader;
import java.io.IOException;

public class ListenThread implements Runnable {
	BufferedReader reader; // �������� reader.

	// �� Ŭ������ �����ִ���(���⼱ reder���)�� �Ѱܹ���.�����ڷ� �ްų�,�޼ҵ�� �ްų�.
	public ListenThread(BufferedReader reader) {
		// �����ڰ� �߰�ȣ�ȿ�����. ���� �ۿ� reader�� �����Ƿ� toss�ؾ���.
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
			// ������ InputStream�� ������� �ѱ�
		}
	}
}
