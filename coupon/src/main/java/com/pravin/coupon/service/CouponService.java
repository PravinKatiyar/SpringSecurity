package com.pravin.coupon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.coupon.entity.Coupon;
import com.pravin.coupon.exception.ItemDoesNotExistsException;
import com.pravin.coupon.repository.CouponRepo;

@Service
public class CouponService {

	@Autowired
	private CouponRepo couponRepo;

	public String saveCoupon(Coupon coupon) {
		couponRepo.save(coupon);
		return "coupon saved!!";
	}

	public Coupon getCoupon(String couponCode) throws ItemDoesNotExistsException {
		Coupon coupon = couponRepo.findByCouponCode(couponCode);
		if (coupon == null) {
			throw new ItemDoesNotExistsException("Item Doesn't exits");
		}else {
			return coupon;
		}
	}

}
