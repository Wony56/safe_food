package com.ssafy.model;

public class Notice {
	private int idx;
	private String title;
	private String content;
	private String writer;
	private String date;
	
	public Notice() {
		
	}

	public Notice(String title, String content, String writer, String date) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}

	public Notice(int idx, String title, String content, String writer, String date) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Notice [idx=" + idx + ", title=" + title + ", content=" + content + ", writer=" + writer + ", date="
				+ date + "]";
	}
}
