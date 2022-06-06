package event;

import javafx.event.Event;
import javafx.event.EventType;

@SuppressWarnings("serial")
public class NewGreenValue extends Event{

	private int valueG;
	
	public final static EventType<NewGreenValue> NEW_GREEN_VALUE = new EventType<>("NEW_GREEN_VALUE");
	public NewGreenValue(Object source, int newValueG) {
		super(NEW_GREEN_VALUE);
		this.valueG = newValueG;
	}
	public int getValueB() {
		return valueG;
	}
}