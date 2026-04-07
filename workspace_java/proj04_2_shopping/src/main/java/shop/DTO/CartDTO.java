package shop.DTO;

import java.util.Date;

public class CartDTO {

	private int cartNo;
    private int userNo;
    private int productNo;
    private int cartQty;
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
	public int getCartQty() {
		return cartQty;
	}
	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}
	public Date getAddedAt() {
		return addedAt;
	}
	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}
	
	@Override
	public String toString() {
		return "CartDTO [cartNo=" + cartNo + ", userNo=" + userNo + ", productNo=" + productNo + ", cartQty=" + cartQty
				+ ", addedAt=" + addedAt + "]";
	}
	
}
