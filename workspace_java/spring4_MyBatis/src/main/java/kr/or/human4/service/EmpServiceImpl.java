package kr.or.human4.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.human4.dao.EmpDAO;
import kr.or.human4.dao.mapper.EmpMapperDAO;
import kr.or.human4.dto.EmpDTO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDAO empDAO;
	
	@Autowired
	EmpMapperDAO empMapperDAO;

	@Override
	public List<EmpDTO> getEmpList() {
		List<EmpDTO> result = empDAO.selectAllEmp();

		return result;
	}

	@Override
	public EmpDTO getEmp() {

		EmpDTO empDTO = empDAO.selectOneEmp();

		return empDTO;
	}

	@Override
	public Map getEmpMap() {

		Map map = empDAO.selectOneEmpMap();

		return map;
	}

	@Override
	public EmpDTO getEmpno(int empno) {
		EmpDTO empDTO = empDAO.selectEmpno(empno);

		return empDTO;
	}

	@Override
	public List<EmpDTO> getEmpName(String ename) {

		List<EmpDTO> result = empDAO.selectEname(ename);

		return result;
	}
	
	@Override
	public List<EmpDTO> getEmpJob(String job) {
		
		List<EmpDTO> result = empDAO.selectJob(job);
		
		return result;
	}
	
	@Override
	public List<EmpDTO> getEmpJobEname(EmpDTO dto) {
		
		List<EmpDTO> result = empDAO.selectJobEname(dto);
		
		return result;
	}
	
	@Override
	public int insertJoin(EmpDTO empDTO) {
		
		int result = empDAO.insertEmp2(empDTO);
		
		return result;
	}
	
	@Override
	public int updateEmp(EmpDTO dto) {
	    return empDAO.updateEmp(dto);
	}

	@Override
	public int deleteEmp(int empno) {
	    return empDAO.deleteEmp(empno);
	}

	@Override
	public List<EmpDTO> search(EmpDTO dto) {
		List<EmpDTO> result = empDAO.search(dto);

		return result;
	}
	
	@Override
	public List<EmpDTO> choice(EmpDTO dto) {
		List<EmpDTO> result = empDAO.choice(dto);
		
		return result;
	}

	// @Mapper 메소드 호출
	@Override
	public List<EmpDTO> selectMapper() {
		return empMapperDAO.selectEmp();
	}
	
	
}
