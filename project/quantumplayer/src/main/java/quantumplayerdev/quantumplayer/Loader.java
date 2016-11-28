package quantumplayerdev.quantumplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.mpatric.mp3agic.Mp3File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Loader {
	org.slf4j.Logger logger = LoggerFactory.getLogger(Loader.class);
	private List<Song> songs = new ArrayList<Song>();

	public void setFolders(List<File> files) {
		File[] array = new File[files.size()];
		addFiles(files.toArray(array));
	}

	public List<Song> loadFiles() {
		return songs;
	}

	private void addFiles(File[] files) {
		try {
			for (File file : files) {
				if (file.canRead() && file.exists() && !file.isHidden()) {
					if (file.isDirectory()) {
						addFiles(file.listFiles());
					} else {
						if (file.getPath().endsWith(".mp3")) {
							songs.add(Song.getSongFromMP3(new Mp3File(file)));
						}
					}
				}
			}
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
	}

	public void playSong(Song song) {
		try {
			Media media = new Media(song.getPath());
			MediaPlayer player = new MediaPlayer(media);
			player.play();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

}
