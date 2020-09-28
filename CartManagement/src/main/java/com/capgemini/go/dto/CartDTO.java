package com.capgemini.go.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Cart")
public class CartDTO{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@NotNull
	//@NotEmpty(message="Id is required")
	private int id;
	
	@NotNull
	@Size(min=2,message="minimum should have atleast 2 characters")
	@NotEmpty(message="User Id is required")
	private String userId;
	
	@NotNull
	@Size(min=2,message="minimum should have atleast 2 characters")
	@NotEmpty(message="Product Id is required")
	private String productId;
	
	//@NotNull
	//@NotEmpty(message="Quantity is required")
	private int quantity;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	
	  public int getQuantity() { return quantity; } public void setQuantity(int
	  quantity) { this.quantity = quantity; }
	 
	public CartDTO() {
	
	}
	public CartDTO(int id, String userId, String productId, int quantity) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartDTO [id=" + id + ", userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
}