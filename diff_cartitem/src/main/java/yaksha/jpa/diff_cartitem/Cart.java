package yaksha.jpa.diff_cartitem;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	private Long id;
	private String customer;
	@OneToMany(targetEntity=Product.class,cascade=CascadeType.ALL)  
	@JoinColumn(name = "cartNo", referencedColumnName="id")
    private List<Product> productList;
	private Double amountPayable;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(Long id, String customer, List<Product> productList, Double amountPayable) {
		super();
		this.id = id;
		this.customer = customer;
		this.productList = productList;
		this.amountPayable = amountPayable;
	}
	
	public Cart(Long id, String customer, List<Product> productList) {
		super();
		this.id = id;
		this.customer = customer;
		this.productList = productList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Double getAmountPayable() {
		return amountPayable;
	}
	public void setAmountPayable(Double amountPayable) {
		this.amountPayable = amountPayable;
	}
}
