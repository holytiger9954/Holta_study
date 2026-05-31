package com.example.demo.controller;

import java.util.List;
import java.util.Map;

//import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.EmpDTO;
import com.example.demo.service.EmpService;

@Controller
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	@Autowired
	EmpService empService;
	
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public String empPage() {
		return "emp";
	}
	
	@RequestMapping("/list")
	public String List(Model model) {
		System.out.println("/list 실행");
		
		List<EmpDTO> list = empService.getEmpList();
		System.out.println("EmpController: list: " + list);
		
		model.addAttribute("list", list);
		
		return "emp";
	}
	
	@RequestMapping("/one")
	public String one(Model model) {
		System.out.println("/one 실행");
		
		EmpDTO empDTO = empService.getEmp();
		System.out.println("EmpController: one: " + empDTO);
		
		model.addAttribute("emp", empDTO);
		
		return "emp";
	}
	
	@RequestMapping("/oneMap")
	public String oneMap(Model model) {
		System.out.println("/oneMap 실행");
		
		Map map = empService.getEmpMap();
		System.out.println("EmpController: oneMap: " + map);
		
		model.addAttribute("map", map);
		
		return "emp";
	}
	
	@RequestMapping("/ajaxList")
	@ResponseBody
	public List<EmpDTO> ajaxList() {
	    System.out.println("/ajaxList 실행");

	    List<EmpDTO> list = empService.getEmpList();

	    return list;
	}

	@RequestMapping("/ajaxOne")
	@ResponseBody
	public EmpDTO ajaxOne() {
	    System.out.println("/ajaxOne 실행");

	    EmpDTO empDTO = empService.getEmp();

	    return empDTO;
	}

	@RequestMapping("/ajaxOneMap")
	@ResponseBody
	public Map ajaxOneMap() {
	    System.out.println("/ajaxOneMap 실행");

	    Map map = empService.getEmpMap();

	    return map;
	}
	
	@RequestMapping("/getEmpno")
	public String getEmpno(Model model,
			@RequestParam(value="empno", required=false)
			int empno
	) {
		System.out.println("/getEmpno 실행");
		
		System.out.println("empno: " + empno);
		
		EmpDTO empDTO = empService.getEmpno(empno);
		model.addAttribute("empno", empDTO);
		
		return "result";
	}
	
//	boolean isDebug = false;
	int debugLevel = 1;
	
	@RequestMapping("/getEname")
	public String getEname(Model model,
			@RequestParam(value="ename", required=false)
			String ename
	) {
		if(debugLevel > 3) {
			System.out.println("/getEname 실행");
		}
		
		logger.info("info:/getEname 실행");
		logger.warn("warn:ename" + ename);
		logger.error("error:ename" + ename);
		
		List<EmpDTO> list = empService.getEmpName(ename);
		System.out.println("EmpController: getEname: " + list);
		
		model.addAttribute("list", list);
		
		return "result";
	}
	
	@RequestMapping("/getJob")
	public String getJob(Model model,
			@RequestParam(value="job", required=false)
			String job
			) {
		if(debugLevel > 3) {
			System.out.println("/getJob 실행");
		}
		
		logger.info("info:/getJob 실행");
		logger.warn("warn:job" + job);
		logger.error("error:job" + job);
		
		List<EmpDTO> list = empService.getEmpJob(job);
		System.out.println("EmpController: getJob: " + list);
		
		model.addAttribute("list", list);
		
		return "result";
	}
	
	@RequestMapping("/getJobEname")
	public String getJob(Model model, EmpDTO dto) {
		System.out.println("/getJobEname 실행");
		
		List<EmpDTO> list = empService.getEmpJobEname(dto);
		System.out.println("EmpController: getJobEname: " + list);
		
		model.addAttribute("list", list);
		
		return "result";
	}
	
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(EmpDTO empDTO) {
	    System.out.println("/join POST 실행");
	    System.out.println("empDTO: " + empDTO);

	    empService.insertJoin(empDTO);

	    return "redirect:/list";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(@RequestParam int empno, Model model) {
	    EmpDTO empDTO = empService.getEmpno(empno);

	    model.addAttribute("empDTO", empDTO);

	    return "empDetail";
	}
	
	@RequestMapping("/updateEmp")
	public String updateEmp(EmpDTO dto) {
	    System.out.println("update 실행: " + dto);

	    empService.updateEmp(dto);

	    return "redirect:/detail?empno=" + dto.getEmpno();
	}
	
//	@RequestMapping("/deleteEmp")
//	public String deleteEmp(@RequestParam int empno, HttpSession session) {
//
//	    Integer loginEmpno = (Integer) session.getAttribute("loginEmpno");
//
//	    empService.deleteEmp(empno);
//
//	    // 본인 계정 삭제면 로그아웃
//	    if(loginEmpno != null && loginEmpno == empno) {
//	        session.invalidate();
//	        return "redirect:/list";
//	    }
//
//	    return "redirect:/list";
//	}
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String loginForm() {
	    return "login";
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String login(@RequestParam int empno, HttpSession session) {
//	    session.setAttribute("loginEmpno", empno);
//
//	    return "redirect:/list";
//	}
	
	@RequestMapping("/search")
	public String search(Model model, EmpDTO dto) {
		System.out.println("/search 실행");
		
		List<EmpDTO> list = empService.search(dto);
		System.out.println("EmpController: list: " + list);
		
		model.addAttribute("list", list);
		
		return "searchResult";
	}
	
	@RequestMapping("/choice")
	public String choice(Model model, EmpDTO dto) {
		System.out.println("/choice 실행");
		
		List<EmpDTO> list = empService.choice(dto);
		System.out.println("EmpController: list: " + list);
		System.out.println("dto: " + dto);
		
		model.addAttribute("list", list);
		
		return "searchResult";
	}
	
//	@RequestMapping("/mapper")
//	public String mapper(Model model) {
//		List<EmpDTO> list = empService.selectMapper();
//		
//		model.addAttribute("list", list);
//		return "emp";
//	}
	
	@RequestMapping("/ajaxSearch")
	@ResponseBody
	public List<EmpDTO> ajaxSearch(EmpDTO dto) {
	    System.out.println("/ajaxSearch 실행");
	    System.out.println("type: " + dto.getType());
	    System.out.println("keyword: " + dto.getKeyword());

	    List<EmpDTO> list = empService.search(dto);

	    System.out.println("ajaxSearch list: " + list);

	    return list;
	}
	
	@RequestMapping("/ajaxChoice")
	@ResponseBody
	public List<EmpDTO> ajaxChoice(EmpDTO dto) {

	    System.out.println("/ajaxChoice 실행");
	    System.out.println(dto.getEmpnos());

	    List<EmpDTO> list = empService.choice(dto);

	    return list;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
}
