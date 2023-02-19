
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateNewAccountant
 */
@WebServlet("/CreateNewAccountant")
public class CreateNewAccountant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAccountant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String username=request.getParameter("arusername");
		String password=request.getParameter("arpassword");
		String joining=request.getParameter("arjoining");
		String birth=request.getParameter("arbirth");
		String salary=request.getParameter("arsalary");
		String sql="insert into accountant_details values('"+username+"','"+password+"','"+joining+"','"+birth+"',"+salary+")";
		out.println("<html><body><form><input type='hidden' name='susername' value='"+username+"'/></form></body></html>");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","enter");
			Statement st=con.createStatement();
			int ctr=st.executeUpdate(sql);
			if(ctr>0)
			{
				request.getRequestDispatcher("AfterAccountantRegistration").include(request, response);
				out.println("Successfully Registered");
			}
			else
				out.println("Sorry!! Please try after sometime");
		}
		catch(Exception e)
		{
			request.getRequestDispatcher("AfterAccountantRegistration").include(request, response);
			out.println("/rInvalid Details Entered");
			out.println(e);
		}
	}

}
