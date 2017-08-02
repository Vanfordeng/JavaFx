package application;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ToggleButtonSample extends Application {
//	//一个不带任何文本或图标的Toggle Button
//	ToggleButton tb1 = new ToggleButton();
//	//一个带有文本的Toggle Button
//	ToggleButton tb2 = new ToggleButton("Press me");
//	//一个带有文本和图标的Toggle Button
//	Image image = new Image(getClass().getResourceAsStream("icon.png"));
//	ToggleButton tb3 = new ToggleButton("Press me",new ImageView(image));

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Toggle Button Sample");
		stage.setWidth(250);
		stage.setHeight(180);
		
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		
		Scene scene = new Scene(new Group(vBox));
		stage.setScene(scene);
		scene.getStylesheets().add("application/ControlStyle_ToggleButton.css");
		
		Rectangle rect = new Rectangle();
		rect.setHeight(50);
		rect.setFill(Color.WHITE);
		rect.setStroke(Color.DARKGRAY);
		rect.setStrokeWidth(2.0);
		rect.setArcHeight(10.0);
		rect.setArcWidth(10.0);
		
		final ToggleGroup group = new ToggleGroup();
		group.selectedToggleProperty().addListener((ObservableValue <? extends Toggle> ov,Toggle toggle,Toggle new_toggle)->{
			
		});
		
	}

}
