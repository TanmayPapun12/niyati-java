
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Recieve_Value_To_Html_Page
 */
@WebServlet("/m")
public class Recieve_Value_To_Html_Page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recieve_Value_To_Html_Page() {
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
			Statement st=con.createStatement();
			String idservlet=request.getParameter("idservlet");
			String sql="select * from student_details where id='"+idservlet+"'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
			out.println("<html><body>"
					+ "<p style='color:blue' >Student Detail:</p>"
					+ "<form action='ssave'>"
					+"<input type='hidden' value='"+idservlet+"' name='idservlets' required/>"
					+ "<table>"
					+ "<tr>"
					+ "	<td>ID:</td>"
					+ "	<td><input type='text' name='sid' value='"+rs.getString(1)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Name:</td>"
					+ "	<td><input type='text' name='sname' value='"+rs.getString(2)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Course:</td>"
					+ "	<td><input type='text' name='scourse' value='"+rs.getString(3)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Mobile:</td>"
					+ "	<td><input type='text' name='smobile' value='"+rs.getString(4)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Father's Name:</td>"
					+ "	<td><input type='text' name='sfname' value='"+rs.getString(5)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Mother's Name:</td>"
					+ "	<td><input type='text' name='smname' value='"+rs.getString(6)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Qualification:</td>"
					+ "	<td><input type='text' name='squalification' value='"+rs.getString(7)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Date of Birth:</td>"
					+ "	<td><input type='text' name='sbirth' value='"+rs.getString(8)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Date of Joining:</td>"
					+ "	<td><input type='text' name='sjoining' value='"+rs.getString(9)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Date of Submission:</td>"
					+ "	<td><input type='text' name='ssubmission' value='"+rs.getString(10)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Paid:</td>"
					+ "	<td><input type='text' name='spaid' value='"+rs.getInt(11)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Fee:</td>"
					+ "	<td><input type='text' name='sfee' value='"+rs.getInt(12)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Balance:</td>"
					+ "	<td><input type='text' name='sbalance' value='"+rs.getInt(13)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Address:</td>"
					+ "	<td><input type='text' name='saddress' value='"+rs.getString(14)+"' required/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "	<td>Description:</td>"
					+ "	<td><input type='text' name='sdescription' value='"+rs.getString(15)+"' required/><br></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td><input type='Submit' value='Save'/></td>"
					+ "</tr>"
					+ "</table>"
					+ "</form>"
					+ "</body></html>");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
