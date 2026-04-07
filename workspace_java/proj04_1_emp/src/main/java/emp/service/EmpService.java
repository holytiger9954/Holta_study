package emp.service;

import java.util.List;

import emp.DAO.EmpDAO;
import emp.DTO.EmpDTO;

public class EmpService {
	
	public List<EmpDTO> getEmpList() {
		EmpDAO dao = new EmpDAO();
		return dao.selectAll();
	}
}
