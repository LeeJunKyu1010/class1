package kr.or.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.human.dao.EmpDAO;
import kr.or.human.dto.EmpDTO;

@Controller
public class EmpController {

	@Autowired
	EmpDAO empDAO;

	@RequestMapping(value = "/emp", method = { RequestMethod.GET, RequestMethod.POST })
	public String listEMP(Model model, @RequestParam(required = false) String action) {

		if ("click".equals(action)) {
			List<EmpDTO> select = empDAO.selectEmpList();
			model.addAttribute("select", select);
			System.out.println("클릭");
		}
		return "emp";
	}

	@RequestMapping(value = "/empOne", method = { RequestMethod.GET, RequestMethod.POST })
	public String empOne(Model model) {

		EmpDTO select = empDAO.selectOneEmp();
		model.addAttribute("select", select);

		return "emp";
	}

	@RequestMapping(value = "/empno", method = { RequestMethod.GET, RequestMethod.POST })
	public String empno(Model model, 
			@RequestParam("empno")
			int empno) {
			EmpDTO select = empDAO.selectOneEmpno(empno);
			model.addAttribute("select", select);
		return "emp";
	}
	
	@RequestMapping(value = "/detailEmp", method = { RequestMethod.GET, RequestMethod.POST })
	public String empno2( 
			@ModelAttribute
			EmpDTO empDTO,
			Model model) {
		
			EmpDTO dto = empDAO.selectOneEmpno2(empDTO);
			System.out.println("empno2 : " + dto);
			model.addAttribute("dto", dto);
			
		return "detailEmp";
	}
	
//	@RequestMapping(value = "/emp", method = RequestMethod.PUT)
//	public String modifyEmp(Model model) {
//		// 실제로 update 실행하는곳
//	}
	
	@RequestMapping(value = "/modifyEmp", method = { RequestMethod.GET, RequestMethod.POST })
	public String empno3(Model model, 
			@ModelAttribute
			EmpDTO empDTO) {
			EmpDTO dto = empDAO.selectOneEmpno2(empDTO);
			System.out.println("empno3 : " + dto);
			model.addAttribute("dto", dto);
		return "modifyEmp";
	}
	

}
