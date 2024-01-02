package com.consultoriaglobaltest.cgtest.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class ContactPage {
    @Autowired
    private WebDriver webDriver;

    @PostConstruct
    public void InitContactPage(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.NAME, using = "your-name")
    public WebElement txtUserName;
    @FindBy(how = How.NAME, using = "your-email")
    public WebElement txtMail;
    @FindBy(how = How.NAME, using = "your-subject")
    public WebElement txtSubject;
    @FindBy(how = How.NAME, using = "your-message")
    public WebElement txtMessage;
    @FindBy(how = How.NAME, using = "captcha-636")
    public WebElement txtValidationCode;
    @FindBy(how = How.CSS, using = ".wpcf7-submit")
    public WebElement btnSubmit;


    public void CompleteForm(String userName, String mail, String subject, String message, String validationCode) {
        System.out.println("Completando la información...");
        txtUserName.sendKeys(userName);
        System.out.println("Name: " + userName);
        txtMail.sendKeys(mail);
        System.out.println("Mail: " + mail);
        txtSubject.sendKeys(subject);
        System.out.println("Subject: " + subject);
        txtMessage.sendKeys(message);
        System.out.println("Message: " + message);
        txtValidationCode.sendKeys(validationCode);
        System.out.println("Validation Code: " + validationCode);

    }

    public void SubmitForm(){
        System.out.println("Sending form...");
        btnSubmit.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));

        By spanElement = By.xpath("//span[contains(text(),'La dirección e-mail parece inválida')]");

        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(spanElement));
            System.out.println("Invalid mail detected!");
        } catch (TimeoutException e) {
            System.out.println("No invalid mail error detected.");
        } finally {
            System.out.println("Closing the program...");
        }
    }


}
