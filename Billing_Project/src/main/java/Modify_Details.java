

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Modify_Details
 */
@WebServlet("/modify")
public class Modify_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modify_Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","enter");
			String name=request.getParameter("search");
			String query = "select * from student_details where name like '%"+name+"%'";
			Statement st = con.createStatement();
			ResultSet rs;
			if(name==null)
				rs=st.executeQuery("select * from student_details");
			else
			rs = st.executeQuery(query);
			out.println("<html>"
					+ "<body>"
					+ "<table border='1'>"
					+ "<tr>"
					+ "<th>ID</th>"
					+ "<th>Name</th>"
					+ "<th>Mobile</th>"
					+ "</tr>"
					+ "</table>"
					+ "</body>"
					+ "</html>");
			while(rs.next())
			{
				out.println("<html>"
						+"<body>"
						+"<table border='1'>"
						+"<tr>"
						+"<td><a href='m?idservlet="+rs.getString(1)+"'>"+rs.getString(1)+"</a></td>"
						+"<td>"+rs.getString(2)+"</td>"
						+"<td>"+rs.getString(4)+"</td>"
						+ "</tr>"
						+ "</table>"
						+"</body>"
						+"</html>");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
