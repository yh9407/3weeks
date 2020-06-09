package http;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InTryCatch {
	public static void main(String[] args) {
		InputStream in = null;// initialize(�ʱ�ȭ �ʿ�)
		try {
			in = new FileInputStream("c:/dev/out.txt");
			while (true) {
				int data = in.read();// add catch clause to surrounding try(�ι�°)
				if (data == -1)
					break;
				System.out.println((char) data);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �������� ���ϰ� ������ �߻��ϴ� ��� ���.
			if (in != null) {
				try {
					in.close();
					// close�� ������ ����Ǿ����.finally��,//
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
