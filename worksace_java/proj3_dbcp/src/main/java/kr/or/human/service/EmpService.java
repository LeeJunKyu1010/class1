package kr.or.human.service;

import java.util.List;

import kr.kr.human.dao.EmpDAO;

public class EmpService {
		
	public List getEmpList() {
		System.out.println("EmpService getEmpList 실행");
		
		EmpDAO empDAO = new EmpDAO();
		List list = empDAO.selectEmpList();
		System.out.println("목록의 길이 : "+ list.size());
		
		return list;
	}
	
}
