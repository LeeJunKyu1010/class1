package kr.or.human4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WtService {

	@Autowired
	private WtDAO wtDAO;

	public void addWt(WtDTO dto) {
		wtDAO.addWt(dto);
	}

	public List getAllWt() {
		return wtDAO.getAllWt();
	}
}
