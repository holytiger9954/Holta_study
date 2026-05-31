package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EmpDTO;

@Repository
public class EmpDAOImpl implements EmpDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<EmpDTO> selectAllEmp() {
		List<EmpDTO> resultList = null;

		resultList = sqlSession.selectList("mapper.emp.selectEmp");
		System.out.println("selectAllEmp: resultList: " + resultList);

		return resultList;
	}

	@Override
	public EmpDTO selectOneEmp() {
		EmpDTO empDTO = null;

		empDTO = sqlSession.selectOne("mapper.emp.selectOneEmp");
		System.out.println("selectOne: empDTO: " + empDTO);

		return empDTO;
	}

	@Override
	public Map selectOneEmpMap() {
		Map map = null;

		map = sqlSession.selectOne("mapper.emp.selectOneEmpMap");
		System.out.println("selectOneMap: empDTO: " + map);

		return map;
	}

	@Override
	public EmpDTO selectEmpno(int empno) {
		EmpDTO empDTO = null;

		empDTO = sqlSession.selectOne("mapper.emp.selectEmpno", empno);
		System.out.println("selectEmpno: empDTO: " + empDTO);

		return empDTO;
	}

	@Override
	public List<EmpDTO> selectEname(String ename) {
		List<EmpDTO> resultList = null;

		resultList = sqlSession.selectList("mapper.emp.selectEname", ename);
		System.out.println("selectEname: resultList: " + resultList);

		return resultList;
	}

	@Override
	public List<EmpDTO> selectJob(String job) {
		List<EmpDTO> resultList = null;

		resultList = sqlSession.selectList("mapper.emp.selectJob", job);
		System.out.println("selectJob: resultList: " + resultList);

		return resultList;
	}

	@Override
	public List<EmpDTO> selectJobEname(EmpDTO dto) {
		List<EmpDTO> resultList = null;

		resultList = sqlSession.selectList("mapper.emp.selectJobEname", dto);
		System.out.println("selectJobEname: resultList: " + resultList);

		return resultList;
	}

	@Override
	public int insertEmp2(EmpDTO empDTO) {
		int result = -1;

		result = sqlSession.insert("mapper.emp.insertEmp2", empDTO);
		System.out.println("insertEmp2: result: " + result);

		return result;
	}

	@Override
	public int updateEmp(EmpDTO dto) {
		int result = sqlSession.update("mapper.emp.updateEmp", dto);
		System.out.println("updateEmp result: " + result);
		return result;
	}

	@Override
	public int deleteEmp(int empno) {
		return sqlSession.delete("mapper.emp.deleteEmp", empno);
	}

	// dept와 emp 정보를 받아서
	// 1. seq_dept2를 확보하고
	// 2. dept insert 하고
	// 3. emp insert 하기
	public int insertDeptEmp(EmpDTO dto) {
		int result = 0;
		
		//////////////////////////////// selectKey 등으로 사라지는 구역
		// insert 하기 전에 seq_dept2 확보하기
		int seq_dept2 = sqlSession.selectOne("mapper.emp.getSeqDept2");
		System.out.println("seq_dept2: " + seq_dept2);
		
		// dto에 저장하기
		dto.setDeptno(seq_dept2);
		////////////////////////////////
		
		// insert에 직접 넣기
		result += sqlSession.insert("mapper.emp.insertDept2", dto);
		// selectKey 때문에 deptno가 채워진 상태
		result += sqlSession.insert("mapper.emp.insertEmp2", dto);
		
		return result;
	}
	
	@Override
	public List<EmpDTO> search(EmpDTO dto) {
		List<EmpDTO> resultList = null;

//		resultList = sqlSession.selectList("mapper.emp.dynamic.selectEmp2", dto);
		resultList = sqlSession.selectList("mapper.emp.dynamic.select2Emp2", dto);
		System.out.println("search: resultList: " + resultList);

		return resultList;
	}
	
	@Override
	public List<EmpDTO> choice(EmpDTO dto) {
		List<EmpDTO> resultList = null;
		
		resultList = sqlSession.selectList("mapper.emp.dynamic.foreach", dto);
		System.out.println("choice: resultList: " + resultList);
		
		return resultList;
	}
}
