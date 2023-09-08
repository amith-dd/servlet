package studentdetails.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentdetails.dao.StudentDao;
import studentdetails.dto.Student;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id= Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String dept= req.getParameter("dept");
		long contact = Long.parseLong(req.getParameter("contact"));
		String city = req.getParameter("city");
		String pass = req.getParameter("pass");
		
		
		Student stu = new Student();
		stu.setCity(city);
		stu.setContact(contact);
		stu.setDept(dept);
		stu.setId(id);
		stu.setName(name);
		stu.setPass(pass);
		
		StudentDao dao = new StudentDao();
		
		try {
			int result = dao.saveStudent(stu);
			if(result==1) {
				req.setAttribute("name",name);
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
				dispatcher.include(req, resp);
			}	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
