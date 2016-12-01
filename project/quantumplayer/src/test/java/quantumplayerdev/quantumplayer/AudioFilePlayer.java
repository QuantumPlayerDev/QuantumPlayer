package quantumplayerdev.quantumplayer;

import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
		FolderScanner loader = new FolderScanner();
		List<File> files = new ArrayList<File>();
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\");
		System.out.println(file.getAbsolutePath());
		files.add(file);
		loader.setFolders(files);
		List<Song> songs = loader.loadFiles();

		System.out.println("----------------------------");
		System.out.println("Found songs: " + songs.size());
		for (Song song : songs) {
			System.out.println("Title: " + song.getTitle());
		}
		SongPlayer player = new SongPlayer();
		System.out.println(songs.get(0).getPath());
		
		Button playButton = new Button("Play");
		playButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				Thread thread = new Thread( new Runnable() {
					@Override
					public void run() {
						player.playSong(songs.get(0));
					}
				});
				thread.start();
		    }
		});
        StackPane root = new StackPane();
        root.getChildren().add(playButton);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}