package com.repairService.repairService.model;

public class User {

    private String login;
    private String roleDescription;


    public User() {
    }

    public User(String login, String roleDescription) {
        this.login = login;
        this.roleDescription = roleDescription;
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


}
