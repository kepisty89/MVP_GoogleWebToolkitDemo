package com.projects.gwt.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowNotesEvent extends GwtEvent<ShowNotesEventHandler> {

	public static Type<ShowNotesEventHandler> TYPE = new Type<ShowNotesEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ShowNotesEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ShowNotesEventHandler handler) {
		handler.onShowNotes(this);
	}
}
