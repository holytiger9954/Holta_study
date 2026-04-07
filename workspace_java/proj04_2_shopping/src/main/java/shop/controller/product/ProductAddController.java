package shop.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DTO.ProductDTO;
import shop.DTO.UserDTO;
import shop.service.ProductService;

@WebServlet("/product/add")
public class ProductAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/product/add.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return;
		}

		String productName = request.getParameter("productName");
		String productPriceStr = request.getParameter("productPrice");
		String productContent = request.getParameter("productContent");
		String stockQtyStr = request.getParameter("stockQty");

		int productPrice = 0;
		int stockQty = 0;

		try {
			productPrice = Integer.parseInt(productPriceStr);
			stockQty = Integer.parseInt(stockQtyStr);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/product/add");
			return;
		}

		ProductDTO dto = new ProductDTO();
		dto.setProductName(productName);
		dto.setProductPrice(productPrice);
		dto.setProductContent(productContent);
		dto.setStockQty(stockQty);
		dto.setSellerUserNo(loginUser.getUserNo());

		boolean result = productService.addProduct(dto);

		if (result) {
			response.sendRedirect(request.getContextPath() + "/product/list");
		} else {
			response.sendRedirect(request.getContextPath() + "/product/add");
		}
	}
}