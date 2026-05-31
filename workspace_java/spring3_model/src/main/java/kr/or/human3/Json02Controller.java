package kr.or.human3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@ResponseBody // 모든 메소드에 붙이는 효과
				// ajax 전용 컨트롤러인 경우 편하다
public class Json02Controller {
	@RequestMapping("/ajax.do")
	public String ajax() {
		System.out.println("ajax 메소드 실행");

		return "ajax";
	}
	
	@RequestMapping("/ajax1")
	public String ajax1(
			@RequestParam(value="id", required=false)
			String id
			
	) {
		System.out.println("ajax1 메소드 실행");
		System.out.println("id: " + id);
		
		return "ajax";
	}
	
	@RequestMapping("/ajax2")
	public String ajax2(
			@RequestParam(value="id", required=false)
			String id,
			
			@RequestBody
			MemberDTO dto
			) {
		System.out.println("ajax2 메소드 실행");
		System.out.println("id: " + id);
		System.out.println("dto: " + dto);
		
		return "ajax";
	}
	
	@RequestMapping("/ajax3")
	@ResponseBody
	public String ajax3() {
		
		return "ajax";
	}
	
	@RequestMapping("/ajax4")
	@ResponseBody
	public MemberDTO ajax4() {
		MemberDTO dto = new MemberDTO();
		dto.setId("id4");
		dto.setPw("pw4");
		dto.setEmail("email@email.com");
		
		return dto;
	}
	
	@RequestMapping("/ajax5")
	@ResponseBody
	public List<MemberDTO> ajax5() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		MemberDTO dto = new MemberDTO();
		dto.setId("id5");
		dto.setPw("pw5");
		dto.setEmail("email@email.com");
		
		list.add(dto);
		list.add(dto);
		list.add(dto);
		
		return list;
	}
	
	@RequestMapping("/ajax6")
	@ResponseBody
	public Map ajax6() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		MemberDTO dto = new MemberDTO();
		dto.setId("id6");
		dto.setPw("pw6");
		dto.setEmail("email@email.com");
		
		list.add(dto);
		list.add(dto);
		list.add(dto);
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", 120);
		map.put("pageNo", 3);
		map.put("keyword", "scott");
		map.put("type", "code");
		
		return map;
	}
}
