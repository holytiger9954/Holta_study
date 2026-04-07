package shop.DTO;

import java.util.Date;

public class CartViewDTO {

    private int cartNo;
    private int userNo;
    private int productNo;

    private String productName;
    private int productPrice;

    private int cartQty;
    private int totalPrice;

    private Date addedAt;

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getCartQty() {
		return cartQty;
	}

	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}

	@Override
	public String toString() {
		return "CartViewDTO [cartNo=" + cartNo + ", userNo=" + userNo + ", productNo=" + productNo + ", productName="
				+ productName + ", productPrice=" + productPrice + ", cartQty=" + cartQty + ", totalPrice=" + totalPrice
				+ ", addedAt=" + addedAt + "]";
	}

}