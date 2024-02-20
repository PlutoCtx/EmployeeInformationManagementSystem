package com.example.controller;

import com.example.Main;
import com.example.entity.Staff;
import com.example.utils.FileUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

/**
 * EmployeeInformationManagementSystem
 *
 * @author PlutoCtx ctx195467@163.com
 * @version 2024/1/4 12:04
 * @since JDK17
 */

public class MainController {

    @FXML
    private TableView tableView;

    @FXML
    TableColumn<Staff, String> name;

    @FXML
    TableColumn<Staff, String> idCard;

    @FXML
    TableColumn<Staff, String> gender;

    @FXML
    TableColumn<Staff, String> age;

    @FXML
    TableColumn<Staff, String> position;

    @FXML
    TableColumn<Staff, String> birthday;

    @FXML
    TableColumn<Staff, String> depart;

    @FXML
    TableColumn<Staff, String> enterDate;

    @FXML
    public void initialize() {
        getData();

    }

    private void getData(){
        List<Staff> staff = FileUtil.readData();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        idCard.setCellValueFactory(new PropertyValueFactory<>("idCard"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        position.setCellValueFactory(new PropertyValueFactory<>("position"));
        birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        depart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        enterDate.setCellValueFactory(new PropertyValueFactory<>("enterDate"));

        tableView.setItems(FXCollections.observableList(staff));
    }

    @FXML
    public void showAddView() {
        Main.addView("view/staff-add.fxml");
    }

    @FXML
    public void showUpdate(){
        Staff staff = (Staff) tableView.getSelectionModel().getSelectedItem();
        if (staff != null) {
            StaffUpdateController.setCurrent(staff);
            Main.addView("view/staff-update.fxml");
        }
    }

    @FXML
    public void doDelete(){
        Staff staff = (Staff) tableView.getSelectionModel().getSelectedItem();
        if (staff != null) {
            FileUtil.deleteData(staff.getIdCard());
            getData();
        }
    }

    @FXML
    public void refresh(){
        getData();
    }
}
