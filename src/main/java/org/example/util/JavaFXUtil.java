package org.example.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class JavaFXUtil {


    private static Stage stage;

    //Se pone para que no se creen instancias fuera
    private JavaFXUtil() {}

    public static void initStage(Stage stage) {
        JavaFXUtil.stage = stage;
    }
    //Sirve para acceder al stage desde cualquier parte del codigo
    public static Stage getStage() {
        return stage;
    }

    //Esto se usa para cambiar entre vistas
    public static <T> T setScene(String fxml){
        try {
            FXMLLoader loader = new FXMLLoader(JavaFXUtil.class.getResource(fxml));

            Parent root=loader.load();

            T Controller=loader.getController();

            //Crea la escena cargada desde el parametro fxml
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            return Controller;
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static void showModal(Alert.AlertType type, String title, String header, String content){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.initOwner(stage);
        alert.showAndWait();
    }


}
