

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportUsers
 */
@WebServlet("/ReportUsers")
public class ReportUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public ReportUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		try {
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankura?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			Statement statement=cn.createStatement();
			ResultSet res = statement.executeQuery("select * from users");
		
			writer.println("<html><head><meta charset='utf-8'><title>BankUra</title> </head><body>");
			writer.println("<table>");
			writer.println("<tr><td>UID</td><td>first name</td><td>last name</td><td>patronymic</td></tr>");
	        int threadid=(int)(Math.random()*100);
			while(res.next()) {
	        	writer.println("<tr><td>"+res.getString(1)+"</td><td>"+res.getString(2)+"</td><td>"+res.getString(3)+"</td><td>"+res.getString(4)+"</td></tr>");
	        }
			writer.println("</table>");
			
			System.out.println("Start for "+threadid);
			
			float sum=0;
			for(int j=0;j<40;j++) {
			for(int i=0;i<1000000;i++) {
				sum+=Math.cos(i)*10.0;
			}}
			System.out.println("End for "+threadid);
			
			
			System.out.println(sum);
	        cn.close();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
