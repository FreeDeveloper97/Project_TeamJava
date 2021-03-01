package org.spring.dto;

public class MemberVO {
	private int no;
	private String spotName;
	private int dustDegree;
	private String time;
	private int isIndoor;
	
	public MemberVO() {
		super();
	}
	
	public MemberVO( int no, String spotName, int dustDegree, String time, int isIndoor)
	{
		this.no = no;
		this.spotName = spotName;
		this.dustDegree = dustDegree;
		this.time = time;
		this.isIndoor = isIndoor;
	}
	public MemberVO( String spotName, int isIndoor)
	{
		this.no = 0;
		this.spotName = spotName;
		this.dustDegree =0;
		this.time = "0";
		this.isIndoor = isIndoor;
	}
	public MemberVO(String spotName, int dustDegree, String time, int isIndoor)
	{
		this.no = 0;
		this.spotName = spotName;
		this.dustDegree = dustDegree;
		this.time = time;
		this.isIndoor = isIndoor;
	}
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSpotName() {
		return spotName;
	}

	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}

	public int getDustDegree() {
		return dustDegree;
	}

	public void setDustDegree(int dustDegree) {
		this.dustDegree = dustDegree;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getIsIndoor() {
		return isIndoor;
	}

	public void setIsIndoor(int is_indoor) {
		this.isIndoor = is_indoor;
	}

	
	
	
}
