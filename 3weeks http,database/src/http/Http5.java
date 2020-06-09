package http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

import jdk.nashorn.internal.scripts.JS;

public class Http5 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		NetworkUtil nu = new NetworkUtil();
		String url = "https://openapi.naver.com/v1/papago/n2mt";
		String param = "source=ko&target=fr&text=";
		param += URLEncoder.encode("안녕하세요. 저는 자바 개발자입니다.", "utf-8");
		String clientId = "OpcnSsAIn37qIu6Iyad6";
		String clientSecret = "p7qtbsYx8N";
		String result = nu.postNaver(url, param, clientId, clientSecret);
		
		JSONObject json = new JSONObject(result);
		JSONObject message = json.getJSONObject("message");
		JSONObject result2 = message.getJSONObject("result");
		String translatedText = result2.getString("translatedText");
		System.out.println(translatedText);
		
	}
}