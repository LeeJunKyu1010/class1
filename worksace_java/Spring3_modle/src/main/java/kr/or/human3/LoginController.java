package kr.or.human3;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	// 로그인 페이지 표시
	@RequestMapping("/login.do")
	public ModelAndView lonigForm() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");

		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {

//		ModelAndView  mav = new ModelAndView();
//		mav.setViewName("result");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + "\n" + pw);

		request.setAttribute("id1", id);

		ModelAndView mav = new ModelAndView("result");
		mav.addObject("id2", id);

		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		mav.addObject("dto", memberDTO);

		return mav;
//		return mav = new ModelAndView("result");
	}

	@RequestMapping("/login2")
	public ModelAndView login2(
	// String id = request.getParameter("id"); 과 같음
	// 기본적으로 필수값. 없다면 400 Bad Reques 코드 발생
//			@RequestParam("id")
			@RequestParam(value = "id", required = false) String id,

			// parmeter의 key와 변수명이 같다면 @RequestParam 생략 가능
			// RequestParam을 생략 하면
			// @RequestParam(value = "pw", required = false)
			String pw, String a, // 안줬으니까 null
//			, int b // null이 안들어가서 500오류
			@RequestParam Map map, MemberDTO memberDTO) {

//		String id = request.getParameter("id");
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		System.out.println("map : " + map.get("id"));
		System.out.println("memberDTO : " + memberDTO);
		ModelAndView mav = new ModelAndView("result");

		return mav;
	}

	@RequestMapping("/login3")
	public ModelAndView login3(
			// 파라메터에서 꺼내서
			// DTO에 알아서 넣어줌
			@ModelAttribute
			MemberDTO dto1,
			
			// DTO를 자동으로 채우고
			// 모델에 넣어주기까지 해줌 아랫줄 생략가능
			// mav.addObject("dto2", dto2);
			@ModelAttribute("dto22")
			MemberDTO dto2,
			
			// DTO 타입의 앞 글자만 소문자로 변경한 key로
			// model에 넣어줌
			// @ModelAttribute("memberDTO")
			MemberDTO dto3
	) {
		System.out.println("dto1 : "+dto1);
		
		ModelAndView mav = new ModelAndView("result");
		mav.addObject("dto11", dto1);
		
		return mav;
	}
}
