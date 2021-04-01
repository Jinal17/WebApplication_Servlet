package main.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        
        int[] int_arr = new int[items.length];
        for(int i = 0; i<items.length; i++) {
        	int_arr[i] = Integer.parseInt(items[i]);
        }
        
        int max = 1;
        for(int i = 0; i < int_arr.length; i++ ) {
        	if(max < int_arr[i]) {
    		max = int_arr[i];
        	}
//        	sum += int_arr[i];
        }
        float sum = 0.0f;
        for(int i = 0; i < int_arr.length; i++ )
        	sum+=int_arr[i];
        sum = sum/int_arr.length;
//        
        System.out.println(Arrays.toString(int_arr));
        System.out.println("Max of the array  = " + max);
        
        
//        String password = request.getParameter("password");
//        
////        System.out.println("Student ID: " + studID);
        System.out.println("name: " + name);
        System.out.println("address : " + address);
//        System.out.println("password: " + password);
        
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p><b>Student ID : </b>"+ studID +"</p>");
		out.println("<p><b>Name : </b>"+ name +"</p>");
		out.println("<p><b>Address : </b>"+ address +"</p>");
		out.println("<p><b>city : </b>"+ city +"</p>");
		out.println("<p><b>state : </b>"+ state +"</p>");
		out.println("<p><b>zip : </b>"+ zip +"</p>");
		out.println("<p><b>Phone : </b>"+ telephone +"</p>");
		out.println("<p><b>email : </b>"+ email +"</p>");
		out.println("<p><b>URL : </b>"+ url +"</p>");
		out.println("<p><b>date: </b>"+ date + "</p>");
		out.println("<p><b>Graduation date: </b>"+ g_month +" - "+ g_year + "</p>");
		out.println("<p><b>Things Liked are : </b>"+ liked +"</p>");
		out.println("<p><b>interests : </b>"+ interested +"</p>");
		out.println("<p><b>comments : </b>"+ comments +"</p>");
		out.println("<p><b>recommentdation : </b>"+ recommend +"</p>");
		out.println("<p><b>data : </b>"+ numbers +"</p>");
		out.println("<p><b>Max : </b>"+ max +"</p>");
		out.println("<p><b>Average : </b>"+ sum +"</p>");
		out.println("</body></html>");
		
		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>");
//		out.println("<h3>Hello World</h3>");
//		out.println("</body></html>");
		
		
	}

}
