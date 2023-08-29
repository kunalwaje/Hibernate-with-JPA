package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeInsert {
	public static void main(String[] args) {
		Employee employee=new Employee();
		System.out.println("Enter ID");
		System.out.println("Enter Name");
		System.out.println("Enter Email");
		System.out.println("Enter Password");
		System.out.println("Enter Phone");
		
		employee.setId(101);
		employee.setName("Dell");
		employee.setEmail("Dell@gmail.com");
		employee.setPassword("12345");
		employee.setPhone(9657708101l);
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("kunal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}

}
	