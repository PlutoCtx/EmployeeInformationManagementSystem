package com.example.controller;

import com.example.entity.Staff;
import com.example.utils.FileUtil;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * EmployeeInformationManagementSystem
 *
 * @author PlutoCtx 15905898514@163.com
 * @version 2024/1/4 16:20
 * @since JDK17
 */

public class StaffAddController {

    @FXML
    private TextField name;

    @FXML
    private TextField idCard;

    @FXML
    private ChoiceBox<String> gender;

    @FXML
    private TextField age;

    @FXML
    private TextField position;

    @FXML
    private DatePicker birthday;

    @FXML
    private TextField depart;

    @FXML
    private DatePicker enterDate;


    @FXML
    public void initialize(){
        gender.getItems().clear();
        gender.getItems().addAll("男", "女");
    }


    @FXML
    public void addDataToFile(){
        Staff staff = new Staff(name.getText(),
                idCard.getText(),
                gender.getValue(),
                age.getText(),
                position.getText(),
                birthday.getEditor().getText(),
                depart.getText(),
                enterDate.getEditor().getText());
        FileUtil.addData(staff);

    }











}
