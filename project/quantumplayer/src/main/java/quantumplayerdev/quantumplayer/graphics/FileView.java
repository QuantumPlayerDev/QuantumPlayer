package quantumplayerdev.quantumplayer.graphics;

import java.io.File;

/**
 * The FileView class is used to represent existing {@link File} objects
 * in a {@link TreeView} object.
 * @author daniel
 *
 */
public class FileView {

	/**
	 * The path of the given {@link File} object.
	 */
	private String path;
	
	/**
	 * The {@link File} object.
	 */
	private File file;
	
	/**
	 * Constructor for creating a new {@link FileView} object
	 * with a {@link File}.
	 * @param file The {@link File} object to set.
	 */
	public FileView(File file) {
		super();
		this.path = file.getPath();
		this.file = file;
	}

	/**
	 * Getter for property {@link #path}.
	 * @return the property {@link #path}.
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Setter for property {@link #path}.
	 * @param path The path to set.
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Getter for property {@link #file}.
	 * @return the property {@link #file}.
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Setter for property {@link #file}.
	 * @param file The {@link File} to set.
	 */
	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return file.getName();
	}
}
