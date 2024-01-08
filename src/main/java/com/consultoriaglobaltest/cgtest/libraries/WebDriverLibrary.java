package com.consultoriaglobaltest.cgtest.libraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverLibrary {
    @Bean
    public WebDriver getChromeDriver(){
        ChromeOptions co = new ChromeOptions();

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver(co);
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
