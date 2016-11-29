package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//http://localhost:8080/RestFul-Jersy2/rest2/source/getName/
@Path("/source")
public class MainImpl extends RestApplication {
	@GET
	@Path("/getName")
	public String getName() {
		return "Babak";

	}

}
