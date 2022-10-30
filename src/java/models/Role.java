/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Hu Peng
 */
public class Role {
    private int roleID;
     private String roleName;

    public Role() {
    }

    public Role(int roleID, String roleName) {
        this.roleID= roleID;
        this.roleName = roleName;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleID() {
        return roleID;
    }

    public String getRoleName() {
        return roleName;
    }
     
   
}
