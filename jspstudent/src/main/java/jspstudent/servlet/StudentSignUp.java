package jspstudent.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspstudent.dao.StudentDao;
import jspstudent.dto.Student;

public class StudentSignUp extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
int id=Integer.parseInt(req.getParameter("id"));
String name=req.getParameter("name");
String email=req.getParameter("email");
String password=req.getParameter("password");
String address=req.getParameter("address");
long phone=Long.parseLong(req.getParameter("phone"));

ServletContext context=getServletContext();
String feesss=context.getInitParameter("fees");
double fees=Double.parseDouble(feesss);

StudentDao dao=new StudentDao();
List<Student> students=dao.getAllStudents();

boolean value=false;
for(Student student:students) {
	if(student.getStudentEmail().equals(email)) {
		value=true;
		break;
	}
}

// email is not present already means value=false;
//email is present means value=true;
if(value==false) {
//email is not present so i can insert a student object into the database;

Student student=new Student();
student.setStudentId(id);
student.setFees(fees);
student.setPhone(phone);
student.setStudentAddress(address);
student.setStudentEmail(email);
student.setStudentName(name);
student.setStudentPassword(password);

Student dbStudent=dao.saveStudent(student);
	req.setAttribute("message", "SIGNEDINSUCCESSFULLY");
	RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
	dispatcher.forward(req, resp);


}else {
	req.setAttribute("message", "SORRY EMAIL ALREADY EXIST");
	RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
	dispatcher.include(req, resp);
}
}
}
