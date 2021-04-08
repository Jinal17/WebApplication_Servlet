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


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		// TODO Auto-generated method stub
		System.out.print("enter get method");
		String[] studentID = request.getParameterValues("param");
        StudentDAO studentDAO = new StudentDAO();
        StudentBean studentBean = studentDAO.retrieveRecord(studentID[0]);
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		String studID = request.getParameter("studID");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String url = request.getParameter("url");
		String date = request.getParameter("date");
		String g_month = request.getParameter("graduation");
		String g_year = request.getParameter("gdate");
		String[] thingsLiked = request.getParameterValues("thingsLiked");
		String liked = "";

		if (thingsLiked != null) {
			System.out.println("things liked are: ");
			for (String k : thingsLiked) {
				liked += k + ",";
				System.out.println("\t" + k);
			}
		}
		String interested = request.getParameter("interested");
		String comments = request.getParameter("comments");
		String recommend = request.getParameter("recommend");
		String numbers = request.getParameter("numbers");
		String[] items = numbers.split(",");

		StudentBean student = new StudentBean(studID, name, address, city, state, zip, telephone, email, url,
				// date
				g_month, g_year, liked, interested, comments, recommend);

		int[] int_arr = new int[items.length];
		for (int i = 0; i < items.length; i++) {
			int_arr[i] = Integer.parseInt(items[i]);
		}

		int max = 1;
		for (int i = 0; i < int_arr.length; i++) {
			if (max < int_arr[i]) {
				max = int_arr[i];
			}
		}
		float sum = 0.0f;
		for (int i = 0; i < int_arr.length; i++)
			sum += int_arr[i];
		sum = sum / int_arr.length;
//        
		System.out.println(Arrays.toString(int_arr));
		System.out.println("Max of the array  = " + max);

		System.out.println("name: " + name);
		System.out.println("address : " + address);

		DataProcessor processor = new DataProcessor(numbers);
		DataBean dataBean = processor.calculate();
		List<String> studentIds = new ArrayList<>();
		try {
			StudentDAO obj = new StudentDAO();
			obj.registerStudent(student);
			studentIds = obj.retrieve();
		} catch (Exception e) {
			System.out.println("data base error " + e.getMessage());
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
