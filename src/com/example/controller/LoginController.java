package com.example.controller;

import com.example.Main;
import com.example.utils.StringUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * EmployeeInformationManagementSystem
 * 登录
 *
 * @author PlutoCtx ctx195467@163.com
 * @version 2024/1/4 10:47
 * @since JDK17
 */

public class LoginController {

    @FXML
    private TextField account;

    @FXML
    private PasswordField password;

    @FXML
    private Label errorInfo;

    @FXML
    public void initialize() {

    }

    @FXML
    public void doLogin(){
        String accountText = account.getText();
        String passwordText = password.getText();
        if (StringUtil.isEmpty(accountText)){
            errorInfo.setText("请输入账号！！！");
            errorInfo.setVisible(true);
            return;
        }

        if (StringUtil.isEmpty(passwordText)){
            errorInfo.setText("请输入密码！！！");
            errorInfo.setVisible(true);
            return;
        }

        if ("admin".equals(accountText) && "admin".equals(passwordText)){
            // TODO 进入系统
            Main.changeView("view/main.fxml");
        } else {
            errorInfo.setText("账号/密码错误");
            errorInfo.setVisible(true);
        }
    }
}
