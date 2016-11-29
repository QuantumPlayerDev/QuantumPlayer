package quantumplayerdev.quantumplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LoaderTest {

	@Test
	public void testPlay() throws Exception {
		FolderScanner loader = new FolderScanner();
		List<File> files = new ArrayList<File>();
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\");
		System.out.println(file.getAbsolutePath());
		files.add(file);
		loader.setFolders(files);
		List<Song> songs = loader.loadFiles();
		System.out.println("Found songs: " + songs.size());
		for (Song song : songs) {
			System.out.println(song.getTitle());
		}
		SongPlayer player = new SongPlayer();
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
