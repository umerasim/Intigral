package com.weather.service.utill;

import org.json.JSONObject;

public class AppUtills {

	public static JSONObject getJsonErrorResponse(String code, String error) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", code);
		jsonObject.put("msg", error);
		return jsonObject;

	}
}
