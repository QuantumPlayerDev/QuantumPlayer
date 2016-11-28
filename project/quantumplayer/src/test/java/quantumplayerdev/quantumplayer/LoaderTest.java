package quantumplayerdev.quantumplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LoaderTest {
	@Test
	public void testPlay() throws Exception {
		Control control = new Control();
		List<File> files = new ArrayList<File>();
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\";
		System.out.println(path);
		files.add(new File(path));
		control.setFolders(files);
		List<Song> songs = control.loadFiles();
		System.out.println("Found songs: " + songs.size());
		control.playSong(songs.get(0));
	}
}
