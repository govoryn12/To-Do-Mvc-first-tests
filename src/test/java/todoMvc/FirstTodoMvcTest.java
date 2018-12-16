package todoMvc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import todoMvc.steps.StepsTodoMvc;

import java.util.concurrent.TimeUnit;

public class FirstTodoMvcTest {

    public static WebDriver driver;
    public static StepsTodoMvc main;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", "D:\\First_project\\chromedriver.exe");
        driver = new ChromeDriver();
        main = new StepsTodoMvc(driver);
    }

    @Test
    public void runTest (){
        //GIVEN
        main.goTo("http://todomvc.com/examples/vue/");

        //WHEN
        main.addTodo("tea");
        main.addTodo("coffe");

        //THEN
        Assert.assertNotEquals(3, main.numberOfTodos());

        main.closeBrowser();
    }

}
