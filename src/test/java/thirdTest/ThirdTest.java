package thirdTest;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ThirdTest {

    private static WebDriver driver;
    private static WebElement inputField;

    @Before
    public void runBrowserAndCreateTodos(){
        System.setProperty("webdriver.chrome.driver", "D:\\First_project\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280,800));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // GIVEN
        driver.get("http://todomvc.com/examples/vue/");

        // create todos
        inputField = driver.findElement(By.xpath("//header/input"));

        inputField.sendKeys("car");
        inputField.sendKeys(Keys.ENTER);
    }

    @Test
    public void workWithTodoList() {

        inputField = driver.findElement(By.xpath("//header/input"));

        //WHEN
        //

        //add five wheel
        for (int i = 0; i < 5; i++) {

            inputField.sendKeys("wheel");
            inputField.sendKeys(Keys.ENTER);
        }

        //add bus
        inputField.sendKeys("bus");
        inputField.sendKeys(Keys.ENTER);

        // mark element as done
        WebElement markDoneThirdOfWheel = driver.findElement(By.xpath("(//div/label[text()=\"wheel\"]/../input)[3]"));
        markDoneThirdOfWheel.click();

        //delete element
        WebElement moveToFirstOfWheel = driver.findElement(By.xpath("(//*[text()=\"wheel\"])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(moveToFirstOfWheel).perform();
        WebElement deleteTheFirstOfWheel = driver.findElement(By.xpath("(//div/label[text()=\"wheel\"]/../button)[1]"));
        deleteTheFirstOfWheel.click();

        //see only Active elements
        WebElement activeElements = driver.findElement(By.xpath("//*[text()=\"Active\"]"));
        activeElements.click();

        //THEN
        //
        // check number of todos
        Assert.assertEquals(driver.findElements(By.xpath("//*[@class=\"view\"]")).size(), 5);

        // check number of wheel
        Assert.assertEquals(driver.findElements(By.xpath("//*[text()=\"wheel\"]")).size(), 3);

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
