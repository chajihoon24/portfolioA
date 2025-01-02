package com.mysite.ProjectA.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private HeaderDTO header;
    private BodyDTO body;

    // 기본 생성자
    public ResponseDTO() {
        this.header = new HeaderDTO();  // HeaderDTO 초기화
    }

}