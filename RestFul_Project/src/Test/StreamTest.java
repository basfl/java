package Test;

import java.io.FileNotFoundException;

import javax.ws.rs.core.StreamingOutput;

import com.UtilClass;

public class StreamTest {
	public static void main(String []args) throws FileNotFoundException{
		String location = "C:\\Users\\babak\\Desktop\\a.txt";
	StreamingOutput r = UtilClass.convert(location);
	}

}
