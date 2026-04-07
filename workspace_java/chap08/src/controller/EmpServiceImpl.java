package controller;

import java.util.ArrayList;
import java.util.List;

public class EmpServiceImpl implements EmpService {
	
//	A.b a = new A().new B();
	
	EmpDAO empDAO = new EmpDAOImpl();

	@Override
	public List getEmpno() {
		
		List<Integer> list = empDAO.selectEmpno();
		
		List<Integer> resultList = new ArrayList();
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) >= 3000) {
				resultList.add(list.get(i));
			}
		}
		
		return resultList;
	}

}
