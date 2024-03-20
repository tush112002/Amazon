package com.model;

public class Products {
	private int productId;
	private String productName;
	private String productDescription;
	private float productPrice;
	private String productImage;
	private int categoryId;
	private Categories categories;
	private Cart cart;

	public Products() {

	}
	
	

	public Products(int productId, String productName, String productDescription, float productPrice,
			String productImage) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productImage = productImage;
	}
	
	


	public Products(int productId, String productName, String productDescription, float productPrice,
			String productImage, int categoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.categoryId = categoryId;
	}



	public Products(int productId, String productName, String productDescription, float productPrice,
			String productImage,Categories categories) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.categories = categories;
	}


	public Products(Cart cart, int productId, String productName, float productPrice, String productImage) {
		// TODO Auto-generated constructor stub
		this.cart = cart;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
	}

	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}



	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productImage=" + productImage + "]";
	}

}
