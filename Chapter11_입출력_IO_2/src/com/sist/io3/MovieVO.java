package com.sist.io3;

import java.io.Serializable;

public class MovieVO implements Serializable{
	private int no;
	private String title;
	private String poster;
	private String score;
	private String reservate;
	private String open;
	private int cno;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

	public String getReservate() {
		return reservate;
	}
	public void setReservate(String reservate) {
		this.reservate = reservate;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	
}
