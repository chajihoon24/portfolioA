package com.mysite.ProjectA.service;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.ProjectA.DTO.CustomData;
import com.mysite.ProjectA.DTO.ItemDTO;
import com.mysite.ProjectA.DTO.ResponseWrapperDTO;



@Service
public class Mainservice {


	
    public List<CustomData> WeatherService(String city) {
    	int cityX=68;
    	int cityY=121;
    	switch (city) {
    	case "이천시":
    		cityX=68;
    		cityY=121;
    		break;
    	case "성남시":
    		cityX=62;
    		cityY=123;
    		break;
    	case "강남구":
    		cityX=61;
    		cityY=126;
    		break;
    	}
    	
    	
    	LocalDateTime currentDateTime1 = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    	System.out.println(currentDateTime1.format(formatter));
    	
    	
    	LocalDateTime currentDateTime2 = LocalDateTime.now();
    	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH");
        int hour = Integer.parseInt(currentDateTime2.format(formatter1)) - 2;
        if(hour<02) {
        	hour=0;       	
        }else if(hour<05) {
        	hour=2;
        }else if(hour<=8) {
        	hour=5;
        }else if(hour<=11) {
        	hour=8;       	
        }else if(hour<=14) {
        	hour=11;
        }else if(hour<=17) {
        	hour=14;
        }else if(hour<=20) {
        	hour=17;
        }else if(hour<=23) {
        	hour=20;
        }
        
        List<CustomData> weatherList = new ArrayList<>();
        int time=3;
        // 4자리 형식으로 만들기 (2자리로 표시되도록 처리)
        for(int i=1;i<=3;i++) {
        	String formattedTime = String.format("%02d00", hour); 
        String apiUrl = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?ServiceKey=yOUYauWN3w884SILQEEd4%2FJ5tIP6XGff2M4%2BocNwA086Xmg0y%2FFqjlw4x0r0SUoQXYDdzcKIavB5rXfMHaVMlQ%3D%3D&pageNo=1&numOfRows=12&dataType=JSON&base_date="+currentDateTime1.format(formatter)+"&base_time="+formattedTime+"&nx="+cityX+"&ny="+cityY+"&ftype=SHRT";
        System.out.println(apiUrl);

          	
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
        
        List<ItemDTO> itemList = responseWrapperDTO.getResponse().getBody().getItems().getItem();
        CustomData customData=new CustomData();
        for(ItemDTO item : itemList) {
        	switch (item.getCategory()) {
        	
        	case "TMP": //기온
        		customData.setTMP(item.getFcstValue());
        	break;
        	
        	case "REH":  //습도
        		customData.setREH(item.getFcstValue());
        	break;
        	case "SKY":  //하늘 상태
        		
        		if(Integer.parseInt(item.getFcstValue())<=5) {
        			
        			customData.setSKY("맑음");
        			
        		}else if(Integer.parseInt(item.getFcstValue())<=8){
        			customData.setSKY("구름많음");
        		}else {
        			customData.setSKY("흐림");
        		}
        	break;
        	case "WSD": // 풍속
        		customData.setWSD(item.getFcstValue());
        	break;
        	
        	}
  
        }
        customData.setHH(time);
        time=time+3;
        weatherList.add(customData);
        hour=hour-3;
        
        };
        return weatherList;
    }
}

