package com.projects.gwt.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.projects.gwt.client.presenter.ShowNotesPresenter.Display;

public class AllNotesView extends Composite implements Display {
	
	/**
	 * Fields.
	 **/
	private final Button addNoteButton = new Button("Add note!"); 
	
	/**
	 * Constructor.
	 **/
	public AllNotesView(){
		
		VerticalPanel mainPanel = new VerticalPanel();
		
		// Composite method - adds main panel to the whole composition.
		initWidget(mainPanel);
		
		// Other layout definitions.
		mainPanel.add(addNoteButton);		
	}
	
	/**
	 * Public methods.
	 **/
	@Override
	public HasClickHandlers getAddNoteButton() {
		return this.addNoteButton;
	}
	
	@Override
	public void setData(List<String> data) {		
		
	}
	
	// This is probably not needed (same as super method).
	@Override
	public Widget asWidget(){
		return this;
	}
}
