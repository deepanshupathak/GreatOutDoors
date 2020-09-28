package com.capgemini.go.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.capgemini.go.dto.CartDTO;
import com.capgemini.go.exception.MethodArgumentNotValidException;
import com.capgemini.go.exception.ResourceNotFoundException;
import com.capgemini.go.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	
	
	//***********************Get All items List of a userId Cart************************
	
	
	
	@GetMapping("Customer/cart/{userId}/viewlist")
	
	public List<CartDTO> getAllCartItemsList(@Valid @PathVariable String userId)
	{
		if(cartService.getAllCartItemsList(userId).size()==0)
		{
			throw new ResourceNotFoundException("user not found with id "+userId);
		}
		return cartService.getAllCartItemsList(userId);
		
	}
	

	//***********************Add item into Cart List************************
	
	
	
	
	@RequestMapping(
			  value = "Customer/cart/{userId}/addItem", 
			  produces = "application/json", 
			  method = {RequestMethod.GET, RequestMethod.POST})
	
	public CartDTO addItemIntoCart(@Valid @PathVariable String userId ,@RequestBody CartDTO addThisItem)
	{
		CartDTO addedItem=cartService.addItemIntoCart(userId,addThisItem);
		
		if(addedItem==null)
		{
			throw new ResourceNotFoundException("user not found with id "+userId);
		}
		return addedItem;
		
	}
	
	
	
	
	//***********************Remove item from a Cart List************************
	
	
	@RequestMapping(
			  value = "Customer/cart/{userId}/removeItem/{productId}", 
			  produces = "application/json", 
			  method = {RequestMethod.GET, RequestMethod.DELETE})
	
	public String removeItemfromCart(@Valid @PathVariable String userId,@PathVariable String productId)
	{
		return cartService.removeItemfromCart(userId, productId);
		
	}
}
