package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.EmpDTO;

public interface EmpDAO {

	List<EmpDTO> selectAllEmp();
	
	EmpDTO selectOneEmp();
	
	Map selectOneEmpMap();
	
	EmpDTO selectEmpno(int empno);
	
	List<EmpDTO> selectEname(String ename);
	
	List<EmpDTO> selectJob(String job);
	
	List<EmpDTO> selectJobEname(EmpDTO dto);
	
	int insertEmp2(EmpDTO empDTO);
	
	int updateEmp(EmpDTO dto);

	int deleteEmp(int empno);
	
	List<EmpDTO> search(EmpDTO dto);
	
	List<EmpDTO> choice(EmpDTO dto);
	
}
