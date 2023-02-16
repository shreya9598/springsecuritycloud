package com.example.springsecuritycloud.repo;

import com.example.springsecuritycloud.model.Coupon;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CouponRepo extends CrudRepository<Coupon, Long> {
    Coupon findByCode(String code);
    ArrayList<Coupon> findAll();
}
