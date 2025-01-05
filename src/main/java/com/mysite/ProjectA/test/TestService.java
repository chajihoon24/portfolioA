package com.mysite.ProjectA.test;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.ProjectA.DTO.FinalDTO;
import com.mysite.ProjectA.DTO.UserDTO;

@Service
public class TestService {


	public List<FinalDTO> jsonService2() {
		String apiUrl = "https://jsonplaceholder.typicode.com/users";
		List<UserDTO> userList = new ArrayList<>();
		FinalDTO finalDTO = new FinalDTO();
		List<FinalDTO> newUserList = new ArrayList<>();

		try {
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			int responseCode = connection.getResponseCode();
			if (responseCode == 200) {
				InputStream data = connection.getInputStream();
				ObjectMapper objectMapper = new ObjectMapper();
				userList = objectMapper.readValue(data,
						objectMapper.getTypeFactory().constructCollectionType(List.class, UserDTO.class));
			} else {
				System.out.println("error :" + connection.getResponseMessage());
			}
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());

		}
		for (UserDTO data : userList) {
			finalDTO.setName(data.getName());
			finalDTO.setUsername(data.getUsername());
			finalDTO.setEmail(data.getEmail());

			newUserList.add(finalDTO);
		}
		return newUserList;

	}
}
