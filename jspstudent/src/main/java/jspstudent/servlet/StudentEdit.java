package jspstudent.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspstudent.dao.StudentDao;
import jspstudent.dto.Student;

//@WebServlet("/edit")
public class StudentEdit extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		ServletContext context=getServletContext();
		String StringFees=context.getInitParameter("fees");
		double fees=Double.parseDouble(StringFees);
		
		Student student=new Student();
		student.setFees(fees);
		student.setPhone(phone);
		student.setStudentAddress(address);
		student.setStudentEmail(email);
		student.setStudentName(name);
		student.setStudentPassword(password);
		
		StudentDao dao=new StudentDao();
		Student student1=dao.updateStudent(id,student);
		

		List<Student> students=dao.getAllStudents();
		req.setAttribute("list", students);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
	}
}