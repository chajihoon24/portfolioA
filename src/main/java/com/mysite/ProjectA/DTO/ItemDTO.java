package com.mysite.ProjectA.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
    private String baseDate;   // 기준 날짜
    private String baseTime;   // 기준 시간
    private String category;   // 예보 카테고리
    private String fcstDate;   // 예보 날짜
    private String fcstTime;   // 예보 시간
    private String fcstValue;  // 예보 값
    private int nx;            // 예보 좌표 nx
    private int ny;            // 예보 좌표 ny

}
