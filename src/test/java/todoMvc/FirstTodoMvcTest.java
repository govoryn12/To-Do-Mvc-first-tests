package todoMvc;

import org.junit.After;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import todoMvc.steps.StepsTodoMvc;

import java.util.concurrent.TimeUnit;

public class FirstTodoMvcTest {

    public WebDriver driver;
    public StepsTodoMvc main;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", "D:\\First_project\\chromedriver.exe");
        driver = new ChromeDriver();
        main = new StepsTodoMvc(driver);
        driver.manage().window().setSize(new Dimension(1280,800));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void runTest (){

        //GIVEN
        driver.get("http://todomvc.com/examples/vue/");

        //WHEN
        main.addTodo("tea");
        main.addTodo("coffe");

        //THEN
        Assert.assertNotEquals(3, main.numberOfTodos());

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
