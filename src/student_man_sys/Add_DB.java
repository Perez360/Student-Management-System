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

public class Add_DB {

    public Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    String url;
    String user;
    String regDriver;
    String pass;

    public Add_DB(String studentID, String first, String last, String prog, String gender, Add_Students add_Student) {
        this.pass = "isaac";
        this.user = "isaac";
        this.regDriver = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/addstudent";

        try {
            Class.forName(regDriver);
            connection = DriverManager.getConnection(url, user, pass);

            String query = "insert into studentdetails (StudentID,Firstname,Lastname,Programme,Gender)values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, studentID);
            preparedStatement.setString(2, first);
            preparedStatement.setString(3, last);
            preparedStatement.setString(4, prog);
            preparedStatement.setString(5, gender);
            if (preparedStatement.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(add_Student,  "Student successfully added","Suucess", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(add_Student, "Failed to add student","Error",  JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Add_DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Add_DB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
