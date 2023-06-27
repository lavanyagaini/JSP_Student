package jspstudent.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jspstudent.dto.Student;

public class StudentDao {
public EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory("Lavanya").createEntityManager();
}

public Student saveStudent(Student student) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.merge(student);
	entityTransaction.commit();
	return student;
}
public List<Student> getAllStudents(){
	EntityManager  entityManager=getEntityManager();
    Query query=entityManager.createQuery("select a from Student a");
    List<Student> list=query.getResultList();
    return list;
	
}

public Student getStudentByEmail(String email) {
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select a from Student a where a.studentEmail=?1");
	query.setParameter(1, email);
	Student student=(Student)query.getSingleResult();
	return student;
}


public Student deleteStudentById(int id) {
EntityManager entityManager=getEntityManager();
Student student=entityManager.find(Student.class, id);
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.remove(student);
	entityTransaction.commit();
	return student;
}

public Student getStudentById(int id) {
EntityManager entityManager=getEntityManager();
Student student=entityManager.find(Student.class, id);
	return student;
}


public Student updateStudent(int id,Student student)
	
	{
		EntityManager manager=getEntityManager();
		Student studentdb =manager.find(Student.class, id);
		if(studentdb!=null)
		{
			EntityTransaction transaction=manager.getTransaction();
			studentdb.setStudentAddress(student.getStudentAddress());
			studentdb.setFees(student.getFees());
			studentdb.setPhone(student.getPhone());
			studentdb.setStudentEmail(student.getStudentEmail());
			studentdb.setStudentName(student.getStudentName());
			studentdb.setStudentPassword(student.getStudentPassword());
			
			transaction.begin();
			manager.merge(studentdb);
			transaction.commit();
			return studentdb;
			
		}
		return null;
	}
	

}
