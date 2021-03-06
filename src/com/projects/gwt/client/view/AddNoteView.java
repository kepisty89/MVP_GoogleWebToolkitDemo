package com.projects.gwt.client.view;


import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;
import com.projects.gwt.client.presenter.AddNotePresenter.Display;
import com.projects.gwt.shared.model.Note;

public class AddNoteView extends Composite implements Display {

	/**
	 * Fields.
	 **/
	private final Button showAllNotesButton = new Button("Show all notes");
	private final Button saveNoteButton = new Button("Save note");
	private final Label inputLabel = new Label("Please type title:");
	private final TextBox input = new TextBox();
	
	/**
	 * Constructor.
	 **/
	public AddNoteView() {
				 
		VerticalPanel mainPanel = new VerticalPanel();
		initWidget(mainPanel);					
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.add(saveNoteButton);
		horizontalPanel.add(showAllNotesButton);
		
		mainPanel.add(inputLabel);
		mainPanel.add(input);
		mainPanel.add(horizontalPanel);		
		
		mainPanel.add(showAllNotesButton);
	}
	
	/**
	 * Public methods.
	 **/
	@Override
	public HasClickHandlers getShowNotesButton() {
		return this.showAllNotesButton;
	}	
	
	@Override
	public HasClickHandlers getSaveNoteButton() {
		return this.saveNoteButton;
	}
	
	@Override
	public Note getNoteData(){
		
		Note noteToAdd = new Note();
		noteToAdd.setTitle(this.input.getText());
		
		return noteToAdd;
	}
	
	// This is probably not needed (same as super method).
	@Override
	public Widget asWidget() {
		return this;
	}

}
