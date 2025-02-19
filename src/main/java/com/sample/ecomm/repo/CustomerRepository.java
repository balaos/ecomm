package com.sample.ecomm.repo;

import com.sample.ecomm.model.Customer;
import com.sample.ecomm.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
