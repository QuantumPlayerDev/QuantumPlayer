package quantumplayerdev.quantumplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Control {
	public static void main(String[] args) {
		Control ctr = new Control();
		List<File> files = new ArrayList<File>();
		files.add(new File("C:\\Users\\reger\\git\\QuantumPlayer\\project\\quantumplayer\\src\\main\\resources"));
		ctr.setFolders(files);
	}

	private List<File> songFiles = new ArrayList<File>();

	public void setFolders(List<File> files) {
		File[] array = new File[files.size()];
		addFiles(files.toArray(array));
	}

	private void addFiles(File[] files) {
		for (File file : files) {
			if (file.isDirectory()) {
				addFiles(file.listFiles());
			} else {
				if (file.getPath().endsWith(".mp3")) {
					songFiles.add(file);
				}
			}
		}
	}

}
