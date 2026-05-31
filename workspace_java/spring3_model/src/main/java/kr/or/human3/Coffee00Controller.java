package kr.or.human3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Coffee00Controller {

	// JSP 화면 열기
	@RequestMapping(value = "/coffee", method = RequestMethod.GET)
	public String coffeePage() {
		return "coffee";
	}

	// SSR 방식 - form submit 처리
	@RequestMapping(value = "/orderCoffeeSSR", method = RequestMethod.POST)
	public String orderCoffeeSSR(HttpServletRequest request, Model model) throws Exception {

		request.setCharacterEncoding("UTF-8");

		String[] menu = request.getParameterValues("menu");
		String[] priceStr = request.getParameterValues("price");
		String[] countStr = request.getParameterValues("count");

		List<CoffeeOrderDTO> orders = new ArrayList<CoffeeOrderDTO>();
		int totalPrice = 0;

		for (int i = 0; i < menu.length; i++) {
			CoffeeOrderDTO dto = new CoffeeOrderDTO();

			int price = Integer.parseInt(priceStr[i]);
			int count = Integer.parseInt(countStr[i]);

			dto.setMenu(menu[i]);
			dto.setPrice(price);
			dto.setCount(count);

			totalPrice += price * count;
			orders.add(dto);
		}

		model.addAttribute("orders", orders);
		model.addAttribute("totalPrice", totalPrice);

		return "coffee";
	}

	// CSR 방식 - AJAX JSON 처리
	@RequestMapping(value = "/orderCoffee", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> orderCoffeeAjax(
			
			@RequestBody 
			List<CoffeeOrderDTO> orders
			
		) {

		int totalPrice = 0;

		for (CoffeeOrderDTO order : orders) {
			totalPrice += order.getPrice() * order.getCount();
		}

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("orders", orders);
		result.put("totalPrice", totalPrice);

		return result;
	}
}