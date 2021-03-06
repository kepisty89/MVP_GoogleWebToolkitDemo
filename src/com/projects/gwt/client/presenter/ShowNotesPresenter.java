package com.projects.gwt.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.projects.gwt.client.DbStorageService;
import com.projects.gwt.client.event.*;

/**
 * Presenter class for displaying all notes.
 * @author Lukasz Kepinski
 *
 */
public class ShowNotesPresenter implements Presenter {
	
	/**
	 * Fields.
	 **/
	final HandlerManager localEventBus;
	final DbStorageService storage;
	private final Display display;
	
	/**
	 * Constructor
	 **/
	public ShowNotesPresenter(HandlerManager eventBus, DbStorageService storageService, Display view){	
		this.localEventBus = eventBus;
		this.storage = storageService;
		this.display = view;
		
		bind();
	}
	
	/**
	 * Presenters display interface.
	 */
	public interface Display {
		HasClickHandlers getAddNoteButton();
		Widget asWidget();
		HasFocusHandlers getNotesTree();
		String GetFocusedNote();
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
		ClickHandler addNoteClickHandler = new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				localEventBus.fireEvent(new AddNoteEvent());
			}
		};
		
		FocusHandler noteFocusHandler = new FocusHandler() {											
			
			@Override
			public void onFocus(FocusEvent event) {
							
				String title = "NaN";
				
				if(display.GetFocusedNote() != null){	
					title = display.GetFocusedNote();
					localEventBus.fireEvent(new NotePopupEvent(title));
				}				
			}
			
		};
		
		display.getAddNoteButton().addClickHandler(addNoteClickHandler);	
		display.getNotesTree().addFocusHandler(noteFocusHandler);
	}

}
