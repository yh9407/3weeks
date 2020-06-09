package http;

import org.json.JSONArray;
import org.json.JSONObject;

public class Http6 {
	public static void main(String[] args) {
		NetworkUtil nu = new NetworkUtil();
		String url = "http://ggoreb.com/python/json/data3.jsp";
		String result = nu.get(url);

		JSONArray json = new JSONArray(result);
		for (int i = 0; i < json.length(); i++) {
			JSONObject obj = json.getJSONObject(i);
			JSONArray address = obj.getJSONArray("address");
			for (int j = 0; j < address.length(); j++) {				
				String add = address.getString(j);			
				System.out.println(add);
				
			}
//			String add = address.getString(0);
//			System.out.println(add);
		}
	}

}
