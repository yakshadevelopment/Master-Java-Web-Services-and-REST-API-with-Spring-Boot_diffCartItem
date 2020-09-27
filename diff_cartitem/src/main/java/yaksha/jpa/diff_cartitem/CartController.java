package yaksha.jpa.diff_cartitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CartController {
 @Autowired
 CartService service;
 
 @GetMapping(path="/index",produces= MediaType.APPLICATION_JSON_VALUE)
 public String index(){
	 service.index();
	 return "App started";
 }
 @GetMapping(path="/cart-json/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Cart showCartJsnon(@PathVariable int id){
		Cart cart=service.findById(id);
		if(cart==null)
			throw new CartNotFoundException("Wrong cart Id");
			return cart;
	}
 @GetMapping(path="/cart-xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public Cart showCartXml(@PathVariable int id){
		Cart cart=service.findById(id);
		if(cart==null)
			throw new CartNotFoundException("Wrong cart Id");
			return cart;
	}
 @PostMapping(path="/add-cart",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public String addUpdateCourse(@RequestBody Cart cart){
		service.save(cart);
		return "Cart Added/Modified Successfully";
	}
	@GetMapping(path="/carts-json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cart> showCourseJson(){
		 return service.findAll();
	}
	@GetMapping(path="/carts-xml", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Cart> showCourseXml(){
		 return service.findAll();
	}
	@GetMapping(path="/delete-cart/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCourse(@PathVariable int id){
		Cart cart=service.findById(id);
		if(cart==null)
			throw new CartNotFoundException("Wrong cart Id");
		else{
			service.delete(id);
			return "Cart removed successfully";
		}
	}	
}