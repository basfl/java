package com;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class CstartEventHandler implements
		ApplicationListener<ContextStartedEvent> {

	@Override
	public void onApplicationEvent(ContextStartedEvent arg0) {
		System.out.println("\n start event .... ");

	}

}
