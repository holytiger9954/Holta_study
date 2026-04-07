package shop.controller.product;

import java.io.IOException;

import shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/product/delete")
public class ProductDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductService productService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productNoStr = request.getParameter("productNo");

        int productNo = 0;

        try {
            productNo = Integer.parseInt(productNoStr);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/product/list");
            return;
        }

        boolean result = productService.removeProduct(productNo);

        if (result) {
            response.sendRedirect(request.getContextPath() + "/product/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/product/detail?productNo=" + productNo);
        }
    }
}