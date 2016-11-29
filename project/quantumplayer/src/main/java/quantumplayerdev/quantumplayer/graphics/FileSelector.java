package quantumplayerdev.quantumplayer.graphics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;

/**
 * The FileSelector class creates a new {@link TreeView} object that
 * contains {@link FileView} object to represent the structure of all
 * {@link File} objects that exist on a local device.
 * @author daniel
 *
 */
public class FileSelector extends TreeView<FileView> {
	
	/**
	 * Constructor for creating a new {@link FileSelector} object
	 * to represent all files that exist depending on the {@link #rootFile}.
	 * @param rootFile The root file to set.
	 */
	public FileSelector(File rootFile) {
		super();
		this.setRoot(new FileSystemView(new FileView(rootFile)));
		this.setCellFactory(CheckBoxTreeCell.<FileView>forTreeView());
		style();
	}
	
	/**
	 * Adds Cascading Style sheet attributes to this {@link TreeView} object.
	 */
	private void style() {
		this.setStyle("-fx-font-weight: bold; -fx-background-color: black;"
				+ "-fx-text-fill: white;");
	}
	
	/**
	 * Gets the {@link File} objects that have been selected in this
	 * {@link TreeView} object.
	 * @return a list of {@link File} objects.
	 */
	public List<File> getSelection() {
		final ObservableList<TreeItem<FileView>> views = this.getSelectionModel().getSelectedItems();
		final List<File> selectedFiles = new ArrayList<File>();
		for (int i = 0; i < views.size(); i++) {
			selectedFiles.add(views.get(i).getValue().getFile());
		}
		return selectedFiles;
	}
}
