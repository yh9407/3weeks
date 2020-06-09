package http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class Http4 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		NetworkUtil nu = new NetworkUtil();
		String url = "https://dapi.kakao.com/v2/local/search/address.json";
		String param = "?query=" + URLEncoder.encode("부산 연제구 연산동 1000", "utf-8");
		String appKey = "37633581c3556b341f3e8e0d614e1b6c";
		String result = nu.getKakao(url + param, appKey);
//		System.out.println(result);

		JSONObject json = new JSONObject(result);
		JSONArray documents = json.getJSONArray("documents");
		for (int i = 0; i < documents.length(); i++) {
			JSONObject doc = documents.getJSONObject(i);
			String lat = doc.getString("y");
			String lng = doc.getString("x");
			System.out.printf("%s, %s\n", lat, lng);

		}
	}
}