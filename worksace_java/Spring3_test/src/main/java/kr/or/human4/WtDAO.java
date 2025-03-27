package kr.or.human4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class WtDAO {

	private List list = new ArrayList();

	// 등록
	public void addWt(WtDTO dto) {
		list.add(dto);
	}

	// 조회
	public List getAllWt() {
		return list;
	}
}
