package com.example.restapi;

import com.example.restapi.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		var user = new UserRequest();
		user.setName("홍길동");
		user.setAge(10);
		user.setEmail("dsad@aef");
		user.setIsKorean(true);

		//직렬화 ObjectMapper의 경우 method에 매칭 -> get으로 시작하는 method의 이름에 매칭 돼 변환.
		var json = objectMapper.writeValueAsString(user);
		System.out.println("json = " + json);
		
		//json = {"name":"홍길동","phone_number":null,"email":"dsad@aef","is_korean":true,"age":10}

		//역직렬화 ObjectMapper는 reflection(권한을 무시하고 우회)방식을 사용하기 떄문에 생성자를 막아도 매핑이 가능
		// set or get method와의 매칭 만약 setter와 getter가 둘 다 없다면 JsonProperty를 통해 매칭 가능
		var dto = objectMapper.readValue(json, UserRequest.class);
		System.out.println("dto = " + dto);


	}

}
