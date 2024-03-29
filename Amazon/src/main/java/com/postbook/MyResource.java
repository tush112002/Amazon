package com.postbook;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.model.Cart;
import com.model.Categories;
import com.model.Products;
import com.model.Status;
import com.model.Users;

import dao.CartDAOImpl;
import dao.ProductsDAOImpl;
import dao.UsersDAOImpl;

@Path("amazon")
public class MyResource {

//	<------------------Users url------------------>

	UsersDAOImpl userImpl = new UsersDAOImpl();

	@Path("users/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Status addUser(Users user) throws SQLException {
		return userImpl.signUp(user);
	}

	@Path("users/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Users loginUser(Users user) throws SQLException {
		return userImpl.signIn(user);
	}

	@Path("users/getUser/{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Users getUser(@PathParam("userId") int userId) throws SQLException {
		return userImpl.viewProfile(userId);
	}

	@Path("users/updateUser")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Status updateUser(Users user) throws SQLException {
		return userImpl.updateProfile(user);
	}
	
	
//	@Path("cart/viewcart/{userId}")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Products> viewCart(Cart cart, @PathParam("userId") int userId) throws SQLException {
//	    return carts.viewCart(userId);
//	}

//	<-----------------Products url------------------>

	ProductsDAOImpl productsImpl = new ProductsDAOImpl();
//
//	@Path("tweets/add")
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Status addTweet(Tweets tweet) throws SQLException {
//		return tweetImpl.addNewTweet(tweet);
//	}
//
//	@Path("tweets/myTweet/{id}")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Tweets> getMyTweet(@PathParam("id") int id) throws SQLException {
//		return tweetImpl.viewMyTweet(id);
//	}
//
//	@Path("tweets/deleteTweet/{id}")
//	@DELETE
//	@Produces(MediaType.APPLICATION_JSON)
//	public Status deleteTweet(@PathParam("id") int id) throws SQLException {
//		return tweetImpl.deleteMyTweet(id);
//	}
//
	@Path("products/viewProducts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Products> viewProducts() throws SQLException {
		return productsImpl.viewProducts();
	}
	
	@Path("products/viewYourProducts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Products viewYourProducts(Products products) throws SQLException {
		return productsImpl.viewYourProducts(products);
	}
	
	@Path("products/filterProducts/{categoryId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Products> filterProducts(@PathParam("categoryId") int categoryId) throws SQLException {
		return productsImpl.filterProducts(categoryId);
	}
	
//	@Path("products/filterProducts/")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Products> filterProducts(Categories cat) throws SQLException {
//		return productsImpl.filterProducts(cat);
//	}
	
	CartDAOImpl carts = new CartDAOImpl();
	
	@Path("cart/addtocart")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Status addToCart(Cart cart) throws SQLException {
		return carts.addToCart(cart);
	}
	
	@Path("cart/viewcart/{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Products> viewCart(Cart cart, @PathParam("userId") int userId) throws SQLException {
	    return carts.viewCart(userId);
	}
	
	@Path("cart/deleteProduct/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Status deleteFromCart(@PathParam("id") int id) throws SQLException {
		return carts.deleteFromCart(id);
	}

	
//	
//	@Path("tweets/likes/{id}")
//	@PUT
//	@Produces(MediaType.APPLICATION_JSON)
//	public Likes likeTweet(@PathParam("id") int id) throws SQLException{
//		return tweetImpl.incrementLikes(id);
//	}
//	

}
