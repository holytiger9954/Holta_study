package shop.controller.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.DTO.CartViewDTO;
import shop.DTO.UserDTO;
import shop.service.CartService;

@WebServlet("/cart/list")
public class CartListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CartService cartService = new CartService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        List<CartViewDTO> cartList = cartService.getCartViewList(loginUser.getUserNo());
        
        request.setAttribute("cartList", cartList);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cart/list.jsp");
        rd.forward(request, response);
    }
}