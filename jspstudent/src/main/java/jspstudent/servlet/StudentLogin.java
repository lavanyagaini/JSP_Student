package jspstudent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspstudent.dao.StudentDao;
import jspstudent.dto.Student;

@WebServlet("/login")
public class StudentLogin extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String email=req.getParameter("email");
String password=req.getParameter("password");

StudentDao dao=new StudentDao();
List<Student> students=dao.getAllStudents();
boolean value=false;
for(Student student:students) {
	if(student.getStudentPassword().equals(password)) {
		value=true;
		break;
	}
}
if(value==false) {
//	email is not present
	req.setAttribute("message1", "INCORRECTEMAIL");
	RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
	dispatcher.include(req, resp);
	
}else {
//	email is present
	Student student=dao.getStudentByEmail(email);
	if(student.getStudentPassword().equals(password)) {
		req.setAttribute("list", students);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
	}
	else {
		req.setAttribute("message", "INCORRECT PASSWORD");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
	}
}

}
}
