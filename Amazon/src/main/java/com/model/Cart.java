package com.model;

public class Cart {
	private int cartId;
	private int productId;
	private int quantity;
	private Users users;
	
	public Cart() {
		
	}
	
	public Cart(int cartId) {
		super();
		this.cartId = cartId;
	}
	

	public Cart(int cartId, int productId, int quantity) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Cart(int cartId, int productId, int quantity, Users users) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.users = users;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + productId + ", quantity=" + quantity + ", users=" + users
				+ "]";
	}

}
