package biblioteka;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main  extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("/cfg/FXML.fxml"));
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("/cfg/ksiazka.png"));
        stage.setScene(scene);
        stage.show();    
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
