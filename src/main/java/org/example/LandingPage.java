package org.example;

import AbstractMethods.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {
  WebDriver driver ;

  public LandingPage(WebDriver driver){
    super(driver);
      this.driver = driver;
      //for page factory
      PageFactory.initElements(driver,this);
  }

 //WebElement usermail =driver.findElement(By.id("userEmail"));

  //pagefcatory
    @FindBy(id="userEmail")
    WebElement userEmail;


   //driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");

    @FindBy(id="userPassword")
    WebElement userPassword;

    //driver.findElement(By.id("login")).click();
    @FindBy(id="login")
    WebElement submit;

    public void loginApplication(String email,String password){
      userEmail.sendKeys(email);
      userPassword.sendKeys(password);
      submit.click();

    }

    public void goTo(){
      driver.get("https://rahulshettyacademy.com/client");
    }




}
