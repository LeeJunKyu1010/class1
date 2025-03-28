package kr.or.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.human.dao.EmpDAO;
import kr.or.human.dto.EmpDTO;

@Controller
public class EmpController {
	
	@Autowired
	EmpDAO empDAO;
	
	@RequestMapping(value = "/emp", method= {RequestMethod.GET,RequestMethod.POST})
	public String listEMP(Model model, @RequestParam(required = false) String action) {
		
		if("click".equals(action)) {
			List<EmpDTO> select = empDAO.selectEmpList();
			model.addAttribute("select",select);
			System.out.println("클릭");		
		}
		return "emp";
	}
	
}
