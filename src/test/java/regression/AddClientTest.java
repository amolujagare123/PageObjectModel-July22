package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Clients;
import pages.Login;
import pages.Menu;

import java.io.IOException;

import static utility.ConfigReader.*;

public class AddClientTest {
    WebDriver driver;

    @BeforeClass
    public void doLogin() throws IOException
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUser(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }


    @Test
    public void addClientTest() throws IOException {

        Menu menu = new Menu(driver);
        menu.clickAddClient();

        Clients clients = new Clients(driver);

        clients.setLanguage("Danish");
        clients.setCountry("Nepal");
        clients.setGender("Female");
        clients.setBirthDate("07/21/1900");

       /* clients.setClientName("Priyanka");
        clients.setClientSurname("bari");
        clients.setClientAdd1("xyz");
        clients.setClientAdd2("abc");
        clients.setClientCity("PUNE");
        clients.setClientState("MH");
        clients.setClientZip("67676767");
        clients.setClientPhone("787878");
        clients.setClientFax("889899");
        clients.setClientMobile("787878787");
        clients.setClientEmail("a@b.com");
        clients.setClientWeb("www.xyz.com");
        clients.setClientVat("89898");
        clients.setClientTax("898989");
        clients.clickSave();*/
    }
}
