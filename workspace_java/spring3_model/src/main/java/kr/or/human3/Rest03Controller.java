package kr.or.human3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController // @Controller + @ResponseBody
public class Rest03Controller {

	@RequestMapping("/a")
//	@ResponseBody
	public String a() {
		return "a";
	}
	
	@RequestMapping("/b")
//	public @ResponseBody String b() {
	public String b() {
		return "b";
	}
	
}
