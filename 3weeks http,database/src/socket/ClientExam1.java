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
		System.out.println("���� ����");
		// �ڵ��ۼ��� s.get~~();����, ���� out �׸��� �´� ���� �տ� �ٿ���.
		OutputStream out = s.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter writer = new BufferedWriter(osw);

		InputStream in = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader reader = new BufferedReader(isr);

		ListenThread lt = new ListenThread(reader); //������� 
		new Thread(lt).start();
		//new Thread(new ListenThread(reader)).start();
		//�ѹ����� ����.

		Scanner scan = new Scanner(System.in);
		while (true) {
			writer.write(scan.next() + "\n"); // writer�� reader���ٸ���.
			// \n ���Ͱ��� �������. ���⼱ next,���Ͱ��� �����ؼ� �Է�.
			writer.flush();
		}
	}
}
