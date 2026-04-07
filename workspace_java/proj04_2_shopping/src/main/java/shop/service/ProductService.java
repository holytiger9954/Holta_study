package shop.service;

import java.util.List;

import shop.DAO.ProductDAO;
import shop.DTO.ProductDTO;

public class ProductService {

    private ProductDAO productDAO = new ProductDAO();

    // 상품 전체 조회
    public List<ProductDTO> getProductList() {
        return productDAO.selectAll();
    }

    // 상품 1개 조회
    public ProductDTO getProduct(int productNo) {
        if (productNo <= 0) {
            return null;
        }

        return productDAO.selectOne(productNo);
    }

    // 상품 등록
    public boolean addProduct(ProductDTO dto) {
        if (dto == null) {
            return false;
        }

        if (dto.getProductName() == null || dto.getProductName().trim().equals("")) {
            return false;
        }

        if (dto.getProductPrice() < 0) {
            return false;
        }

        if (dto.getStockQty() < 0) {
            return false;
        }

        int result = productDAO.insert(dto);
        return result > 0;
    }

    // 상품 수정
    public boolean modifyProduct(ProductDTO dto) {
        if (dto == null) {
            return false;
        }

        if (dto.getProductNo() <= 0) {
            return false;
        }

        if (dto.getProductName() == null || dto.getProductName().trim().equals("")) {
            return false;
        }

        if (dto.getProductPrice() < 0) {
            return false;
        }

        if (dto.getStockQty() < 0) {
            return false;
        }

        int result = productDAO.update(dto);
        return result > 0;
    }

    // 상품 삭제
    public boolean removeProduct(int productNo) {
        if (productNo <= 0) {
            return false;
        }

        int result = productDAO.delete(productNo);
        return result > 0;
    }
}