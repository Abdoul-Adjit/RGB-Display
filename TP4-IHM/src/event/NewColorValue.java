package event;

import javafx.event.Event;
import javafx.event.EventType;

@SuppressWarnings("serial")
public class NewColorValue extends Event {

	private int valueR;
	private int valueG;
	private int valueB;
	
	public static final EventType<NewColorValue> NEW_COLOR_VALUE = new EventType<>("NEW_COLOR_VALUE");
	
	public NewColorValue(Object source, int newValueR, int newValueG, int newValueB) {
		super(NEW_COLOR_VALUE);
		this.valueR = newValueR;
		this.valueG = newValueG;
		this.valueB = newValueB;
	}

	public int getValueR() {
		return valueR;
	}

	public int getValueG() {
		return valueG;
	}

	public int getValueB() {
		return valueB;
	}
	
	public String getHexa() {
		String valueHexa = String.format("%02x%02x%02x", valueR, valueG, valueB);
		return valueHexa;
	}
}
