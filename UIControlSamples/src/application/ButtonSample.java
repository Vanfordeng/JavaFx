package application;

import java.awt.event.ActionEvent;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ButtonSample extends Application{
	
	
	private static final Color color = Color.web("#464646");
	
	
	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage stage) throws Exception {
		//JavaFxӦ�ó����������ֹ��췽��������Button�ؼ�
		//һ��Button
		Button button1 = new Button();
		//һ��ָ�����ı������Button
		Button button2 = new Button("Accept");
		//һ��ָ�����ı������ͼ����Button
		Image imageOK = new Image(getClass().getResourceAsStream("ok.png"));
		Button button3 = new Button("Accept", new ImageView(imageOK));
		
	
		
		Scene scene = new Scene(new Group());
		stage.setTitle("ButtonSample");
		stage.setWidth(300);
		stage.setHeight(190);
		scene.getStylesheets().add("buttonsample/ControlStyle.cass");
		
		
		
		
		Image imageDecline = new Image(getClass().getResourceAsStream("not.png"));
		Button button5 = new Button();
		button5.setGraphic(new ImageView(imageDecline));
		
//		button2.setOnAction((ActionEvent e)-> {
//			label.setText("Accepted");
//		});
		
	}

}