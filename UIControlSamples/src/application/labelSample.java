package application;

import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class labelSample extends Application {
	
	Label label3 = new Label("A label that needs to be wrapped");

	@Override
	public void start(Stage stage){
		
		//JavaFx API 为Label提供了三个构造方法
		//一个空Label
		Label labelA = new Label();
		//一个带文本元素的Label
		Label labelB = new Label("Search");
		//一个带文本和图标的Label
		Image image = new Image(getClass().getResourceAsStream("labels.jpg"));
		
		
		Scene scene = new Scene(new Group());
		stage.setTitle("Label Sample");
		stage.setWidth(420);
		stage.setHeight(180);
		
		HBox hBox = new HBox();
		Image imageEX = new Image(getClass().getResourceAsStream("labels.jpg"));
		
		Label label1 =new Label("Search");
		label1.setGraphic(new ImageView(image));
		label1.setFont(new Font("Arial",30));
		label1.setTextFill(Color.web("#FF6688"));
		label1.setTextAlignment(TextAlignment.JUSTIFY);
		label1.setGraphicTextGap(10);
//		label1.setContentDisplay(ContentDisplay.TOP);
		
		Label label2 = new Label("Values");
		label2.setFont(Font.font("Cambria",32));
		label2.setRotate(270);
		label2.setTranslateY(50);
		
		label3.setWrapText(true);
		label3.setTranslateY(50);
		label3.setPrefWidth(100);
		label3.setTextOverrun(OverrunStyle.CENTER_ELLIPSIS);
		
		label3.setOnMouseEntered((MouseEvent e) -> {
			label3.setScaleX(1.5);
			label3.setScaleY(1.5);
		});
		
		label3.setOnMouseExited((MouseEvent e)->{
			label3.setScaleY(1);
			label3.setScaleY(1);
		});
		
		hBox.setSpacing(10);
		hBox.getChildren().add(label1);
		hBox.getChildren().add(label2);
		hBox.getChildren().add(label3);
		
		((Group)scene.getRoot()).getChildren().add(hBox);
		
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
