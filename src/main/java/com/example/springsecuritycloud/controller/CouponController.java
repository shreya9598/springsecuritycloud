package com.example.springsecuritycloud.controller;


import java.util.List;

import com.example.springsecuritycloud.model.Coupon;
import com.example.springsecuritycloud.repo.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;


@RestController
public class CouponController {
    @Autowired
    private CouponRepo couponRepo;

    @PostMapping("/coupons")
    public void createCoupon(@RequestBody Coupon coupon) {
//        System.out.println("POST MAPPING");
        couponRepo.save(coupon);
    }

    @GetMapping("/coupons")
    @PermitAll()
    public List<Coupon> getAllCoupons() {
        // return List.of();
        return couponRepo.findAll();
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code") String code) {
        Coupon coupon = couponRepo.findByCode(code);
        return coupon;
    }

//    @PostMapping("/test")
//    void test() {
//        System.out.println("TESTPOST");
//    }
}