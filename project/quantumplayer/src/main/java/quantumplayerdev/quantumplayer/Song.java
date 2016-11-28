package quantumplayerdev.quantumplayer;

import java.io.File;

public class Song {
	private String id;
	private File path;

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

}
