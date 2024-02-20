package com.example;

import com.example.utils.DBUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Objects;

/**
 * EmployeeInformationManagementSystem
 *
 * @author PlutoCtx ctx195467@163.com
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
//            root = FXMLLoader.load(Main.class.getResource(fxml));
            root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml)));
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


    public static void main(String[] args) throws Exception {
        Application.launch(args);
        DBUtil dbUtil = new DBUtil();
        Connection conn = dbUtil.getConnection();
        ResultSet resultSet =conn.createStatement().executeQuery("SELECT * FROM t_book");
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }

    }
}
