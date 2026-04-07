package shop.DTO;

public class OrderItemDTO {

	private int orderItemNo;
    private int orderNo;
    private int productNo;
    private int orderPrice;
    private int orderQty;
    
	public int getOrderItemNo() {
		return orderItemNo;
	}
	public void setOrderItemNo(int orderItemNo) {
		this.orderItemNo = orderItemNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	@Override
	public String toString() {
		return "OrderItemDTO [orderItemNo=" + orderItemNo + ", orderNo=" + orderNo + ", productNo=" + productNo
				+ ", orderPrice=" + orderPrice + ", orderQty=" + orderQty + "]";
	}
	
}
