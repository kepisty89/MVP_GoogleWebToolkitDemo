package com.projects.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class Project1GWT implements EntryPoint {

	/**
	 * Public methods.
	 **/
	public void onModuleLoad() {
				
		// Main MVP event bus.
		HandlerManager eventBus = new HandlerManager(null);
		
		// Fake database. 
		DbStorageService storage = new DbStorageService();
		
		// Other dependencies, services goes here.
	    AppController appController = new AppController(storage, eventBus);
	    	   
	    appController.go(RootPanel.get());
	}
	
}
