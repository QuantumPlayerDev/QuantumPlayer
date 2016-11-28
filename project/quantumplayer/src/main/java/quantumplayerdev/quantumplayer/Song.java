package quantumplayerdev.quantumplayer;

import java.io.File;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

public class Song {
	private String id;
	private File path;
	private Mp3File mp3;

	private String title;
	private String album;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public File getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public static Song getSongFromMP3(Mp3File mp3File) {
		Song song = new Song();
		if (mp3File.hasId3v1Tag()) {
			ID3v1 tag = mp3File.getId3v1Tag();
			song.setTitle(tag.getTitle());
			song.setAlbum(tag.getAlbum());
		} else if (mp3File.hasId3v2Tag()) {
			ID3v2 tag = mp3File.getId3v2Tag();
			song.setTitle(tag.getTitle());
			song.setAlbum(tag.getAlbum());
		}
		return song;
	}

}
