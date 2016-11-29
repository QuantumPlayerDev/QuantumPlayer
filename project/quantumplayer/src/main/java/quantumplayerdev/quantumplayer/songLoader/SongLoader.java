package quantumplayerdev.quantumplayer.songLoader;

import java.io.File;
import java.io.IOException;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import quantumplayerdev.quantumplayer.Song;

public class SongLoader {

	public Song getSongFromFile(File file) throws UnsupportedTagException, InvalidDataException, IOException {
		if (file.getPath().endsWith(".mp3")) {
			return getSongFromMP3(file);
		} else if (file.getPath().endsWith(".m4a")) {
			System.out.println(".m4a is unsupported");
		} else {
			System.out.println("filetype is unsupported");
		}
		return null;
	}

	public Song getSongFromMP3(File file) throws UnsupportedTagException, InvalidDataException, IOException {
		Mp3File mp3File = new Mp3File(file);
		Song song = new Song();
		song.setPath(mp3File.getFilename());
		ID3v1 tag = null;
		if (mp3File.hasId3v1Tag()) {
			tag = mp3File.getId3v1Tag();
		} else if (mp3File.hasId3v2Tag()) {
			tag = mp3File.getId3v2Tag();
		}

		song.setTitle(tag.getTitle());
		song.setAlbum(tag.getAlbum());
		song.setArtist(tag.getArtist());
		song.setYear(tag.getYear());
		if (mp3File.hasId3v2Tag()) {
		}
		return song;
	}
}
