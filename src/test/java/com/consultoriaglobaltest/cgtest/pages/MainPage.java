package com.consultoriaglobaltest.cgtest.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MainPage {

    public MainPage(){
        System.out.println("In main page");
    }

    @Autowired
    private ContactPage contactPage;
    @Autowired
    private HomePage homePage;

    @Value("${app.url}")
    private String appUrl;

    @Autowired
    private WebDriver webDriver;

    public void PerformCompleteForm(){
        webDriver.manage().window().maximize();
        webDriver.navigate().to(appUrl);

        homePage.ClickContact();
        contactPage.CompleteForm("Santiago", "Santim.com", "Test subject", "Hola a todos!", "123");
        contactPage.SubmitForm();
    }


}
