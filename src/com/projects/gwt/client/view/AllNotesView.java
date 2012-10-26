package com.projects.gwt.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
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
		
		Grid mainGrid = new Grid(4, 4); 			
		
		// Composite method - adds main panel to the whole composition.
		initWidget(mainGrid);						
		
		// Other layout definitions.
		Tree notesTree = new Tree();								
		
		// Tree items.
		TreeItem rootItem = new TreeItem();		
		rootItem.setText("My shopping list");
		rootItem.setTitle("My shopping list");				
		
		for (Note note : dbStorageService.getAllNotes()) {			
			TreeItem subItem = new TreeItem();
			subItem.setText(note.getTitle());			
			rootItem.addItem(subItem);			
		}		
		
		notesTree.addItem(rootItem);
		notesTree.addItem(rootItem);
		
		mainGrid.setWidget(0, 0, notesTree);
		mainGrid.setWidget(0, 1, addNoteButton);		
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
