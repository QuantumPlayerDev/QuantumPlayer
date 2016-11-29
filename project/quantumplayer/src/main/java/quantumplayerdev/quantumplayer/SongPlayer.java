package quantumplayerdev.quantumplayer;

import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;

public class SongPlayer {
	public void playSong(Song song) {
		try {
			FileInputStream fis = new FileInputStream(new File(song.getPath()));
			AdvancedPlayer player = new AdvancedPlayer(fis);
			player.play();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
}
