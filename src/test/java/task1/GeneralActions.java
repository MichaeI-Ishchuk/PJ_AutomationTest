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

    private By formAuth =  By.cssSelector("li a");
    private By form =  By.cssSelector("form[name=login]");
    private  By loginId = By.cssSelector("input[name=username]");
    private By password =  By.cssSelector("input[name=password]");
    private  By submit = By.cssSelector(".radius i");
    private  By success = By.cssSelector(".flash.success");


    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);

    }


    public void authorization(String login, String password) throws Exception {

       driver.navigate().to(Properties.getBaseUrl());

        List<WebElement> list = driver.findElements(this.formAuth);
        WebElement formAuth = list.get(17);

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();"
                ,formAuth);

        formAuth.click();
        waitForContentLoad(form);

        WebElement loginId = driver.findElement(this.loginId);
        WebElement passwd = driver.findElement(this.password);
        loginId.sendKeys(login);
        passwd.sendKeys(password);

        WebElement submit = driver.findElement(this.submit);
        submit.click();

        waitForContentLoad(success);

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
