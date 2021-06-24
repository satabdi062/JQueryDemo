package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
@WebServlet(urlPatterns = "/GetUserServlet")
public class MyController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String userEmail=req.getParameter("userEmail");
		Student s1=new Student();
		s1.setEmail(userEmail);
		try {
			boolean res=s1.checkEmail();
			if(res)
			{
				out.println("email is already register");
			}
			else {
				out.println("email is available");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("hello "+userEmail);
	}

}
