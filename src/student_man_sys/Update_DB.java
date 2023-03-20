/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_man_sys;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Update_DB {

    public Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    String url;
    String user;
    String regDriver;
    String pass;

    public Update_DB(String studentID, String first, String last, String prog, String gender, Update_Students update_Students) {
        this.pass = "isaac";
        this.user = "isaac";
        this.regDriver = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/addstudent";

        try {
            Class.forName(regDriver);
            connection = DriverManager.getConnection(url, user, pass);

            String query = "update studentdetails set Firstname=?,Lastname=?,Programme=?,Gender=?  where StudentID=?";
            preparedStatement = connection.prepareStatement(query);

           
            preparedStatement.setString(1, first);
            preparedStatement.setString(2, last);
            preparedStatement.setString(3, prog);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, studentID);
            if (preparedStatement.executeUpdate()==1) {
                JOptionPane.showMessageDialog(update_Students,  "Student successfully updated","Suucess", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(update_Students,"The Student ID is invalid",  "Error", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Update_DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Update_DB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
