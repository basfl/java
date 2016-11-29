package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Response;
import javax.xml.ws.Service;

import schema.User;
import xml.XMLUtil;
import BackendGen.Backend;
import BackendGen.BackendService;
import BackendGen.UserEntity;

@Path("/main")
public class Proj {
	private static Backend getBackend() {
		Backend b = null;
		try {

			URL url = new URL("http://localhost:8081/WebService_proj/?wsdl");
			QName qname = new QName("http://com/", "BackendService");
			Service backend2 = BackendService.create(url, qname);
			b = backend2.getPort(Backend.class);
			// b.userInfo(1);
			System.out.println("it s  ok !! and WSDL location is"
					+ backend2.getWSDLDocumentLocation());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;

	}

	@POST
	@Path("/user")
	// @WebServiceRef(wsdlLocation =
	// "hhttp://localhost:8081/WebService_proj/?wsdl")
	public String userInfo1(String id) throws MalformedURLException,
			SOAPException, JAXBException {

		User userS = new User();
		List<UserEntity> userInfo = getBackend().userInfo(1);
		String name = null;
		String address = null;
		String dob = null;
		userS.setAddress(address);
		for (UserEntity e : userInfo) {
			name = e.getName();
			address = e.getAddress();
			dob = "" + e.getDob();
			userS.setDob(e.getDob());
			userS.setName(name);
			System.out.println("\n the address is " + e.getAddress());
			System.out.println("\n the dob is " + e.getDob());
			System.out.println("\n the name is " + e.getName());
		}

		String s = "<user><name>" + name + "<name><date>" + dob
				+ "</date><address>" + address + "</address></user>";

		System.out.println("\n the result would be " + XMLUtil.getXML(userS));
		return s;

	}

	@GET
	@Path("/resource")
	public String sayxml() {
		return "<student><name></name><last></last></student>";

	}

	@GET
	@Path("/stream")
	public javax.ws.rs.core.Response stream() throws FileNotFoundException {
		String location = "C:\\Users\\babak\\Desktop\\a.txt";
		StreamingOutput streamingOutput = UtilClass.convert(location);
		// ResponseBuilder response = null;
		// = Response.ok(streamingOutput);
		File f1=new File(location);
		ResponseBuilder response = javax.ws.rs.core.Response
				.ok(streamingOutput);
		javax.ws.rs.core.Response.ok(f1);
		return response.build();

	}

}
