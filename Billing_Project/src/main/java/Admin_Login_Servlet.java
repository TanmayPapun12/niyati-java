
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_Login_Servlet
 */
@WebServlet("/Admin_Login_Servlet")
public class Admin_Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String username=request.getParameter("adminusername");
		String password=request.getParameter("adminpassword");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","enter");
			Statement st=con.createStatement();
			String sql="select * from administrator_details where username='"+username+"' and password='"+password+"'";
			int ctr=st.executeUpdate(sql);
			
			if(ctr>0)
			{
				out.println("<Html> <body>"
						+ "<h4 align='center' style=\"color:blue;\">CONSULTANT:"+username+"</h4>"
						+ "<br><br>"
						+"<form action='searchingAdminservlet' target='down'>"
						+"Branch:"
						+ "<select name = 'Branch' id = 'Branch'>"
						+ "<option>Select Branch</option>"
						+ "<option value='MCA'>MCA</option>"
						+ "<option value='MBA'>MBA</option>"
						+ "<option value='B.Tech'>B.Tech</option>"
						+ "</select><br>"
						+ "Search:<input type='text' name='adminSearching'/>"
						+ "<input type='submit' value='Find'/>"
						+"</form><br><p align='right'><a href='CreateNewAccountant.html'target='down'>Create New Accountant</a></p>"
						+ " </body></Html>");
			}
			else
			{
				request.getRequestDispatcher("other_login.html").include(request, response);
				out.println("Incorrect Credentials");
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
