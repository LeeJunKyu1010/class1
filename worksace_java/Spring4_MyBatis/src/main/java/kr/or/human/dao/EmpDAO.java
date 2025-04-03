package kr.or.human.dao;

import java.util.List;

import kr.or.human.dto.EmpDTO;

public interface EmpDAO {

	public List<EmpDTO> selectEmpList(EmpDTO empDTO);

	public EmpDTO selectOneEmp();

	public EmpDTO selectOneEmpno(int empno);

	public EmpDTO selectOneEmpno2(EmpDTO empno);

	public int updateEMP(EmpDTO empDTO);
	
	public int insertEmp(EmpDTO empDTO);
	
	public int deleteEmp (EmpDTO empDTO);
	
	public List<EmpDTO> searchEmp(EmpDTO empDTO);
	
	public List<EmpDTO> choose(EmpDTO empDTO);


}
