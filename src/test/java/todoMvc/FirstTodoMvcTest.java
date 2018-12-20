package todoMvc;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import todoMvc.steps.StepsTodoMvc;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class FirstTodoMvcTest {

    @Steps
    public StepsTodoMvc main;

    @Managed(driver = "chrome")
    public WebDriver driver;

    @Before
    public void start(){
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
