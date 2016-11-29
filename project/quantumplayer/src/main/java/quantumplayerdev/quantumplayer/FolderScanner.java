package quantumplayerdev.quantumplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import quantumplayerdev.quantumplayer.songLoader.SongLoader;

public class FolderScanner {
	org.slf4j.Logger logger = LoggerFactory.getLogger(FolderScanner.class);
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
						// load song
						SongLoader songLoader = new SongLoader();
						Song song = songLoader.getSongFromFile(file);
						if (song != null) {
							songs.add(songLoader.getSongFromFile(file));
						}
					}
				}
			}
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
	}
}