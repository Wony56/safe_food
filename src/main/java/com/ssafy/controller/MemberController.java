package com.ssafy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.Allergy;
import com.ssafy.model.Member;
import com.ssafy.service.AllergyService;
import com.ssafy.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AllergyService allergyService;
	
	@RequestMapping("signUp.do")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response, Member member){
		String[] allergies = request.getParameterValues("allergy");
		String path = "";
		
		try {
			memberService.addMember(member);
			
			for(String allergy : allergies) {
				allergyService.addAllergy(new Allergy(member.getId(), allergy));
			}
			
			path = "redirect:index.jsp";
		}catch(Exception e) {
			path = "errors/error";
			request.setAttribute("error", "signUp");
		}
		
		return new ModelAndView(path);
	}
	
	@RequestMapping("logIn.do")
	public ModelAndView logIn(HttpServletRequest request, HttpServletResponse response, HttpSession session, Member member) {
		Member rvo = null;
		String path = "";
		
		try {
			rvo = memberService.logIn(member);
			
			rvo.setAllergyList(allergyService.getAllergy(rvo.getId()));
			
			session.setAttribute("member", rvo);
			path = "redirect:index.jsp";
		}catch(Exception e) {
			path = "errors/error";
			request.setAttribute("error", "logIn");
		}
		
		return new ModelAndView(path);
	}
	
	@RequestMapping("logOut.do")
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		if(session.getAttribute("member") != null) {
			session.invalidate();
		}
		
		return new ModelAndView("redirect:index.jsp");
	}
	
	@RequestMapping("updateMember.do")
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response, HttpSession session, Member member) throws Exception {
		String[] allergies = request.getParameterValues("allergy");
		
		memberService.updateMember(member);
		
		allergyService.deleteAllergy(member.getId());
		
		for(String allergy : allergies) {
			allergyService.addAllergy(new Allergy(member.getId(), allergy));
		}
		
		member.setAllergyList(allergyService.getAllergy(member.getId()));
		
		session.setAttribute("member", member);
		
		return new ModelAndView("redirect:memberInfo.jsp");
	}
	
	@RequestMapping("deleteMember.do")
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		String path = "redirect:memberInfo.jsp";
		
		Member member = (Member) session.getAttribute("member");
		
		if(member != null) {
			int row = memberService.deleteMember(member.getId());
			
			if(row > 0) {
				session.invalidate();
				path = "redirect:index.jsp";
			}
		}
		
		return new ModelAndView(path);
	}
	
	@RequestMapping("findPwd.do")
	public ModelAndView findPwd(HttpServletRequest request, HttpServletResponse response, Member member) {
		Member rMember = null;
		
		try {
			rMember = memberService.findPassword(member);
			request.setAttribute("result", "ok");
			request.setAttribute("pwd", rMember.getPassword());
		}catch(Exception e) {
			request.setAttribute("result", "fail");
		}
		
		return new ModelAndView("results/findPwdResult");
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionParameter(RuntimeException e, HttpServletRequest req) {
		System.out.println("에러에러에러에러");
		return new ModelAndView("redirect:index.jsp");
	}
}
