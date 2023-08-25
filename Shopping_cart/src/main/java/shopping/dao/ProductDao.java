package shopping.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import shopping.dto.Cart;
import shopping.dto.Product;

public class ProductDao {

	public List<Product> getAllProduct() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		return em.createQuery("select p from Product p").getResultList();
	}

	public List<Cart> getCartProduct(ArrayList<Cart> cartList) {
		List<Cart> products = new ArrayList<Cart>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		if (cartList.size() > 0) {
			for (Cart cart : cartList) {
				Cart c = new Cart();
				Query query = em.createQuery("select p from Product p where p.id=?1");
				query.setParameter(1, cart.getId());
				Product p=(Product) query.getSingleResult();
				c.setCategory(p.getCategory());
				c.setName(p.getName());
				c.setPrice(p.getPrice() * cart.getQuntity());
				c.setId(p.getId());
				c.setQuntity(cart.getQuntity());
				products.add(c);

			}
		}

		return products;

	}
	
	public double getTotalCartPrice(ArrayList<Cart> cartList ) {
		double sum=0;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		if (cartList.size() > 0) {
			for (Cart cart : cartList) {
				Query query = em.createQuery("select p.price from Product p where p.id=?1");
				query.setParameter(1, cart.getId());
				double price =(double) query.getSingleResult();
				sum+=price*cart.getQuntity();

			}
		}
		
		
		return sum;
	}
	
	public Product getProduct(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		Product product=em.find(Product.class, id);
		return product;
	}

}
