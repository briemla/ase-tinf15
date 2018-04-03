package lecture.guitest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		ActiveDayEditor activeDayEditor = new ActiveDayEditor();
		primaryStage.setScene(new Scene(activeDayEditor));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Main.class);
	}

}
