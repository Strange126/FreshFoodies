public class Order {
	protected int order_id;
	protected int order_user_id;
	protected int order_food_id;
	protected String address;
	protected int timestamp;
	protected String status;
	
	public Order(int order_id, int order_user_id, int order_food_id, String address, int timestamp, String status) {
		super();
		this.order_id = order_id;
		this.order_user_id = order_user_id;
		this.order_food_id = order_food_id;
		this.address = address;
		this.timestamp = timestamp;
		this.status = status;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getOrder_user_id() {
		return order_user_id;
	}
	public void setOrder_user_id(int order_user_id) {
		this.order_user_id = order_user_id;
	}
	public int getOrder_food_id() {
		return order_food_id;
	}
	public void setOrder_food_id(int order_food_id) {
		this.order_food_id = order_food_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
