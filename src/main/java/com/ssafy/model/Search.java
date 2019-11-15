package com.ssafy.model;

import java.io.Serializable;

public class Search implements Serializable{
	private String id;
	private String keyword;
	private String search_date;
	
	public Search() {
		
	}

	public Search(String id, String keyword, String search_date) {
		super();
		this.id = id;
		this.keyword = keyword;
		this.search_date = search_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearch_date() {
		return search_date;
	}

	public void setSearch_date(String search_date) {
		this.search_date = search_date;
	}

	@Override
	public String toString() {
		return "Search [id=" + id + ", keyword=" + keyword + ", search_date=" + search_date + "]";
	}
	
}
