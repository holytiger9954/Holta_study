package shop.service;

import java.util.List;

import shop.DAO.CartDAO;
import shop.DAO.OrderDAO;
import shop.DAO.OrderItemDAO;
import shop.DTO.CartViewDTO;
import shop.DTO.OrderDTO;
import shop.DTO.OrderItemDTO;

public class OrderService {

    private OrderDAO orderDAO = new OrderDAO();
    private OrderItemDAO orderItemDAO = new OrderItemDAO();
    private CartDAO cartDAO = new CartDAO();

    public boolean placeOrder(int userNo) {
        if (userNo <= 0) {
            return false;
        }

        List<CartViewDTO> cartList = cartDAO.selectCartViewByUserNo(userNo);

        if (cartList == null || cartList.isEmpty()) {
            return false;
        }

        int totalPrice = 0;
        for (CartViewDTO cart : cartList) {
            totalPrice += cart.getTotalPrice();
        }

        int orderNo = orderDAO.getNextOrderNo();
        if (orderNo <= 0) {
            return false;
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderNo(orderNo);
        orderDTO.setUserNo(userNo);
        orderDTO.setTotalPrice(totalPrice);
        orderDTO.setOrderStatus("PAID");

        int orderResult = orderDAO.insert(orderDTO);
        if (orderResult <= 0) {
            return false;
        }

        for (CartViewDTO cart : cartList) {
            OrderItemDTO itemDTO = new OrderItemDTO();
            itemDTO.setOrderNo(orderNo);
            itemDTO.setProductNo(cart.getProductNo());
            itemDTO.setOrderPrice(cart.getProductPrice());
            itemDTO.setOrderQty(cart.getCartQty());

            int itemResult = orderItemDAO.insert(itemDTO);

            if (itemResult <= 0) {
                return false;
            }
        }

        int deleteResult = cartDAO.deleteAllByUserNo(userNo);

        return deleteResult >= 0;
    }
    
    public boolean hasOrderedProduct(int userNo, int productNo) {
        if (userNo <= 0 || productNo <= 0) {
            return false;
        }

        return orderDAO.hasOrderedProduct(userNo, productNo);
    }
}