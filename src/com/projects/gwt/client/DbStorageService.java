package com.projects.gwt.client;

import java.util.ArrayList;
import java.util.List;

import com.projects.gwt.shared.model.*;

public class DbStorageService {
	
	private static Long counter = new Long(0);
	
	private List<Note> dataBase = new ArrayList<Note>();
	
	public void addNote(Note note){				
		note.setId(counter++);
		dataBase.add(note);
	}
	
	public void removeNote(Long id){
		dataBase.remove(id);
	}
	
	public List<Note> getAllNotes(){		
		return this.dataBase;	
	}
}
