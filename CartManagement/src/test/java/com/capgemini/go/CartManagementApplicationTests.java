package com.capgemini.go;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.go.dao.CartDao;
import com.capgemini.go.dto.CartDTO;
import com.capgemini.go.service.CartService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CartManagementApplicationTests {
	
	@Autowired
	private CartService cartServcieTest;
	
	@Mock
	private CartDao cartDaoTest;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void getAllItemListTest()
	{
		CartDTO testData1=new CartDTO();
		testData1.setId(1);
		testData1.setUserId("u10001");
		testData1.setProductId("p10001");
		testData1.setQuantity(2);
	
		CartDTO testData2=new CartDTO();
		testData2.setId(2);
		testData2.setUserId("u10001");
		testData2.setProductId("p10002");
		testData2.setQuantity(3);
		
		CartDTO testData3=new CartDTO();
		testData3.setId(4);
		testData3.setUserId("u10001");
		testData3.setProductId("p10001");
		testData3.setQuantity(3);
	
		CartDTO testData4=new CartDTO();
		testData4.setId(6);
		testData4.setUserId("u10001");
		testData4.setProductId("p10001");
		testData4.setQuantity(3);
		
		List<CartDTO> allItems=new ArrayList<CartDTO>();
		
		allItems.add(testData1);
		allItems.add(testData2);
		allItems.add(testData3);
		allItems.add(testData4);
		
		
		Mockito.when(cartDaoTest.findAll()).thenReturn(allItems);
		
		assertThat(cartServcieTest.getAllCartItemsList("u10001")).isEqualTo(allItems);
	}
	
	@Test
	public void addItemIntoListTest()
	{
		CartDTO testData=new CartDTO();
		testData.setId(1);
		testData.setUserId("u10005");
		testData.setProductId("p10001");
		testData.setQuantity(2);
		
		Mockito.when(cartDaoTest.save(testData)).thenReturn(testData);
		
		assertThat(cartServcieTest.addItemIntoCart("u10001", testData)).isEqualTo(testData);
	}
	
	@Test
	public void removeItemFromListTest()
	{
		CartDTO testData=new CartDTO();
		testData.setId(1);
		testData.setUserId("u10001");
		testData.setProductId("p10001");
		testData.setQuantity(2);
		
		Mockito.when(cartDaoTest.delete(testData)).thenReturn(testData);
		
		assertThat(cartServcieTest.removeItemfromCart("u10001", "p10001")).isEqualTo(testData);
	}
	

}
