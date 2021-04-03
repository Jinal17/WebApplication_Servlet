/**
 * 
 */
package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.java.bean.StudentBean;


/**
 * @author jinalshah
 *
 */
public class StudentDAO {

	public int registerStudent(StudentBean student) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO StudentForm" +
            "  (studentId,  username, streetAddress, city, state, zipCode, phoneNo, email, url, hsGradMonth, hsGradYear, likedMost, interested, comments, recommend) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int result = 0;

        Class.forName("oracle.jdbc.driver.OracleDriver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","jshah21","abeckoab");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
        	preparedStatement.setString(1, student.getStudentId());
        	preparedStatement.setString(2, student.getUsername());
        	preparedStatement.setString(3, student.getStreetAddress());
        	preparedStatement.setString(4, student.getCity());
        	preparedStatement.setString(5, student.getState());
        	preparedStatement.setString(6, student.getZipCode());
        	preparedStatement.setString(7, student.getPhoneNo());
        	preparedStatement.setString(8, student.getEmail());
        	preparedStatement.setString(9, student.getUrl());
        	preparedStatement.setString(10, student.getHsGradMonth());
        	preparedStatement.setString(11, student.getHsGradYear());
        	preparedStatement.setString(12, student.getLikedMost());
        	preparedStatement.setString(13, student.getInterested());
        	preparedStatement.setString(14, student.getComments());
        	preparedStatement.setString(15, student.getRecommend());


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    public static void main(String[] arg) throws Exception{
    	StudentBean student = new StudentBean("12345","jinal", "42287 impervious ter", "ashburn", "va", "20148", "317-992-7764", "jinal17@gmail.com", "www.sivyati.com", 
    			"February", "2020", "Students", "Internet", "Comments are Comments", "likely");
    	StudentDAO obj = new StudentDAO();
    	obj.registerStudent(student);
    	
    }
}
