
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Save_To_Database
 */
@WebServlet("/ssave")
public class Servlet_Save_To_Database extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Save_To_Database() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String idservlet=request.getParameter("idservlets");
		String id=request.getParameter("sid");
		String name=request.getParameter("sname");
		String course=request.getParameter("scourse");
		String mobile=request.getParameter("smobile");
		String father=request.getParameter("sfname");
		String mother=request.getParameter("smname");
		String qualification=request.getParameter("squalification");
		String dob=request.getParameter("sbirth");
		String joining=request.getParameter("sjoining");
		String submission=request.getParameter("ssubmission");
		String paid=request.getParameter("spaid");
		String fee=request.getParameter("sfee");
		String balance=request.getParameter("sbalance");
		String address=request.getParameter("saddress");
		String description=request.getParameter("sdescription");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","enter");
			String sql="update student_details set id='"+id+"',name='"+name+"',course='"+course+"',mobile='"+mobile+"',fathers_name='"+father+"',mothers_name='"+mother+"',qualification='"+qualification+"',date_of_birth='"+dob+"',date_of_joining='"+joining+"',date_of_submission='"+submission+"',paid="+paid+",fee="+fee+",balance="+balance+",address='"+address+"',description='"+description+"' where id='"+idservlet+"'";
			Statement st=con.createStatement();
			st.executeQuery(sql);
			out.println("Updated");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
