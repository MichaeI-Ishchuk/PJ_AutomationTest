package task1;




import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import task1.utils.Properties;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.List;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    private By form =  By.cssSelector(".nav-item");

    private  By loginId = By.cssSelector("#email");
    private By password =  By.cssSelector("#password");


    private  By submit = By.cssSelector("#login_form [name=submitLogin]");







    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);

    }


    public void authorization(String login, String password) throws Exception {

       driver.navigate().to(Properties.getBaseUrl());


        List<WebElement> elementList = driver.findElements(this.form);


        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();"
                ,allProducts);

        allProducts.click();



        WebElement loginId = driver.findElement(this.loginId);
        WebElement password = driver.findElement(this.password);
        loginId.sendKeys(login);
        password.sendKeys(password);

        WebElement submit = driver.findElement(this.sub);
        submit.click();

        waitForContentLoad(this.main);

        getscreenshot();

    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad(By locator) {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void getscreenshot() throws Exception
    {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrFile, new File("screenshot.png"));
    }
}
