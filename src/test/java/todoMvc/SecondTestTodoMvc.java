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
public class SecondTestTodoMvc {

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
