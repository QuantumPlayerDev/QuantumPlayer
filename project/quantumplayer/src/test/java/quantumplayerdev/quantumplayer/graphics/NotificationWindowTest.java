package quantumplayerdev.quantumplayer.graphics;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class NotificationWindowTest extends Application {

	@Test
	public void run() {
		String[] args = null;
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button = new Button("Test");
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				NotificationWindow notification = null;
				Image image = null;
				try {
					image = new Image(new FileInputStream(new File(new Properties(System.getProperties()).getProperty("user.home")) + "/Documents/testCover.jpg"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				ImageView imageView = new ImageView(image);
				imageView.setFitWidth(80.0);
				imageView.setFitHeight(80.0);
				notification = new NotificationWindow("SongName", "SongTitle", 3, imageView, Pos.TOP_RIGHT);
				notification.show();
			}
		});
		
		Scene scene = new Scene(button);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
