package com.projects.gwt.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddNoteEvent extends GwtEvent<AddNoteEventHandler>{
		
	public static Type<AddNoteEventHandler> TYPE = new Type<AddNoteEventHandler>();
		
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AddNoteEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AddNoteEventHandler handler) {
		handler.onAddNote(this);
		
	}
	
}