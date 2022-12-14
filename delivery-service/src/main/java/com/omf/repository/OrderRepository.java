package com.omf.repository;

import com.omf.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "orders")
public interface OrderRepository extends PagingAndSortingRepository<Order, String> {
    @RestResource(description = @Description("Find order by order id"))
    Order findByOrderId(@Param("orderId") String orderId);

    @RestResource(rel = "save", description = @Description("Save order"))
    Order save(@Param("order") Order order);
}
