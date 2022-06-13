package org.cory.rice.bingetv.services;



import okhttp3.*;

import org.cory.rice.bingetv.BingeTvConfigProperties;
import org.cory.rice.bingetv.models.TvShow;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;


@Service
public class ApiService extends OkHttpClient {
	
	private static BingeTvConfigProperties bingConfig;
	
	static OkHttpClient client = null;
	
	public ApiService(BingeTvConfigProperties bingConfig) {
		this.bingConfig = bingConfig;
	}
	
	public static  String ApiCallById(String showId) throws IOException {
		
		HttpUrl httpByIdUrl = new HttpUrl.Builder()
				.scheme("http")
				.host("api.themoviedb.org")
				.addPathSegment("3")
				.addPathSegment("tv")
				.addPathSegment(showId)
				.addQueryParameter("api_key", bingConfig.apiKey())
				.build();
		
		client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(httpByIdUrl)
				.build();
		
		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static String ApiCallByName(String query) throws IOException {
		
		HttpUrl httpByNameUrl = new HttpUrl.Builder()
				.scheme("http")
				.host("api.themoviedb.org")
				.addPathSegment("3")
				.addPathSegment("search")
				.addPathSegment("tv")
				.addQueryParameter("api_key", bingConfig.apiKey())
				.addQueryParameter("query", query)
				.build();
		
		client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(httpByNameUrl)
				.build();
		
		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
