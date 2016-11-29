package quantumplayerdev.quantumplayer.graphics;

import java.io.File;
 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeItem;
 
/**
 * The FileSystemView class builds up a structure of the existing {@link File}
 * objects on a local device.
 * @author daniel
 *
 */
public class FileSystemView extends CheckBoxTreeItem<FileView> {
 
	/**
	 * An attribute to check if a {@link File} object is first time
	 * children.
	 */
	private boolean isFirstTimeChildren = true;
	
	/**
	 * An attribute to check if a {@link File} object is first time
	 * leaf.
	 */
	private boolean isFirstTimeLeaf = true;
	
	/**
	 * An attribute to check if a {@link File} object is leaf.
	 */
	private boolean isLeaf;
	
	/**
	 * Constructor for creating a new {@link CheckBoxTreeItem} object
	 * with a {@link FileView} object.
	 * @param fileView The {@link FileView} object to set in the 
	 * {@link CheckBoxTreeItem} object.
	 */
	public FileSystemView(FileView fileView) {
		super(fileView);
	}
	
	@Override
	public ObservableList<TreeItem<FileView>> getChildren() {
		if (isFirstTimeChildren) {
			isFirstTimeChildren = false;
			super.getChildren().setAll(buildChildren(this));
		}
		return super.getChildren();
	}
 
	@Override
	public boolean isLeaf() {
		if (isFirstTimeLeaf) {
			isFirstTimeLeaf = false;
			final File f = this.getValue().getFile();
			isLeaf = f.isFile();
		}
 
		return isLeaf;
	}
	
	/**
	 * Builds the children of the current {@link CheckBoxTreeView} object
	 * if the {@link FileView} object that is set into the {@link CheckBoxTreeView}
	 * contains some.
	 * @param treeItem The current {@link CheckBoxTreeView} object.
	 * @return a list of {@link CheckBoxTreeItem} objects that will be added to its
	 * root.
	 */
	private ObservableList<CheckBoxTreeItem<FileView>> buildChildren(CheckBoxTreeItem<FileView> treeItem) {
		final File f = treeItem.getValue().getFile();
		if (f != null & f.isDirectory()) {
			final File[] files = f.listFiles();
			if (files != null) {
				final ObservableList<CheckBoxTreeItem<FileView>> children = FXCollections
						.observableArrayList();
 
				for (final File childFile : files) {
					children.add(new FileSystemView(new FileView(childFile)));
				}
				return children;
			}
		}
		return FXCollections.emptyObservableList();
	}
}