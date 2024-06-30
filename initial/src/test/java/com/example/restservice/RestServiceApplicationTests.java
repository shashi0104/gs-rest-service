package com.example.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestServiceApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private String baseUrl;

	@BeforeEach
	public void setUp() {
		baseUrl = "http://localhost:" + port + "/employees";
	}

	@Test
	public void testGetAllEmployees() {
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void testAddEmployee() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		String newEmployeeJson = "{\"employee_id\":3,\"first_name\":\"Steve\",\"last_name\":\"Smith\",\"email\":\"steve.smith@example.com\",\"title\":\"Analyst\"}";

		HttpEntity<String> request = new HttpEntity<>(newEmployeeJson, headers);

		ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.POST, request, String.class);
	}

}
