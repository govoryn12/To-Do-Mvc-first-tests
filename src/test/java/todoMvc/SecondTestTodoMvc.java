package todoMvc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import todoMvc.steps.StepsTodoMvc;

public class SecondTestTodoMvc {
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
        main.addTodo("tea");
        main.addTodo("coffe");

        //WHEN
        main.markDoneCoffeTodo();
        main.addTodo("pasta");

        //THEN
        Assert.assertEquals(3, main.numberOfTodos());
        Assert.assertTrue(main.checkIfDone());

        main.closeBrowser();
    }

}
