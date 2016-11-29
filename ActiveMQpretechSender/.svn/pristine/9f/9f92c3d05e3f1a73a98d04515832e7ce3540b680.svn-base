package com;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MessageProducerExample {
	static Logger log = Logger
			.getLogger(MessageProducerExample.class.getName());

	public static void main(String[] args) {
		PropertyConfigurator.configure("log.properties");

		try {

			// Create a ConnectionFactory
			// "tcp://localhost:61616"
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					"admin", "admin", ActiveMQConnection.DEFAULT_BROKER_URL);

			// Create a Connection

			Connection connection = connectionFactory.createConnection();

			connection.start();

			// Create a Session

			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// Create the destination

			Destination destination = session.createQueue("testMQ");

			// Create a MessageProducer from the Session to the Queue

			MessageProducer producer = session.createProducer(destination);

			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			// Create a messages
			String xml = "<root><name>babak</name><id>123</id></root>";
			TextMessage message = session.createTextMessage("Helloworld babak "
					+ new Date() + " xml mesg is " + xml);

			producer.send(message);
			log.info("\n message send from activemq is " + message);

			session.close();

			connection.close();

			System.out.println("Message sent");

		}

		catch (Exception e) {

			System.out.println(e);

			e.printStackTrace();

		}

	}

}
