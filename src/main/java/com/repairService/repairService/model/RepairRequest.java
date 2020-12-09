package com.repairService.repairService.model;

import java.util.Date;

public class RepairRequest {
    private int userId;
    private String userLogin;
    private String description;
    private Date date;
    private int statusId;
    private String statusDescription;

    public RepairRequest() {
    }

    public RepairRequest(int user_id, String userLogin, String description, Date date, int statusId, String statusDescription) {
        this.userId = user_id;
        this.userLogin = userLogin;
        this.description = description;
        this.date = date;
        this.statusId = statusId;
        this.statusDescription = statusDescription;
    }

    public int getUser_id() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
