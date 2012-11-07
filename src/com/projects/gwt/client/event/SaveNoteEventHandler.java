package com.projects.gwt.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface SaveNoteEventHandler extends EventHandler {
	
	void onSaveNote(SaveNoteEvent saveEvent);

}
