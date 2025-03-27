package kr.or.human4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WtController {
	List list = new ArrayList();

	@RequestMapping(value = "/Wt")
	public String addWt(WtDTO dto, Model model) {
		System.out.println("addWt 실행");
		
		list.add(dto);

//		model.addAttribute("list",list);
		return "Wt";
	}
	
}
