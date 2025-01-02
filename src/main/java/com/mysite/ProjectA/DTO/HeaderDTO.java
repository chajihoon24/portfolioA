package com.mysite.ProjectA.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeaderDTO {
    private String resultCode;  // 상태 코드
    private String resultMsg;

}
