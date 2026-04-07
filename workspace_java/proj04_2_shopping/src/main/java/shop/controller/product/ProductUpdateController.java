package shop.controller.product;

import java.io.IOException;

import shop.DTO.ProductDTO;
import shop.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product/update")
public class ProductUpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productNoStr = request.getParameter("productNo");
        int productNo = 0;

        try {
            productNo = Integer.parseInt(productNoStr);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/product/list");
            return;
        }

        ProductDTO product = productService.getProduct(productNo);

        if (product == null) {
            response.sendRedirect(request.getContextPath() + "/product/list");
            return;
        }

        request.setAttribute("product", product);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/product/update.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String productNoStr = request.getParameter("productNo");
        String productName = request.getParameter("productName");
        String productPriceStr = request.getParameter("productPrice");
        String productContent = request.getParameter("productContent");
        String stockQtyStr = request.getParameter("stockQty");

        int productNo = 0;
        int productPrice = 0;
        int stockQty = 0;

        try {
            productNo = Integer.parseInt(productNoStr);
            productPrice = Integer.parseInt(productPriceStr);
            stockQty = Integer.parseInt(stockQtyStr);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/product/list");
            return;
        }

        ProductDTO dto = new ProductDTO();
        dto.setProductNo(productNo);
        dto.setProductName(productName);
        dto.setProductPrice(productPrice);
        dto.setProductContent(productContent);
        dto.setStockQty(stockQty);

        boolean result = productService.modifyProduct(dto);

        if (result) {
            response.sendRedirect(request.getContextPath() + "/product/detail?productNo=" + productNo);
        } else {
            response.sendRedirect(request.getContextPath() + "/product/update?productNo=" + productNo);
        }
    }
}