package kr.or.human4.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.or.human4.dto.EmpDTO;

@Mapper
public interface EmpMapperDAO {

	List<EmpDTO> selectEmp();
	
	@Select("select * from emp where empno = #{a}")
	EmpDTO detail(
			@Param("a")
			int empno
	);
	
	// @Param의 값과 변수 명이 같으면 @Param 생략 가능
//	@Select("select * from emp where empno = #{a}")
	@Select("select * from emp where empno = #{empno}")
//	EmpDTO detail2(@Param("a") int empno);
	EmpDTO detail2(int empno);
	
}
