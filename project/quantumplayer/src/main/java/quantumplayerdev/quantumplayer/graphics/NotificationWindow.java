package quantumplayerdev.quantumplayer.graphics;

import org.controlsfx.control.Notifications;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class NotificationWindow {

	private static final String DEFAULT_TITLE = "Message";
	
	private static final Pos DEFAULT_POS = Pos.TOP_LEFT;
	
	private static final double DEFAULT_DURATION = 5;
	
	private Notifications notification;
	
	public NotificationWindow(String title, String message, double duration,
			ImageView img, Pos pos) {
		super();
		notification = Notifications.create()
				.title(title)
				.text(message)
				.graphic(img)
				.hideAfter(Duration.seconds(duration))
				.position(pos);
		notification.darkStyle();
	}
	
	public NotificationWindow(String title, String message, ImageView img) {
		this(title, message, DEFAULT_DURATION, img, DEFAULT_POS);
	}
	
	public NotificationWindow(String message) {
		this(DEFAULT_TITLE, message, DEFAULT_DURATION, null, DEFAULT_POS);
	}
	
	public void show() {
		notification.show();
	}
}
