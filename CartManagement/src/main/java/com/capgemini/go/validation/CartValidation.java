package com.capgemini.go.validation;

import org.springframework.stereotype.Component;

import com.capgemini.go.exception.MethodArgumentNotValidException;

@Component
public class CartValidation
{
	public boolean checkQuantityValue(String quantity)
	{
	try
	{
		Integer.parseInt(quantity);
	}
	
	catch(MethodArgumentNotValidException e)
	{
		return false;
	}
	
	return true;
		
	}
	
	
}
