package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

public class UtilClass {
	public static StreamingOutput convert(String pathAccess)
			throws FileNotFoundException {
		File file = new File(pathAccess);
		@SuppressWarnings("resource")
		final FileInputStream fStream = new FileInputStream(file);
		file.length();
		System.out.println("\n file size is " + file.length());
		StreamingOutput streamingOutput = new StreamingOutput() {

			@Override
			public void write(OutputStream out) throws IOException,
					WebApplicationException {
				int n;
				byte[] buffer = new byte[1024];
				while ((n = fStream.read(buffer)) > -1) {
					out.write(buffer, 0, n);
					System.out.println("ok");
				}
				out.close();

			}
		};
		return streamingOutput;
	}

	public static String fileSize(String pathAccess) {
		File file = new File(pathAccess);
		long length = file.length();
		String size = Long.toString(length);

		return size;

	}

}


