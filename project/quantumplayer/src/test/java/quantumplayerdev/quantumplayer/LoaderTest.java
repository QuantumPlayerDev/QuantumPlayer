package quantumplayerdev.quantumplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

public class LoaderTest {

	@Before
	public void init() {
		Logger log = LogManager.getLogManager().getLogger("");
		for (Handler h : log.getHandlers()) {
			h.setLevel(Level.WARNING);
		}
	}

	@Test
	public void testPlay() throws Exception {
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
		player.playSong(songs.get(0));
		// System.out.println("Found songs: " + songs.size());
		// Scanner scan = new Scanner(System.in);
		// String input;
		// while (true) {
		// input = scan.nextLine();
		// if (input.equals("play")) {
		// loader.playSong(songs.get(0));
		// } else {
		// break;
		// }
		// }
	}
}
