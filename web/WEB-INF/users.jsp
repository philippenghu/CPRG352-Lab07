

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add User</h1>

        <form action="user" method="post">
            <tr>
                <td>
                    <input type="email" name="email" placeholder="Email" value=""><br>
                </td>    
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="active"  value=""> Active <br>
                </td>    
            </tr>
            <tr>
                <td>
                    <input type="text" name="firstname"  placeholder="First Name" value=""><br>
                </td>    
            </tr>
            <tr>
                <td>
                    <input type="text" name="lastname" placeholder="Last Name" value=""><br>
                </td>    
            </tr>
            <tr>
                <td>
                    <input type="password" name="password" placeholder="Password" value=""><br>
                </td>    
            </tr>
            <tr>
                <td>
                    <select name="role">
                        <option value="1">system admin</option>
                        <option value="2">regular user</option>
                        <option value="3">company admin</option>
                    </select>
                </td>    
            </tr>



            <input type="hidden" name="action" value="save">
            <input type="submit" value="Save">
        </form>
        <div>
            ${message}
        </div>

        <h1>Manage User</h1>

        <table>
            <form action="user" method="post">
                <tr>

                    <th>
                        Active</th>
                    <th>First Name</th>
                    <th>Last Name</th> 
                    <th>Role</th> 
                    <th>Password</th> 
                    <th>Edit</th>
                    <th>Delete</th>    
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>
                            <c:out value = "${user.active}"/>
                        </td>
                        <td>
                            <c:out value = "${user.firstname}"/>
                        </td>
                        <td>
                            <c:out value = "${user.lastname}"/>
                        </td>
                        <td>
                            <c:out value = "${user.roleName}"/>
                        </td>
                        <td>
                            <c:out value = "${user.password}"/>
                        </td>
                        <td>
                            <form  method="post"> 
                                <input type="hidden" name="editUser" value="${user.email}">
                                <input type="submit" value="Edit">
                                <input type="hidden" name="action" value="showEdit">
                            </form>
                        </td>
                        <td>
                            <form action="?action=delete" method="post">
                                
                                <input type="hidden" name="deleteUser" value="${user.email}">
                                <input type="submit" name="action" value="Delete">
                                
                            </form>
                        </td>
                    </tr> 
                </c:forEach>
         
        </table>
        <h1>Edit User</h1>
        <p>${editMessage}</p>
        <form action="?action=update" method="post">


            <tr>
                <td>
                    <c:choose>
                        <c:when test="${editUser.active}">
                            <input type="checkbox" name="activeEdit" value="1" checked>Active
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="activeEdit" value="1">Active
                        </c:otherwise>
                    </c:choose>
                </td>  
            </tr>
            <br>
            <tr>
                <td>
                    <input type="text" name="firstnameEdit" value="${editUser.firstname}"><br>
                </td>    
            </tr>
            <tr>
                <td>
                    <input type="text" name="lastnameEdit" value="${editUser.lastname}"><br>
                </td>    
            </tr>
            <tr>
                <td>
                    <c:if test="${editUser.roleID==1}">
                         <select name="editRole">
                             <option value="1" selected>system admin</option>
                        <option value="2">regular user</option>       
                        <option value="3">company admin</option>
                    </select> 
                    </c:if>
                    <c:if test="${editUser.roleID==2}">
                    <select name="editRole">
                        <option value="1">system admin</option>
                        <option value="2" selected>regular user</option>       
                        <option value="3">company admin</option>
                    </select>
                    </c:if>
                     <c:if test="${editUser.roleID==3}">
                    <select name="editRole">
                        <option value="1">system admin</option>
                        <option value="2">regular user</option>       
                        <option value="3" selected>company admin</option>
                    </select>
                    </c:if>
                </td>    
            </tr>
            <tr>
                <td>
                    <input type="text" name="passwordEdit" value="${editUser.password}"><br>
                </td>    
            </tr>
            <input type="submit" value="Save">
           
          <input type="hidden" name="saveChange" value="${user.email}">
        </form>
             <br> 
               
  <form action="?action=reset"  method="post">
      <input type="submit" value="Cancel">
   <input type="hidden" name="action" value="reset">
  </form>
 </form>
    </body>
</html>
