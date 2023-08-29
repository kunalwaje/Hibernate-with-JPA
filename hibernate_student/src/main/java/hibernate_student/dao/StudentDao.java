package hibernate_student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import hibernate_student.dto.Student;

public class StudentDao {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("kunal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveStudent(Student student)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();	
	}
	
	public void fetchStudentById(int id)
	{
		EntityManager entityManager=getEntityManager();
		Student student=entityManager.find(Student.class, id);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Student with given id"+id+" not found");
		}
	}
	
	public void findAll()
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("SELECT s FROM Student s");
		List<Student> list=query.getResultList();
		System.out.println(list);
	}
	public void findByPhone(long phone)
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("SELECT a FROM Student a WHERE a.phone=?1");
		query.setParameter(1, phone);
		try {
			Student student=(Student) query.getSingleResult();
			System.out.println(student);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Student with given phone not found");
		}
	}
	public void updateStudent(int id,Student student)
	{
		EntityManager entityManager=getEntityManager();
		Student dbstudent=entityManager.find(Student.class, id);
		if (dbstudent!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			student.setId(id);
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
			
		} else {
			System.out.println("Id not found");
		}
	}
	public void deleteStudent(int id,Student student)
	{
		EntityManager entityManager=getEntityManager();
		Student dbstudent=entityManager.find(Student.class, id);
		if (dbstudent!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbstudent);
			entityTransaction.commit();
			
		} else {
			System.out.println("ID not found");
		}
		
	}

}
