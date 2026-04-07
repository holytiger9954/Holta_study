package shop.controller.cart;

import java.io.IOException;

import shop.DTO.UserDTO;
import shop.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cart/add")
public class CartAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CartService cartService = new CartService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        String productNoStr = request.getParameter("productNo");
        String qtyStr = request.getParameter("qty");

        int productNo = 0;
        int qty = 0;

        try {
            productNo = Integer.parseInt(productNoStr);
            qty = Integer.parseInt(qtyStr);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/product/list");
            return;
        }

        boolean result = cartService.addCart(loginUser.getUserNo(), productNo, qty);

        if (result) {
            response.sendRedirect(request.getContextPath() + "/product/detail?productNo=" + productNo + "&cartAdded=true");
        } else {
            response.sendRedirect(request.getContextPath() + "/product/detail?productNo=" + productNo + "&cartAdded=false");
        }
    }
}