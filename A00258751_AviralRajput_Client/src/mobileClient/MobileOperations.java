package mobileClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class MobileOperations {

	public void insermobile(int id, String name, int price, String description)
			throws URISyntaxException, ClientProtocolException, IOException {
		CloseableHttpResponse response = null;
		URI uri = new URIBuilder().setScheme("http").setHost("localhost").setPort(8080)
				.setPath("/A00258751_AviralRajput_Server/mobile/mobileService/mob").build();

		HttpPost httpPost = new HttpPost(uri);
		httpPost.setHeader("Accept", "text/html");
		CloseableHttpClient client = HttpClients.createDefault();

		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("id", String.valueOf(id)));
		nameValuePairs.add(new BasicNameValuePair("name", name));
		nameValuePairs.add(new BasicNameValuePair("price", String.valueOf(price)));
		nameValuePairs.add(new BasicNameValuePair("description", description));
		httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		response = client.execute(httpPost);
		System.out.println(response.toString());

	}

	public void updatemobile(int id, String name, int price, String description)
			throws URISyntaxException, ClientProtocolException, IOException {
		CloseableHttpResponse response = null;
		URI uri = new URIBuilder().setScheme("http").setHost("localhost").setPort(8080)
				.setPath("/A00258751_AviralRajput_Server/mobile/mobileService/mob").build();

		HttpPut httpPut = new HttpPut(uri);
		httpPut.setHeader("Accept", "text/html");
		CloseableHttpClient client = HttpClients.createDefault();

		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("id", String.valueOf(id)));
		nameValuePairs.add(new BasicNameValuePair("name", name));
		nameValuePairs.add(new BasicNameValuePair("price", String.valueOf(price)));
		nameValuePairs.add(new BasicNameValuePair("description", description));
		httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		response = client.execute(httpPut);
		System.out.println(response.toString());

	}

	public void deletemobile(int id) throws ClientProtocolException, IOException {
		final HttpDelete httpdelete = new HttpDelete(
				"http://localhost:8080/A00258751_AviralRajput_Server/mobile/mobileService/mob/" + id);
		HttpResponse response = null;
		try {
			CloseableHttpClient HttpClient = HttpClients.createDefault();
			response = HttpClient.execute(httpdelete);
			System.out.println(response.toString());
			System.out.println("Deleted sucessfully");
		} finally {
			if (response != null) {
				response.getEntity().getContent().close();
			}
		}
	}
}
