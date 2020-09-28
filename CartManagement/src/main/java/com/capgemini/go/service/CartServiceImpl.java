package com.capgemini.go.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.dao.CartDao;
import com.capgemini.go.dto.CartDTO;
import com.capgemini.go.exception.MethodArgumentNotValidException;
import com.capgemini.go.validation.CartValidation;

@Service
public class CartServiceImpl implements CartService
{

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartValidation cartValidation;
	
	//***********************Get All items List of a userId Cart************************
	
	
	
	@Override
	public List<CartDTO> getAllCartItemsList(String userId) 
	{
		
		 
		 Iterator<CartDTO> allItem=cartDao.findAll().iterator();
		 List items=new ArrayList<CartDTO>();
		 
		 while(allItem.hasNext())
		 {
			 CartDTO cart=allItem.next();
			 if(cart.getUserId().equalsIgnoreCase(userId))
			 {
				 items.add(cart);
			 }
		 }
		
		 return items;
			
	}

	
	//***********************Add item into Cart List************************
	
	
	
	@Override
	public CartDTO addItemIntoCart(String userId,CartDTO addThisItem) 
	{
		
		if(!userId.equalsIgnoreCase(addThisItem.getUserId()))
		{
			throw new MethodArgumentNotValidException("UserId does not match with your Cart id");
		}
		
		if(addThisItem.getProductId().isEmpty())
		{
			throw new MethodArgumentNotValidException("Product Id must not be empty");	
		}
		
		
		  if(!cartValidation.checkQuantityValue(Integer.toString(addThisItem.
		  getQuantity()))) 
		  {
			  throw new MethodArgumentNotValidException("Quantity value is not a numeric"); 
		  }
		 
		
		 Iterator<CartDTO> allItem=cartDao.findAll().iterator();
		
		 while(allItem.hasNext())
		 {
			 CartDTO cart=allItem.next();
			 if(cart.getUserId().equalsIgnoreCase(userId))
			 {
				 return cartDao.save(addThisItem);
			 }
		 }
		 return null;
	}	
	
	
	
	//***********************Remove item from a Cart List************************
	

	@Override
	public String removeItemfromCart(String userId, String productId) 
	{
		 Iterator<CartDTO> allItem=cartDao.findAll().iterator();
		 int matchUserId=0;
		 int matchProductId=0;
		 while(allItem.hasNext())
		 {
			 CartDTO cart=allItem.next();
			 if(cart.getUserId().equalsIgnoreCase(userId))
			 {
				 matchUserId=1;
				 if(cart.getProductId().equalsIgnoreCase(productId))
				 {
					 cartDao.deleteById(cart.getId());
					 matchProductId=1;
				 }
			 }
		 }
		 if(matchUserId==0)
		 {
			 return "UserId not found, please provide valid user Id";
		 }
		 if(matchProductId==0)
		 {
			 return "Product Id not found, please provide valid user Id";
		 }
		 else
		 {
			return "Your Item has successfully removed from your Cart;";
			
		 }
	}
	
}
