package kr.or.human2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.human2.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
//		MemberDAO memberDAO = new MemberDAOImpl();
	
	@Override
	public List getList(MemberDAO memberDAO) {
		
		return memberDAO.select();
		
	}

//	@Autowired
//	MemberDAO memberDAO;
//	MemberDAO memberDAOmpl;
//	MemberDAO dao;
	@Autowired
	@Qualifier("dao")
	MemberDAO memberDAO;
	
	@Override
	public List getList2() {
		
//		MemberDAO memberDAO = new MemberDAOImpl();
		
		return memberDAO.select();
//		return dao.select();
	}
	
}
