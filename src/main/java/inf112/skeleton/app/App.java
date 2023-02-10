package inf112.skeleton.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.Game;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import scenes.IScene;

public class App extends Application {
	private AnimationTimer timer;
	private Canvas canvas;
	private long nanosPerStep = 1000_000_000L / 60L;
	private long timeBudget = nanosPerStep;
	private long lastUpdateTime = 0L;
	
	private IScene scene;



	public static void startIt(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		double width = 500;
		double height = 500;
		Group root = new Group();
		Scene scene = new Scene(root, width, height, Color.BLACK);
		stage.setScene(scene);

		canvas = new Canvas(width, height);
		canvas.widthProperty().bind(scene.widthProperty());
		canvas.heightProperty().bind(scene.heightProperty());

		setup();

		timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// System.out.println("Elapsed: " + (now -
				// lastUpdateTime)/(double)millisPerStep);
				if (lastUpdateTime > 0) {
					timeBudget = Math.min(timeBudget + (now - lastUpdateTime), 10 * nanosPerStep);
				}
				lastUpdateTime = now;

				while (timeBudget >= nanosPerStep) {
					// System.out.println("Budget: " + timeBudget);
					timeBudget = timeBudget - nanosPerStep;
					step();
				}
				draw();
			}

		};
		root.getChildren().add(canvas);

		// canvas.setEffect(new BoxBlur());
		timer.start();
//		stage.setFullScreen(true);
		stage.show();

	}

	private void setup() {
		scene = new Game();
	}
	
	private int stepCount = 0;

	protected void step() {
		scene.step(stepCount);
		stepCount++;
	}

	protected void draw() {
		scene.draw(canvas);
		
	}
}