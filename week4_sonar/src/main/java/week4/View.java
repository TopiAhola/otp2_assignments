package week4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class View extends Application {

    /**
     * static Controller for tests to call its methods
     */
    static Controller controller;

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui.fxml"));
        Parent root = fxmlLoader.load();
        setController(fxmlLoader.getController());

        stage.setScene(new Scene(root));
        stage.setMinWidth(300);
        stage.setMinHeight(500);
        stage.setTitle("TripCalc");

        stage.show();
    }

    public static synchronized Controller getController(){
        return controller;
    }

    public static synchronized void setController(Controller c){
        controller = c;
    }

}