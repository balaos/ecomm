package com.sample.ecomm.repo;

import com.sample.ecomm.model.Order;
import com.sample.ecomm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
