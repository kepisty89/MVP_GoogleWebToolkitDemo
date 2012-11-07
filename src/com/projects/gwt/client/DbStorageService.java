package com.projects.gwt.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.projects.gwt.shared.model.*;

public class DbStorageService {
	
	private static Long counter = new Long(0);
	
	private static List<Note> dataBase = new ArrayList<Note>();	
	
	public DbStorageService(){		
	}
	
	public void addNote(Note note){				
		note.setId(counter++);
		dataBase.add(note);
	}
	
	public void removeNote(Long id){
		dataBase.remove(id);
	}
	
	public List<Note> getAllNotes(){
		return DbStorageService.dataBase;
	}
	
	public void setData() {		
		
		List<String> data = new ArrayList<String>();
		
		data.add("Buy bread");
		data.add("Buy milk");
		data.add("Buy apple");
		data.add("Buy bread");
		data.add("Return T-Shirt");		
		
		
		for (int i = 0; i < 5; i++) {
			Note note = new Note();
			note.setBody("Example note body" + i);
			note.setLastModificationDate(new Date());
			note.setTitle(data.get(i));
						
			addNote(note);		
		}		
	}
}