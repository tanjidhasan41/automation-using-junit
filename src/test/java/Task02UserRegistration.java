import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Task02UserRegistration {

    WebDriver driver;

    @BeforeAll
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headed");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    @DisplayName("Check if user can registration successfully")
    public void userRegistration() throws InterruptedException {

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase()+"@gmail.com";
        //String password = Utils.generateRandomPassword();
        String phoneNumber = "0170" + Utils.randomPhoneNumber(1000000, 9999999);

        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");

        List<WebElement> formElements = driver.findElements(By.className("input-text"));
        formElements.get(0).sendKeys(firstName);
        formElements.get(1).sendKeys(email);
        formElements.get(2).sendKeys("usEr1!tEst");
        formElements.get(3).sendKeys(lastName);
        formElements.get(5).sendKeys("Bangladeshi");

        WebElement gender = driver.findElement(By.id("radio_1665627729_Male"));
        gender.click();

        Select country = new Select(driver.findElement(By.id("country_1665629257")));
        country.selectByValue("BD");

        List<WebElement> dobField = driver.findElements(By.cssSelector("[type=text]"));
        WebElement firstDob = dobField.get(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', '1995-11-25')", firstDob);

        List<WebElement> phoneNumberID = driver.findElements(By.id("phone_1665627880"));
        phoneNumberID.get(1).sendKeys(phoneNumber);

        Utils.scroll(driver, 500);

        WebElement termsAndConditions = driver.findElement(By.id("privacy_policy_1665633140"));
        termsAndConditions.click();
        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.className("ur-submit-button"));
        submitButton.click();

        WebElement confirmationMessage = driver.findElement(By.id("ur-submit-message-node"));
        String actualMessage = confirmationMessage.getText();
        String expectedMessage = "User successfully registered.";
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @AfterAll
    public void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
