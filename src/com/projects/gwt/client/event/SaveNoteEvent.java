package com.projects.gwt.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class SaveNoteEvent extends GwtEvent<SaveNoteEventHandler>{

	public static Type<SaveNoteEventHandler> TYPE = new Type<SaveNoteEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SaveNoteEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SaveNoteEventHandler handler) {
		handler.onSaveNote(this);		
	}
}