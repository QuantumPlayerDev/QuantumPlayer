package quantumplayerdev.quantumplayer.graphics;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CoreConstruction extends BorderPane {

	public CoreConstruction(final WindowManager manager) {
		super();
		this.setStyle("-fx-background-color: white;");
		
		final BorderPane borderTop = new BorderPane();
		borderTop.setPrefSize(791.0, 51.0);
		BorderPane.setAlignment(borderTop, Pos.CENTER);
		
		final ToolBar toolBar = new ToolBar();
		borderTop.setBottom(toolBar);
		
		final FlowPane decorationPane = new FlowPane();
		decorationPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		decorationPane.setPrefSize(791.0, 15.0);
		decorationPane.setStyle("-fx-background-color: gainsboro;");
		BorderPane.setAlignment(decorationPane, Pos.CENTER);
		
		final JFXButton btnClose = new JFXButton();
		btnClose.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				manager.getPrimaryStage().close();
			}
		});
		final ImageView imageClose = new ImageView(new Image("/resources/png/007__close.png"));
		imageClose.setFitWidth(30.0);
		imageClose.setFitHeight(30.0);
		btnClose.setGraphic(imageClose);
		btnClose.setPrefSize(42.0, 25.0);
		btnClose.setStyle("-fx-background-color: transparent;");
		
		final JFXButton btnMinimize = new JFXButton();
		
		final JFXButton btnIconify = new JFXButton();
		btnIconify.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				manager.getPrimaryStage().setIconified(true);
			}
		});
		final ImageView imageIconify = new ImageView(new Image("/resources/png/006__minus.png"));
		imageIconify.setFitWidth(30.0);
		imageIconify.setFitHeight(30.0);
		btnIconify.setGraphic(imageIconify);
		btnIconify.setPrefSize(42.0, 25.0);
		btnIconify.setStyle("-fx-background-color: transparent;");
		
		final JFXButton btnMaximize = new JFXButton();
		btnMaximize.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				manager.getPrimaryStage().setFullScreen(true);
				decorationPane.getChildren().clear();
				decorationPane.getChildren().addAll(btnClose, btnMinimize, btnIconify);
			}
		});
		final ImageView imageMaximize = new ImageView(new Image("/resources/png/053__desktop.png"));
		imageMaximize.setFitWidth(30.0);
		imageMaximize.setFitHeight(30.0);
		btnMaximize.setGraphic(imageMaximize);
		btnMaximize.setPrefSize(42.0, 25.0);
		btnMaximize.setStyle("-fx-background-color: transparent;");
		
		btnMinimize.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				manager.getPrimaryStage().setFullScreen(false);
				decorationPane.getChildren().clear();
				decorationPane.getChildren().addAll(btnClose, btnMaximize, btnIconify);
			}
		});
		btnMinimize.setPrefSize(42.0, 25.0);
		btnMinimize.setStyle("-fx-background-color: transparent;");
		
		decorationPane.getChildren().addAll(btnClose, btnMaximize, btnIconify);
		
		borderTop.setTop(decorationPane);
		
		this.setTop(borderTop);
		
		final Pane centerPane = new Pane();
		centerPane.setPrefSize(200.0, 200.0);
		BorderPane.setAlignment(centerPane, Pos.CENTER);
		
		final VBox playlist = new VBox();
		playlist.setPrefSize(190.0, 537.0);
		BorderPane.setAlignment(playlist, Pos.CENTER);
		
		this.setCenter(centerPane);
		this.setLeft(playlist);
	}
}
