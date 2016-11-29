package quantumplayerdev.quantumplayer.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowManager extends Application {

	private Stage primaryStage;
	
	public WindowManager() {
		super();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		primaryStage.centerOnScreen();
		primaryStage.setWidth(791.0);
		primaryStage.setHeight(588.0);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		final CoreConstruction defaultLayer = new CoreConstruction(this);
		final Scene scene = new Scene(defaultLayer);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		super.stop();
	}
	
	public void setDefaultSize() {
		primaryStage.setWidth(791.0);
		primaryStage.setHeight(588.0);
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
}
