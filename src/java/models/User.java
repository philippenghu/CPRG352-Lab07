/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import services.RoleService;

/**
 *
 * @author Hu Peng
 */
public class User {

    private String email;
    private boolean active;
    private String firstname;
    private String lastname;
    private String password;
    private int roleID;
    private String roleName;
    public User() {
    }

    public User(String email, boolean active, String firstname, String lastname, String password, int roleID, String roleName) {
        this.email = email;
        this.active = active;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.roleID = roleID;
        this.roleName=roleName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

}
