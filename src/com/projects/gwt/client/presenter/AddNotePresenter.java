package com.projects.gwt.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.projects.gwt.client.DbStorageService;
import com.projects.gwt.client.event.*;
import com.projects.gwt.shared.model.Note;

/**
 * Presenter class for adding new note.
 * @author Lukasz Kepinski
 *
 */
public class AddNotePresenter implements Presenter {
	
	/**
	 * Fields.
	 **/
	final HandlerManager localEventBus;
	final DbStorageService storage;
	private final Display display;
	
	/**
	 * Constructor.
	 **/
	public AddNotePresenter(HandlerManager eventBus, DbStorageService storageService, Display view){	
		this.localEventBus = eventBus;
		this.storage = storageService;
		this.display = view;
		
		bind();
	}
	
	/**
	 * Presenters display interface.
	 */
	public interface Display {
		HasClickHandlers getShowNotesButton();
		HasClickHandlers getSaveNoteButton();
		Widget asWidget();
		Note getNoteData();		
	}

	/**  
	 * Public methods.
	 */
	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}
	
	/**
	 * Private methods.
	 **/	
	private void bind(){			
		
		// TODO: Replace with ClickHandler factory.
		ClickHandler showNotesClickHandler = new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				localEventBus.fireEvent(new ShowNotesEvent());		
			}			
		};
				
		ClickHandler saveNoteClickHandler = new ClickHandler() {								
			@Override
			public void onClick(ClickEvent event) {				
				// Set data from display input.		
				Note noteToAdd = display.getNoteData();
				
				localEventBus.fireEvent(new SaveNoteEvent(noteToAdd));		
			}			
		};
			
		display.getShowNotesButton().addClickHandler(showNotesClickHandler);
		display.getSaveNoteButton().addClickHandler(saveNoteClickHandler);			
	}
}
