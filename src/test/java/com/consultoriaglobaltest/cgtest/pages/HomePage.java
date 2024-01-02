package com.consultoriaglobaltest.cgtest.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage {
    @Autowired
    private WebDriver webDriver;

    @PostConstruct
    public void InitHomePage(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.LINK_TEXT, using = "Contáctenos")
    public WebElement contactBtn;


    public ContactPage ClickContact(){
        System.out.println("Entering the contact section...");
        contactBtn.click();
        return new ContactPage();
    }

}
