package kr.or.human.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.human.dto.EmpDTO;

@Repository
public class EmpDAOImpl implements EmpDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<EmpDTO> selectEmpList() {
		List<EmpDTO> result = sqlSession.selectList("mapper.emp.selectEmp");
		System.out.println("result : " + result);
		return result;
	}

	@Override
	public EmpDTO selectOneEmp() {
		EmpDTO dto = sqlSession.selectOne("mapper.emp.selectOneEmp");
		System.out.println("dto : " + dto);
		return dto;
	}

	@Override
	public EmpDTO selectOneEmpno(int empno) {
		EmpDTO dto = sqlSession.selectOne("mapper.emp.selectEmpno", empno);
		System.out.println("dto : " + dto);
		return dto;
	}

	@Override
	public EmpDTO selectOneEmpno2(EmpDTO empDTO) {
		EmpDTO dto = sqlSession.selectOne("mapper.emp.selectEmpno2", empDTO);
		System.out.println("EmpDAOImpl selectOneEmpno2 : " + dto);
		return dto;
	}
	
	@Override
	public int updateEMP(EmpDTO empDTO) {
		int dto = sqlSession.update("mapper.emp.updateEMP", empDTO);
		System.out.println("EmpDAOImpl updateEMP : " + dto);
		return dto;
	}
	
	@Override
	public int insertEmp(EmpDTO empDTO) {
		int dto = sqlSession.insert("mapper.emp.insertEMP",empDTO);
		System.out.println("EmpDAOImpl insertEmp : " + dto);
		return dto;
	}
	
	@Override
	public int deleteEmp (EmpDTO empDTO) {
		int dto = sqlSession.delete("mapper.emp.deleteEMP",empDTO);
		System.out.println("EmpDAOImpl deleteEmp : "+ dto);
		return dto;
	}
	

	void getSeq() {
		int seq = sqlSession.selectOne("mapper.emp.getSeq");
		EmpDTO dto = new EmpDTO();
		dto.setEmpno(seq);
		dto.setEname("임의");
		// insert에 보내서 등록 테이블 a에서 seq 사용
		// insert에 보내서 등록 테이블 b에서 seq 사용
	}
	@Override
	public List<EmpDTO> searchEmp(EmpDTO empDTO) {
		
		if("ename".equals(empDTO.getType())) {
			
			empDTO.setEname(empDTO.getKeyword());
			
		}else if (empDTO.getType() != null && empDTO.getType().equals("sal")) {
			try {
				
				int sal = Integer.parseInt(empDTO.getKeyword());
				empDTO.setSal(sal);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		List<EmpDTO> dto = sqlSession.selectList("mapper.emp.dynamic.selectEmp",empDTO);
		
		System.out.println("searchEmp" + dto);
		return dto;
	}
}
