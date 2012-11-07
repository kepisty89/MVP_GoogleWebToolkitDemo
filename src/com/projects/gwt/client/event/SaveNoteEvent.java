package com.projects.gwt.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.projects.gwt.client.DbStorageService;
import com.projects.gwt.shared.model.Note;

public class SaveNoteEvent extends GwtEvent<SaveNoteEventHandler>{
		
	public static Type<SaveNoteEventHandler> TYPE = new Type<SaveNoteEventHandler>();			
	private DbStorageService dbStorageService = new DbStorageService();
	
	public SaveNoteEvent(Note note) {		
		dbStorageService.addNote(note);
	}
		
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SaveNoteEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SaveNoteEventHandler handler) {
		handler.onSaveNote(this);		
	}
	
}