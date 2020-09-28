package com.capgemini.go.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.go.dto.CartDTO;

@Service
public interface CartService {
	
	public List<CartDTO> getAllCartItemsList(String userId);
	public CartDTO addItemIntoCart(String userId,CartDTO addThisItem);
	public String removeItemfromCart(String userId,String productId);

}
