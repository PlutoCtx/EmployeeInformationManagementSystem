package com.example.entity;

/**
 * EmployeeInformationManagementSystem
 * 员工
 *
 * @author PlutoCtx 15905898514@163.com
 * @version 2024/1/4 15:36
 * @since JDK17
 */

public class Staff {

    private String name;

    private String idCard;


    private String gender;

    private String age;

    private String position;

    private String birthday;

    private String depart;

    private String enterDate;

    public Staff() {
    }

    public Staff(String name,
                 String idCard,
                 String gender,
                 String age,
                 String position,
                 String birthday,
                 String depart,
                 String enterDate) {
        this.name = name;
        this.idCard = idCard;
        this.gender = gender;
        this.age = age;
        this.position = position;
        this.birthday = birthday;
        this.depart = depart;
        this.enterDate = enterDate;
    }

    @Override
    public String toString() {
        return name + ',' +
               idCard + ',' +
                gender + ',' +
                age + ',' +
                position + ',' +
                birthday + ',' +
                depart + ',' +
                enterDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }
}
