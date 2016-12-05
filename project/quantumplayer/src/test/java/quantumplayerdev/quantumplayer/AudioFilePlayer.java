package quantumplayerdev.quantumplayer;

import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class AudioFilePlayer extends Application {

	private MediaPlayer player;

	@Test
	public void run() {
		String[] args = null;
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FolderScanner loader = new FolderScanner();
		List<File> files = new ArrayList<File>();
		File file = new File("D:\\Users\\Jonas\\Music");
		// File file = new File(System.getProperty("user.dir") +
		// "\\src\\test\\resources\\");
		System.out.println(file.getAbsolutePath());
		files.add(file);
		loader.setFolders(files);
		List<Song> songs = loader.loadFiles();

		System.out.println("----------------------------");
		System.out.println("Found songs: " + songs.size());

		FlowPane root = new FlowPane();

		Label playTime = new Label();
		playTime.setPrefWidth(130);
		playTime.setMinWidth(50);
		root.getChildren().add(playTime);

		Button stopButton = new Button("pause");
		stopButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				player.pause();
			};
		});

		Button playButton = new Button("play");
		playButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						player.play();
					}
				});
				thread.start();
			}
		});
		
		
		root.getChildren().add(stopButton);
		root.getChildren().add(playButton);
		for (Song song : songs) {
			// System.out.println("Title: " + song.getTitle());

			Button songButton = new Button(song.getTitle());
			songButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Thread thread = new Thread(new Runnable() {
						@Override
						public void run() {
							if (player != null) {
								player.stop();
							}
							// player.playSong(songs.get(0));
							File mediaFile = new File(songs.get(songs.indexOf(song)).getPath());
							System.out.println(mediaFile.getPath());
							Media song = new Media(mediaFile.toURI().toASCIIString());
							player = new MediaPlayer(song);
							player.play();
							player.currentTimeProperty().addListener(new InvalidationListener() 
							{
								@Override
								public void invalidated(Observable observable) {
									Platform.runLater(new Runnable() {
										public void run() {
											playTime.setText(player.currentTimeProperty().get().toSeconds() + " / " + player.getStopTime().toSeconds());
										}
									});
								}
							});
						}
					});
					thread.start();
				}
			});
			root.getChildren().add(songButton);
		}
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("QuantumPlayer");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}