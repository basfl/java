package Test;

import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;

public class getTest extends Build {
	String url;
	String m = MediaType.TEXT_PLAIN;
	ClientResponse response;
	String expString;
	String acString;

	@Before
	public void getResult() {

		url = Relative("resource/");
		response = get(url, m);
		acString = response.getEntity(String.class);
	}

	@Test
	public void verify() {
		Assert.assertEquals(acString, expString);
	}

	public getTest() {
		this.expString = "<student><name></name><last></last></student>";
	}
}
