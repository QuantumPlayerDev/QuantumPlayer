package quantumplayerdev.quantumplayer.graphics;

import java.io.File;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

public class FileSelector extends Stage {
	
	private TreeTableView<File> tableView;
	
	public FileSelector(Window window) {
		super();
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(window);
		this.tableView = new TreeTableView<File>();
		
		final TreeItem<String> columnName = new TreeItem<String>();
//		columnName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<File,String>, ObservableValue<String>>() {
//			
//			public ObservableValue<String> call(CellDataFeatures<File, String> param) {
//				return new SimpleStringProperty(param.getValue().getValue().getName());
//			}
//		});
//		final TreeTableColumn<File, Boolean> columnSelect = new TreeTableColumn<File, Boolean>();
//		columnSelect.setPrefWidth(75.0);
//		columnSelect.setStyle("-fx-alignment: CENTER-RIGHT;");
//		columnSelect.setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(columnSelect));
	}
	
	private void findFile(File dir, TreeItem<File> parent) {
		TreeItem<File> root = new TreeItem<File>(dir);
	}
}
