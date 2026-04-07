package shop.DTO;

import java.util.Date;

public class OrderDTO {

	private int orderNo;
    private int userNo;
    private int totalPrice;
    private String orderStatus;
    private Date createdAt;
    
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "OrderDTO [orderNo=" + orderNo + ", userNo=" + userNo + ", totalPrice=" + totalPrice + ", orderStatus="
				+ orderStatus + ", createdAt=" + createdAt + "]";
	}
	
}
