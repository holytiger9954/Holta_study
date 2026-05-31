package kr.or.human3;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalorieController {

	// 화면
	@RequestMapping(value = "/calorie", method = RequestMethod.GET)
	public String page() {
		return "calorie";
	}

	// AJAX 처리
	@RequestMapping(value = "/calorieAjax", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> calorieAjax(
			
			@RequestBody 
			Map<String, Object> param, 
			
			HttpSession session
			
		) {

		int bodyCalorie = session.getAttribute("bodyCalorie") == null ? 0 : ((Number) session.getAttribute("bodyCalorie")).intValue();

		String type = (String) param.get("type");
		String name = (String) param.get("name");
		int calorie = ((Number) param.get("calorie")).intValue();

		if ("food".equals(type)) {
			bodyCalorie += calorie / 10;
		} else if ("exercise".equals(type)) {
			bodyCalorie -= calorie;
			if (bodyCalorie < 0)
				bodyCalorie = 0;
		}

		session.setAttribute("bodyCalorie", bodyCalorie);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("bodyCalorie", bodyCalorie);
		result.put("name", name);

		return result;
	}
}