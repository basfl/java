package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/source")
public class MainImpl {
	@GET
	@Path("/getName")
	public String getName() {
		return "Babak";

	}

}