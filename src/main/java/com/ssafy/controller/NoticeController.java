package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.Notice;
import com.ssafy.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("registerNotice.do")
	public ModelAndView registerNotice(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session, Notice notice){
		
		int row = 0;
				
		try {
			row = noticeService.addNotice(notice);
		}catch(Exception e) {
			
		}
		
		return new ModelAndView("redirect:getNoticeList.do");
	}
	
	@RequestMapping("getNoticeList.do")
	public ModelAndView getNoticeList(HttpServletRequest request, HttpServletResponse response){
		
		List<Notice> noticeList = null;
		
		try {
			noticeList = noticeService.getAllNotice();
		}catch(Exception e) {
			
		}
		
		
		return new ModelAndView("notice","noticeList", noticeList);
	}
	
	@RequestMapping("getNotice.do")
	public ModelAndView getNotice(HttpServletRequest request, HttpServletResponse response, HttpSession session, String idx){
		
		Notice notice = null;
		
		try {
			notice = noticeService.getNotice(Integer.parseInt(idx));
		}catch(Exception e) {
			
		}
		
		session.setAttribute("notice", notice);
		
		return new ModelAndView("noticeView");
	}
	
	@RequestMapping("deleteNotice.do")
	public ModelAndView deleteNotice(HttpServletRequest request, HttpServletResponse response, String idx){
		int row = 0;
		
		try {
			row = noticeService.deleteNotice(Integer.parseInt(idx));
		}catch(Exception e) {
			
		}
		
		return new ModelAndView("redirect:getNoticeList.do");
	}
	
	
	@RequestMapping("updateNotice.do")
	public ModelAndView updateNotice(HttpServletRequest request, HttpServletResponse response, Notice notice){
		
		int row = 0;
		
		try {
			row = noticeService.updateNotice(notice);
		}catch(Exception e) {
			
		}
		
		
		return new ModelAndView("redirect:getNotice.do?idx="+notice.getIdx());
	}
}
