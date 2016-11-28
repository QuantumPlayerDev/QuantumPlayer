package quantumplayerdev.quantumplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

public class Control {
	org.slf4j.Logger logger = LoggerFactory.getLogger(Control.class);

	public static void main(String[] args) {
		Control ctr = new Control();
		List<File> files = new ArrayList<File>();
		files.add(new File("C:\\Users\\reger"));
		ctr.setFolders(files);
	}

	private List<File> songFiles = new ArrayList<File>();
	private List<Song> songs = new ArrayList<Song>();

	public void setFolders(List<File> files) {
		File[] array = new File[files.size()];
		addFiles(files.toArray(array));
	}

	private void addFiles(File[] files) {
		try {
			for (File file : files) {
				if (file.canRead() && file.exists() && !file.isHidden()) {
					if (file.isDirectory()) {
						addFiles(file.listFiles());
					} else {
						if (file.getPath().endsWith(".mp3")) {
							songFiles.add(file);
						}
					}
				}
			}
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
	}

}
