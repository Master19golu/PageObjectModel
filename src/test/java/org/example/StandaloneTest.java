package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandaloneTest {
    public static void main(String[] args) throws InterruptedException {
        String ProductName = "IPHONE 13 PRO";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.get("https://rahulshettyacademy.com/client");

        //craeting object of landing page
        LandingPage page  = new LandingPage(driver);
        page.goTo();
        page.loginApplication("anshika@gmail.com","Iamking@000");

        driver.manage().window().maximize();
        //store all products in list
        //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        List<WebElement> products=productCatalogue.getProductList();
        String productName ="IPHONE 13 PRO";
        productCatalogue.addproductToCart(productName);
        productCatalogue.gotoCartPage();


        //WebElement prod = products.stream().filter(product ->
          //      product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
        //click on add to cart
        //prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        //toast message validation
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        //ng animation
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animation"))));
        //Thread.sleep(4000);
        //driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
        //validation of product on the cart section
        List<WebElement> cart = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = cart.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(ProductName));
        Assert.assertTrue(match);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
        //country selection
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
        String confirmMessage = driver.findElement(By.xpath("//h1[text()=' Thankyou for the order. ']")).getText();
        Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");
        driver.close();

    }
}
