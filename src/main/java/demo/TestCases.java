package demo;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;
    WebDriverWait wait;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        // Pseudocode
        // 1.
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com");
        Thread.sleep(2000);
        String homeUrl = driver.getCurrentUrl();
        if (homeUrl.contains("leetcode")) {

            System.out.println("The URL of the Leetcode homepage contains leetcode : PASS");
        } else {

            System.out.println("The URL of the Leetcode homepage missing leetcode : FAIL");
        }

        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {

        System.out.println("Start Test case: testCase02");
        WebElement viewQues = driver.findElement(By.xpath("(//p[@class='link'])[2]"));
        viewQues.click();
        Thread.sleep(3000);
        String problemUrl = driver.getCurrentUrl();
        if (problemUrl.contains("problemset")) {

            System.out.println("The URL of the Leetcode questions page contains problemset : PASS");
        } else {

            System.out.println("The URL of the Leetcode questions page missing problemset : FAIL");
        }
        List<WebElement> questions = driver.findElements(By.xpath(
                "//div[@role='cell' and contains(@class, 'flex items-center') and @style[contains(., 'width: 260px')]]"));
        for (int i = 1; i < 6; i++) {

            String text = questions.get(i).getText();
            System.out.println("Questions " + text);
            if (i == 1) {

                if (text.contains("Two Sum")) {

                    System.out.println("First Question is Two Sum : PASS");
                } else {

                    System.out.println("First Question is not Two Sum : FAIL");
                }
            }

        }

        System.out.println("end Test case: testCase02");
    }

    public void testCase03() {

        System.out.println("Start Test case: testCase03");
        WebElement twoSumQues = driver.findElement(By.xpath("//a[normalize-space()='1. Two Sum']"));
        twoSumQues.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='submissions_tab']")));
        String twoSumUrl = driver.getCurrentUrl();
        if (twoSumUrl.contains("two-sum")) {

            System.out.println("The URL of the problem contains two-sum : PASS");
        } else {

            System.out.println("The URL of the problem missing two-sum : PASS : FAIL");
        }

        System.out.println("end Test case: testCase03");
    }

    public void testCase04() throws InterruptedException {

        System.out.println("Start Test case: testCase04");
        WebElement submissionsTab = driver.findElement(By.xpath("//div[@id='submissions_tab']"));
        submissionsTab.click();
        Thread.sleep(1000);
        WebElement SignIn = driver.findElement(By.xpath("//a[normalize-space()='Register or Sign In']"));
        String signinText = SignIn.getText();
        if (signinText.equalsIgnoreCase("Register or Sign In")) {

            System.out.println(
                    "The message Register or Sign In is displayed when you click on the submissions tab : PASS");
        } else {

            System.out.println(
                    "The message Register or Sign In is not displayed when you click on the submissions tab : FAIL");
        }

        System.out.println("end Test case: testCase04");
    }
}
