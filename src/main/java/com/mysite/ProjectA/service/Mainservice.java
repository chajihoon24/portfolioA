package com.mysite.ProjectA.service;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.ProjectA.DTO.ResponseWrapperDTO;



@Service
public class Mainservice {


	
    public ResponseWrapperDTO WeatherService() {
        String apiUrl = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?ServiceKey=yOUYauWN3w884SILQEEd4%2FJ5tIP6XGff2M4%2BocNwA086Xmg0y%2FFqjlw4x0r0SUoQXYDdzcKIavB5rXfMHaVMlQ%3D%3D&pageNo=1&numOfRows=12&dataType=JSON&base_date=20250102&base_time=0500&nx=68&ny=121&ftype=SHRT";

        ResponseWrapperDTO responseWrapperDTO = new ResponseWrapperDTO();
        try {
            // API 호출
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                ObjectMapper objectMapper = new ObjectMapper();
                responseWrapperDTO = objectMapper.readValue(inputStream, ResponseWrapperDTO.class);

                // 응답 확인
                System.out.println("Response Header: " + responseWrapperDTO.getResponse().getHeader().getResultMsg());
                System.out.println("Items: " + responseWrapperDTO.getResponse().getBody().getItems());
            } else {
                // 실패한 경우 처리
                responseWrapperDTO.getResponse().getHeader().setResultCode("ERROR");
                responseWrapperDTO.getResponse().getHeader().setResultMsg("Failed to fetch data.");
            }
        } catch (Exception e) {
            // 예외 처리
            responseWrapperDTO.getResponse().getHeader().setResultCode("ERROR");
            responseWrapperDTO.getResponse().getHeader().setResultMsg("Exception occurred: " + e.getMessage());
        }

        return responseWrapperDTO;
    }
}

