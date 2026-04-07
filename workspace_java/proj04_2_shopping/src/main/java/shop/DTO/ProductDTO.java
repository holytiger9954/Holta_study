package shop.DTO;

import java.util.Date;

public class ProductDTO {

	private int productNo;
	private String productName;
	private int productPrice;
	private String productContent;
	private int stockQty;
	private int sellerUserNo;
	private Date createdAt;
	private Date updatedAt;
	
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
	public String getProductContent() {
		return productContent;
	}
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	public int getStockQty() {
		return stockQty;
	}
	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}
	public int getSellerUserNo() {
		return sellerUserNo;
	}
	public void setSellerUserNo(int sellerUserNo) {
		this.sellerUserNo = sellerUserNo;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [productNo=" + productNo + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productContent=" + productContent + ", stockQty=" + stockQty + ", sellerUserNo=" + sellerUserNo
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
