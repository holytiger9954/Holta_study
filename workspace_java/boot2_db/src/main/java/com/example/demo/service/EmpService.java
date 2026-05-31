package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.EmpDTO;

public interface EmpService {

	List<EmpDTO> getEmpList();
	
	EmpDTO getEmp();
	
	Map getEmpMap();
	
	EmpDTO getEmpno(int empno);
	
	List<EmpDTO> getEmpName(String ename);
	
	List<EmpDTO> getEmpJob(String job);
	
	List<EmpDTO> getEmpJobEname(EmpDTO dto);
	
	int insertJoin(EmpDTO empDTO);
	
	public int updateEmp(EmpDTO dto);

	public int deleteEmp(int empno);
	
	List<EmpDTO> search(EmpDTO dto);
	
	List<EmpDTO> choice(EmpDTO dto);
	
//	List<EmpDTO> selectMapper();
}
