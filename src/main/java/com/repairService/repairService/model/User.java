package com.repairService.repairService.model;

public class User {

    private String login;
    private String roleDescription;
    private int id;


    public User() {
    }

    public User(String login, String roleDescription, int id) {
        this.login = login;
        this.roleDescription = roleDescription;
        this.id = id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
