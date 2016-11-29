package xml;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

public class XMLUtil {
	public static <T> String getXML(T jaxb) throws JAXBException {
		if (jaxb == null) {
			return null;
		}
		if (jaxb instanceof String) {
			return (String) jaxb;
		}
		try {
			XmlRootElement annotation = jaxb.getClass().getAnnotation(
					XmlRootElement.class);
			if (annotation == null) {
				return jaxb.toString();
			}
			StringWriter sw = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(jaxb.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			String name = annotation.name();
			QName qname = new QName("", name);

			@SuppressWarnings("unchecked")
			JAXBElement<T> element = new JAXBElement(qname, jaxb.getClass(),
					jaxb);
			marshaller.marshal(element, sw);
			return sw.toString();

		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;

		}

	}

}