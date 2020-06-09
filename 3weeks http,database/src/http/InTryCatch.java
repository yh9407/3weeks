package http;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InTryCatch {
	public static void main(String[] args) {
		InputStream in = null;// initialize(초기화 필요)
		try {
			in = new FileInputStream("c:/dev/out.txt");
			while (true) {
				int data = in.read();// add catch clause to surrounding try(두번째)
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
			// 생성하지 못하고 오류가 발생하는 경우 대비.
			if (in != null) {
				try {
					in.close();
					// close는 무조건 실행되어야함.finally로,//
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
