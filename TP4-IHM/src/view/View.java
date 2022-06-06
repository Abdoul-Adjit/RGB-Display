package view;

import control.Control;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import event.ColorObservateur;
import event.NewColorValue;

public class View extends HBox implements ColorObservateur {
	
	private Control control;
	private Slider SliderR;
	private Slider SliderG;
	private Slider SliderB;
	private TextField TextFieldR;
	private TextField TextFieldG;
	private TextField TextFieldB;
	private TextField TextFieldRGB;
	private Pane PaneRGB;
	public View(Control control) {
		this.control = control;
		control.addObservateur(this);
		initialize();
	}
	public void initialize() {
		SliderR = new Slider(0,255,0);
		SliderG = new Slider(0,255,0);
		SliderB = new Slider(0,255,0);
		SliderR.setShowTickLabels(true);
		SliderR.setShowTickMarks(true);
		SliderB.setShowTickLabels(true);
		SliderB.setShowTickMarks(true);
		SliderG.setShowTickLabels(true);
		SliderG.setShowTickMarks(true);
		TextFieldR = new TextField("0");
		TextFieldR.setPrefSize(50, 30);
		TextFieldG = new TextField("0");
		TextFieldG.setPrefSize(50, 30);
		TextFieldB = new TextField("0");
		TextFieldB.setPrefSize(50, 30);
		TextFieldRGB = new TextField("#000000");
		TextFieldRGB.setPrefSize(70, 15);
		PaneRGB = new Pane();
		PaneRGB.setPrefSize(130, 130);
		
		
		
		//On configure l'action à effectuer quand l'utilisateur 
		//manipule le Slider correspondant à la valeur de rouge
		SliderR.valueProperty().addListener(new ChangeListener<Number>()
		{
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
				{
					control.valueRedChanged(newValue.intValue());
				}
			
		});
		
		//On configure l'action à effectuer quand l'utilisateur 
		//Ecrit dans le TextField correspondant à la valeur de rouge
		TextFieldR.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
				int valueR = Integer.parseInt(newValue);
				if(valueR > 255 || valueR < 0)
				{
					System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
					return;
				}
				control.valueRedChanged(valueR);
				}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
				
			}
			
		});
		//On configure l'action à effectuer quand l'utilisateur 
		//manipule le Slider correspondant à la valeur de vert
		SliderG.valueProperty().addListener(new ChangeListener<Number>()
		{
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
				{
					control.valueGreenChanged(newValue.intValue());
				}
			
		});
		//On configure l'action à effectuer quand l'utilisateur 
		//Ecrit dans le TextField correspondant à la valeur de vert
		TextFieldG.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					int valueG = Integer.parseInt(newValue);
					
					if(valueG > 255 || valueG < 0)
					{
						System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
						return;
					}
					
					control.valueGreenChanged(valueG);
				}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
			}
			
		});
		//On configure l'action à effectuer quand l'utilisateur 
		//manipule le Slider correspondant à la valeur de bleu   
		SliderB.valueProperty().addListener(new ChangeListener<Number>()
		{
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
				{
					control.valueBlueChanged(newValue.intValue());
				}
			
		});
		//On configure l'action à effectuer quand l'utilisateur 
		//Ecrit dans le TextField correspondant à la valeur de bleu
		TextFieldB.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					int valueB = Integer.parseInt(newValue);
					
					if(valueB > 255 || valueB < 0)
					{
						System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
						return;
					}
					
					control.valueBlueChanged(valueB);
			}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
			}
		}
		);
		//On configure l'action à effectuer quand l'utilisateur
		//Ecrit dans le TextField correspondant  à  la valeur hexadécimale
		TextFieldRGB.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					java.awt.Color PaneRGB = java.awt.Color.decode("#"+newValue);
					int valueR = PaneRGB.getRed();
					int valueG = PaneRGB.getGreen();
					int valueB = PaneRGB.getBlue();
					if((valueR > 255 || valueR < 0) && (valueG > 255 || valueG < 0) && (valueB > 255 || valueB < 0))
					{
						System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
						return;
					}
					control.colorChanged(valueR, valueG, valueB);
				}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
			}
			
		});
		VBox gauche = new VBox(10);
		VBox droite = new VBox(10);
		HBox box1 = new HBox(15);
		HBox box2 = new HBox(15);
		HBox box3 = new HBox(15);
		box1.getChildren().addAll(SliderR,TextFieldR);
		box2.getChildren().addAll(SliderG,TextFieldG);
		box3.getChildren().addAll(SliderB,TextFieldB);
		gauche.getChildren().addAll(box1,box2,box3);
		droite.getChildren().addAll(TextFieldRGB,PaneRGB);
		this.setSpacing(30);
		HBox.setMargin(this, new Insets(20,50,15,20));
		this.getChildren().addAll(gauche,droite);
		
		
	}
	@Override
	public void NewColorObservateur(NewColorValue event) {
		SliderR.setValue(event.getValueR());
		TextFieldR.setText("" + event.getValueR());
		SliderG.setValue(event.getValueG());
		TextFieldG.setText("" + event.getValueG());
		SliderB.setValue(event.getValueB());
		TextFieldB.setText("" + event.getValueB());
		TextFieldRGB.setText("" + event.getHexa());
		PaneRGB.setStyle("-fx-background-color: #" + event.getHexa() + ";");
	}
}
