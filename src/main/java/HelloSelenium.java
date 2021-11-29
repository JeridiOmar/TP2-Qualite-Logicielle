import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HelloSelenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100000));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(200));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
        driver.get("https://www.tunisianet.com.tn/");
        /**
         * Step 1 Go to connexion page
         */
        Thread.sleep(1500);
        WebElement userInfoDropdown = driver.findElement(By.cssSelector("#_desktop_user_info > div > div > svg"));
        userInfoDropdown.click();

        // Click on "Connexion"
        Thread.sleep(1500);
        WebElement signinButton = driver.findElement(By.cssSelector(".user-down > li > a > span"));
        signinButton.click();
        /**
         * Step 2 Enter credentials to log in
         */
        // Fill the email field
        Thread.sleep(1500);
        WebElement emailTextField = driver.findElement(By.cssSelector(".form-group > div > input"));
        emailTextField.sendKeys("amrouch_jridi@hotmail.fr");

        // Fill the password field
        Thread.sleep(1500);
        WebElement pwdTextField = driver.findElement(By.cssSelector(".form-group > div > div > input"));
        pwdTextField.sendKeys("55479319");

        // Click on sign in
        Thread.sleep(1500);
        WebElement submitButton = driver.findElement(By.id("submit-login"));
        submitButton.click();
        /**
         * Step 3 Search for MAc
         */
        // Search for the desired Mac
        Thread.sleep(1500);
        WebElement searchBar = driver.findElement(By.className("search_query"));
        searchBar.sendKeys("PC portable MacBook M1 13.3");

        // Click to search
        Thread.sleep(1500);
        WebElement searchButton = driver.findElement(By.cssSelector("#sp-btn-search > button"));
        searchButton.click();

        // Click on the first product
        Thread.sleep(1500);
        List<WebElement> productsTitle = driver.findElements(By.className("product-title"));
        productsTitle.get(0).click();
        /**
         * Step 4 Buy process
         */
        // Add product to cart
        Thread.sleep(1500);
        WebElement addToCartButton = driver.findElement(By.className("add-to-cart"));
        addToCartButton.click();

        // Click to order
        Thread.sleep(1500);
        WebElement orderButton = driver.findElement(By.cssSelector("a.btn-block"));
        orderButton.click();
    }
}
