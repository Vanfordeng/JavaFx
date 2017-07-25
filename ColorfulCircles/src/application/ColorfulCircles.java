package application;


import static java.lang.Math.random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class ColorfulCircles extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//�������ø��ڵ�
			Group root = new Group();
			//��������
			Scene scene = new Scene(root, 800, 600, Color.BLACK);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//-����circles�ڵ�,��������ӵ����ڵ�
			Group circles = new Group();
			for (int i = 0; i < 30; i++) {
				Circle circle = new Circle(150, Color.web("white", 0.05));
				circle.setStrokeType(StrokeType.OUTSIDE);
				circle.setStroke(Color.web("white", 0.16));
				circle.setStrokeWidth(4);
				circles.getChildren().add(circle);
			}
			//-����Rectangle colors�ڵ�,��������ӵ����ڵ�
			Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
				     new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new
				         Stop[]{
				           new Stop(0, Color.web("#f8bd55")),
				           new Stop(0.14, Color.web("#c0fe56")),
				           new Stop(0.28, Color.web("#5dfbc1")),
				           new Stop(0.43, Color.web("#64c2f8")),
				           new Stop(0.57, Color.web("#be4af7")),
				           new Stop(0.71, Color.web("#ed5fc2")),
				           new Stop(0.85, Color.web("#ef504c")),
				           new Stop(1, Color.web("#f2660f")),}));
			//�����������д����ʾ��scene�ͽ�����εĴ�С�󶨱���һ�¡�
			colors.widthProperty().bind(scene.widthProperty());
			colors.heightProperty().bind(scene.heightProperty());
			
			//���ڵ����circles��colors
//			root.getChildren().add(circles);
//			root.getChildren().add(colors);
			//����Ҫ�ӳ���ͼ���Ƴ���Ϊcircles��Group�����Խ�����Σ�Ȼ��������ӵ��µ��ɰ���Group��
			//TODO �����׻��ģʽ
			//Group���캯���пɱ��������,����Ӷ��Node���ڵ㣩
			Group blendModeGroup = new Group(new Group(new Rectangle(scene.getWidth(),scene.getHeight(),Color.BLACK),circles),colors);
			colors.setBlendMode(BlendMode.OVERLAY);
			root.getChildren().add(blendModeGroup);
			
		    //Ϊcircles���ú�ʽģ��(Box Blur)Ч��
			circles.setEffect(new BoxBlur(10, 10, 3));
			
			//��Ӷ���
			/**
			 * ������һ��ʱ�����������������δ��봴����һ��ʱ���ᣬȻ��ʹ��һ��forѭ����Ϊ30��ԲȦ�������������ؼ�֡����һ���ؼ�֡���ڵ�0�룬
			 * ͨ��ʹ��translateXProperty��translateYProperty������ΪԲȦ���ô����е�һ�����λ�á��ڶ����ڵ�40��Ĺؼ�֡Ҳ�������Ƶ����顣
			 * ��˵�ʱ���ᱻ����ʱ�����Ὣ���е�ԲȦ��40��֮�ڴ�һ�����λ���Ƶ�����һ�����λ�á�
			 */
			Timeline timeline = new Timeline();

			for (Node circle: circles.getChildren()) {
			   timeline.getKeyFrames().addAll(
			       new KeyFrame(Duration.ZERO, // set start position at 0
			           new KeyValue(circle.translateXProperty(), random() * 800),
			           new KeyValue(circle.translateYProperty(), random() * 600)
			       ),

			       new KeyFrame(new Duration(40000), // set end position at 40s
			           new KeyValue(circle.translateXProperty(), random() * 800),
			           new KeyValue(circle.translateYProperty(), random() * 600)
			       )
			   );
			}

			// play 40s of animation
			timeline.play();
			
			//��̨���ó���
			primaryStage.setScene(scene);
			primaryStage.setTitle("ColorfulCircles");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		test();
	}
	
	/**
	 * �Լ�д�����
	 */
	public void test() {
		System.out.println("Hello World");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
