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

	// 전체조회
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public String listEMP(Model model, @RequestParam(required = false) String action) {

//		if ("click".equals(action)) {
		List<EmpDTO> select = empDAO.selectEmpList();
		model.addAttribute("select", select);
		System.out.println("클릭");
//		}
		return "emp";
	}

	// 부분조회
	@RequestMapping(value = "/empOne", method = { RequestMethod.GET, RequestMethod.POST })
	public String empOne(Model model) {

		EmpDTO select = empDAO.selectOneEmp();
		model.addAttribute("select", select);

		return "emp";
	}

	// empno 조회
	@RequestMapping(value = "/empno", method = { RequestMethod.GET, RequestMethod.POST })
	public String empno(Model model, @RequestParam("empno") int empno) {
		EmpDTO select = empDAO.selectOneEmpno(empno);
		model.addAttribute("select", select);
		return "emp";
	}

	// 상세조회
	@RequestMapping(value = "/detailEmp", method = { RequestMethod.GET, RequestMethod.POST })
	public String empno2(@ModelAttribute EmpDTO empDTO, Model model) {

		EmpDTO dto = empDAO.selectOneEmpno2(empDTO);
		System.out.println("empno2 : " + dto);
		model.addAttribute("dto", dto);

		return "detailEmp";
	}

	// 수정
	@RequestMapping(value = "/modifyEmp", method = { RequestMethod.GET, RequestMethod.POST })
	public String empno3(Model model, @ModelAttribute EmpDTO empDTO) {
		EmpDTO dto = empDAO.selectOneEmpno2(empDTO);
		System.out.println("empno3 : " + dto);
		model.addAttribute("dto", dto);
		return "modifyEmp";
	}

	// 수정 완료
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String modifyEmp2(Model model, @ModelAttribute EmpDTO empDTO) {
		// 실제 update
		EmpDTO dto = empDAO.updateEMP(empDTO);
		model.addAttribute("dto", dto);

		System.out.println("Controller modifyEmp2 empDTO : " + empDTO);
		return "redirect:emp";
	}

	@RequestMapping(value = "/insertEmp", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertEmp(Model model, @ModelAttribute EmpDTO empDTO, String action) {
		if ("click".equals(action)) {
			EmpDTO dto = empDAO.insertEmp(empDTO);
			System.out.println("Controller insertEmp empDTO : " + empDTO);
			System.out.println("insert 등록클릭");
			return "redirect:emp";
		}
		System.out.println("insert 클릭");
		return "insertEmp";
	}

	@RequestMapping(value = "/deleteEmp", method = RequestMethod.GET)
	public String deleteEmp(Model model, @ModelAttribute EmpDTO empDTO) {

			EmpDTO dto = empDAO.deleteEmp(empDTO);
			model.addAttribute("dto", dto);
			System.out.println("delete 클릭");

		return "redirect:emp";
	}

}
