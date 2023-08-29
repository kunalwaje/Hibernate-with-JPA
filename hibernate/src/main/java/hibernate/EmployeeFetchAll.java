package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

//import antlr.collections.List;

//import com.mysql.cj.Query;

public class EmployeeFetchAll {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("kunal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select e from Employee e");
		List<Employee> list=query.getResultList();
		
		System.out.println(list);
		
		
		
	}

}
