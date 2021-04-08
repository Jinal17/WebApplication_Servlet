/**
 * 
 */
package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import main.java.bean.StudentBean;

/**
 * @author jinalshah
 *
 */
public class StudentDAO extends ConnectionUtil{
	
	public StudentDAO() {
		super();
	}
	public int registerStudent(StudentBean student) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO StudentForm"
				+ "  (studentId,  username, streetAddress, city, state, zipCode, phoneNo, email, url, hsGradMonth, hsGradYear, likedMost, interested, comments, recommend) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		int result = 0;

		try (

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
		for (Throwable e : ex) {
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
	
	public List<String> retrieve() {

		List<String> result = new ArrayList<>();
		try {
			Statement selectStmt = connection.createStatement();
			ResultSet rs = selectStmt.executeQuery("select * from StudentForm");

			while (rs.next()) {
				result.add(rs.getString(1));
			}
		} catch (SQLException e) { // process sql exception
			e.printStackTrace();
		}
		return result;
	}

	public StudentBean retrieveRecord(String studentId) {

		StudentBean result = null;
		try {
			String selectTableSql = "select * from StudentForm where studentId = " + "'" + studentId + "'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(selectTableSql);

			while (rs.next()) {
				StudentBean studentBean = new StudentBean(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15));
				result = studentBean;
				break;
			}
		} catch (SQLException e) { // process sql exception
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] arg) throws Exception {
		StudentBean student = new StudentBean("12345", "jinal", "42287 impervious ter", "ashburn", "va", "20148",
				"317-992-7764", "jinal17@gmail.com", "www.sivyati.com", "February", "2020", "Students", "Internet",
				"Comments are Comments", "likely");
		StudentDAO obj = new StudentDAO();
    	obj.registerStudent(student);

		System.out.println("Display student records");
		List<String> res = obj.retrieve();
		for (String studentId: res)
			System.out.println(studentId);
	}
}
