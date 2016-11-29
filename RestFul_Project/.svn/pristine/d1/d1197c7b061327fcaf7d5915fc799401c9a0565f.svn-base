package Test;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Build {
	Client client;
	ClientResponse clientResponse;
	WebResource webresource;

	public ClientResponse get(String url, String m) {

		try {

			client = Client.create();
			webresource = client.resource(url);
			clientResponse = webresource.accept(m).get(ClientResponse.class);

		} catch (Exception e) {
			System.out.println("\n ERROR " + e.getMessage());
		}
		return clientResponse;

	}

	public ClientResponse post(String url, String m, String input) {
		try {
			client = Client.create();
			webresource = client.resource(url);
			clientResponse = webresource.accept(m).type(m)
					.post(ClientResponse.class, input);
			if (clientResponse.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ clientResponse.getStatus());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return clientResponse;

	}

	public String Relative(String relative) {
		String url="http://localhost:8080/RestFul-Proj/rest/main/";
		String urlR = url + relative;
		return urlR;
	}

}
