package com.pravin.coupon.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coupon {
	@Id
	@GeneratedValue
	private int id;
	private String couponCode;
	private long discount;
	private String expDate;
	public Coupon() {
		super();
	}
	public Coupon(int id, String couponCode, long discount, String expDate) {
		super();
		this.id = id;
		this.couponCode = couponCode;
		this.discount = discount;
		this.expDate = expDate;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public long getDiscount() {
		return discount;
	}
	public String getExpDate() {
		return expDate;
	}
	public int getId() {
		return id;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public void setDiscount(long discount) {
		this.discount = discount;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", couponCode=" + couponCode + ", discount=" + discount + ", expDate=" + expDate
				+ "]";
	}

}
