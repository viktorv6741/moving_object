import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MovingObject extends Application{

    private int width = 400;
    private int height = 400;
    private int squareSide = 15;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

    @Override
    public void start(Stage primaryStage) throws Exception {
		
		Canvas canvas = new Canvas(width, height);
		
        DoubleProperty x = new SimpleDoubleProperty();
        DoubleProperty y = new SimpleDoubleProperty();

        KeyFrame keyFrame0 = new KeyFrame(Duration.seconds(0), new KeyValue(x, (width/2)), new KeyValue(y, 0));
        KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(4), new KeyValue(x, (width/2) - squareSide), new KeyValue(y, height - squareSide));


        Timeline timeline = new Timeline(keyFrame0, keyFrame1);

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.setCycleCount(3);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      
		
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

                graphicsContext.setFill(Color.BLACK);
                graphicsContext.fillRect(0, 0, width, height);
                graphicsContext.setFill(Color.BLUE);
                graphicsContext.fillRect(x.doubleValue(), y.doubleValue(), squareSide, squareSide);
            }
        };

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Group group = new Group(canvas);
        Scene scene = new Scene(group);
		

        primaryStage.setScene(scene);
        primaryStage.setTitle("Moving Object");
        primaryStage.show();

        timer.start();
        timeline.play();
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
    public static void main(String[] args) {
		
        launch(args);
		
		}
}