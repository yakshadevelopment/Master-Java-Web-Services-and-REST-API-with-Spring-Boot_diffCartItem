package yaksha.jpa.diff_cartitem;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service 
@Transactional
@Component
public class CartService {
	@Autowired
    CartRepository repository;
   
	public void index()
	{
		Product p1=new Product(1L,"Soap",20.00,2.00);
		Product p2=new Product(1L,"Sampoo",120.00,3.00);
		Product p3=new Product(1L,"Snow",50.00,1.00);
		List<Product> prodList=new ArrayList<Product>();
		prodList.add(p1);
		prodList.add(p2);
		prodList.add(p3);
		Cart cart=new Cart(1l,"John",prodList);
		save(cart);
	}
	
	public List<Cart> findAll() {
		return repository.findAll();
	}
	
	public  void save(Cart cart) {
		double total=0.0;
		for(Product product:cart.getProductList())
		{
			total=total+(product.getPrice()*product.getOrderQty());
		}
		cart.setAmountPayable(total);
		repository.save(cart);
	}
	
	public Cart findById(long id) {
		try {
		return repository.findById(id).get();
		}catch(Exception e)
		{
			return null;
		}
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}


}
