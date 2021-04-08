/**
 * 
 */
package main.java.util;

import main.java.bean.DataBean;
import main.java.bean.DataProcessor;
import main.java.bean.StudentBean;
import main.java.dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author jinalshah
 *
 */
public class DataRetriever {

	/**
	 * 
	 */
	public DataRetriever() {
		// TODO Auto-generated constructor stub
	}
	public StudentBean getStudentRecord(String[] studentID) {
		StudentDAO studentDAO = new StudentDAO();
        StudentBean studentBean = studentDAO.retrieveRecord(studentID[0]);
        return studentBean;
	}
	public StudentBean createStudentBean(HttpServletRequest request) {
		RequestParser parser = new RequestParser();
		return parser.parseRequest(request);
	}
	public DataBean createDataBean(String numbers) {
		DataProcessor processor = new DataProcessor(numbers);
		DataBean dataBean = processor.calculate();
		return dataBean;
	}
}
