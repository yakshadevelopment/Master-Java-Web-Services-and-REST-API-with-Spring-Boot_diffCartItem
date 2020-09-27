package yaksha.jpa.diff_cartitem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
  
	@Id
	@GeneratedValue
	private Long serialNo;
	private Long cartNo;
	private String name;
	private Double price;
	private Double orderQty;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long cartNo, String name, Double price, Double orderQty) {
		super();
		this.cartNo = cartNo;
		this.name = name;
		this.price = price;
		this.orderQty = orderQty;
	}
	public Long getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}
	public Long getCartNo() {
		return cartNo;
	}
	public void setCartNo(Long cartNo) {
		this.cartNo = cartNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(Double orderQty) {
		this.orderQty = orderQty;
	}
	
	
	
}
