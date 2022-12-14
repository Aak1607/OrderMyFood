package com.omf.repository;

import com.omf.model.Order;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "order")
public interface OrderRepository extends PagingAndSortingRepository<Order, String> {

    @RestResource(description = @Description("Find by Customer Name and Item Name"))
    public List<Order> findByCustomerNameAndItemDetailName(@Param("customerName") String customerName, @Param("itemDetail.name") String name);

    @RestResource(description = @Description("Find by Customer Name"))
    public List<Order> findByCustomerName(@Param("customerName") String customerName);

    @RestResource(description = @Description("Find by ItemDetail Name"))
    public List<Order> findByItemDetailName(@Param("itemDetail.name") String name);

    @RestResource(description = @Description("Find by Restaurant Id"))
    public List<Order> findByRestaurantId(@Param("restaurantId") String restaurantId);

    @RestResource(description = @Description("Find by Ids"))
    public List<Order> id(@Param("id") String[] ids);

    @RestResource(description = @Description("Find by Order Id and Customer Name"))
    public Order getByOrderIdAndCustomerName(@Param("orderId") String id, @Param("customerName") String customerName);

    @Aggregation(pipeline = { " { '$match': { '_id': { '$in':  ?0  } } }" } )
    List<Order> findByIdsIn(List<String> ids);

    /*@RestResource(rel = "delete-by-id", description = @Description("Delete by id"))
    public void delete(@Param("id") String id);

    @RestResource(rel = "create", description = @Description("Create"))
    public Order save(@Param("order") Order order);*/
}
