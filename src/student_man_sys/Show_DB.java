/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_man_sys;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isaac
 */
public class Show_DB {

    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    String url = "jdbc:mysql://localhost:3306/addstudent";
    String user = "isaac";
    String regDriver = "com.mysql.cj.jdbc.Driver";
    String pass = "isaac";

    public Show_DB(DefaultTableModel defaultTableModel) {
        try {
            Class.forName(regDriver);
            connection = DriverManager.getConnection(url, user, pass);
            String query = "Select * from studentdetails";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            int resultCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {

                Vector vector = new Vector();
                for (int i = 0; i < resultCount; i++) {
                    vector.add(resultSet.getString("Id"));
                    vector.add(resultSet.getString("StudentID"));
                    vector.add(resultSet.getString("Firstname"));
                    vector.add(resultSet.getString("Lastname"));
                    vector.add(resultSet.getString("Programme"));
                    vector.add(resultSet.getString("Gender"));
                }
                defaultTableModel.addRow(vector);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Show_DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Show_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

