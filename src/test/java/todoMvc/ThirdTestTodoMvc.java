package todoMvc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import todoMvc.steps.StepsTodoMvc;

public class ThirdTestTodoMvc {
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
        main.addTodo("car");

        //WHEN
        main.addTodoManyTimes("wheel", 5);
        main.addTodo("bus");
        main.markDoneThirdWheelTodo();
        main.deleteFirstWheel();
        main.seeActiveElements();

        //THEN
        Assert.assertEquals(5, main.numberOfTodos());
        Assert.assertEquals(3, main.numberOfWheelTodos());

        main.closeBrowser();
    }

}
