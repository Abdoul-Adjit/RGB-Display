package model;

import java.util.ArrayList;
import java.util.List;
import event.ColorObservateur;
import event.NewColorValue;

public class Model {    //implements ModelInterface
	
	private int Rvalue = 0;
	private int Gvalue = 0;
	private int Bvalue = 0;
	
	private List<ColorObservateur> colorObservateurs = new ArrayList<ColorObservateur>();
	

	public int getRvalue() {
		return Rvalue;
	}


	public void setRValue(int Rvalue) {
		this.Rvalue = Rvalue;
		notifyObservateur();
	}


	public int getGvalue() {
		return Gvalue;
	}


	public void setGValue(int Gvalue) {
		this.Gvalue = Gvalue;
		notifyObservateur();
	}


	public int getBvalue() {
		return Bvalue;
	}


	public void setBValue(int Bvalue) {
		this.Bvalue = Bvalue;
		notifyObservateur();
	}


	public void setRGB(int Rvalue, int Gvalue, int Bvalue) {
		this.Rvalue = Rvalue;
		this.Gvalue = Gvalue;
		this.Bvalue = Bvalue;
		notifyObservateur();
	}

	public void addObservateur(ColorObservateur colorObservateur) {
		this.colorObservateurs.add(colorObservateur);
	}

	
	public void deleteObservateur(ColorObservateur colorObservateur) {
		this.colorObservateurs.remove(colorObservateur);	
	}

	
	public void notifyObservateur() {
		for(ColorObservateur colorObservateur : colorObservateurs) {
			colorObservateur.NewColorObservateur(new NewColorValue(this,Rvalue,Gvalue,Bvalue));
		}
	}
	
}
