/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import java.util.ArrayList;
import java.util.List;
import models.Role;

/**
 *
 * @author Hu Peng
 */
public class RoleService {

    public ArrayList<Role> getAll(int roleID) throws Exception {
        RoleDB roleDB = new RoleDB();
        ArrayList<Role> roles = roleDB.getAll(roleID);
        return roles;
    }

    public String getRoleName(int roleID) throws Exception {
        RoleDB roleDB = new RoleDB();
        String roleName = roleDB.getRoleName(roleID);   
        return roleName;
    }

}
