import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Flushable;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Task01WebFormSubmission {

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
    @DisplayName("Check if form is submitting properly")
    public void submitForm() throws InterruptedException {

        Faker faker = new Faker();

        String name = faker.name().firstName();
        String number = "0170" + Utils.randomPhoneNumber(1000000, 9999999);
        String email = name.toLowerCase()+"@gmail.com";

        driver.get("https://www.digitalunite.com/practice-webform-learners");

        WebElement btnElement = driver.findElement(By.id("onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
        actions.click(btnElement).perform();
        Thread.sleep(1000);
        Utils.scroll(driver, 500);

        List<WebElement> formElements = driver.findElements(By.className("form-control"));
        formElements.get(0).sendKeys(name);
        formElements.get(1).sendKeys(number);
        formElements.get(2).sendKeys("12/22/2024");
        formElements.get(3).sendKeys(email);
        formElements.get(4).sendKeys("My name is Tanjid");

        WebElement uploadImage = driver.findElement(By.id("edit-uploadocument-upload"));
        uploadImage.sendKeys(System.getProperty("user.dir") + "/src/test/resources/s13.jpg");
        Thread.sleep(3000);

        WebElement clickCheckBox = driver.findElement(By.id("edit-age"));
        clickCheckBox.click();
        Thread.sleep(1000);

        WebElement clickSubmitButton = driver.findElement(By.id("edit-submit"));
        clickSubmitButton.click();

        WebElement confirmationMessage = driver.findElement(By.tagName("h1"));
        String actualMessage = confirmationMessage.getText();
        String expectedMessage = "Thank you for your submission!";
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @AfterAll
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
