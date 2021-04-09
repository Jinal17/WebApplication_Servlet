package main.java.util;

import main.java.bean.StudentBean;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Parses every input elements from the student survey form and sets it to the StudentBean
 * @author jinalshah
 *
 */
public class RequestParser {

	// Default Constructor
	public RequestParser() {
		
	}
	/**
	 * Parse request and creates studentbean
	 * @param request
	 * @return
	 */
	public StudentBean parseRequest(HttpServletRequest request) {
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

		return new StudentBean(studID, name, address, city, state, zip, telephone, email, url,
				// date
				g_month, g_year, liked, interested, comments, recommend);
	}

}
