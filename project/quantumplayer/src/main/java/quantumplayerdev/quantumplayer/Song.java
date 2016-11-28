package quantumplayerdev.quantumplayer;

import java.io.File;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;

public class Song {
	private String id;
	private File path;
	private Mp3File mp3;

	private String title;
	private String album;
	private String artist;
	private String year;

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

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Mp3File getMp3() {
		return mp3;
	}

	public void setMp3(Mp3File mp3) {
		this.mp3 = mp3;
	}

	public static Song getSongFromMP3(Mp3File mp3File) {
		Song song = new Song();
		song.setPath(new File(mp3File.getFilename()));
		song.setMp3(mp3File);
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
