package com.projects.gwt.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.projects.gwt.client.DbStorageService;
import com.projects.gwt.client.presenter.ShowNotesPresenter.Display;
import com.projects.gwt.shared.model.Note;

public class AllNotesView extends Composite implements Display {
	
	/**
	 * Fields.
	 **/
	private final Button addNoteButton = new Button("Click here to add item!");	
	private final DbStorageService dbStorageService = new DbStorageService();
	
	/**
	 * Constructor.
	 **/
	public AllNotesView(){
		
		VerticalPanel mainPanel = new VerticalPanel();
		
		// Composite method - adds main panel to the whole composition.
		initWidget(mainPanel);			
		
		// Create a Dock Panel
	    DockPanel dock = new DockPanel();	    
	    dock.setSpacing(5);
	    dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);

		// Other layout definitions.
		Tree notesTree = new Tree();								
		
		// Tree items.
		TreeItem rootTreeItem = new TreeItem();		
		rootTreeItem.setText("My shopping list");
		rootTreeItem.setTitle("My shopping list");	
		
		for (Note note : dbStorageService.getAllNotes()) {			
			TreeItem subItem = new TreeItem();
			subItem.setText(note.getTitle());			
			rootTreeItem.addItem(subItem);			
		}		
		
		notesTree.addItem(rootTreeItem);		
		
		dock.add(notesTree, DockPanel.EAST);
		dock.add(addNoteButton, DockPanel.SOUTH);		
		
		mainPanel.add(dock);					
	}
	
	/**
	 * Public methods.
	 **/
	@Override
	public HasClickHandlers getAddNoteButton() {
		return this.addNoteButton;
	}
	
	// This is probably not needed (same as super method).
	@Override
	public Widget asWidget(){
		return this;
	}
}
