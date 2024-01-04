package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * EmployeeInformationManagementSystem
 *
 * @author PlutoCtx 15905898514@163.com
 * @version 2024/1/4 10:00
 * @since JDK17
 */

public class Main extends Application{

    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        stage.setTitle("员工信息管理系统");
        changeView("view/login.fxml");
        stage.show();
    }

    public static void changeView(String fxml) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Main.class.getResource(fxml));
            stage.setScene(new Scene(root));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addView(String fxml) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(Main.class.getResource(fxml));
            stage.setScene(new Scene(root));
        }catch (Exception e) {
            e.printStackTrace();
        }
        stage.show();
    }





    //--module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
    public static void main(String[] args){
        Application.launch(args);
    }
}

































