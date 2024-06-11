package org.example;

import AbstractMethods.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponents {

    WebDriver driver ;

    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver = driver;
        //for page factory
        PageFactory.initElements(driver,this);
    }

    //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

    //pagefcatory
    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
            WebElement spinner;

    By productBy = By.cssSelector(".mb-3");
    By toastMessage = By.cssSelector("#toast-container");


public List<WebElement> getProductList(){
  WaitElementToAppear(productBy);
  return products;
}

public WebElement getProductByName(String productName){
    WebElement prod = products.stream().filter(product ->
            product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);

    return prod;
}

public void addproductToCart (String productName){
  WebElement prod = getProductByName(productName);
  prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
  //tost message validation
  WaitElementToAppear(toastMessage);
  //wait for element to dissapear
  WaitForElementToDissapear(spinner);
}










}
