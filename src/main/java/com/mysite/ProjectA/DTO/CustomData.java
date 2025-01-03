package com.mysite.ProjectA.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomData {
	
	
	
	private String TMP;
	private String REH;
	private String SKY;
	private String WSD;
	private int HH;
	
	public CustomData() {
		this.TMP = "Unknown";
		this.REH = "Unknown";
		this.SKY = "Unknown";
		this.WSD = "Unknown";
	}

}
