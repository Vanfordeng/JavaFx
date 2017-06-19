package application;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("JavaFx Welcom");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		Scene scene = new Scene(grid,800,600);
		
		//�����ı�
		Text sceneTitle = new Text("Welcome");
		sceneTitle.setId("welcome-text");
		
//		sceneTitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
		grid.add(sceneTitle, 0,0,2,1);
		//����Label����,�ŵ���0��,��1��
		Label userName = new Label("User Name��");
		grid.add(userName, 0, 1);
		
		//�����ı������,�ŵ���1�У���1��
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
		
		//����Label����,�ŵ���0�У���2��
		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);
		
		//�����ı������,�ŵ���1�У���2��
		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
		
		//����ʹ��grid��ʾ����
//		grid.setGridLinesVisible(true);
		
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		
		final Text actiontarget = new Text();//����������ʾ��Ϣ���ı�
		grid.add(actiontarget, 1, 6);
		actiontarget.setId("actiontarget");
	
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
//				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Sign in button pressed");
			}
		});
		
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//���´���ͬ��Ч��
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
//		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}