
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class New_Registration_Database_Connectivity
 */
@WebServlet("/save")
public class New_Registration_Database_Connectivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New_Registration_Database_Connectivity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String course=request.getParameter("course");
		String mobile=request.getParameter("mobile");
		String father=request.getParameter("fname");
		String mother=request.getParameter("mname");
		String qualification=request.getParameter("qualification");
		String dob=request.getParameter("birth");
		String joining=request.getParameter("joining");
		String submission=request.getParameter("submission");
		String paid=request.getParameter("paid");
		String fee=request.getParameter("fee");
		String balance=request.getParameter("balance");
		String address=request.getParameter("address");
		String description=request.getParameter("description");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","enter");
			String sql="insert into student_details values('"+id+"','"+name+"','"+course+"','"+mobile+"','"+father+"','"+mother+"','"+qualification+"','"+dob+"','"+joining+"','"+submission+"',"+paid+","+fee+","+balance+",'"+address+"','"+description+"')";
			Statement st=con.createStatement();
			int ctr=st.executeUpdate(sql);
			if(ctr>0)
				out.println("Connected");
			else
				out.println("Not connected");
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	}

}
