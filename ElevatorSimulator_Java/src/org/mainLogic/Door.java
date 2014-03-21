package org.mainLogic;

public abstract class Door {
	
	// status of the door either open or closed
	// thus here open = true or false
	boolean isOpen;
	
	// an elevator door or floor door or any other kind
	String type;

	// constructor, by default a new door is closed
	public Door(String doorType){
		type = doorType;
		isOpen = false;
	}
	
	public void open(){
		isOpen = true;
//		return type + " opened.";
		System.out.println(type + " opened.");
	}
	
	public void close(){
		isOpen = false;
//		return type + " closed.";
		System.out.println(type + " closed.");
	}
}
