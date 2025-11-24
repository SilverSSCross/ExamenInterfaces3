package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.util.JavaFXUtil;
import org.example.util.SoundUtil;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        JavaFXUtil.initStage(primaryStage);

       //Sonido para toda la aplicacion
        SoundUtil.initialize();
        SoundUtil.playMedia();

        JavaFXUtil.setScene("/view/main-view.fxml");
    }
}
