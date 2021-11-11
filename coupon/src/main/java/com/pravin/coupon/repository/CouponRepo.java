package com.pravin.coupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.coupon.entity.Coupon;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Integer> {

	Coupon findByCouponCode(String couponCode);

}
