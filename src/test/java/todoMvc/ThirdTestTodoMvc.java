package todoMvc;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import todoMvc.steps.StepsTodoMvc;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class ThirdTestTodoMvc {

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
        main.addTodo("car");

        //WHEN
        main.addTodo("wheel", 5);
        main.addTodo("bus");
        main.markDoneTodo("wheel", 3);
        main.deleteTodo("wheel", 1);
        main.seeActiveElements();

        //THEN
        Assert.assertEquals(5, main.numberOfTodos());
        Assert.assertEquals(3, main.numberOfTodos("wheel"));

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
