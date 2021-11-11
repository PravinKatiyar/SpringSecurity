package com.pravin.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.coupon.entity.Coupon;
import com.pravin.coupon.exception.ItemDoesNotExistsException;
import com.pravin.coupon.service.CouponService;

@RestController
@RequestMapping("/couponapi")
public class Controller {

	@Autowired
	private CouponService service;
	
	@PostMapping("/saveCoupon")
	public ResponseEntity<String> saveCoupon(@RequestBody Coupon coupon){
		String msg=service.saveCoupon(coupon);
	    return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/getCoupon/{couponCode}")
	public ResponseEntity<Coupon> getCoupon(@PathVariable String couponCode ) throws ItemDoesNotExistsException{
		Coupon coupon=service.getCoupon(couponCode);
	    return new ResponseEntity<Coupon>(coupon, HttpStatus.OK);
	}
	
}
