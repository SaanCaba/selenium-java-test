package com.consultoriaglobaltest.cgtest;

import com.consultoriaglobaltest.cgtest.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CgTestApplicationTests {
	@Autowired
	private MainPage mainPage;
	@Value("${app.url}")
	private String appUrl;

	@Test
	void performContactFormTest() {
		mainPage.PerformCompleteForm();
	}


}