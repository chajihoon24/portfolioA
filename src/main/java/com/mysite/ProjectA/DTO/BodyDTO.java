package com.mysite.ProjectA.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BodyDTO {
	 private String dataType;  // 데이터 타입
	 private ItemsDTO items;
	    private int pageNo;
	    private int numOfRows;
	    private int totalCount;
}
