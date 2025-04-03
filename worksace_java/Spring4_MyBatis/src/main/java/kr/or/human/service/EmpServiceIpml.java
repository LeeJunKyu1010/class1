package kr.or.human.service;

import java.util.List;

import kr.or.human.dto.EmpDTO;

public class EmpServiceIpml {

	void paging() {
		int page = 3;
		int viewCount = 10;
		
//		int idxStart = 21;
//		int idxEnd = 30;
	
//		20+1		
//		(10 * 2) +1
//		(viewCount * 2) +1
//		(viewCount * (3-1)) +1
		int idxStart = (viewCount * (page-1)) +1;
		int idxEnd = page * viewCount;
	}
	

	
}
