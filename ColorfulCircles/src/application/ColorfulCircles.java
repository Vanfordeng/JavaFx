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
			//场景设置根节点
			Group root = new Group();
			//创建场景
			Scene scene = new Scene(root, 800, 600, Color.BLACK);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//-创建circles节点,后续会添加到根节点
			Group circles = new Group();
			for (int i = 0; i < 30; i++) {
				Circle circle = new Circle(150, Color.web("white", 0.05));
				circle.setStrokeType(StrokeType.OUTSIDE);
				circle.setStroke(Color.web("white", 0.16));
				circle.setStrokeWidth(4);
				circles.getChildren().add(circle);
			}
			//-创建Rectangle colors节点,后续会添加到根节点
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
			//接下来的两行代码表示将scene和渐变矩形的大小绑定保持一致。
			colors.widthProperty().bind(scene.widthProperty());
			colors.heightProperty().bind(scene.heightProperty());
			
			//根节点添加circles和colors
//			root.getChildren().add(circles);
//			root.getChildren().add(colors);
			//你需要从场景图中移除名为circles的Group和线性渐变矩形，然后将它们添加到新的蒙版混合Group中
			//TODO 不明白混合模式
			//Group构造函数有可变参数设置,可添加多个Node（节点）
			Group blendModeGroup = new Group(new Group(new Rectangle(scene.getWidth(),scene.getHeight(),Color.BLACK),circles),colors);
			colors.setBlendMode(BlendMode.OVERLAY);
			root.getChildren().add(blendModeGroup);
			
		    //为circles设置盒式模糊(Box Blur)效果
			circles.setEffect(new BoxBlur(10, 10, 3));
			
			//添加动画
			/**
			 * 动画由一个时间轴来驱动，因此这段代码创建了一个时间轴，然后使用一个for循环来为30个圆圈各增加了两个关键帧。第一个关键帧是在第0秒，
			 * 通过使用translateXProperty和translateYProperty属性来为圆圈设置窗体中的一个随机位置。第二个在第40秒的关键帧也做了类似的事情。
			 * 因此当时间轴被播放时，它会将所有的圆圈在40秒之内从一个随机位置移到另外一个随机位置。
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
			
			//舞台设置场景
			primaryStage.setScene(scene);
			primaryStage.setTitle("ColorfulCircles");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		test();
	}
	
	/**
	 * 自己写着玩的
	 */
	public void test() {
		System.out.println("Hello World");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
