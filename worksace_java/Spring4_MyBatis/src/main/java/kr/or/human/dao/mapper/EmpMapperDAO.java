package kr.or.human.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.or.human.dto.EmpDTO;

@Mapper
public interface EmpMapperDAO {

	List<EmpDTO> selecteEmp();
	
	@Select("select * form emp2 where empno = #{empno}")
	List<EmpDTO> selecteDetailEmp(@Param("empno") int empno);

}
