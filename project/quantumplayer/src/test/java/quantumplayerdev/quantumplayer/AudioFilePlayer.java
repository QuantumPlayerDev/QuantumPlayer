package quantumplayerdev.quantumplayer;

import java.awt.event.ActionEvent;
import java.net.URL;

import org.junit.Test;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class AudioFilePlayer extends Application {

	@Test
	public void run() {
		String[] args = null;
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		String name = "C:\\Users\\dejon\\dev\\git\\QuantumPlayer\\project\\quantumplayer\\src\\test\\resources\\TestMusic\\rotten.mp3";
//		URL resource = getClass().getResource("./resources/TestMusic/rotten.mp3");
//		AudioClip clip = new AudioClip(resource.toString());
        
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}