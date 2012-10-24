package com.projects.gwt.client.view;


import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Widget;
import com.projects.gwt.client.presenter.AddNotePresenter.Display;

public class AddNoteView extends Composite implements Display {

	/**
	 * Fields.
	 **/
	private final Button showAllNotesButton = new Button("Show all notes");
	
	/**
	 * Constructor.
	 **/
	public AddNoteView() {
		
		DockPanel mainDockPanel = new DockPanel();
		initWidget(mainDockPanel);			
		
		mainDockPanel.add(showAllNotesButton);
	}
	
	/**
	 * Public methods.
	 **/
	@Override
	public HasClickHandlers getShowNotesButton() {
		return this.showAllNotesButton;
	}	
	
	// This is probably not needed (same as super method).
	@Override
	public Widget asWidget() {
		return this;
	}

}
