package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import view.View;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import control.Control;


public class Main extends Application {
	
	@Override
	public void start(Stage arg0) throws Exception {
		Model modele = new Model();
		Control control = new Control(modele);
		View view = new View(control);
		HBox root = new HBox();
		root.getChildren().add(view);
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
