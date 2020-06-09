package http;

import org.json.JSONArray;
import org.json.JSONObject;

public class Http3 {
	public static void main(String[] args) {
		NetworkUtil nu = new NetworkUtil();
		String url1 = "http://api.visitkorea.or.kr";
		String url2 = "/openapi/service/rest/KorService/searchFestival";
		String param = "?serviceKey=A2usf4txsthrBPXx7%2FckSjISrlOOF3DR";
		param += "CXlpwxFKcl1KPyvOOWSD%2FUhcapvCkM51AdZOieoo";
		param += "IvkMdz2XQCt33w%3D%3D";
		param += "&MobileOS=ETC";
		param += "&MobileApp=AppTest";
		param += "&eventStartDate=20191101";
		param += "&_type=json";
		String result = nu.get(url1 + url2 + param);
//		System.out.println(result);
		JSONObject json = new JSONObject(result);
		JSONObject response = json.getJSONObject("response");
		JSONObject body = response.getJSONObject("body");
		JSONObject items = body.getJSONObject("items");
		JSONArray item = items.getJSONArray("item"); //Q.10���� �׸� ��� ����ϱ����ؼ�?���ȣ�� Array
		//�ݺ��� ���
	int count = 0;
		for(int i=0; i < item.length(); i++) {
			count++;
			JSONObject a = item.getJSONObject(i);
			String addr1 = a.getString("addr1");
			//��� ��¥�� ��� ������ ����Ѵٸ�
			String title = a.getString("title");
			int eventstartdate = a.getInt("eventstartdate");
			System.out.println("��糯¥ ====" + eventstartdate);
			System.out.println("��� �� ====" + title);
			System.out.println("�ּ� ====" + addr1);
			System.out.println(count);
		}

	}
}