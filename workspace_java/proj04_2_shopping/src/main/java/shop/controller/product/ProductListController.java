package shop.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DTO.ProductDTO;
import shop.DTO.UserDTO;
import shop.service.ProductService;

@WebServlet("/product/list")
public class ProductListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        List<ProductDTO> list = productService.getProductList();

        request.setAttribute("productList", list);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/product/list.jsp");
        rd.forward(request, response);
    }
}