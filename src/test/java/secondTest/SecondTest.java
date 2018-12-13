package secondTest;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecondTest {


    private static WebDriver driver;
    private static WebElement inputField;

    // GIVEN
    @Before
    public void runBrowserAndCreateTodos(){
        System.setProperty("webdriver.chrome.driver", "D:\\Загрузки\\screenplay-pattern-todomvc-master\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280,800));//set1280x800
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://todomvc.com/examples/vue/");

        // create todos
        inputField = driver.findElement(By.xpath("//header/input"));

        inputField.sendKeys("tea");
        inputField.sendKeys(Keys.ENTER);

        inputField.sendKeys("coffe");
        inputField.sendKeys(Keys.ENTER);
    }


    @Test
    public void workWithTodoList() {

        //WHEN
        //
        // mark element as done
        WebElement markDone = driver.findElement(By.xpath("//div/label[text()=\"coffe\"]/../input"));
        markDone.click();

        // create todos
        inputField.sendKeys("pasta");
        inputField.sendKeys(Keys.ENTER);



        //THEN
        //
        // check number of todos
        Assert.assertEquals(driver.findElements(By.xpath("//*[@class=\"view\"]")).size(), 3);

        // check if todos "coffe" is mark as done
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"todo completed\"]/div/label[text()=\"coffe\"]")).isDisplayed());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
