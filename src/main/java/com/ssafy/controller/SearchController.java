package com.ssafy.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.model.Member;
import com.ssafy.model.Search;
import com.ssafy.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping("addSearch.do")
	public void addSearch(HttpServletRequest request, HttpServletResponse response, String keyword) throws Exception{
		Member member = (Member)request.getSession().getAttribute("member");
		String id = member.getId();
		Search search = new Search(id, keyword, "");
		int re = searchService.updateSearch(search);
		if(re == 0) {
			searchService.addSearch(search);
		}
	}
	
	@RequestMapping("selectSearch.do")
	@ResponseBody
	public HashSet<String> selectSearch(HttpServletRequest request, HttpServletResponse response, String term) throws Exception{
		Member member = (Member)request.getSession().getAttribute("member");
		String id = "none";
		if(member != null) {
			id = member.getId();
		}
		System.out.println("id : "+id+"\t term : "+term);
		Search search = new Search(id, term, "");
		List<Search> sList = searchService.selectSearch(search);
		HashSet<String> sSet = new HashSet<>();
		for(Search s : sList) {
			sSet.add(s.getKeyword());
		}
		return sSet;
	}
}
