package quantumplayerdev.quantumplayer.graphics;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class ToolBar extends MenuBar {

	public ToolBar() {
		super();
		
		final Menu menuFile = new Menu("File");
		final MenuItem itemClose = new MenuItem("Close");
		menuFile.getItems().add(itemClose);
		
		final Menu menuEdit = new Menu("Edit");
		final MenuItem itemDelete = new MenuItem("Delete");
		menuEdit.getItems().add(itemDelete);
		
		final Menu menuHelp = new Menu("Help");
		final MenuItem itemAbout = new MenuItem("About");
		menuHelp.getItems().add(itemAbout);
		
		this.getMenus().addAll(menuFile, menuEdit, menuHelp);
	}
}
