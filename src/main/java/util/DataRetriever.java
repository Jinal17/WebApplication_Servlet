package main.java.util;

import main.java.bean.DataBean;
import main.java.bean.DataProcessor;
import main.java.bean.StudentBean;
import main.java.dao.StudentDAO;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * DataRetriever : Creates objects of StudentBean and DataBean class.
 * @author jinalshah
 *
 */
public class DataRetriever {

	/**
	 * Constructor
	 */
	public DataRetriever() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Creates studentbean based on the output from database for given studentId
	 * @param studentID
	 * @return
	 */
	public StudentBean getStudentRecord(String[] studentID) throws SQLException {
		StudentDAO studentDAO = new StudentDAO();
        StudentBean studentBean = studentDAO.retrieveRecord(studentID[0]);
        return studentBean;
	}
	/**
	 * Creates studentbean after parsing input request
	 * @param request
	 * @return
	 */
	public StudentBean createStudentBean(HttpServletRequest request) {
		RequestParser parser = new RequestParser();
		return parser.parseRequest(request);
	}
	/**
	 * Creates databean after calculating mean & std deviation
	 * @param numbers
	 * @return
	 */
	public DataBean createDataBean(String numbers) {
		DataProcessor processor = new DataProcessor(numbers);
		DataBean dataBean = processor.calculate();
		return dataBean;
	}
}
