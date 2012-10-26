package com.projects.gwt.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.projects.gwt.client.DbStorageService;

public interface SaveNoteEventHandler extends EventHandler {

	void onSaveNote(SaveNoteEvent saveEvent);
	
}
