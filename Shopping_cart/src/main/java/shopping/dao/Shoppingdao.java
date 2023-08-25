package shopping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import shopping.dto.User;



public class Shoppingdao {
	
	public void saveUser(User user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();
	}
	public User getByEmail(String email) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select u from User u where u.email=?1");
		query.setParameter(1, email);
		return (User) query.getSingleResult();
		
		
	}

}
