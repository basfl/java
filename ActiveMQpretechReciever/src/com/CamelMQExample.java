package com;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class CamelMQExample implements ExceptionListener {

	public static void main(String[] args) {


		try {

			// Create a ConnectionFactory

			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					"admin", "admin", ActiveMQConnection.DEFAULT_BROKER_URL);

			// Create a Connection
			Connection connection = connectionFactory.createConnection();
			connection.start();
			System.out.println("\n ****" + connection.toString());

		//	connection.setExceptionListener(this);
			connection.setExceptionListener(null);
			///////////////
			

			// Create a Session
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// Create the destination (Topic or Queue)
			Destination destination = session.createQueue("testMQ");

			// Create a MessageConsumer from the Session to the Topic or
			// Queue
			MessageConsumer consumer = session.createConsumer(destination);

			// Wait for a message
			Message message = consumer.receive(3000);
			System.out.println("\n ****" + message);

			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String text = textMessage.getText();
				System.out.println("Received: " + text);
			} else {
				System.out.println("Received: " + message);
			}

			consumer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}

		

	}

	@Override
	public void onException(JMSException exception) {
		// TODO Auto-generated method stub
		
	}

}