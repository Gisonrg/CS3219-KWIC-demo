package sg.edu.nus.comp.cs3219.event;

public class BaseEvent {
	final String name;
	
	public BaseEvent(String name) {
		this.name = name;
	}
	
	public String getEventName() {
		return name;
	}
}