package kr.or.human.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kr.or.human.dto.EmpDTO;

public class EmpView {
	
	public void viewEmp(List<EmpDTO> list, HttpServletResponse response) throws IOException{
		 
		 for(int i = 0; i<list.size(); i++) {
			    response.getWriter().println(list.get(i).getEmpno());
			    response.getWriter().println(list.get(i).getEname());
			    response.getWriter().println(list.get(i).getHiredate());;
			}
	}
	
}
