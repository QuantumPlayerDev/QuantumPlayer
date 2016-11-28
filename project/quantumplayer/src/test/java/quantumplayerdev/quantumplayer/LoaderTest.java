package quantumplayerdev.quantumplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LoaderTest {
	@Test
	public void testPlay() throws Exception {
		Loader loader = new Loader();
		List<File> files = new ArrayList<File>();
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\");
		System.out.println(file.getAbsolutePath());
		files.add(file);
		loader.setFolders(files);
		List<Song> songs = loader.loadFiles();
		System.out.println("Found songs: " + songs.size());
		loader.playSong(songs.get(0));
	}
}
