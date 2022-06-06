package event;

import javafx.event.Event;
import javafx.event.EventType;

@SuppressWarnings("serial")
public class NewRedValue extends Event{

	private int valueR;
	
	public final static EventType<NewRedValue> NEW_RED_VALUE = new EventType<>("NEW_RED_VALUE");
	public NewRedValue(Object source, int newValueR) {
		super(NEW_RED_VALUE);
		this.valueR = newValueR;
	}
	public int getValueR() {
		return valueR;
	}
}
