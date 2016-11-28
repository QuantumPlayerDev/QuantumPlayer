package quantumplayerdev.quantumplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

public class Control {
	org.slf4j.Logger logger = LoggerFactory.getLogger(Control.class);

	public static void main(String[] args) {
		Control ctr = new Control();
		List<File> files = new ArrayList<File>();
		files.add(new File("C:\\Users\\reger"));
		ctr.setFolders(files);
		ctr.loadFiles();
	}

	private List<Mp3File> songsMP3 = new ArrayList<Mp3File>();
	private List<Song> songs = new ArrayList<Song>();

	public void setFolders(List<File> files) {
		File[] array = new File[files.size()];
		addFiles(files.toArray(array));
	}

	public List<Song> loadFiles() {
		for (Mp3File mp3File : songsMP3) {
			Song song = new Song();
			if (mp3File.hasId3v1Tag()) {
				ID3v1 tag = mp3File.getId3v1Tag();
				song.setTitle(tag.getTitle());
				song.setAlbum(tag.getAlbum());
			} else if (mp3File.hasId3v2Tag()) {
				ID3v2 tag = mp3File.getId3v2Tag();
				song.setTitle(tag.getTitle());
				song.setAlbum(tag.getAlbum());
			} else {

			}
			songs.add(song);
		}
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
							songsMP3.add(new Mp3File(file));
						}
					}
				}
			}
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
	}

}
