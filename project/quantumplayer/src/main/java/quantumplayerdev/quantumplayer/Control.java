package quantumplayerdev.quantumplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.slf4j.LoggerFactory;

import com.mpatric.mp3agic.Mp3File;

public class Control {
	org.slf4j.Logger logger = LoggerFactory.getLogger(Control.class);
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
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(song.getPath());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

}
