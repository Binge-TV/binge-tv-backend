package org.cory.rice.bingetv.services;


import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class ApiService extends OkHttpClient {

	@Value("${binge.api-key}")
	private static String apiKey;

	static OkHttpClient client = null;
	
	public static String ApiCallById(String showId) throws IOException {
		//builds the url needed to make external api call
		HttpUrl httpByIdUrl = new HttpUrl.Builder()
				.scheme("http")
				.host("api.themoviedb.org")
				.addPathSegment("3")
				.addPathSegment("tv")
				.addPathSegment(showId)
				.addQueryParameter("api_key", apiKey)
				.build();

		return executeRequest(httpByIdUrl);
	}

	public static String ApiCallByName(String query) throws IOException {
		//builds the url needed to make external api call
		HttpUrl httpByNameUrl = new HttpUrl.Builder()
				.scheme("http")
				.host("api.themoviedb.org")
				.addPathSegment("3")
				.addPathSegment("search")
				.addPathSegment("tv")
				.addQueryParameter("api_key", apiKey)
				.addQueryParameter("query", query)
				.build();

		return executeRequest(httpByNameUrl);
	}

	@Nullable
	private static String executeRequest(HttpUrl httpByIdUrl) {
		client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(httpByIdUrl)
				.build();//makes client with defined url to make external api call

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();//makes call and returns json string
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
