import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Utils {
    public static void scroll(WebDriver driver, int height){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, "+height+")");
    }

    public static int randomPhoneNumber(int min, int max) {
        double randomPhoneNumber = Math.random()*(max-min)+min;
        return (int) randomPhoneNumber;
    }

}