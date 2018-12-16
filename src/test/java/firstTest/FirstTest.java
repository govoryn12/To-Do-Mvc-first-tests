package firstTest;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest {


    private static WebDriver driver;

    // GIVEN
    @Before
    public  void runBrowser(){
        System.setProperty("webdriver.chrome.driver", "D:\\First_project\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280,800));//set1280x800
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//what it means?
        driver.get("http://todomvc.com/examples/vue/");
    }


    @Test
    public void workWithTodoList(){

        //WHEN
        //
        // create todos
        WebElement inputField = driver.findElement(By.xpath("//header/input"));

        inputField.sendKeys("tea");
        inputField.sendKeys(Keys.ENTER);

        inputField.sendKeys("coffe");
        inputField.sendKeys(Keys.ENTER);


        //THEN
        //
        // check number of todos
        Assert.assertNotEquals(driver.findElements(By.xpath("//li/div[@class=\"view\"]")).size(), 3);
    }


    @After

    public void closeBrowser(){
        driver.quit();
    }

}
