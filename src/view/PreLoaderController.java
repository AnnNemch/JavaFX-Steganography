package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PreLoaderController implements Initializable {
    @FXML
    private StackPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new PreLoader().start();
    }

    class PreLoader extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(0);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/view/MainWindow.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("LSB-Steganography");
                        stage.getIcons().add(new Image("/resources/images/logo2.png",3000,3000,false,true));
                        stage.show();
                        rootPane.getScene().getWindow().hide();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}