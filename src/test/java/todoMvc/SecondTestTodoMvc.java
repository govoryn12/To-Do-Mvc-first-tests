package todoMvc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import todoMvc.steps.StepsTodoMvc;

import java.util.concurrent.TimeUnit;

public class SecondTestTodoMvc {
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
        main.addTodo("tea");
        main.addTodo("coffe");

        //WHEN
        main.markDoneTodo("coffe");
        main.addTodo("pasta");

        //THEN
        Assert.assertEquals(3, main.numberOfTodos());
        Assert.assertTrue(main.checkIfDone("coffe"));

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
