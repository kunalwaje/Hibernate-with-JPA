package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeUpdate {
	public static void main(String[] args) {
//		 Employee employee = new Employee();
//		 employee.setId(101);
//		 employee.setEmail("kunalwaje28@gmail.com");
//		 employee.setPassword("kunal007");
//		 employee.setPhone(9284676889l);
//		 employee.setName("Kunaal");
//		 
//		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("kunal");
//		 EntityManager entityManager=entityManagerFactory.createEntityManager();
//		 EntityTransaction entityTransaction= entityManager.getTransaction();
//		 
//		 entityTransaction.begin();
//		 entityManager.merge(employee); //it is polymorphic in nature and it is always depend on primary key if the primary key is already present its act like update. if the primary key is not available its act like insert query.
//		 entityTransaction.commit();
		 
		 
		 //To update specific data
		 
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("kunal");
		 EntityManager entityManager=entityManagerFactory.createEntityManager();
		 
		 Employee employee= entityManager.find(Employee.class, 101);
		 if (employee !=null) {
			//employee.setPhone(9657708101l);
			employee.setName("Kunal");
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
		} else {
			System.out.println("ID not found");
		}
	}

}
