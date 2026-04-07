package shop.controller.cart;

import java.io.IOException;

import shop.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cart/delete")
public class CartDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CartService cartService = new CartService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cartNoStr = request.getParameter("cartNo");

        int cartNo = 0;

        try {
            cartNo = Integer.parseInt(cartNoStr);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/cart/list");
            return;
        }

        cartService.removeCart(cartNo);

        response.sendRedirect(request.getContextPath() + "/cart/list");
    }
}