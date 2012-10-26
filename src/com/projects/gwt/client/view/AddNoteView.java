package com.projects.gwt.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;
import com.projects.gwt.client.presenter.AddNotePresenter.Display;

public class AddNoteView extends Composite implements Display {

	/**
	 * Fields.
	 **/
	private final Button showAllNotesButton = new Button("Show all notes");
	private final Button saveNoteButton = new Button("Save");
	private final Label inputLabel = new Label("Please type title:");
	private final TextBox input = new TextBox();
	
	/**
	 * Constructor.
	 **/
	public AddNoteView() {
		
		FlexTable mainTable = new FlexTable();
		mainTable.getFlexCellFormatter().setColSpan(1, 0, 3);		
		initWidget(mainTable);					
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.add(saveNoteButton);
		horizontalPanel.add(showAllNotesButton);		
		
		mainTable.setWidget(0, 0, inputLabel);
		mainTable.setWidget(0, 1, input);
				
		mainTable.setWidget(1, 0, horizontalPanel);				
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
		return this.showAllNotesButton;
	}	
	
	// This is probably not needed (same as super method).
	@Override
	public Widget asWidget() {
		return this;
	}

}
