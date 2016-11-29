package quantumplayerdev.quantumplayer.graphics;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FileSelectorTest extends Application {

	public FileSelectorTest() {
		super();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final FileSelector selector = new FileSelector(new File("/"));
		final AnchorPane pane = new AnchorPane(selector);
		final Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
