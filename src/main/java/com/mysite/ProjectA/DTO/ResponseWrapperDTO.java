package com.mysite.ProjectA.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseWrapperDTO {
    private ResponseDTO response;  // JSON 응답의 최상위 필드
}