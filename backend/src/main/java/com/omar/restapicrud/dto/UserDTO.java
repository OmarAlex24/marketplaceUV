package com.omar.restapicrud.dto;

public class UserDTO {
    private String name;
    private String lastName;
    private String carnetNumber;
    private String schoolMail;
    private String password;
    private Long campusId;
    private String clabe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCarnetNumber() {
        return carnetNumber;
    }

    public void setCarnetNumber(String carnetNumber) {
        this.carnetNumber = carnetNumber;
    }

    public String getSchoolMail() {
        return schoolMail;
    }

    public void setSchoolMail(String schoolMail) {
        this.schoolMail = schoolMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }
}
