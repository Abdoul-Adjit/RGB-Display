package event;

import javafx.event.Event;
import javafx.event.EventType;

@SuppressWarnings("serial")
public class NewBlueValue extends Event{

	private int valueB;
	
	public final static EventType<NewBlueValue> NEW_BLUE_VALUE = new EventType<>("NEW_BLUE_VALUE");
	public NewBlueValue(Object source, int newValueB) {
		super(NEW_BLUE_VALUE);
		this.valueB = newValueB;
	}
	public int getValueB() {
		return valueB;
	}
}