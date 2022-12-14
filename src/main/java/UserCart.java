public class UserCart {
	protected int cart_id;
	protected int food_id;
	protected String name;
	protected double price;
	protected String description;
	
	public UserCart(int cart_id, int food_id, String name, double price, String description) {
		super();
		this.cart_id = cart_id;
		this.food_id = food_id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}