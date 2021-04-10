package main.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import main.java.bean.DataBean;
import main.java.bean.DataProcessor;
import main.java.bean.StudentBean;
import main.java.dao.StudentDAO;
import main.java.util.DataRetriever;


/**
 * Servlet Controller : Handles doGet and doPost requests raised by the html & JSP pages. 
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
	}
	
	// This resolves the no driver found exception
	static{
	    try {
	        Class.forName ("oracle.jdbc.OracleDriver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("enter get method");
		String[] studentID = request.getParameterValues("param");
        DataRetriever dataRetriever = new DataRetriever();
        try {
        	StudentBean studentBean = dataRetriever.getStudentRecord(studentID);
            HttpSession session = request.getSession();
            session.setAttribute("studentRecord", studentBean);
            request.setAttribute("studentRecord", studentBean);
            String address;
            if (studentBean != null) { //If student details found
                 address = "/WEB-INF/Student.jsp"; // TODO
            } else {
                 address = "/WEB-INF/NoSuchStudent.jsp"; // TODO
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataRetriever dataRetriever = new DataRetriever();
		StudentBean student = dataRetriever.createStudentBean(request);
		String numbers = request.getParameter("numbers");
		
		DataBean dataBean = dataRetriever.createDataBean(numbers);
		List<String> studentIds = new ArrayList<>();
		try {
			StudentDAO obj = new StudentDAO();
			studentIds = obj.registerStudent(student); // register student and retrieve all registered student Ids
		} catch (Exception e) {
			System.out.println("data base error" + e.getMessage());
		}
		
		HttpSession session = request.getSession();
        session.setAttribute("dataBean", dataBean);
		request.setAttribute("dataBean", dataBean);
		request.setAttribute("studentIds", studentIds);
		
		if(dataBean.getMean() < 90 ) {
			RequestDispatcher dispatcher =
			request.getRequestDispatcher("/WEB-INF/SimpleAcknowledgement.jsp");
			dispatcher.forward(request, response);
		}else if (dataBean.getMean() >= 90) {
			RequestDispatcher dispatcher =
			request.getRequestDispatcher("/WEB-INF/WinnerAcknowledgement.jsp");
			dispatcher.forward(request, response);
		}
				
		
	}

}
