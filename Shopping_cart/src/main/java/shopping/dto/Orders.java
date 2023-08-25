package shopping.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private int productId;
	private int uId;
	private int quanity;
	private String date;
	
	public Orders() {
	}

	public Orders(int orderId, int productId, int uId, int quanity, String date) {
		
		this.orderId = orderId;
		this.productId = productId;
		this.uId = uId;
		this.quanity = quanity;
		this.date = date;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", productId=" + productId + ", uId=" + uId + ", quanity=" + quanity
				+ ", date=" + date + "]";
	}
	

}