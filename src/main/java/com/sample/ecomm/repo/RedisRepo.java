package com.sample.ecomm.repo;

import com.sample.ecomm.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepo extends CrudRepository<Cart, Long> {

}
