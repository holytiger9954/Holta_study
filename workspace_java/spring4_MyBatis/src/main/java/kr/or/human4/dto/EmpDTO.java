package kr.or.human4.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class EmpDTO {
//  - 사번, 이름, 직급, 연봉, 상사의 사번

	private int empno;
	private String ename;
	private String job;
	private Integer sal = Integer.MIN_VALUE;
	private Integer mgr;
	private Date hiredate;
	private Integer comm;
	private int deptno;
	
	private int size = 10;
	private int page = 1;
	private int start = 0;
	private int end;
	
	private String type;
	private String keyword;
	
	private List<Integer> empnos;
	
}
