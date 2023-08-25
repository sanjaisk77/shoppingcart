package shopping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import shopping.dto.Orders;

public class OrderDao {
	
	public boolean saveOrder(Orders order) {
		boolean res=false;
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(order);
		et.commit();
		res=true;
		
		return res;
		
	}
	
	public List<Orders> userOrder(int id){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		return em.createQuery("select o from Orders o").getResultList();
	}
	
	public void cancelOrder(int id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Orders orders=em.find(Orders.class, id);
		et.begin();
		em.remove(orders);
		et.commit();
		
	}
}
