package kr.or.human2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.human2.dao.MemberDAO;
import kr.or.human2.dao.MemberDAOImpl;
import kr.or.human2.service.MemberService;
import kr.or.human2.service.MemberServiceImpl;

@Controller
public class MemberController {

	MemberController() {
		System.out.println("MemberController 생성자 실행");
	}
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/member")
	String listMember() {
		
		System.out.println("listMember 메소드 실행");

		// 주도권을 내가 가지고 있어서 이후 Autowired가 안된다
//		MemberService memberService = new MemberServiceImpl();
//		MemberDAO memberDAO = new MemberDAOImpl();
//		MemberDAO memberDAO = new MemberDAOImpl2();
//		List list = memberService.getList(memberDAO);
//		System.out.println("list: " + list);
		
		// 주도권을 spring에게 준 상태
		List list = memberService.getList2();
		System.out.println("list: " + list);
		
		return "home";
	}
	
}
