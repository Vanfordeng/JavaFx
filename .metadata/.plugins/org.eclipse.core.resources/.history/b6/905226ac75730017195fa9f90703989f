package application;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonSample extends Application{
	
	final ImageView icon = new ImageView();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
//		//标签为空的Radio Button
//		RadioButton rb1 = new RadioButton();
//		//设置标签文字
//		rb1.setText("Home");
//		//指定标签问题的Radio Button
//		RadioButton rb2 = new RadioButton("Calendar");
		
		Scene scene = new Scene(new Group());
		stage.setTitle("Radio Button Sample");
		stage.setWidth(250);
		stage.setHeight(150);
		
		final ToggleGroup group = new ToggleGroup();
		
		RadioButton rb1 = new RadioButton("Home");
		rb1.setToggleGroup(group);
		rb1.setUserData("Home");

		RadioButton rb2 = new RadioButton("Calendar");
		rb2.setToggleGroup(group);
		rb2.setUserData("Calendar");
		

		RadioButton rb3 = new RadioButton("Contacts");
		rb3.setToggleGroup(group);
		rb3.setUserData("Contacts");
			
		group.selectedToggleProperty().addListener((ObservableValue <? extends Toggle> ov,Toggle old_toggle, Toggle new_toggle) ->{
			if (group.getSelectedToggle() !=null) {
				final Image image = new Image(getClass().getResourceAsStream(group.getSelectedToggle().getUserData().toString() + ".jpg"));
				icon.setImage(image);
			}
	
		});
		
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		
		vBox.getChildren().add(rb1);
		vBox.getChildren().add(rb2);
		vBox.getChildren().add(rb3);
		vBox.setSpacing(10);
		
		hBox.getChildren().add(vBox);
		hBox.getChildren().add(icon);
		hBox.setSpacing(50);
		hBox.setPadding(new Insets(20,10,10,20));
		
		((Group)scene.getRoot()).getChildren().add(hBox);
		
		stage.setScene(scene);
		stage.show();
	}

}
