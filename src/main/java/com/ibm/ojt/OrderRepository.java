package com.ibm.ojt;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

@RepositoryRestResource(collectionResourceRel="orderdetail", path="order")
public interface OrderRepository extends MongoRepository<Order, String>{
	
	List<Order> findByOrderDateGreaterThanEqual(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);
	List<Order> findByCustomerIdAndOrderDateGreaterThanEqual(@Param("custid") String customerId, @Param("date") 
												@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date);
	List<Order> findByCustomerId(@Param("custid") String customerId);
	Order findByOrderId(@Param("orderid") String orderId);
}
