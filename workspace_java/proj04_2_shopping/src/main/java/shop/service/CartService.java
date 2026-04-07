package shop.service;

import java.util.List;

import shop.DAO.CartDAO;
import shop.DTO.CartDTO;
import shop.DTO.CartViewDTO;

public class CartService {

    private CartDAO cartDAO = new CartDAO();

    // 장바구니 담기
    public boolean addCart(int userNo, int productNo, int qty) {
        if (userNo <= 0 || productNo <= 0 || qty <= 0) {
            return false;
        }

        CartDTO existingCart = cartDAO.selectByUserNoAndProductNo(userNo, productNo);

        int result = 0;

        if (existingCart == null) {
            CartDTO dto = new CartDTO();
            dto.setUserNo(userNo);
            dto.setProductNo(productNo);
            dto.setCartQty(qty);

            result = cartDAO.insert(dto);
        } else {
            result = cartDAO.increaseQty(existingCart.getCartNo(), qty);
        }

        return result > 0;
    }

    // 내 장바구니 조회
    public List<CartDTO> getCartList(int userNo) {
        if (userNo <= 0) {
            return null;
        }

        return cartDAO.selectAllByUserNo(userNo);
    }

    // 장바구니 수량 수정
    public boolean modifyCartQty(int cartNo, int cartQty) {
        if (cartNo <= 0 || cartQty <= 0) {
            return false;
        }

        int result = cartDAO.updateQty(cartNo, cartQty);
        return result > 0;
    }

    // 장바구니 삭제
    public boolean removeCart(int cartNo) {
        if (cartNo <= 0) {
            return false;
        }

        int result = cartDAO.delete(cartNo);
        return result > 0;
    }

    // 장바구니 1건 조회
    public CartDTO getCart(int cartNo) {
        if (cartNo <= 0) {
            return null;
        }

        return cartDAO.selectOne(cartNo);
    }
    
    // 장바구니 목록
    public List<CartViewDTO> getCartViewList(int userNo) {
        return cartDAO.selectCartViewByUserNo(userNo);
    }
}