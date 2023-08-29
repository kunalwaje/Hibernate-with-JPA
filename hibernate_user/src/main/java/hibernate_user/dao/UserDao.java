package hibernate_user.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_user.dto.User;

public class UserDao {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("kunal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
	
	public void signupUser(User user)
	{
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();	
	}
	
	public boolean loginUser(String email,String password)
	{
		Query query=entityManager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			User user=(User) query.getSingleResult();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public void displayPasswords(String email)
	{
		Query query=entityManager.createQuery("select u from User u where u.email=?1");
		query.setParameter(1, email);
		User user=(User)query.getSingleResult();
		
		System.out.println("FaceBook :"+user.getFacebook());
		System.out.println("Instagram :"+user.getInstagram());
		System.out.println("Snapchatt :"+user.getSnapchat());
		System.out.println("twitter :"+user.getTwitter());
		System.out.println("Whatsapp :"+user.getWhatsapp());
	}
	
	public void updatePasswords(User user)
	{
		Query query=entityManager.createQuery("select u from User u where u.email=?1");
		query.setParameter(1,user.getEmail());
			User dbuser=(User)query.getSingleResult();
			user.setId(dbuser.getId());
			user.setName(dbuser.getName());
			user.setPhone(dbuser.getPhone());
	
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		
	}

}
