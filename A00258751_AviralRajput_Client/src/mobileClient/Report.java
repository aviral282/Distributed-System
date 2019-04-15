package mobileClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Report {

	public DefaultTableModel showall() throws Exception {

		CloseableHttpResponse response = null;
		try {
			URI uri = new URIBuilder().setScheme("http").setHost("localhost").setPort(8080)
					.setPath("/A00258751_AviralRajput_Server/mobile/mobileService/mob").build();

			System.out.println(uri.toString());

			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Accept", "application/xml");

			CloseableHttpClient httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);

			HttpEntity entity = response.getEntity();
			String text = EntityUtils.toString(entity);
			System.out.println(text);
			DefaultTableModel mobilemodel = new DefaultTableModel();
			mobilemodel
					.setColumnIdentifiers(new Object[] { "ID", "Mobile Name", "Mobile Price", "Mobile Description" });
			List<mobile> MobileList = new parseMobile().mobileParserFunc(text);
			for (mobile mobile : MobileList) {
				mobilemodel.addRow(
						new Object[] { mobile.getId(), mobile.getName(), mobile.getPrice(), mobile.getDescription() });
			}
			return mobilemodel;
		} finally {
			response.close();
		}

	}

	public DefaultTableModel show(int id) throws Exception {

		CloseableHttpResponse response = null;
		try {
			URI uri = new URIBuilder().setScheme("http").setHost("localhost").setPort(8080)
					.setPath("/A00258751_AviralRajput_Server/mobile/mobileService/mob").build();

			System.out.println(uri.toString());

			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Accept", "application/xml");

			CloseableHttpClient httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);

			HttpEntity entity = response.getEntity();
			String text = EntityUtils.toString(entity);
			System.out.println(text);
			DefaultTableModel mobilemodel = new DefaultTableModel();
			mobilemodel
					.setColumnIdentifiers(new Object[] { "ID", "Mobile Name", "Mobile Price", "Mobile Description" });
			List<mobile> MobileList = new parseMobile().mobileParserFunc(text);
			for (mobile mobile : MobileList) {
				if (mobile.getId() == id) {
					mobilemodel.addRow(new Object[] { mobile.getId(), mobile.getName(), mobile.getPrice(),
							mobile.getDescription() });
				}
			}
			return mobilemodel;
		} finally {
			response.close();
		}

	}
}
