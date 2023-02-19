

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfterAccountantRegistration
 */
@WebServlet("/AfterAccountantRegistration")
public class AfterAccountantRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfterAccountantRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String username=request.getParameter("susername");
		try
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
		catch(Exception e)
		{
			out.println(e);
		}

	}

}
