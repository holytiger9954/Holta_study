package kr.or.human3;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Param01Controller {

	@RequestMapping("/join.do")
	public void joinForm(HttpServletRequest request, HttpServletResponse response) {
		// jsp로 포워드
		System.out.println("joinForm 메소드 실행");
		
		try {
			request.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/join2.do")
	public ModelAndView joinForm2() {
		System.out.println("joinForm2 메소드 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("join");
		
		return mav;
	}
	
	@RequestMapping("/join3.do")
	public ModelAndView joinForm3() {
		System.out.println("joinForm3 메소드 실행");
		
		ModelAndView mav = new ModelAndView("join");
		
		return mav;
	}
	
	// *이 방식을 많이 씀*
	@RequestMapping("/join4.do")
	public String joinForm4() {
		System.out.println("joinForm4 메소드 실행");
		
		return "join";
	}
	
	// 주소와 jsp명이 같을 때
	@RequestMapping("/join")
	public void joinForm5() {
		System.out.println("joinForm5 메소드 실행");
		
	}
	
	@RequestMapping("/join6.do")
	public String joinForm6() {
		System.out.println("joinForm6 메소드 실행");
		
		return "redirect:join.do";
	}
	
	@RequestMapping("/join7.do")
	public String joinForm7() {
		System.out.println("joinForm7 메소드 실행");
		
		return "forward:join.do";
	}
	
	///////////////////////////////////////////////////////
	
	@RequestMapping("/join1")
	public void join1(HttpServletRequest request) {
		System.out.println("join1 메소드 실행");
		
		String id = request.getParameter("id");
		System.out.println("id: " + id);
	}
	
	// @RequestParam
	
	@RequestMapping("/join2")
	public String join2(
			// String id = request.getParameter("id");
			// 위의 코드와 같음
			// 기본적으로 필수 값, 그래서 400 Bad Request 코드 발생
			// required=true가 기본 값
			@RequestParam("id") String id, 
			
			@RequestParam(value="email", required=false)
			String email,
			
			// 필수 값
			@RequestParam(value="pw", required=true)
			String pw2,
			
			// @RequestParam(value="tel", required=false)
			// 파라메터 key와 변수 명이 같다면 @RequestParam 생략 가능
			// 필수가 아님에 주의!
			// 그래서 없으면 null
			String tel,
			String a, String b,
			
			// int는 null이 안돼서 500 에러
//			int age,
			Integer age
	) {
		System.out.println("join2 메소드 실행");
		
		System.out.println("id: " + id);
		System.out.println("email: " + email);
		System.out.println("pw: " + pw2);
		System.out.println("tel: " + tel);
		System.out.println("age: " + age);
		
		return "join";
	}
	
	@RequestMapping("/join3")
//	public String join3(String id, String pw, String tel) {
	public String join3(
			// 전달 인자를 key, value로 정리한다
			@RequestParam
			Map map
			
			// @RequestParam에 DTO는 안된다 
//			,
//			@RequestParam
//			MemberDTO memberDTO
			
	) {
		System.out.println(map);
//		System.out.println(memberDTO);
		
		return "join";
	}
	
	@RequestMapping("/join4")
	public String join4(
			
			@ModelAttribute
			MemberDTO memberDTO
			
			) {
		System.out.println(memberDTO);
		
		return "join";
	}
	
	@RequestMapping("/signup1")
	public ModelAndView signup1(
			HttpServletRequest request,
			
			String id
			
	) {
		System.out.println("/signup1 실행");
		System.out.println("id: " + id);
		
		ModelAndView mav = new ModelAndView("result");
		
		request.setAttribute("id", id);
		
		return mav;
	}
	
	@RequestMapping("/signup2")
	public ModelAndView signup2(
			HttpServletRequest request,
			
			String id
			
	) {
		System.out.println("/signup2 실행");
		System.out.println("id: " + id);
		
		ModelAndView mav = new ModelAndView("result");
		
//		request.setAttribute("id", id);
		mav.addObject("id", id);
		
		return mav;
	}
	
	@RequestMapping("/signup3")
	public ModelAndView signup3(
			// parameter에서 꺼내서
			// DTO의 setter를 이용하여
			// 자동으로 넣어줌
			@ModelAttribute
			MemberDTO dto1,
			
			// 심지어 다음줄의 코드까지 해줌
			// mav.addObject("memberDTO3", dto2);
			@ModelAttribute("memberDTO3")
			MemberDTO dto2,
			
			// @ModelAttribute 생략 가능
			// 생략하면 타입(클래스)의 앞글자를 소문자로한 key로 
			// 모델에 넣어줌
			@ModelAttribute("memberDTO")
			MemberDTO dto3
			
			) {
		System.out.println("/signup3 실행");
		System.out.println("dto1: " + dto1);
		
		ModelAndView mav = new ModelAndView("result");
		
		mav.addObject("dto1", dto1);
		
		return mav;
	}
	
	@RequestMapping("/signup4")
	public ModelAndView signup4(MemberDTO dto1, String id) {
		System.out.println("/signup4 실행");
		
		System.out.println(dto1);
		System.out.println(id);
		
		ModelAndView mav = new ModelAndView("result");
		
		return mav;
	}
	
	@RequestMapping("/cal/1")
	public void cal() {
		System.out.println("1월 달력이다.");
	}
	
	@RequestMapping("/cal/{month}")
	public void cal2(
			@PathVariable("month") // 생략 불가능
			int month
	) {
		System.out.println(month + "월 달력");
	}
	
	@RequestMapping("/lunch/{store}/order/{menu}/start")
	public void lunch(
			@PathVariable("store")
			String store,
			
			@PathVariable // 변수명이 같으면 괄호 생략 가능
			String menu
	) {
		System.out.println(store + "에서 " + menu + "을/를 준비합니다.");
	}
	
	@RequestMapping("/dinner")
	public String dinner(Model model, String menu) {
		System.out.println("/dinner 실행 menu: " + menu);

		model.addAttribute("menu", menu);
		
		return "result";
	}
	
	@RequestMapping(value="/brunch")
	public String brunch() {
		System.out.println("/brunch");
		return "result";
	}
	
	@RequestMapping(value={"/brunch1", "/brunch2"})
	public String brunch2() {
		System.out.println("/brunch1 또는 /brunch2");
		return "result";
	}
	
	@RequestMapping(value="/brunch3", method=RequestMethod.POST)
	public String brunch3() {
		System.out.println("/brunch3");
		return "result";
	}
	
	@RequestMapping(value="/brunch4", method= {RequestMethod.GET, RequestMethod.POST})
	public String brunch4() {
		System.out.println("/brunch4");
		return "result";
	}
}
