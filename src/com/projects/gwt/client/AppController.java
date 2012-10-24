package com.projects.gwt.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.projects.gwt.client.event.AddNoteEvent;
import com.projects.gwt.client.event.AddNoteEventHandler;
import com.projects.gwt.client.event.ShowNotesEvent;
import com.projects.gwt.client.event.ShowNotesEventHandler;
import com.projects.gwt.client.presenter.AddNotePresenter;
import com.projects.gwt.client.presenter.Presenter;
import com.projects.gwt.client.presenter.ShowNotesPresenter;
import com.projects.gwt.client.view.AddNoteView;
import com.projects.gwt.client.view.AllNotesView;

/**
 * Application controller class - main presenter class.
 * @author Lukasz Kepinski
 *
 */
public class AppController implements Presenter, ValueChangeHandler<String> {

	/**
	 * Fields.
	 **/
	private final HandlerManager eventBus;
	private final DbStorageService dbStorage;
	private HasWidgets container;

	private final static String SHOW_NOTES = "showNotes";
	private final static String ADD_NOTE = "addNote";

	/**
	 * Constructor.
	 **/
	public AppController(DbStorageService storage, HandlerManager eventBus) {
		
		this.eventBus = eventBus;
		this.dbStorage = storage;		
		
		this.bind();
	}

	/**
	 * Public methods.
	 **/
	@Override
	public void go(HasWidgets container) {
		
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem(SHOW_NOTES);
		} else {
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {

		// Get current token identifying view.
		String token = event.getValue();
		
		if(token != null){
			
			Presenter presenter = null;
			
			if (token.equals(SHOW_NOTES)) 
			{			
				presenter = new ShowNotesPresenter(eventBus, dbStorage, new AllNotesView());			
			} 
			else if (token.equals(ADD_NOTE))
			{
				presenter = new AddNotePresenter(eventBus, dbStorage, new AddNoteView());
			}
			
			if(presenter != null) {
				presenter.go(container);
			}
		}		
	}
			
	/**
	 * Private methods.
	 **/
	// Create and bind event handlers to the event bus.
	private void bind() {
		
		History.addValueChangeHandler(this);
		
		eventBus.addHandler(AddNoteEvent.TYPE, new AddNoteEventHandler() {
			
			@Override
			public void onAddNote(AddNoteEvent addEvent) {
				doAddNote();				
			}
		});
		
		eventBus.addHandler(ShowNotesEvent.TYPE, new ShowNotesEventHandler() {
			
			@Override
			public void onShowNotes(ShowNotesEvent showEvent) {
				doShowNotes();				
			}
		});					
	}
	
	// Adding items to history. 
	
	private void doAddNote(){
		History.newItem(ADD_NOTE);
	}
	
	private void doShowNotes(){
		History.newItem(SHOW_NOTES);
	}
	
	
}