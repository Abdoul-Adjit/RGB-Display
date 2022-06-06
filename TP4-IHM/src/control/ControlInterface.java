package control;

import event.ColorObservateur;

public interface ControlInterface {
	public void addObservateur(ColorObservateur colorObservateur);
	public void deleteObservateur(ColorObservateur colorObservateur);
	public void valueRedChanged(int valueR);
	public void valueGreenChanged(int valueG);
	public void valueBlueChanged(int valueB);
	public void colorChanged(int valueR, int valueG, int valueB);
}
