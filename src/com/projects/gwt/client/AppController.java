package com.projects.gwt.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.projects.gwt.client.presenter.Presenter;

/**
 * Application controller class - main presenter class.
 * @author Lukasz Kepinski
 *
 */
public class AppController implements Presenter, ValueChangeHandler<String> {

	private final HandlerManager eventBus;
	private final DbStorageService dbStorage;
	private HasWidgets container;

	private final static String SHOW_NOTES = "showNotes";
	private final static String ADD_NOTE = "addNote";

	public AppController(DbStorageService storage, HandlerManager eventBus) {
		
		this.eventBus = eventBus;
		this.dbStorage = storage;		
		
		this.bind();
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem(ADD_NOTE);
		} else {
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		// TODO Auto-generated method stub
		
	}	
}