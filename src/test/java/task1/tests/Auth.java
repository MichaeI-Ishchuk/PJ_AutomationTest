package task1.tests;
import task1.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auth extends BaseTest {



    @Test(dataProvider = "logIn")
    public void successfulAuthorization(String login, String password) throws Exception {

        actions.authorization(login, password);


    }



}
