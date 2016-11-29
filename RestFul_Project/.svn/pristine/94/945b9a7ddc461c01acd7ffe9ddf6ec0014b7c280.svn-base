package Test;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.ClientResponse;

class ClientBuild extends Build {

	String m = MediaType.TEXT_PLAIN;
	ClientResponse clientResponse;
	String url;


	public void verifyGet() {

		
		url = Relative("stream/");
		ClientResponse response = get(url, m);
		String output = response.getEntity(String.class);
		System.out.println("\n the get  result is " + output);
	}

	public void verifyPost() {
		url=Relative("user/");
		String input = "12";
		ClientResponse response = post(url, m, input);
		System.out.println("\n the post result is "
				+ response.getEntity(String.class));

	}
}

public class ClientExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClientBuild a = new ClientBuild();
		 a.verifyGet();
		// a.verifyPost();

	}

}
