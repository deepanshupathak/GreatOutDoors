package com.capgemini.go.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;*/
import org.springframework.stereotype.Repository;

import com.capgemini.go.dto.CartDTO;


@Repository
public interface CartDao extends JpaRepository<CartDTO,Integer>
	{
		
	}
